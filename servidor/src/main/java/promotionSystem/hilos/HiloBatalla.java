package promotionSystem.hilos;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import javax.swing.JOptionPane;

import promotionSystem.Personaje;

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
			System.exit(0);
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
