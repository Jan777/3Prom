package promotionSystem.hilos;

import promotionSystem.Personaje;

import javax.swing.*;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class HiloBatalla extends Thread {
	private ServerSocket servidorBatalla;
	private HashMap<Personaje, Socket> jugadoresBatalla;
	private HashMap<Socket, Personaje> jugadores;
	private int i=0;
	private int cantidadMaximaDeClientes;

	public HiloBatalla(ServerSocket servidorBatalla, HashMap<Socket, Personaje> jugadores, HashMap<Personaje, Socket> jugadoresBatalla, int cantidadMaximaDeClientes) {
		this.servidorBatalla=servidorBatalla;
		this.jugadoresBatalla=jugadoresBatalla;
		this.jugadores=jugadores;
		this.cantidadMaximaDeClientes=cantidadMaximaDeClientes;
	}

	public void run(){
		try {
			aceptarClientes();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null,"Error al aceptar clientes","Error",JOptionPane.ERROR_MESSAGE);
		}
	}

	private void aceptarClientes() throws IOException {
		while (i < cantidadMaximaDeClientes) {
			Socket cliente = servidorBatalla.accept();
			HiloAsignadorDeSocketBatalla hilo=new HiloAsignadorDeSocketBatalla(cliente,jugadores,jugadoresBatalla);
			new Thread(hilo).start();
			i++;
		}
		servidorBatalla.close();
		
	}
}
