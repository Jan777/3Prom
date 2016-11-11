package promotionSystem.hilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
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
	private String nombreCliente;
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

			while(true){
				Method miMetodo = ServidorHilo.class.getMethod(recibirAccion());
				miMetodo.invoke(this);
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		
	
	}
	
	public void cerrar() throws IOException{
		cliente.close();
	}
	
	public void recibirMapas() throws IOException{
		enviarMapas();
	}
	
	public void  seleccionarMapa() throws IOException{
		recibirMapaElegido();
	}
	
	
	public void registrar() throws Exception{
		registrarJugador();
		enviarRazas();
		enviarListaDeCastas();
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
			JsonObject respuesta=new JsonObject();
			raza =elemento.getAsJsonObject().get("raza").getAsString();
			casta =elemento.getAsJsonObject().get("casta").getAsString();
	}

	private void registrarJugador() throws Exception {
		if(!comprobarUsuario()){
			crearUsuario();			
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
		return conector.validarUsuario(elemento.getAsJsonObject().get("nombre").getAsString(),Integer.parseInt((elemento.getAsJsonObject().get("contrasena").getAsString())));
	
	}

	private void crearPersonaje() throws Exception {
		Personaje personaje=crearPersonajeAPartirDeRazaYCasta();
		jugadores.put(cliente, personaje);
		conector.agregarPersonaje(nombreCliente,personaje,raza,casta);
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
		jugadoresPorMapa.put(jugadores.get(cliente), mapasDisponibles.get(elemento.getAsJsonObject().get("mapa").getAsString()));
	}
	
	
	
	private JsonElement recibirObjetoJson() throws IOException {
		JsonParser parser = new JsonParser();
		return parser.parse(entrada.readUTF());
	}
	
	
	/**no implementados**/
	public void comunicarInvitacionAAlianza() throws IOException{
		Personaje personaje = recibirInvitacionAAlianza();
		enviarInvitacionAAlianza(personaje);		
	}

	private Personaje recibirInvitacionAAlianza() throws IOException {
		JsonElement elemento = recibirObjetoJson(); 
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
	
	//FIXME terminar esos metodos
	public void recibirRespuestaDeInvitacionAAlianza() throws JsonSyntaxException, IOException{
		JsonElement elemento = recibirObjetoJson(); 
		if(elemento.getAsJsonObject().get("respuesta").getAsString().equals("true")){
			comunicarAlianza();
		}
		else{
			enviarBatalla();
		}
		
	}

	private void comunicarAlianza() {
		//TODO hacer metodo para comunicar alianza
		
	}

	private void enviarBatalla() {
		//TODO hacer metodo para enviar batalla.
		
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

	
}
