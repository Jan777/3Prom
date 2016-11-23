package promotionSystem.hilos;

import promotionSystem.Alianza;
import promotionSystem.Conector;
import promotionSystem.Personaje;
import promotionSystem.mapa.Mapa;

import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

public class HiloCreadorServidor extends Thread {
	private Conector conector;
	private Socket cliente;
	private HashMap<Socket, Personaje> jugadores;
	private HashMap<Mapa, ArrayList<Socket>> jugadoresPorMapa;
	private HashMap<String, Mapa> mapasDisponibles;
	private int indiceDeAlianzas;
	private Set<Alianza> alianzas;

	public HiloCreadorServidor(Socket cliente, HashMap<Socket, Personaje> jugadores,
			HashMap<Mapa, ArrayList<Socket>> jugadoresPorMapa, HashMap<String, Mapa> mapasDisponibles,
			Conector conector, Set<Alianza> alianzas, int indiceDeAlianzas) {
		super();
		this.indiceDeAlianzas = indiceDeAlianzas;
		this.alianzas = alianzas;
		this.jugadoresPorMapa = jugadoresPorMapa;
		this.conector = conector;
		this.cliente = cliente;
		this.jugadores = jugadores;
		this.mapasDisponibles = mapasDisponibles;
	}

	public void run() {
		try {
			new ServidorHilo(cliente, jugadores, jugadoresPorMapa, mapasDisponibles, conector, indiceDeAlianzas, alianzas).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
