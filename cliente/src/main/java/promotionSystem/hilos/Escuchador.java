package promotionSystem.hilos;

import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import promotionSystem.Alianza;
import promotionSystem.Cliente;
import promotionSystem.Personaje;
import promotionSystem.Punto;
import promotionSystem.juego.TileOtrosJugadores;
import promotionSystem.mapagrafico.TilePersonaje;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

public class Escuchador extends Thread {
	private Socket socketCliente;
	private String nombre;
	private Personaje personaje;
	private DataOutputStream salida;
	private DataInputStream entrada;
	private String raza;
	private String casta;
	private ArrayList<Personaje> jugadoresEnPartida;
	private boolean continuar = true;
	private ArrayList<TileOtrosJugadores> tilesOtrosJugadores;
	private Cliente cliente;
	private ArrayList<Alianza> alianzas;
	
	public Escuchador(Cliente cliente)
			throws IOException {
		this.cliente = cliente;
		this.socketCliente = cliente.getSocket();
		this.nombre = cliente.getNombre();
		this.personaje = cliente.getPersonaje();
		this.raza = cliente.getRaza();
		this.casta = cliente.getCasta();
		this.jugadoresEnPartida = cliente.getJugadoresEnPartida();
		salida = new DataOutputStream(this.socketCliente.getOutputStream());
		entrada = new DataInputStream(this.socketCliente.getInputStream());
		this.tilesOtrosJugadores = cliente.getTiles();
		alianzas = new ArrayList<>();
	}

	public void run() {

		try {

			while (continuar) {
				Method miMetodo = Escuchador.class.getMethod(recibirAccion());
				miMetodo.invoke(this);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Hubo un problema en la comunicacion con el Servidor","Error",JOptionPane.ERROR_MESSAGE);
			System.exit(MAX_PRIORITY);
		}

	}
	
	public void recibirResultadoDeBatalla() throws Exception{
		JsonParser parser = new JsonParser();
		JsonArray listaDePersonajesActualizados = parser.parse(entrada.readUTF()).getAsJsonArray();
		Type tipoPersonajeActualizado = new TypeToken<ArrayList<JsonObject>>() {}.getType();
		ArrayList<JsonObject> elemento = new Gson().fromJson(listaDePersonajesActualizados, tipoPersonajeActualizado);
		//parsear
		Iterator<JsonObject> iterador = elemento.iterator();
		while(iterador.hasNext()){
			JsonObject objeto = iterador.next();
			//System.out.println("nombre:"+" "+objeto.get("nombre").getAsString()+" "+"experiencia:"+" "+objeto.get("experienciaGanada").getAsInt()+" "+objeto.get("x").getAsInt()+" "+objeto.get("y").getAsInt()+" "+"salud:"+" "+objeto.get("salud").getAsInt());
			String nombrePersonaje = objeto.get("nombre").getAsString();
			Personaje personaje = buscarPersonajePorNombre(nombrePersonaje);
			int experiencia = objeto.get("experienciaGanada").getAsInt();
			Punto punto = new Punto(objeto.get("x").getAsInt(), objeto.get("y").getAsInt());
			int salud = objeto.get("salud").getAsInt();
			if(personaje!=null){
				personaje.subirExperiencia(experiencia);
				//asignarPuntoAPersonaje(nombrePersonaje, punto);
				personaje.sacarDeModoBatalla();
				personaje.setSalud(salud);
				personaje.setEnergia(personaje.getEnergiaMaxima());
			}
			else{
				this.personaje.subirExperiencia(experiencia);
				//this.personaje.setPosicion(punto);
				this.personaje.setSalud(salud);
				this.personaje.sacarDeModoBatalla();
				this.personaje.setEnergia(this.personaje.getEnergiaMaxima());
			}
		}
	}

	public String recibirAccion() throws IOException {
		JsonElement elemento = recibirObjetoJson();
		return elemento.getAsJsonObject().get("Accion").getAsString();
	}

	public JsonElement recibirObjetoJson() throws IOException {
		JsonParser parser = new JsonParser();
		return parser.parse(entrada.readUTF());
	}

	public void recibirListaDePersonajes() throws Exception {

		JsonParser parser = new JsonParser();
		JsonArray json = parser.parse(entrada.readUTF()).getAsJsonArray();
		Type tipoListaRazas = new TypeToken<ArrayList<JsonObject>>() {
		}.getType();
		ArrayList<JsonObject> crearPersonajes = new Gson().fromJson(json, tipoListaRazas);
		for (JsonObject personaje : crearPersonajes) {
			Personaje personajeAAgregar = crearPersonaje(personaje);
			jugadoresEnPartida.add(personajeAAgregar);
		}
	}
	
	public void recibirListaDeAlianzas() throws JsonSyntaxException, IOException{
		JsonParser parser = new JsonParser();
		JsonArray personajeASetear = parser.parse(entrada.readUTF()).getAsJsonArray();
		Type tipoListaAlianzas = new TypeToken<ArrayList<JsonArray>>() {}.getType();
		ArrayList<JsonArray> elemento = new Gson().fromJson(personajeASetear, tipoListaAlianzas);
		Iterator<JsonArray> iterador = elemento.iterator();
		while(iterador.hasNext()){
			Type tipoListaPersonajes = new TypeToken<List<String>>() {}.getType();
			JsonArray alianza = iterador.next();
			ArrayList<String> elemento2 = new Gson().fromJson(alianza, tipoListaPersonajes);
			ArrayList<Personaje> listaDePersonajes = new ArrayList<>();
			for(String personajeActual : elemento2){
				Personaje personaje = buscarPersonajePorNombre(personajeActual);
				System.out.println(personaje.getNombre()+"  personaje");
				listaDePersonajes.add(personaje);
			}
			alianzas.add(new Alianza(listaDePersonajes));
		}
	}

	public void movimientoDePersonaje() throws IOException {
		JsonParser parser = new JsonParser();
		JsonObject objeto = parser.parse(entrada.readUTF()).getAsJsonObject();
		String nombrePersonaje = objeto.get("nombre").getAsString();
		Punto puntoNuevo = new Punto(objeto.get("x").getAsInt(), objeto.get("y").getAsInt());
		asignarPuntoAPersonaje(nombrePersonaje, puntoNuevo);
	}

	public void asignarPuntoAPersonaje(String nombrePersonaje, Punto puntoNuevo) {
		boolean encontro = false;
		int i = 0;

		while (i < jugadoresEnPartida.size() && !encontro) {
			if (jugadoresEnPartida.get(i).getNombre().equals(nombrePersonaje)) {
				jugadoresEnPartida.get(i).setPosicion(puntoNuevo);
				encontro = true;
				tilesOtrosJugadores.get(i).setPuntoDestino(puntoNuevo);
			}
			i++;
		}
	}

	public void agregarPersonaje() throws Exception {
		JsonParser parser = new JsonParser();
		JsonObject objeto = parser.parse(entrada.readUTF()).getAsJsonObject();
		Personaje personaje = crearPersonaje(objeto);
		jugadoresEnPartida.add(personaje);
		tilesOtrosJugadores.add(new TileOtrosJugadores(personaje));
	}

	private Personaje crearPersonaje(JsonObject objeto) throws Exception {
		Personaje personaje = crearPersonajeAPartirDeRazaCasta(objeto.get("raza").getAsString(),objeto.get("casta").getAsString());
		personaje.subirStats(objeto.get("nivel").getAsInt() - 1);
		personaje.setNombre(objeto.get("nombre").getAsString());
		personaje.setPosicion(new Punto(objeto.get("x").getAsInt(), objeto.get("y").getAsInt()));
		personaje.setRaza(objeto.get("raza").getAsString());
		personaje.setCasta(objeto.get("casta").getAsString());
		return personaje;
	}

	public Personaje crearPersonajeAPartirDeRazaCasta(String raza, String casta)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return (Personaje) Class.forName("promotionSystem.razas.castas." + raza + "." + casta).newInstance();
	}

