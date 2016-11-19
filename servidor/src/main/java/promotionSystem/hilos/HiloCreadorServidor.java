package promotionSystem.hilos;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import promotionSystem.Conector;
import promotionSystem.Personaje;
import promotionSystem.mapa.Mapa;

public class HiloCreadorServidor extends Thread {
	private Conector conector;
	private Socket cliente;
	private HashMap<Socket, Personaje> jugadores;
	private HashMap<Mapa, ArrayList<Socket>> jugadoresPorMapa;
	private HashMap<String, Mapa> mapasDisponibles;

	public HiloCreadorServidor(Socket cliente, HashMap<Socket, Personaje> jugadores,
			HashMap<Mapa, ArrayList<Socket>> jugadoresPorMapa, HashMap<String, Mapa> mapasDisponibles,
			Conector conector) {
		super();
		this.jugadoresPorMapa = jugadoresPorMapa;
		this.conector = conector;
		this.cliente = cliente;
		this.jugadores = jugadores;
		this.mapasDisponibles = mapasDisponibles;
	}

	public void run() {
		try {
			new ServidorHilo(cliente, jugadores, jugadoresPorMapa, mapasDisponibles, conector).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
