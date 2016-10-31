package promotionSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Scanner;

import promotionSystem.hilos.HiloCreadorServidor;

public class Servidor {
	
	private int i = 0;
	private int puerto;
	private int cantidadMaximaDeClientes;
	private String archivoDeConfiguracion="C:\\Users\\Pablo\\Workspace\\GameUltimo\\jrpg\\configuracion.config";
	private HashMap<Socket,Personaje> jugadores = new HashMap<Socket,Personaje>();
	
	
	public Servidor(){
		ServerSocket servidor;
		try {
			configurar();
			servidor = new ServerSocket(puerto);
			aceptarClientes(servidor);
			
			
			servidor.close();
		} catch (IOException e) {
			System.err.println("Ocurrió un problema con el Servidor");
		}
	}

	private void aceptarClientes(ServerSocket servidor) throws IOException {
		while(i<cantidadMaximaDeClientes){
			Socket cliente  = servidor.accept();		
			new HiloCreadorServidor(cliente,jugadores).start();;
			i++;
			
		}
	}

	private void configurar() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(archivoDeConfiguracion));
		puerto=scanner.nextInt();
		cantidadMaximaDeClientes=scanner.nextInt();
		scanner.close();
	}
	
	public int cantidadDeJugadores(){
		return jugadores.size();
	}
	

}
