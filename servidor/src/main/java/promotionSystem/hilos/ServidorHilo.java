package promotionSystem.hilos;

import com.google.gson.*;
import promotionSystem.Alianza;
import promotionSystem.Conector;
import promotionSystem.Personaje;
import promotionSystem.Punto;
import promotionSystem.mapa.Mapa;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.sql.SQLException;
import java.util.*;

public class ServidorHilo extends Thread {
	private Socket cliente;
	private boolean continuar = true;
	private HashMap<Socket, Personaje> jugadores;
	private ArrayList<Punto> puntosIniciales;
	private HashMap<Mapa, ArrayList<Socket>> jugadoresPorMapa;
	private HashMap<String, Mapa> mapasDisponibles;
	private DataInputStream entrada;
	private DataOutputStream salida;
	private String raza;
	private String casta;
	private Conector conector;
	private String nombreCliente;
	private int nivel;
	private Mapa mapa;
	private Socket invitado;
	private Socket invitador;
	private HashMap<Personaje, Socket> jugadoresBatalla;

	private int indiceDeAlianzas;
	private Set<Alianza> alianzas;
	
	public ServidorHilo(Socket cliente, HashMap<Socket, Personaje> jugadores,
			HashMap<Mapa, ArrayList<Socket>> jugadoresPorMapa, HashMap<String, Mapa> mapasDisponibles,
			Conector conector,HashMap<Personaje, Socket> jugadoresBatalla) throws IOException {
		this.cliente = cliente;
		this.indiceDeAlianzas = indiceDeAlianzas;
		this.alianzas = alianzas;
		this.jugadoresPorMapa = jugadoresPorMapa;
		this.jugadores = jugadores;
		this.mapasDisponibles = mapasDisponibles;
		this.conector = conector;
		this.jugadoresBatalla=jugadoresBatalla;
		entrada = new DataInputStream(cliente.getInputStream());
		salida = new DataOutputStream(cliente.getOutputStream());
		puntosIniciales = new ArrayList<>();
		agregarPuntosIniciales();
	}

	private void agregarPuntosIniciales() {
		puntosIniciales.add(new Punto(1, 1));
		puntosIniciales.add(new Punto(10, 10));
		puntosIniciales.add(new Punto(20, 20));
		puntosIniciales.add(new Punto(30, 30));
		puntosIniciales.add(new Punto(40, 40));
	}

