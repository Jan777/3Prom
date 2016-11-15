package promotionSystem.hilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Random;


import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import promotionSystem.Alianza;
import promotionSystem.Conector;
import promotionSystem.Personaje;
import promotionSystem.Punto;
import promotionSystem.mapa.Mapa;

public class ServidorHilo extends Thread {
	private Socket cliente;
	private boolean continuar=true;
	private HashMap<Socket,Personaje> jugadores;
	private ArrayList<Punto> puntosIniciales;
	private HashMap<Mapa,ArrayList<Socket>> jugadoresPorMapa;
	private HashMap<String,Mapa>mapasDisponibles;
	private DataInputStream entrada;
	private DataOutputStream salida;
	private String raza;
	private String casta;
	private Conector conector;
	private String nombreCliente;
	private int nivel;
	private Mapa mapa;
	public ServidorHilo(Socket cliente,HashMap<Socket,Personaje> jugadores,HashMap<Mapa,ArrayList<Socket>> jugadoresPorMapa,HashMap<String,Mapa> mapasDisponibles,Conector conector) throws IOException{
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
		puntosIniciales.add(new Punto(1,1));
		puntosIniciales.add(new Punto(10,10));
		puntosIniciales.add(new Punto(20,20));
		puntosIniciales.add(new Punto(30,30));
		puntosIniciales.add(new Punto(40,40));
	}
	
