package promotionSystem;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

import java.util.Scanner;

import com.google.gson.JsonElement;
import com.google.gson.JsonPrimitive;

import promotionSystem.hilos.HiloCreadorServidor;
import promotionSystem.mapa.Mapa;

public class Servidor {
	private Conector conector = new Conector();
	private int i = 0;
	private int puerto;
	private int cantidadMaximaDeClientes;
	private String archivoDeConfiguracion="../configuracion.config";
	private HashMap<Socket,Personaje> jugadores = new HashMap<Socket,Personaje>();
	private HashMap<Personaje,Mapa> jugadoresPorMapa=new HashMap<Personaje,Mapa>();
	private HashMap<String,Mapa>mapasDisponibles= new HashMap<String,Mapa>();
	
	public Servidor(){
		ServerSocket servidor;
		try {
			cargarMapas();
			configurar();
			servidor = new ServerSocket(puerto);
			aceptarClientes(servidor);
			
			
			servidor.close();
		} catch (IOException e) {
			e.printStackTrace();
			//System.err.println("Ocurri� un problema con el Servidor");
		}
	}

	private void cargarMapas() {
		mapasDisponibles.put("Mundo Star Wars",new Mapa(100,100));
		mapasDisponibles.put("Mundo Pokemom",new Mapa(100,100));
		mapasDisponibles.put("Mundo Undertale",new Mapa(100,100));
		mapasDisponibles.put("Mundo Kingdom Hearts",new Mapa(100,100));
		
	}

	private void aceptarClientes(ServerSocket servidor) throws IOException {
		while(i<cantidadMaximaDeClientes){
			Socket cliente  = servidor.accept();		
			new HiloCreadorServidor(cliente,jugadores,jugadoresPorMapa,mapasDisponibles,conector).start();;
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
