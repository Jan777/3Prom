package promotionSystem.hilos;

import promotionSystem.Conector;
import promotionSystem.Personaje;
import promotionSystem.mapa.Mapa;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

public class HiloCreadorServidor extends Thread {
	private Conector conector;
	private Socket cliente;
	private HashMap<Socket, Personaje> jugadores;
	private HashMap<Mapa, ArrayList<Socket>> jugadoresPorMapa;
	private HashMap<String, Mapa> mapasDisponibles;
	private HashMap<Personaje, Socket> jugadoresBatalla;

	public HiloCreadorServidor(Socket cliente, HashMap<Socket, Personaje> jugadores,
			HashMap<Mapa, ArrayList<Socket>> jugadoresPorMapa, HashMap<String, Mapa> mapasDisponibles,
			Conector conector,HashMap<Personaje, Socket> jugadoresBatalla) {
		super();
		this.jugadoresPorMapa = jugadoresPorMapa;
		this.conector = conector;
		this.cliente = cliente;
		this.jugadores = jugadores;
		this.mapasDisponibles = mapasDisponibles;
		this.jugadoresBatalla=jugadoresBatalla;
	}

	public void run() {
		try {
			new ServidorHilo(cliente, jugadores, jugadoresPorMapa, mapasDisponibles, conector,jugadoresBatalla).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
