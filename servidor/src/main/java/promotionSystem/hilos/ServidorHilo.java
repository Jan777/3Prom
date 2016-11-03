package promotionSystem.hilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
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

import promotionSystem.Personaje;
import promotionSystem.Punto;
import promotionSystem.mapa.Mapa;
import promotionSystem.razas.castas.humano.GuerreroHumano;

public class ServidorHilo extends Thread {
	private Socket cliente;
	private HashMap<Socket,Personaje> jugadores;
	private ArrayList<Punto> puntosIniciales;
	private HashMap<Personaje,Mapa> jugadoresPorMapa;
	private HashMap<String,Mapa>mapasDisponibles;
	
	public ServidorHilo(Socket cliente,HashMap<Socket,Personaje> jugadores,HashMap<Personaje,Mapa> jugadoresPorMapa,HashMap<String,Mapa> mapasDisponibles){
		this.cliente=cliente;
		this.jugadoresPorMapa=jugadoresPorMapa;
		this.jugadores=jugadores;
		this.mapasDisponibles=mapasDisponibles;
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
			crearPersonaje();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println(jugadores.size());
		mostrarRazas();
		
		
	}

	private void mostrarRazas() {
		 Iterator<Socket> it=jugadores.keySet().iterator();
		 while(it.hasNext()){
			 Socket jugador = it.next();
			 System.out.println(jugadores.get(jugador).getClass().getName());
			 
		 }
		
	}
	private void crearPersonaje() throws Exception {
		String razaYCastaPersonaje;
			razaYCastaPersonaje = new DataInputStream(cliente.getInputStream()).readUTF();
			JsonParser parser = new JsonParser();
			JsonElement elemento = parser.parse(razaYCastaPersonaje);
			Personaje personaje=crearPersonajeAPartirDeRazaYCasta(elemento.getAsJsonObject().get("raza").getAsString(),elemento.getAsJsonObject().get("casta").getAsString());
			jugadores.put(cliente, personaje);
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
	
	private Personaje crearPersonajeAPartirDeRazaYCasta(String raza, String casta) throws Exception {
		return (Personaje) Class.forName("promotionSystem.razas.castas." + raza + "." + casta).newInstance();
	}

	public void enviarMapas() throws IOException{
		JsonArray mapas = new JsonArray(); 
		cargarMapas(mapas);
		JsonObject mapasEnviados = new JsonObject();
		mapasEnviados.add("mapas", mapas);
		new DataOutputStream(cliente.getOutputStream()).writeUTF(mapasEnviados.toString());
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
		String mapaElegido = new DataInputStream(cliente.getInputStream()).readUTF();
		JsonParser parser = new JsonParser();
		JsonElement elemento = parser.parse(mapaElegido);
		jugadoresPorMapa.put(jugadores.get(cliente), mapasDisponibles.get(elemento.getAsJsonObject().get("mapa")));
	}
}
