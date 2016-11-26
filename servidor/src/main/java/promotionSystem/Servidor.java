package promotionSystem;

import promotionSystem.hilos.HiloBatalla;
import promotionSystem.hilos.HiloJuego;
import promotionSystem.mapa.Mapa;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

public class Servidor {
	private Conector conector;

	private int puerto;
	private int cantidadMaximaDeClientes;
	private String archivoDeConfiguracion = "configuracion.config";
	private HashMap<Socket, Personaje> jugadores = new HashMap<>();
	private HashMap<Mapa, ArrayList<Socket>> jugadoresPorMapa = new HashMap<>();
	private HashMap<String, Mapa> mapasDisponibles = new HashMap<>();
	private int indiceDeAlianzas;
	private Set<Alianza> alianzas;

	private ServerSocket servidorBatalla;
	private ServerSocket servidor;
	private HashMap<Personaje, Socket> jugadoresBatalla = new HashMap<>();
	
	public Servidor() throws Exception {
		conector = new Conector();
		ServerSocket servidor;
			indiceDeAlianzas = 0;
			alianzas = new LinkedHashSet<>();
			cargarMapas();
			configurar();
			servidor = new ServerSocket(puerto);
			servidorBatalla = new ServerSocket(puerto+1);
			JOptionPane.showMessageDialog(null,"Servidor en linea","Server",JOptionPane.INFORMATION_MESSAGE);
			new HiloJuego(servidor,jugadores,jugadoresPorMapa,mapasDisponibles,conector,cantidadMaximaDeClientes,jugadoresBatalla, indiceDeAlianzas, alianzas).start();
			new HiloBatalla(servidorBatalla,jugadores,jugadoresBatalla,cantidadMaximaDeClientes).start();
			
		
	}

	private void cargarMapas() {
		mapasDisponibles.put("Mundo Star Wars", new Mapa(100, 100));
		mapasDisponibles.put("Mundo Pokemon", new Mapa(100, 100));
		mapasDisponibles.put("Mundo Undertale", new Mapa(100, 100));
		mapasDisponibles.put("Mundo Kingdom Hearts", new Mapa(100, 100));

		jugadoresPorMapa.put(mapasDisponibles.get("Mundo Star Wars"), new ArrayList<Socket>());
		jugadoresPorMapa.put(mapasDisponibles.get("Mundo Pokemon"), new ArrayList<Socket>());
		jugadoresPorMapa.put(mapasDisponibles.get("Mundo Undertale"), new ArrayList<Socket>());
		jugadoresPorMapa.put(mapasDisponibles.get("Mundo Kingdom Hearts"), new ArrayList<Socket>());
	}

	private void configurar() throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(archivoDeConfiguracion));
		puerto = scanner.nextInt();
		cantidadMaximaDeClientes = scanner.nextInt();
		scanner.close();
	}

	public int cantidadDeJugadores() {
		return jugadores.size();
	}

}
