package promotionSystem.hilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;

import promotionSystem.Conector;
import promotionSystem.Personaje;
import promotionSystem.Punto;
import promotionSystem.mapa.Mapa;

public class ServidorHilo extends Thread {
	private Socket cliente;
	private HashMap<Socket,Personaje> jugadores;
	private ArrayList<Punto> puntosIniciales;
	private HashMap<Personaje,Mapa> jugadoresPorMapa;
	private HashMap<String,Mapa>mapasDisponibles;
	private DataInputStream entrada;
	private DataOutputStream salida;
	private String raza;
	private String casta;
	private Conector conector;
	public ServidorHilo(Socket cliente,HashMap<Socket,Personaje> jugadores,HashMap<Personaje,Mapa> jugadoresPorMapa,HashMap<String,Mapa> mapasDisponibles,Conector conector) throws IOException{
		this.cliente=cliente;
		this.jugadoresPorMapa=jugadoresPorMapa;
		this.jugadores=jugadores;
		this.mapasDisponibles=mapasDisponibles;
		this.conector=conector;
		entrada= new DataInputStream(cliente.getInputStream());
		salida=new DataOutputStream(cliente.getOutputStream());
		puntosIniciales =new ArrayList<>();
		agregarPuntosIniciales();
	}
	
	private void agregarPuntosIniciales() {
		puntosIniciales.add(new Punto(0,0));
		puntosIniciales.add(new Punto(10,10));
		puntosIniciales.add(new Punto(20,20));
		puntosIniciales.add(new Punto(30,30));
		puntosIniciales.add(new Punto(40,40));
	}
	