	public void run(){
		try {

			while(continuar){
				Method miMetodo = ServidorHilo.class.getMethod(recibirAccion());
				miMetodo.invoke(this);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	public void cargarPersonaje() throws Exception{
		jugadores.put(cliente,obtenerPersonaje()); 
		enviarPersonaje();
		
	}
	
	
	public void mover() throws IOException{
		jugadores.get(cliente).setPosicion(obtenerPuntoEnviado());
		enviarAlRestoPunto();
		
	}
	private void enviarAlRestoPunto() throws IOException {
		JsonObject puntoAMover = new JsonObject();
		puntoAMover.addProperty("nombre", nombreCliente);
		puntoAMover.addProperty("x",jugadores.get(cliente).getPosicion().getX());
		puntoAMover.addProperty("y",jugadores.get(cliente).getPosicion().getY());
		enviarMensajeAJugadores(puntoAMover,jugadoresPorMapa.get(mapa));
		
	}

	private Punto obtenerPuntoEnviado() throws IOException {
		JsonElement elemento = recibirObjetoJson(); 
		return new Gson().fromJson(elemento, Punto.class);
	}

	private Personaje obtenerPersonaje() throws Exception {
		raza=conector.obtenerRazaPersonaje(nombreCliente);
		casta=conector.obtenerCastaPersonaje(nombreCliente);
		nivel=conector.obtenerNivelPersonaje(nombreCliente);
		Personaje personaje = crearPersonajeAPartirDeRazaYCasta();
		personaje.subirStats(nivel-1);
		personaje.setNombre(nombreCliente);
		return personaje;
	}

	private void enviarPersonaje() throws IOException {
		JsonObject personaje= new JsonObject();
		personaje.addProperty("raza", raza);
		personaje.addProperty("casta", casta);
		personaje.addProperty("nivel", nivel);
		salida.writeUTF(personaje.toString());
	}

	public void cerrar() throws IOException{
		cliente.close();
	    continuar=false;
	}
	
	public void recibirMapas() throws IOException{
		enviarMapas();
	}
	
	public void  seleccionarMapa() throws IOException{
		recibirMapaElegido();
		enviarPosicionInicial();	
//		enviarPersonajeAlResto();
	}
	
	
	private void enviarPersonajeAlResto() throws IOException {
		JsonObject json = new JsonObject();
		json.addProperty("raza",raza);
		json.addProperty("raza",casta);
		json.addProperty("raza",nivel);
		json.addProperty("x",jugadores.get(cliente).getPosicion().getX());
		json.addProperty("y",jugadores.get(cliente).getPosicion().getY());
		enviarMensajeAJugadores(json, jugadoresPorMapa.get(mapa));
	}

	private void enviarMensajeAJugadores(JsonObject json,ArrayList<Socket> jugadoresAEnviar) throws IOException {
		Iterator<Socket> iterador = jugadoresAEnviar.iterator();
		while(iterador.hasNext()){
			Socket jugador = iterador.next();
			if(jugador!=cliente){
				new DataOutputStream(jugador.getOutputStream()).writeUTF(json.toString());
			}
		}
	}

	public void registrar() throws Exception{
		registrarJugador();
	
	}
	
	public void login(){
		loguearJugador();
	}
	
	public void seleccionarRazaYCasta() throws Exception{
		recibirRazaYCasta();
		crearPersonaje(); 
	}
	
	private void recibirRazaYCasta() throws IOException {
			JsonElement elemento = recibirObjetoJson(); 
			raza =elemento.getAsJsonObject().get("raza").getAsString();
			casta =elemento.getAsJsonObject().get("casta").getAsString();
	}

	private void registrarJugador() throws Exception {
		if(!comprobarUsuario()){
			crearUsuario();	
			enviarRazas();
			enviarListaDeCastas();
		}
	}

	private String recibirAccion() throws Exception{
		JsonElement elemento = recibirObjetoJson(); 
		return elemento.getAsJsonObject().get("Accion").getAsString();
	}

	private void loguearJugador() {
		try {			
			if(!validarContraseña()){
				salida.writeUTF("false");
			}
			else{
				salida.writeUTF("true");				
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private boolean comprobarUsuario() throws Exception{
		JsonElement elemento = recibirObjetoJson(); 
		JsonObject respuesta=new JsonObject();
		boolean resultado =conector.validarNombreUsuario(elemento.getAsJsonObject().get("nombre").getAsString());
		respuesta.addProperty("Resultado",resultado);
		salida.writeUTF(respuesta.toString());
		return resultado;
	}

	private void crearUsuario() throws JsonSyntaxException, IOException, SQLException {
		JsonElement elemento = recibirObjetoJson(); 
		nombreCliente=elemento.getAsJsonObject().get("nombre").getAsString();
	    conector.agregarUsuario(nombreCliente,Integer.parseInt((elemento.getAsJsonObject().get("contrasena").getAsString())));
	}

	private boolean validarContraseña() throws Exception {
		JsonElement elemento = recibirObjetoJson(); 
		nombreCliente=elemento.getAsJsonObject().get("nombre").getAsString();
		return conector.validarUsuario(nombreCliente,Integer.parseInt((elemento.getAsJsonObject().get("contrasena").getAsString())));
	
	}

	private void crearPersonaje() throws Exception {
		Personaje personaje=crearPersonajeAPartirDeRazaYCasta();
		personaje.setNombre(nombreCliente);
		jugadores.put(cliente, personaje);
		conector.agregarPersonaje(personaje,raza,casta);
	}



	
	public void enviarRazas() throws IOException{
		JsonArray razas = new JsonArray(); 
		cargarRazas(razas);
		enviarLista(razas,"razas");
		
	}

	private void enviarLista(JsonArray lista,String nombre) throws IOException {
		salida.writeUTF(lista.toString());
	}
	
	private void cargarRazas(JsonArray razas) {
		
		JsonElement razaStarWars = new JsonPrimitive("Star Wars");
		JsonElement razaPokemon = new JsonPrimitive("Pokemon");
		JsonElement razaUndertale = new JsonPrimitive("Undertale");
		JsonElement razaKingdomHearts = new JsonPrimitive("Kingdom Hearts");
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
		JsonElement elemento = recibirObjetoJson(); 
		raza=elemento.getAsJsonObject().get("raza").getAsString();
		System.out.println(raza);
		
	}

	private void enviarListaDeCastas() throws Exception {
		JsonArray castas = new JsonArray(); 
		cargarCastas(castas);
		enviarLista(castas,"castas");
	
	}

	//FIXME esto hay que cambiarlo urgente.
	private void cargarCastas(JsonArray castas) {
		
		castas.add(new JsonPrimitive("Guerrero Humano"));
		castas.add(new JsonPrimitive("Mago Humano"));
		castas.add(new JsonPrimitive("Tanque Humano"));
		
		castas.add(new JsonPrimitive("Riku"));
		castas.add(new JsonPrimitive("Sora"));
		castas.add( new JsonPrimitive("Roxas"));

		castas.add(new JsonPrimitive("Pokemon Tipo Fuego"));
		castas.add(new JsonPrimitive("Pokemon Tipo Agua"));
		castas.add( new JsonPrimitive("Pokemon Tipo Planta"));
		
		castas.add(new JsonPrimitive("Jedi"));
		castas.add(new JsonPrimitive("Droide"));
		castas.add(new JsonPrimitive("Wookie"));
		

		castas.add(new JsonPrimitive("Chara"));	
		

		castas.add(new JsonPrimitive("Tanque Orco"));
		castas.add(new JsonPrimitive("Mago Orco"));
		castas.add( new JsonPrimitive("Guerrero Orco"));
		
	}
	
	public void recibirCastaElegida() throws IOException{
		JsonElement elemento = recibirObjetoJson(); 
		casta=elemento.getAsJsonObject().get("casta").getAsString();
	}
	
	private Personaje crearPersonajeAPartirDeRazaYCasta() throws Exception {
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
		JsonElement elemento = recibirObjetoJson();
		mapa=mapasDisponibles.get(elemento.getAsJsonObject().get("mapa").getAsString());
		jugadoresPorMapa.get(mapa).add(cliente);
	}
	
	
	
	private JsonElement recibirObjetoJson() throws IOException {
		JsonParser parser = new JsonParser();
		return parser.parse(entrada.readUTF());
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
	
	
	/**no implementados**/	
	
	public void comunicarInvitacionAAlianza() throws IOException{
		Personaje personaje = recibirInvitacionAAlianza();
		Socket invitado = enviarInvitacionAAlianza(personaje);
		recibirRespuestaDeInvitacionAAlianza(invitado);
		
	}

	private void recibirRespuestaDeInvitacionAAlianza(Socket invitado) throws IOException {
			
			JsonParser parser = new JsonParser();
			JsonElement elemento = parser.parse(new DataInputStream(invitado.getInputStream()).readUTF());
		if(elemento.getAsJsonObject().get("respuesta").getAsString().equals("true")){
			jugadores.get(invitado).aceptarAlianza(jugadores.get(cliente));
			comunicarAlianza();
		}
		else{
			enviarBatalla();
		}
			
		
	}

	private Personaje recibirInvitacionAAlianza() throws IOException {
		JsonElement elemento = recibirObjetoJson(); 
		return new Gson().fromJson(elemento, Personaje.class);
	}
	

	private Socket enviarInvitacionAAlianza(Personaje personaje) throws IOException {
		Iterator<Socket> iterator= jugadoresPorMapa.get(mapa).iterator();
		while(iterator.hasNext()){
			Socket jugador = iterator.next();
			if(jugadores.get(jugador).equals(personaje)){
				JsonObject personajeInvitador = new JsonObject();	
				personajeInvitador.addProperty("nombre", jugadores.get(cliente).getNombre());
				new DataOutputStream(jugador.getOutputStream()).writeUTF(personajeInvitador.toString());
				return jugador;
				
			}
		}
		return null;
	}
	

	
	//FIXME terminar esos metodos
	private void comunicarAlianza() throws IOException {
		Iterator<Socket> iterador =jugadoresPorMapa.get(mapa).iterator();
		List<Personaje>listaDeAliados=jugadores.get(cliente).getAlianza().getPersonajes();
		JsonObject json = new JsonObject();
		json.addProperty("nombreAliado",jugadores.get(cliente).getNombre());
		while(iterador.hasNext()){
			Socket jugador = iterador.next();
			Personaje personaje=jugadores.get(jugador);
			if(!personaje.equals(jugadores.get(cliente))&&listaDeAliados.contains(personaje)){
				new DataOutputStream(jugador.getOutputStream()).writeUTF(json.toString());
			}
		}
	}

	private void enviarBatalla() {
		//TODO hacer metodo para enviar batalla.
		
	}
	
	
	
	
	
	public void armarBatalla() throws IOException{
		String enemigo = recibirEnemigo();
		Personaje personajeEnemigo = enviarNotificacionDeComienzoDeBatallaAEnemigo(enemigo);
		Alianza aliados = jugadores.get(cliente).invocarAliados();
		Alianza enemigos = personajeEnemigo.invocarAliados();
		new BatallaHilo(jugadores,aliados,enemigos).start();;
	}

	
	private Personaje enviarNotificacionDeComienzoDeBatallaAEnemigo(String enemigo) throws IOException {
		Iterator<Socket> iterador = jugadoresPorMapa.get(mapa).iterator();
		while(iterador.hasNext()){
			Socket jugador=iterador.next();
			if(jugadores.get(jugador).getNombre().equals(enemigo)){
				JsonObject json = new JsonObject();
				json.addProperty("nombreEnemigo",jugadores.get(cliente).getNombre());
				new DataOutputStream(jugador.getOutputStream()).writeUTF(json.toString());
				return jugadores.get(jugador);
			}
		}
		return null;
	}

	public String recibirEnemigo() throws IOException{
		JsonElement elemento = recibirObjetoJson();
		return elemento.getAsJsonObject().get("personajeEnemigo").getAsString();
	}
	
	public void enviarNotificacionDeBatalla(Personaje atacado, String accion, Personaje atacante) throws IOException{
		JsonObject personaje=new JsonObject();
		personaje.addProperty("personajeAtacado", atacado.toString());
		personaje.addProperty("accion", accion);
		personaje.addProperty("personajeAtacante", atacante.toString());
		salida.writeUTF(personaje.toString());
	}
	

	public void enviarNotificacionDeBatallaATodosLosParticipantes(ArrayList<Personaje> participantes) throws IOException{
		JsonArray personajeBatalla=new JsonArray();
		Iterator<Personaje> iterator = participantes.iterator();
		while(iterator.hasNext()){
			personajeBatalla.add(new JsonPrimitive(iterator.next().getNombre()));
		}
		Iterator<Personaje> iteratorPersonajes = participantes.iterator();
		while(iteratorPersonajes.hasNext()){
			String personaje = iteratorPersonajes.next().getNombre();
			Iterator<Socket> iteratorSocket= jugadores.keySet().iterator();
			boolean encontro=false;
			while(!encontro && iteratorSocket.hasNext()){
				Socket jugador = iteratorSocket.next();
				if(jugadores.get(jugador).equals(personaje)){
					new DataOutputStream(jugador.getOutputStream()).writeUTF(personajeBatalla.toString());;
					encontro = true;
				}
			}
		}
	}
	
	public void librarBatalla(){
		do{
//			Personaje personajeConTurno = decidirTurno();
//			enviarTurno(personajeConTurno);
		}while(hayAlMenosUnPersonajeDeAlMenosUnEquipoVivo());
		
	}
	
	private void decidirTurno() {
		
	}

	private boolean hayAlMenosUnPersonajeDeAlMenosUnEquipoVivo() {
		return true;
	}

	public void enviarTurno(Personaje personaje) throws IOException{
		JsonObject personajeConTurno=new JsonObject();
		personajeConTurno.addProperty("accion", "turno");
		/*Iterator<Personaje> iterator = jugadores.entrySet().iterator();
		while(iterator.hasNext()){
			if(jugadores.entrySet().equals(personaje)){
				
			}
			personajeBatalla.add(new JsonPrimitive(iterator.next().getNombre()));
		}
		
		Socket socket = jugadores;
		new DataOutputStream(socket.getOutputStream()).writeUTF(personajeConTurno.toString());;
		*/
	}
}
