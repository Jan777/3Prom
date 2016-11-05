package promotionSystem;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

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
	String raza="humano";
	String casta="GuerreroHumano";//viene por swing
	public Cliente(String name) throws Exception {
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

	private Personaje crearPersonaje(String raza, String casta) throws Exception{
		return (Personaje) Class.forName("promotionSystem.razas.castas." + raza + "." + casta).newInstance();
	}

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
	
	public List<String> recibirMapas() throws IOException{
		String mapas = entrada.readUTF();
		JsonParser parser = new JsonParser();
		JsonObject json = parser.parse(mapas).getAsJsonObject();

		String[] mapasRecibidos = json.get("mapas").getAsJsonArray().toString().split(",");
		List<String> listaDeMapas = new ArrayList<String>();
		Collections.addAll(listaDeMapas, mapasRecibidos);
		return listaDeMapas;
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
	

}
