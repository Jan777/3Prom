package promotionSystem;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;

import java.io.*;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
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

	
	//FIXME si no me equivoco este metodo seria innecesario
	private void enviarPersonaje(String raza, String casta) throws IOException {
		JsonObject personaje = new JsonObject();
		personaje.addProperty("raza", raza);
		personaje.addProperty("casta", casta);
		salida.writeUTF(personaje.toString());
	}

	private void configurar(String path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(path));
		puerto=scanner.nextInt();
		scanner.nextLine();
		scanner.nextLine();
		ip=scanner.nextLine();
		scanner.close();
	}

	public void recibirPosicionInicial() throws IOException{
		String punto = entrada.readUTF();
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(punto).getAsJsonObject();
		personaje.setPosicion(new Gson().fromJson(json,Punto.class));
	}
	
	public List<String> recibirRazas() throws IOException{
		return recibirLista("razas");
	}
	
	public void enviarRazaSeleccionada(String raza) throws IOException{
		JsonObject razaElegida = new JsonObject();
		razaElegida.addProperty("raza",raza);
	    salida.writeUTF(razaElegida.toString());
	}
	
	public List<String> recibirCasta() throws IOException{
		
		return recibirLista("castas");
	}

	private List<String> recibirLista(String propiedad) throws IOException {
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(entrada.readUTF()).getAsJsonObject();
		String[] listaRecibidas = json.get(propiedad).getAsJsonArray().toString().split(",");
		List<String> lista = new ArrayList<String>();
		Collections.addAll(lista, listaRecibidas);
		return lista;
	}
	
	public void enviarCastaSeleccionada(String casta) throws Exception{
		JsonObject castaElegida = new JsonObject();
		castaElegida.addProperty("casta",casta);
	    salida.writeUTF(castaElegida.toString());
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
	
	public void enviarInvitacionAAlianza(Personaje invitado) throws IOException{
		JsonObject personajeInvitado=new JsonObject();
		personajeInvitado.addProperty("nombre", invitado.getNombre());
		salida.writeUTF(personajeInvitado.toString());
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

}
