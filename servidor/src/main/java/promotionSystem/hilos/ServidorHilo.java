package promotionSystem.hilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import promotionSystem.Personaje;
import promotionSystem.Punto;
import promotionSystem.razas.castas.humano.GuerreroHumano;

public class ServidorHilo extends Thread {
	private Socket cliente;
	private HashMap<Socket,Personaje> jugadores;
	private ArrayList<Punto> puntosIniciales;
	
	public ServidorHilo(Socket cliente,HashMap<Socket,Personaje> jugadores){
		this.cliente=cliente;
		this.jugadores=jugadores;
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


	private void enviarPosicionInicial() throws IOException{
		Random random = new Random();
		Punto puntoInicial=puntosIniciales.get(random.nextInt(puntosIniciales.size()));
		JsonObject punto = new JsonObject();
	    punto.addProperty("x", puntoInicial.getX());
		punto.addProperty("y", puntoInicial.getX());	
		jugadores.get(cliente).setPosicion(puntoInicial);
		 new DataOutputStream(cliente.getOutputStream()).writeUTF(punto.toString());
	}
	
	private Personaje crearPersonajeAPartirDeRazaYCasta(String raza, String casta) {
		return new GuerreroHumano();
	}

}
