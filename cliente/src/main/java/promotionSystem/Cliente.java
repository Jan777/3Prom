package promotionSystem;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

import com.google.gson.JsonObject;

import promotionSystem.razas.castas.humano.GuerreroHumano;

public class Cliente {
	private Socket cliente;
	private String name;
	private String ip;
	private String sala;
	private int puerto;
	private String archivoDeConfiguracion="C:\\Users\\Pablo\\Workspace\\GameUltimo\\jrpg\\configuracion.config";
	private Personaje personaje;
	
	String raza="Humano";
	String casta="GuerreroHumano";//viene por swing
	public Cliente(String name){

		try {
			
			configurar(archivoDeConfiguracion);
			this.name=name;
			cliente = new Socket(ip,puerto);
			personaje=crearPersonaje(raza,casta);
			enviarPersonaje(raza,casta);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	private Personaje crearPersonaje(String raza, String casta) {
		return new GuerreroHumano();
	}

	private void enviarPersonaje(String raza, String casta) throws IOException {
		JsonObject personaje = new JsonObject();
		personaje.addProperty("raza", raza);
		personaje.addProperty("casta", casta);
		new DataOutputStream(cliente.getOutputStream()).writeUTF(personaje.toString());

	}

	private void configurar(String path) throws FileNotFoundException {
		Scanner scanner = new Scanner(new File(path));
		puerto=scanner.nextInt();
		scanner.nextLine();
		scanner.nextLine();
		ip=scanner.nextLine();
		scanner.close();
	}

}
