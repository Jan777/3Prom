package promotionSystem.hilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;

import promotionSystem.Conector;
import promotionSystem.Personaje;
import promotionSystem.mapa.Mapa;

public class HiloJuego extends Thread {
	private ServerSocket servidor;
	private int i = 0;
	private HashMap<Mapa, ArrayList<Socket>> jugadoresPorMapa;
	private Conector conector;
	private Socket cliente;
	private HashMap<Socket, Personaje> jugadores;
	private HashMap<String, Mapa> mapasDisponibles;
	private int cantidadMaximaDeClientes;
	private HashMap<Personaje, Socket> jugadoresBatalla;
	
		public HiloJuego(ServerSocket servidor, HashMap<Socket, Personaje> jugadores,HashMap<Mapa, ArrayList<Socket>> jugadoresPorMapa, HashMap<String, Mapa> mapasDisponibles,Conector conector,int cantidadMaximaDeClientes,HashMap<Personaje, Socket> jugadoresBatalla){
			this.cantidadMaximaDeClientes=cantidadMaximaDeClientes;
			this.servidor=servidor;
			this.jugadoresPorMapa = jugadoresPorMapa;
			this.conector = conector;
			this.jugadores = jugadores;
			this.mapasDisponibles = mapasDisponibles;
			this.jugadoresBatalla=jugadoresBatalla;
			
		}
		
		public void run(){
			try {
				aceptarClientes();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		private void aceptarClientes() throws IOException {
			while (i < cantidadMaximaDeClientes) {
				Socket cliente = servidor.accept();
				new HiloCreadorServidor(cliente, jugadores, jugadoresPorMapa, mapasDisponibles, conector,jugadoresBatalla).start();
				i++;

			}
			servidor.close();
		}

}
