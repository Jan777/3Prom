package promotionSystem.hilos;

import java.net.Socket;
import java.util.HashMap;

import promotionSystem.Personaje;

public class HiloCreadorServidor extends Thread {
	
	private Socket cliente;
	HashMap<Socket,Personaje> jugadores;
	
	public HiloCreadorServidor(Socket cliente,HashMap<Socket,Personaje> jugadores){
		super();
		this.cliente=cliente;
		this.jugadores=jugadores;
	}
	
	public void run(){
		new ServidorHilo(cliente,jugadores).start();
	}

}