	public void run(){
		try {
			while(recibirAccion().equals("Registrar")){
				registrarJugador();
			}
			do{
				loguearJugador();
			}while(recibirAccion().equals("Login"));
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}

	private void registrarJugador() throws Exception {
		if(!comprobarUsuario()){
			crearUsuario();			
		}
	}

	private String recibirAccion() throws Exception{
		JsonParser parser = new JsonParser();
		JsonElement elemento = parser.parse(entrada.readUTF());
		return elemento.getAsJsonObject().get("Accion").getAsString();
	}

	private void loguearJugador() {
		try {			
			if(!validarContraseña()){
				salida.writeUTF("false");
			}
			salida.writeUTF("true");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean comprobarUsuario() throws Exception{
		JsonParser parser = new JsonParser();
		JsonElement elemento = parser.parse(entrada.readUTF());
		JsonObject respuesta=new JsonObject();
		boolean resultado =conector.validarNombreUsuario(elemento.getAsJsonObject().get("nombre").getAsString());
		respuesta.addProperty("Resultado",resultado);
		salida.writeUTF(respuesta.toString());
		
		return resultado;
	}

	private void crearUsuario() throws JsonSyntaxException, IOException, SQLException {
		JsonParser parser = new JsonParser();
		JsonElement elemento = parser.parse(entrada.readUTF());
	    conector.agregarUsuario(elemento.getAsJsonObject().get("nombre").getAsString(),Integer.parseInt((elemento.getAsJsonObject().get("contrasena").getAsString())));
	}

	private boolean validarContraseña() throws Exception {
		JsonParser parser = new JsonParser();
		JsonElement elemento = parser.parse(entrada.readUTF());
		return conector.validarUsuario(elemento.getAsJsonObject().get("nombre").getAsString(),Integer.parseInt((elemento.getAsJsonObject().get("contrasena").getAsString())));
	
	}

	private void crearPersonaje() throws Exception {
		Personaje personaje=crearPersonajeAPartirDeRazaYCasta(raza,casta);
			jugadores.put(cliente, personaje);
	}


	private void enviarPosicionInicial() throws IOException{
		Random random = new Random();
		Punto puntoInicial=puntosIniciales.get(random.nextInt(puntosIniciales.size()));
		JsonObject punto = new JsonObject();
	    punto.addProperty("x", puntoInicial.getX());
		punto.addProperty("y", puntoInicial.getX());
		jugadores.get(cliente).setPosicion(puntoInicial);
		 salida.writeUTF(punto.toString());
	}
	
	public void enviarRazas() throws IOException{
		JsonArray razas = new JsonArray(); 
		cargarRazas(razas);
		enviarLista(razas,"razas");
	}

	private void enviarLista(JsonArray lista,String nombre) throws IOException {
		JsonObject listaEnviada = new JsonObject();
		listaEnviada.add(nombre, lista);
		salida.writeUTF(listaEnviada.toString());
	}
	
	private void cargarRazas(JsonArray razas) {
		
		JsonElement razaStarWars = new JsonPrimitive("Personajes Star Wars");
		JsonElement razaPokemon = new JsonPrimitive("Personajes de Pokemon");
		JsonElement razaUndertale = new JsonPrimitive("Personajes de Undertale");
		JsonElement razaKingdomHearts = new JsonPrimitive("Personajes de Kingdom Hearts");
		JsonElement razaHumano = new JsonPrimitive("Humano");
		JsonElement razaOrco = new JsonPrimitive("Orco");
		
		razas.add(razaStarWars);
		razas.add(razaPokemon);
		razas.add(razaUndertale);
		razas.add(razaKingdomHearts);
		razas.add(razaHumano);
		razas.add(razaOrco);
			
	}
	
	public void recibirRazaElegido() throws Exception{
		JsonParser parser = new JsonParser();
		JsonElement elemento = parser.parse(entrada.readUTF());
		raza=elemento.getAsJsonObject().get("raza").getAsString();
		enviarCastas();
	}

	private void enviarCastas() throws Exception {
		JsonArray castas = new JsonArray(); 
		cargarCastas(castas);
		enviarLista(castas,"castas");
		crearPersonaje();
	}

	//FIXME esto hay que cambiarlo urgente.
	private void cargarCastas(JsonArray castas) {
		if (raza.equals("Humano") || raza.equals("Orco")) {
			JsonElement casta1 = new JsonPrimitive("Guerrero");
			JsonElement casta2 = new JsonPrimitive("Mago");
			JsonElement casta3 = new JsonPrimitive("Tanque");
			castas.add(casta1);
			castas.add(casta3);
			castas.add(casta2);
		} else {
			if (raza.equals("Kingdom Hearts")) {
				JsonElement casta1 = new JsonPrimitive("Riku");
				JsonElement casta2 = new JsonPrimitive("Sora");
				JsonElement casta3 = new JsonPrimitive("Roxas");
				castas.add(casta1);
				castas.add(casta3);
				castas.add(casta2);
			} else {
				if (raza.equals("Pokemon")) {
					JsonElement casta1 = new JsonPrimitive("Tipo Fuego");
					JsonElement casta2 = new JsonPrimitive("Tipo Agua");
					JsonElement casta3 = new JsonPrimitive("Tipo Planta");
					castas.add(casta1);
					castas.add(casta3);
					castas.add(casta2);
				} else {
					if (raza.equals("Stars Wars")) {
						JsonElement casta1 = new JsonPrimitive("Jedi");
						JsonElement casta2 = new JsonPrimitive("Droide");
						JsonElement casta3 = new JsonPrimitive("Wookie");
						castas.add(casta1);
						castas.add(casta3);
						castas.add(casta2);
					} else {
						if (raza.equals("Undertale")){
							JsonElement casta1 = new JsonPrimitive("Chara");
							castas.add(casta1);							
						}
					}
				}
			}
		}
		
	}
	
	public void recibirCastaElegida() throws IOException{
		JsonParser parser = new JsonParser();
		JsonElement elemento = parser.parse(entrada.readUTF());
		casta=elemento.getAsJsonObject().get("casta").getAsString();
		
	}

	private Personaje crearPersonajeAPartirDeRazaYCasta(String raza, String casta) throws Exception {
		return (Personaje) Class.forName("promotionSystem.razas.castas." + raza + "." + casta).newInstance();
	}

	public void enviarMapas() throws IOException{
		JsonArray mapas = new JsonArray(); 
		cargarMapas(mapas);
		enviarLista(mapas,"mapas");
	}

	private void cargarMapas(JsonArray mapas) {	
		JsonElement mapaStarWars = new JsonPrimitive("Mundo Star Wars");
		JsonElement mapaPokemon = new JsonPrimitive("Mundo Pokemon");
		JsonElement mapaUndertale = new JsonPrimitive("Mundo Undertale");
		JsonElement mapaKingdomHearts = new JsonPrimitive( "Mundo Kingdom Hearts");
		mapas.add(mapaStarWars);
		mapas.add(mapaPokemon);
		mapas.add(mapaUndertale);
		mapas.add(mapaKingdomHearts);
	}
	
	public void recibirMapaElegido() throws IOException{
		JsonParser parser = new JsonParser();
		JsonElement elemento = parser.parse(entrada.readUTF());
		jugadoresPorMapa.put(jugadores.get(cliente), mapasDisponibles.get(elemento.getAsJsonObject().get("mapa").getAsString()));
	}
	
	public void comunicarInvitacionAAlianza() throws IOException{
		Personaje personaje = recibirInvitacionAAlianza();
		enviarInvitacionAAlianza(personaje);		
	}

	private Personaje recibirInvitacionAAlianza() throws IOException {
		JsonParser parser = new JsonParser();
		JsonElement elemento = parser.parse(entrada.readUTF());
		return new Gson().fromJson(elemento, Personaje.class);
	}
	

	private void enviarInvitacionAAlianza(Personaje personaje) throws IOException {
		Iterator<Socket> iterator= jugadores.keySet().iterator();
		boolean encontro=false;
		while(!encontro&&iterator.hasNext()){
			Socket jugador = iterator.next();
			if(jugadores.get(jugador).equals(personaje)){
				JsonObject personajeInvitador = new JsonObject();	
				personajeInvitador.addProperty("nombre", jugadores.get(cliente).getNombre());
				salida.writeUTF(personajeInvitador.toString());
				encontro=true;
			}
		}
	}
}
