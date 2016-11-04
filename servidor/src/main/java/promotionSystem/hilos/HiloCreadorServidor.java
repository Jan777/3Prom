package promotionSystem.hilos;

import java.io.IOException;
import java.net.Socket;
import java.util.HashMap;

import promotionSystem.Personaje;
import promotionSystem.mapa.Mapa;

public class HiloCreadorServidor extends Thread {
	
	private Socket cliente;
	private HashMap<Socket,Personaje> jugadores;
	private	HashMap<Personaje,Mapa> jugadoresPorMapa;
	private HashMap<String,Mapa>mapasDisponibles;
	public HiloCreadorServidor(Socket cliente,HashMap<Socket,Personaje> jugadores,HashMap<Personaje,Mapa> jugadoresPorMapa,HashMap<String,Mapa>mapasDisponibles){
		super();
		this.jugadoresPorMapa=jugadoresPorMapa;
		this.cliente=cliente;
		this.jugadores=jugadores;
		this.mapasDisponibles=mapasDisponibles;
	}
	
	public void run(){
		try {
			new ServidorHilo(cliente,jugadores,jugadoresPorMapa,mapasDisponibles).start();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
