package promotionSystem;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Cliente {
	private Socket cliente;
	private String name;
	private String ip;
	private String sala;
	private int puerto;
	private String archivoDeConfiguracion="configuracion.config";
	private Personaje personaje;
	private DataOutputStream salida;
	private DataInputStream entrada;
	private String raza;
	private String casta;
	public Cliente() throws Exception {
		try {
			configurar(archivoDeConfiguracion);
			this.name=name;
			cliente = new Socket(ip,puerto);
			salida=new DataOutputStream(cliente.getOutputStream());
			entrada=new DataInputStream(cliente.getInputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private Personaje crearPersonaje() throws Exception{
		return (Personaje) Class.forName("promotionSystem.razas.castas." + raza + "." + casta).newInstance();
	}

	private void configurar(String path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(path));
		puerto=scanner.nextInt();
		scanner.nextLine();
		scanner.nextLine();
		ip=scanner.nextLine();
		scanner.close();
	}


	
	public List<String> recibirRazas() throws IOException{
		return recibirLista("razas");
	}
	
	public ArrayList<String> recibirListaDeCastas() throws IOException {
		return (ArrayList<String>) recibirLista("castas");
	}

	

	private List<String> recibirLista(String propiedad) throws IOException {
		JsonParser parser = new JsonParser();
		JsonArray json = parser.parse(entrada.readUTF()).getAsJsonArray();
		Type tipoListaRazas = new TypeToken<List<String>>(){}.getType();
		List<String> listaRecibidas = new Gson().fromJson(json, tipoListaRazas);
		return listaRecibidas;
	}

	public void enviarRazaYCastaSeleccionada(String raza, String casta) throws Exception {
		this.raza=raza.replaceAll(" ", "").replace(raza.charAt(0),Character.toLowerCase(raza.charAt(0))); 
		this.casta=casta.replaceAll(" ", ""); 
		JsonObject razaYCastaElegidas = new JsonObject();
		razaYCastaElegidas.addProperty("raza",this.raza);
		razaYCastaElegidas.addProperty("casta",this.casta);
		salida.writeUTF(razaYCastaElegidas.toString());
		crearPersonaje();
		
	}
	
	public List<String> recibirMapas() throws IOException{
		return recibirLista("mapas");
	}
	
	public void enviarMapaSeleccionado(String mapa) throws IOException{
		JsonObject mapaElegido = new JsonObject();
	    mapaElegido.addProperty("mapa",mapa);
	    salida.writeUTF(mapaElegido.toString());
	}
	
	
	
	public void enviarUsuarioYContraseña(String nombre, String contraseña) throws IOException{
			int hashContraseña=contraseña.hashCode();
			JsonObject usuario=new JsonObject();
			usuario.addProperty("nombre",nombre);
			usuario.addProperty("contrasena", hashContraseña);
			salida.writeUTF(usuario.toString());	
	}

	public String resultado() throws IOException {
		return entrada.readUTF();
	}

	public void enviarUsuario(String nombre) throws IOException {
		JsonObject usuario=new JsonObject();
		usuario.addProperty("nombre",nombre);
		salida.writeUTF(usuario.toString());	
	}

	public boolean recibirComprobacion() throws Exception {
		JsonParser parser = new JsonParser();
		String resultado = parser.parse(entrada.readUTF()).getAsJsonObject().get("Resultado").getAsString();
		return resultado.equals("false");
	}

	public void enviarAccion(String accion) throws IOException {
		JsonObject usuario=new JsonObject();
		usuario.addProperty("Accion",accion);
		salida.writeUTF(usuario.toString());
		
	}

	
	///No implementados.
	public void enviarInvitacionAAlianza(Personaje invitado) throws IOException{
		JsonObject personajeInvitado=new JsonObject();
		personajeInvitado.addProperty("nombre", invitado.getNombre());
		salida.writeUTF(personajeInvitado.toString());
	}
	
	//FIXME Revisar este metodo, no me convence.
	public void recibirInvitacionAAlianza() throws JsonSyntaxException, IOException{
		JsonParser parser = new JsonParser();
		JsonElement elemento = parser.parse(entrada.readUTF());
		Personaje invitador = new Gson().fromJson(elemento, Personaje.class);
		personaje.tratarAlianza(invitador);

	}
	
	public void enviarRespuestaAInvitacionDeAlianza(boolean respuesta) throws Exception{
		JsonObject respuestaEnviada = new JsonObject();
		respuestaEnviada.addProperty("respuesta", respuesta);
		salida.writeUTF(respuestaEnviada.toString());
	}

	public void recibirPosicionInicial() throws IOException{
		String punto = entrada.readUTF();
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(punto).getAsJsonObject();
		personaje.setPosicion(new Gson().fromJson(json,Punto.class));
	}
	
	public void enviarEnemigoYListaDePersonajesParaBatalla(Personaje enemigo, ArrayList<Personaje> amiga) throws IOException{
		JsonObject personaje=new JsonObject();
		JsonObject personajeEnemigo=new JsonObject();
		JsonArray listaDeAmigos=new JsonArray();
		personajeEnemigo.addProperty("nombre", enemigo.getNombre());
		personaje.addProperty("personajeEnemigo", personajeEnemigo.toString());
		Iterator<Personaje> iterator = amiga.iterator();
		while(iterator.hasNext()){
			listaDeAmigos.add(new JsonPrimitive(iterator.next().getNombre()));
		}
		personaje.addProperty("aliados", listaDeAmigos.toString());
		salida.writeUTF(personaje.toString());
	}
	
	private JsonElement recibirObjetoJson() throws IOException {
		JsonParser parser = new JsonParser();
		return parser.parse(entrada.readUTF());
	}
	
	public void recibirNotificacionDeBatalla() throws IOException{
		JsonElement elemento = recibirObjetoJson();
		String atacante = elemento.getAsJsonObject().get("personajeEnemigo").getAsString();
		String accion = elemento.getAsJsonObject().get("accion").getAsString();
	}
	
	public void enviarListaDeAliados(ArrayList<Personaje> aliados) throws IOException{
		JsonObject personaje=new JsonObject();
		JsonObject personajePropio=new JsonObject();
		JsonArray listaDeAmigos=new JsonArray();
		personajePropio.addProperty("nombre", this.personaje.getNombre());
		personaje.addProperty("personajePropio", personajePropio.toString());
		Iterator<Personaje> iterator = aliados.iterator();
		while(iterator.hasNext()){
			listaDeAmigos.add(new JsonPrimitive(iterator.next().getNombre()));
		}
		personaje.addProperty("aliados", listaDeAmigos.toString());
		salida.writeUTF(personaje.toString());
	}

	

}
