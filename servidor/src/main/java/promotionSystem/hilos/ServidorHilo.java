package promotionSystem.hilos;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import promotionSystem.Personaje;
import promotionSystem.razas.castas.humano.GuerreroHumano;

public class ServidorHilo extends Thread {
	private Socket cliente;
	private HashMap<Socket,Personaje> jugadores;
	public ServidorHilo(Socket cliente,HashMap<Socket,Personaje> jugadores){
		this.cliente=cliente;
		this.jugadores=jugadores;
	}
	
	
	public void run(){
		crearPersonaje();
		System.out.println(jugadores.size());
		
		
	}


	private void crearPersonaje() {
		String razaYCastaPersonaje;
		try {
			razaYCastaPersonaje = new DataInputStream(cliente.getInputStream()).readUTF();
			JsonParser parser = new JsonParser();
			JsonElement elemento = parser.parse(razaYCastaPersonaje);
			Personaje personaje=crearPersonajeAPartirDeRazaYCasta(elemento.getAsJsonObject().get("raza").getAsString(),elemento.getAsJsonObject().get("casta").getAsString());
			jugadores.put(cliente, personaje);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}


	private Personaje crearPersonajeAPartirDeRazaYCasta(String raza, String casta) {
		return new GuerreroHumano();
	}

}