	public void run() {
		try {

			while (continuar) {
				Method miMetodo = ServidorHilo.class.getMethod(recibirAccion());
				miMetodo.invoke(this);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void cargarPersonaje() throws Exception {
		jugadores.put(cliente, obtenerPersonaje());
		enviarPersonaje();

	}

	public void mover() throws IOException {
		jugadores.get(cliente).setPosicion(obtenerPuntoEnviado());
		enviarAlRestoPunto();

	}

	public void enviarAccion(String accion) throws IOException {
		JsonObject usuario = new JsonObject();
		usuario.addProperty("Accion", accion);
		salida.writeUTF(usuario.toString());
	}

	private void enviarAlRestoPunto() throws IOException {
		JsonObject puntoAMover = new JsonObject();
		puntoAMover.addProperty("nombre", jugadores.get(cliente).getNombre());
		puntoAMover.addProperty("x", jugadores.get(cliente).getPosicion().getX());
		puntoAMover.addProperty("y", jugadores.get(cliente).getPosicion().getY());
		enviarMensajeAJugadores(puntoAMover, jugadoresPorMapa.get(mapa), "movimientoDePersonaje");

	}

	private Punto obtenerPuntoEnviado() throws IOException {
		JsonElement elemento = recibirObjetoJson();
		// Punto punto = new
		// Punto(elemento.getAsJsonObject().get("x").getAsInt(),elemento.getAsJsonObject().get("y").getAsInt());
		return new Gson().fromJson(elemento.getAsJsonObject(), Punto.class);
		//
	}

	private Personaje obtenerPersonaje() throws Exception {
		raza = conector.obtenerRazaPersonaje(nombreCliente);
		casta = conector.obtenerCastaPersonaje(nombreCliente);
		nivel = conector.obtenerNivelPersonaje(nombreCliente);
		Personaje personaje = crearPersonajeAPartirDeRazaYCasta();
		personaje.subirStats(nivel - 1);
		personaje.setNombre(nombreCliente);
		personaje.setCasta(casta);
		personaje.setRaza(raza);
		return personaje;
	}

	private void enviarPersonaje() throws IOException {
		JsonObject personaje = new JsonObject();
		personaje.addProperty("raza", raza);
		personaje.addProperty("casta", casta);
		personaje.addProperty("nivel", nivel);
		salida.writeUTF(personaje.toString());
	}

	public void cerrar() throws IOException {
		if (mapa != null) {
			enviarAOtrosQueJugadorSalio();
			jugadores.get(cliente).getAlianza().sacarPersonaje(jugadores.get(cliente));
			if(alianzas.contains(jugadores.get(cliente).getAlianza().cantidadDePersonajes() == 1)){
				alianzas.remove(jugadores.get(cliente).getAlianza());
			}
			jugadoresPorMapa.get(mapa).remove(cliente);
		}

		jugadores.remove(cliente);

		enviarAccion("cerrar");
		cliente.close();
		continuar = false;
	}

	private void enviarAOtrosQueJugadorSalio() throws IOException {
		JsonObject json = new JsonObject();
		json.addProperty("nombre", nombreCliente);
		enviarMensajeAJugadores(json, jugadoresPorMapa.get(mapa), "removerJugador");

	}

	public void recibirMapas() throws IOException, SQLException {
		enviarMapas();
	}

	public void seleccionarMapa() throws IOException {
		recibirMapaElegido();
		enviarPosicionInicial();
		if (jugadoresPorMapa.size() != 1) {
			enviarAccion("recibirListaDePersonajes");
			enviarListaDePersonajesEnLaPartida();
			enviarAccion("recibirListaDeAlianzas");
			enviarListaDeAlianzas();
		}
		enviarPersonajeAlResto();
	}

	private void enviarListaDePersonajesEnLaPartida() throws IOException {

		JsonArray personajes = new JsonArray();
		for (Socket socketDelPersonaje : jugadoresPorMapa.get(mapa)) {
			JsonObject elemento = new JsonObject();
			Personaje personajeAEnviar = jugadores.get(socketDelPersonaje);
			if (!personajeAEnviar.equals(jugadores.get(cliente))) {

				elemento.addProperty("nombre", personajeAEnviar.getNombre());
				elemento.addProperty("raza", personajeAEnviar.getRaza());
				elemento.addProperty("casta", personajeAEnviar.getCasta());
				elemento.addProperty("nivel", personajeAEnviar.getNivel());
				elemento.addProperty("x", personajeAEnviar.getPosicion().getX());
				elemento.addProperty("y", personajeAEnviar.getPosicion().getY());
				personajes.add(elemento);
			}
		}

		salida.writeUTF(personajes.toString());

	}
	
	private void enviarListaDeAlianzas() throws IOException{
		JsonArray lista = new JsonArray();
		for(Alianza alianza : alianzas){
			JsonArray personajes = new JsonArray();
			for(Personaje personaje : alianza.getPersonajes()){
				personajes.add(new JsonPrimitive(personaje.getNombre()));
			}
			lista.add(personajes);
		}
		salida.writeUTF(lista.toString());
	}

	private void enviarPersonajeAlResto() throws IOException {

		JsonObject json = new JsonObject();
		json.addProperty("nombre", nombreCliente);
		json.addProperty("raza", raza);
		json.addProperty("casta", casta);
		json.addProperty("nivel", nivel);
		json.addProperty("x", jugadores.get(cliente).getPosicion().getX());
		json.addProperty("y", jugadores.get(cliente).getPosicion().getY());
		enviarMensajeAJugadores(json, jugadoresPorMapa.get(mapa), "agregarPersonaje");
	}

	private void enviarMensajeAJugadores(JsonObject json, ArrayList<Socket> jugadoresAEnviar, String accionAEnviar)
			throws IOException {
		Iterator<Socket> iterador = jugadoresAEnviar.iterator();
		while (iterador.hasNext()) {
			Socket jugador = iterador.next();
			if (!jugador.equals(cliente)) {

				DataOutputStream salidaCliente = new DataOutputStream(jugador.getOutputStream());
				JsonObject accion = new JsonObject();
				accion.addProperty("Accion", accionAEnviar);
				salidaCliente.writeUTF(accion.toString());
				salidaCliente.writeUTF(json.toString());
			}
		}
	}

	public void registrar() throws Exception {
		registrarJugador();

	}

	public void login() {
		loguearJugador();
	}

	public void seleccionarRazaYCasta() throws Exception {
		recibirRazaYCasta();
		crearPersonaje();
	}

	private void recibirRazaYCasta() throws IOException {
		JsonElement elemento = recibirObjetoJson();
		raza = elemento.getAsJsonObject().get("raza").getAsString();
		casta = elemento.getAsJsonObject().get("casta").getAsString();
	}

	private void registrarJugador() throws Exception {
		if (!comprobarUsuario()) {
			crearUsuario();
			enviarRazas();
			enviarListaDeCastas();
		}
	}

	private String recibirAccion() throws Exception {
		JsonElement elemento = recibirObjetoJson();
		return elemento.getAsJsonObject().get("Accion").getAsString();
	}

	private void loguearJugador() {
		try {
			if (validarContraseña() && !estaLogueado()) {
				salida.writeUTF("true");

			} else {
				salida.writeUTF("false");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private boolean estaLogueado() {
		Iterator<Socket> iterador = jugadores.keySet().iterator();
		while (iterador.hasNext()) {
			Socket jugador = iterador.next();
			if (jugadores.get(jugador).getNombre().equals(nombreCliente)) {
				return true;
			}
		}

		return false;
	}

	private boolean comprobarUsuario() throws Exception {
		JsonElement elemento = recibirObjetoJson();
		JsonObject respuesta = new JsonObject();
		boolean resultado = conector.validarNombreUsuario(elemento.getAsJsonObject().get("nombre").getAsString());
		respuesta.addProperty("Resultado", resultado);
		salida.writeUTF(respuesta.toString());
		return resultado;
	}

	private void crearUsuario() throws JsonSyntaxException, IOException, SQLException {
		JsonElement elemento = recibirObjetoJson();
		nombreCliente = elemento.getAsJsonObject().get("nombre").getAsString();
		conector.agregarUsuario(nombreCliente,
				Integer.parseInt((elemento.getAsJsonObject().get("contrasena").getAsString())));
	}

	private boolean validarContraseña() throws Exception {
		JsonElement elemento = recibirObjetoJson();
		nombreCliente = elemento.getAsJsonObject().get("nombre").getAsString();
		return conector.validarUsuario(nombreCliente,
				Integer.parseInt((elemento.getAsJsonObject().get("contrasena").getAsString())));

	}

	private void crearPersonaje() throws Exception {
		Personaje personaje = crearPersonajeAPartirDeRazaYCasta();
		personaje.setNombre(nombreCliente);
		personaje.setRaza(raza);
		personaje.setCasta(casta);
		jugadores.put(cliente, personaje);
		conector.agregarPersonaje(personaje);
	}

	public void enviarRazas() throws IOException, SQLException {
		enviarLista(conector.obtenerRazas());
	}

	private void enviarLista(JsonArray lista) throws IOException {
		salida.writeUTF(lista.toString());
	}

	public void recibirRazaElegido() throws Exception {
		JsonElement elemento = recibirObjetoJson();
		raza = elemento.getAsJsonObject().get("raza").getAsString();
	}

	private void enviarListaDeCastas() throws Exception {
		enviarLista(conector.obtenerCastas());
	}

	public void recibirCastaElegida() throws IOException {
		JsonElement elemento = recibirObjetoJson();
		casta = elemento.getAsJsonObject().get("casta").getAsString();
	}

	private Personaje crearPersonajeAPartirDeRazaYCasta() throws Exception {
		return (Personaje) Class.forName("promotionSystem.razas.castas." + raza + "." + casta).newInstance();
	}

	public void enviarMapas() throws IOException, SQLException {
		enviarLista(conector.obtenerMapas());
	}

	public void recibirMapaElegido() throws IOException {
		JsonElement elemento = recibirObjetoJson();
		mapa = mapasDisponibles.get(elemento.getAsJsonObject().get("mapa").getAsString());
		jugadoresPorMapa.get(mapa).add(cliente);
	}

	private JsonElement recibirObjetoJson() throws IOException {
		JsonParser parser = new JsonParser();
		return parser.parse(entrada.readUTF());
	}

	private void enviarPosicionInicial() throws IOException {
		Random random = new Random();
		Punto puntoInicial = puntosIniciales.get(random.nextInt(puntosIniciales.size()));
		JsonObject punto = new JsonObject();
		punto.addProperty("x", puntoInicial.getX());
		punto.addProperty("y", puntoInicial.getX());
		jugadores.get(cliente).setPosicion(puntoInicial);
		salida.writeUTF(punto.toString());
	}

	public void comunicarInvitacionAAlianza() throws IOException {
		JsonElement elemento = recibirObjetoJson();
		String personajeInvitado = elemento.getAsJsonObject().get("nombre").getAsString();
		Socket invitado = enviarInvitacionAAlianza(personajeInvitado);
		// aca seria necesario sincronizar por si el cliente elige no responder
		// indefinidamente la solicitud
		// tal vez un timer?
	}

	private Socket enviarInvitacionAAlianza(String personaje) throws IOException {
		Iterator<Socket> iterator = jugadoresPorMapa.get(mapa).iterator();
		while (iterator.hasNext()) {
			Socket jugador = iterator.next();
			if (jugadores.get(jugador).getNombre().equals(personaje)) {
				invitado = jugador;
				DataOutputStream salidaAOtroJugador = new DataOutputStream(jugador.getOutputStream());
				JsonObject usuario = new JsonObject();
				usuario.addProperty("Accion", "recibirInvitacionAAlianza");
				salidaAOtroJugador.writeUTF(usuario.toString());
				JsonObject personajeInvitador = new JsonObject();
				personajeInvitador.addProperty("nombre", jugadores.get(cliente).getNombre());
				salidaAOtroJugador.writeUTF(personajeInvitador.toString());
				return jugador;
			}
		}
		return null;
	}

	public void recibirRespuestaDeInvitacionAAlianza() throws IOException {
		JsonParser parser = new JsonParser();
		JsonElement elemento = parser.parse(entrada.readUTF());
		
		if (elemento.getAsJsonObject().get("respuesta").getAsString().equals("true")) {
			String invitador = elemento.getAsJsonObject().get("invitador").getAsString();
			buscarSocketDeInvitador(invitador);
			jugadores.get(cliente).aceptarAlianza(jugadores.get(this.invitador));
			alianzas.add(jugadores.get(cliente).getAlianza());
			comunicarAlianza();
		}
	

	}

	private void buscarSocketDeInvitador(String invitador) {
		Iterator<Socket> iterador = jugadoresPorMapa.get(mapa).iterator();
		while (iterador.hasNext()) {
			Socket socketActual = iterador.next();
			if (jugadores.get(socketActual).getNombre().equals(invitador)) {
				this.invitador = socketActual;
				return;
			}
		}
	}

	private void comunicarAlianza() throws IOException {
		Iterator<Socket> iterador = jugadoresPorMapa.get(mapa).iterator();
		JsonObject personajeUnidoAAlianza = new JsonObject();
		personajeUnidoAAlianza.addProperty("nombreInvitado", jugadores.get(cliente).getNombre());
		personajeUnidoAAlianza.addProperty("nombreInvitador", jugadores.get(invitador).getNombre());
		while (iterador.hasNext()) {
			Socket jugador = iterador.next();
			Personaje personaje = jugadores.get(jugador);
			DataOutputStream salidaAOtroJugador = new DataOutputStream(jugador.getOutputStream());
			JsonObject usuario = new JsonObject();
			usuario.addProperty("Accion", "recibirComunicacionDeNuevaAlianza");
			salidaAOtroJugador.writeUTF(usuario.toString());
			salidaAOtroJugador.writeUTF(personajeUnidoAAlianza.toString());
		}
	}

	public void armarBatalla() throws IOException {
		JsonElement elemento = recibirObjetoJson();
		String nombreAtacante = elemento.getAsJsonObject().get("nombreAtacante").getAsString();
		String nombreAtacado = elemento.getAsJsonObject().get("nombreAtacado").getAsString();
		Personaje personajeAtacado = obtenerPersonajePorNombre(nombreAtacado);
		Alianza aliados = jugadores.get(cliente).invocarAliados();
		Alianza enemigos = personajeAtacado.invocarAliados();
//
		enviarNotificacionDeBatallaATodos(aliados, enemigos);
	
		new BatallaHilo(jugadoresBatalla, aliados, enemigos).start();
		// subirStats();
	}

	private Personaje obtenerPersonajePorNombre(String nombreAtacado) {
		Iterator<Socket> iterator = jugadoresPorMapa.get(mapa).iterator();
		while (iterator.hasNext()) {
			Socket jugador = iterator.next();
			if (jugadores.get(jugador).getNombre().equals(nombreAtacado)) {
				return jugadores.get(jugador);
			}
		}
		return null;
	}

	// Este metodo creo que no se usa
	public String recibirEnemigo() throws IOException {
		JsonElement elemento = recibirObjetoJson();
		return elemento.getAsJsonObject().get("personajeEnemigo").getAsString();
	}

	public void enviarNotificacionDeBatallaATodos(Alianza aliados, Alianza enemigos) throws IOException {
		JsonArray personajesAliados = cargarJsonArrayDeAlianza(aliados);
		JsonArray personajesEnemigos = cargarJsonArrayDeAlianza(enemigos);
		Iterator<Socket> personajes = jugadoresPorMapa.get(mapa).iterator();
		while (personajes.hasNext()) {
			Socket jugador = personajes.next();
			DataOutputStream personaje = new DataOutputStream(jugador.getOutputStream());
			JsonObject accion = new JsonObject();
			accion.addProperty("Accion", "recibirNotificacionDeBatalla");
			personaje.writeUTF(accion.toString());
			personaje.writeUTF(personajesAliados.toString());
			personaje.writeUTF(personajesEnemigos.toString());
		}
	}

	private JsonArray cargarJsonArrayDeAlianza(Alianza alianza) {
		JsonArray personajes = new JsonArray();
		Iterator<Personaje> iteratorAliados = alianza.getPersonajes().iterator();
		while (iteratorAliados.hasNext()) {
			personajes.add(new JsonPrimitive(iteratorAliados.next().getNombre()));
		}
		return personajes;
	}
}