	public void removerJugador() throws Exception {
		JsonParser parser = new JsonParser();
		JsonObject objeto = parser.parse(entrada.readUTF()).getAsJsonObject();
		String nombreCliente = objeto.get("nombre").getAsString();
		Personaje personajeQueSeVa = buscarPersonajePorNombre(nombreCliente);
		if(personajeQueSeVa.getAlianza().cantidadDePersonajes()==1){
			alianzas.remove(personajeQueSeVa.getAlianza());
		}
		if(personajeQueSeVa.getAlianza()!=null){
			personajeQueSeVa.getAlianza().sacarPersonaje(personajeQueSeVa);
		}
		jugadoresEnPartida.remove(buscarPersonajeAQuitarDeLaLista(objeto.get("nombre").getAsString()));
	}

	private Personaje buscarPersonajeAQuitarDeLaLista(String nombre) {
		for (int i = 0; i < jugadoresEnPartida.size(); i++) {
			if (jugadoresEnPartida.get(i).getNombre().equals(nombre)) {
				removerTile(i);
				return jugadoresEnPartida.get(i);
			}
		}
		return null;
	}

	private void removerTile(int i) {
		tilesOtrosJugadores.get(i).setPuntoDestino(new Punto(10000, 10000));
		tilesOtrosJugadores.remove(i);
	}

	public void cerrar() {
		continuar = false;
	}
	
	public void recibirInvitacionAAlianza() throws JsonSyntaxException, IOException {
		JsonParser parser = new JsonParser();
		JsonElement elemento = parser.parse(entrada.readUTF());
		String invitador = elemento.getAsJsonObject().get("nombre").getAsString();
		//cartel en pantalla con timer para dar la respuesta
		cliente.setInvitador(invitador);
		mostrarInvitacion();
	}
	
