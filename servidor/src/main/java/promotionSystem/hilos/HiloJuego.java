package promotionSystem.hilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import promotionSystem.Alianza;
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
	private int indiceDeAlianzas;
	private Set<Alianza> alianzas;
	
		public HiloJuego(ServerSocket servidor, HashMap<Socket, Personaje> jugadores,HashMap<Mapa, ArrayList<Socket>> jugadoresPorMapa, HashMap<String, Mapa> mapasDisponibles,Conector conector,int cantidadMaximaDeClientes,HashMap<Personaje, Socket> jugadoresBatalla, int indiceDeAlianzas, Set<Alianza> alianzas){
			this.cantidadMaximaDeClientes=cantidadMaximaDeClientes;
			this.servidor=servidor;
			this.jugadoresPorMapa = jugadoresPorMapa;
			this.conector = conector;
			this.jugadores = jugadores;
			this.mapasDisponibles = mapasDisponibles;
			this.jugadoresBatalla=jugadoresBatalla;
			this.indiceDeAlianzas = indiceDeAlianzas;
			this.alianzas = alianzas;
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
				new HiloCreadorServidor(cliente, jugadores, jugadoresPorMapa, mapasDisponibles, conector,jugadoresBatalla, indiceDeAlianzas, alianzas).start();
				i++;

			}
			servidor.close();
		}

}
