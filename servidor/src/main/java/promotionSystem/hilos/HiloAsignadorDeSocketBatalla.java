package promotionSystem.hilos;

import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;

import promotionSystem.Personaje;

public class HiloAsignadorDeSocketBatalla implements Runnable{
	

	private HashMap<Personaje, Socket> jugadoresBatalla;
	private HashMap<Socket, Personaje> jugadores;
	private Socket cliente;

	public HiloAsignadorDeSocketBatalla(Socket cliente, HashMap<Socket, Personaje> jugadores, HashMap<Personaje, Socket> jugadoresBatalla) {
		this.jugadoresBatalla=jugadoresBatalla;
		this.jugadores=jugadores;
		this.cliente=cliente;
	}

	@Override
	public void run() {
		try {
			
			buscarPersonaje();
		
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private void buscarPersonaje() throws IOException {
		JsonParser parser = new JsonParser();
		JsonElement elemento = parser.parse(new DataInputStream(cliente.getInputStream()).readUTF());
		Iterator<Socket> iterador = jugadores.keySet().iterator();
		boolean encontro = false;
		String nombreJugador = elemento.getAsJsonObject().get("nombre").getAsString();
		while(!encontro&&iterador.hasNext()){
			Socket jugador = iterador.next();
			if(jugadores.get(jugador).getNombre().equals(nombreJugador)){
				jugadoresBatalla.put(jugadores.get(jugador), cliente);
				encontro=true;
			}
		}
	}
	
	
}