	public void mostrarInvitacion(){
		cliente.setInvitacionAAlianza(true);
	}

	public void recibirComunicacionDeNuevaAlianza() throws JsonSyntaxException, IOException{
		JsonElement elemento = recibirObjetoJson();
		String nombreInvitado = elemento.getAsJsonObject().get("nombreInvitado").getAsString();
		String nombreInvitador = elemento.getAsJsonObject().get("nombreInvitador").getAsString();
		if(cliente.getNombre().equals(nombreInvitador)){
			Personaje personajeInvitado = buscarPersonajePorNombre(nombreInvitado);
			this.cliente.getPersonaje().aceptarAlianza(personajeInvitado);
			System.out.println(cliente.getPersonaje().getAlianza().getPersonajes());
		}
		else if(cliente.getNombre().equals(nombreInvitado)){
			Personaje personajeInvitador = buscarPersonajePorNombre(nombreInvitador);
			this.cliente.getPersonaje().aceptarAlianza(personajeInvitador);
			System.out.println(cliente.getPersonaje().getAlianza().getPersonajes());
		}
		else{
			Personaje personajeInvitado = buscarPersonajePorNombre(nombreInvitado);
			Personaje personajeInvitador = buscarPersonajePorNombre(nombreInvitador);
			personajeInvitador.aceptarAlianza(personajeInvitado);
			System.out.println(personajeInvitado.getAlianza().getPersonajes());
		}
	}
	
	private Personaje buscarPersonajePorNombre(String nuevoAliado) {
		Iterator<Personaje> iterator = jugadoresEnPartida.iterator();
		while (iterator.hasNext()) {
			Personaje actual = iterator.next();
			if(actual.getNombre().equals(nuevoAliado)){
				return actual;
			}
		}
		return null;
	}

	public void recibirNotificacionDeBatalla() throws IOException {
		Alianza listaAliados = recibirElementoDeJsonArrayYTransformarloEnAlianza();
		Alianza listaEnemigos = recibirElementoDeJsonArrayYTransformarloEnAlianza();

		for (Personaje personaje : listaAliados.getPersonajes()) {
			if(personaje.getNombre().equals(cliente.getNombre())){
				System.out.println(cliente.getNombre());
				cliente.getPersonaje().ponerEnModoBatalla();
				cliente.setAlianzaAmiga(listaAliados);
				cliente.setAlianzaEnemiga(listaEnemigos);
				mostrarBatalla();
			}
			else{
				personaje.ponerEnModoBatalla();
			}
		}

		for (Personaje personaje : listaEnemigos.getPersonajes()) {
			if(personaje.getNombre().equals(cliente.getNombre())){
				System.out.println(cliente.getNombre());
				cliente.getPersonaje().ponerEnModoBatalla();
				cliente.setAlianzaAmiga(listaEnemigos);
				cliente.setAlianzaEnemiga(listaAliados);
				mostrarBatalla();
			}
			else{
				personaje.ponerEnModoBatalla();
			}
		}

	}

	private Alianza recibirElementoDeJsonArrayYTransformarloEnAlianza() throws IOException {
		JsonElement elemento = recibirObjetoJson();
		Type tipoLista = new TypeToken<ArrayList<String>>() {}.getType();
		ArrayList<String> lista = new Gson().fromJson(elemento, tipoLista);
		return crearAlianzaAPartirDeArrayDeString(lista);
	}

	private Alianza crearAlianzaAPartirDeArrayDeString(ArrayList<String> lista) {
		Alianza alianza = new Alianza();
		for (String personaje : lista) {
			if(personaje.equals(cliente.getPersonaje().getNombre())){
				alianza.agregarPersonaje(cliente.getPersonaje());
			}
			else{
				alianza.agregarPersonaje(buscarPersonajePorNombre(personaje));
			}
		}
		return alianza;
	}
	
	private void mostrarBatalla() {
		cliente.setDesafioABatalla(true);
	}

	public void enviarEnemigoYListaDePersonajesParaBatalla(Personaje enemigo, ArrayList<Personaje> amiga) throws IOException {
		JsonObject personaje = new JsonObject();
		JsonObject personajeEnemigo = new JsonObject();
		JsonArray listaDeAmigos = new JsonArray();
		personajeEnemigo.addProperty("nombre", enemigo.getNombre());
		personaje.addProperty("personajeEnemigo", personajeEnemigo.toString());
		Iterator<Personaje> iterator = amiga.iterator();
		while (iterator.hasNext()) {
			listaDeAmigos.add(new JsonPrimitive(iterator.next().getNombre()));
		}
		personaje.addProperty("aliados", listaDeAmigos.toString());
		salida.writeUTF(personaje.toString());
	}

	public void turnoOtorgado() throws IOException{
		JsonElement turno = recibirObjetoJson();
		if(turno.getAsJsonObject().get("turno").equals("true")){
			cliente.setTurno(true);
		}
	}

}
