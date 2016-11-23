package promotionSystem.hilos;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import promotionSystem.Alianza;
import promotionSystem.Item;
import promotionSystem.Personaje;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.util.*;

public class BatallaHilo extends Thread {
	private Alianza alianza1;
	private Alianza alianza2;
	private List<Personaje> listaDePersonajes;
	private HashMap<Personaje, Socket> socketAlianza1;
	private HashMap<Personaje, Socket> socketAlianza2;
	private int numeroDePersonajeAlQueLeCorrespondeElTurno;
	private String accion;
	private ArrayList<Item> pozoDeItems;
	private ArrayList<Personaje> muertos;
	private Personaje personajeActual;
	private HashMap<Personaje, Socket> jugadoresBatalla;
	private Socket socketActual;
	private DataOutputStream salidaJugadorActual;
	private DataInputStream entradaJugadorActual;
	private Personaje personajeEnemigo;
	private int cantidadMuertesAlianza1;
	private int cantidadMuertesAlianza2;
	private String hechizo;
	public BatallaHilo(HashMap<Personaje, Socket> jugadoresBatalla, Alianza alianza1, Alianza alianza2) {
		this.alianza1 = alianza1;
		this.alianza2 = alianza2;
		this.jugadoresBatalla=jugadoresBatalla;
		 cantidadMuertesAlianza1 = 0;
		 cantidadMuertesAlianza2 = 0;
		 muertos=new ArrayList<>();
	}



	public void run() {
		
		listaDePersonajes=new ArrayList<>();
		listaDePersonajes.addAll(alianza1.getPersonajes());
		listaDePersonajes.addAll(alianza2.getPersonajes());
		Collections.sort(listaDePersonajes, Collections.reverseOrder());
	
		try {
			while (cantidadMuertesAlianza1 < alianza1.cantidadDePersonajes()
					&& cantidadMuertesAlianza2 < alianza2.cantidadDePersonajes()) {

				darTurno();
				System.out.println("turno para: "+ personajeActual.getNombre());
				recibirAccionPersonaje();
				realizarAccion();
				despuesDelTurno();
			} 
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
	/*	revisarSiAlgunPersonajeMurioYEnEseCasoSacarleLosItems();
		tratarEntregaDeItems();
		reasignarPersonajesAlMapa();*/
	}



	private void despuesDelTurno() {
		if(!personajeEnemigo.estaVivo()){
			if(alianza1.getPersonajes().contains(personajeEnemigo)){
				cantidadMuertesAlianza1++;
			}
			else{
				cantidadMuertesAlianza2++;
			}
			muertos.add(personajeEnemigo);
		
		}
		
	}



	private void revisarSiAlgunPersonajeMurioYEnEseCasoSacarleLosItems() {
		Iterator<Personaje> iteratorPersonajes = listaDePersonajes.iterator();
		while (iteratorPersonajes.hasNext()) {
			Personaje personajeActual = iteratorPersonajes.next();
			if (!personajeActual.estaVivo()) {
				muertos.add(personajeActual);
				pozoDeItems.addAll(personajeActual.getItems());//FIXME se le saca uno solo.
			}
		}
	}



	private void realizarAccion()
			throws Exception {
		Method miMetodo = BatallaHilo.class.getMethod(accion);
		miMetodo.invoke(this);
	}

	public void atacar() throws JsonSyntaxException, IOException {
		JsonParser parser = new JsonParser();
		JsonElement elemento;
		
		elemento = parser.parse(entradaJugadorActual.readUTF());
		String enemigo = elemento.getAsJsonObject().get("enemigo").getAsString();
		if (estaEnLaAlianzaUno(personajeActual)) {	
			personajeEnemigo = obtenerPersonaje(enemigo, alianza2);
		} else {
			personajeEnemigo = obtenerPersonaje(enemigo, alianza1);
		}

		personajeActual.atacar(personajeEnemigo);
		
		informarAtacarAlResto();
		
	}
	
	private void informarAtacarAlResto() throws IOException {
		enviarNotificacionDeAtacarATodosLosParticipantesDeUnaAlianza();		
	}
	
	
	private void enviarNotificacionDeAtacarATodosLosParticipantesDeUnaAlianza() throws IOException {
		JsonObject mensaje = new JsonObject();
		mensaje.addProperty("Accion", "ataqueRealizado");
		
		JsonObject ataque = new JsonObject();
		ataque.addProperty("atacante", personajeActual.getNombre());
		ataque.addProperty("atacado",personajeEnemigo.getNombre());
		
		
		Iterator<Personaje> iteratorSocket1 = listaDePersonajes.iterator();
			
		while (iteratorSocket1.hasNext()) {
			Personaje jugador = iteratorSocket1.next();
			if(!jugador.getNombre().equals(personajeActual.getNombre())){
				System.out.println("jugador avisado " + jugador.getNombre());
				DataOutputStream salidaJugador = new DataOutputStream(jugadoresBatalla.get(jugador).getOutputStream());				
				salidaJugador.writeUTF(mensaje.toString());
				salidaJugador.writeUTF(ataque.toString());
			}
		}
		
	
		
	}
	
	
	public void hechizar() throws JsonSyntaxException, IOException{
		JsonParser parser = new JsonParser();
		JsonElement elemento;
		
		elemento = parser.parse(entradaJugadorActual.readUTF());
		String enemigo = elemento.getAsJsonObject().get("enemigo").getAsString();
		if (estaEnLaAlianzaUno(personajeActual)) {	
			personajeEnemigo = obtenerPersonaje(enemigo, alianza2);
		} else {
			personajeEnemigo = obtenerPersonaje(enemigo, alianza1);
		}
		
		hechizo = elemento.getAsJsonObject().get("hechizo").getAsString();
		personajeActual.atacarConMagia(personajeEnemigo, hechizo);
		
		
		informarAtacarConMagiaAlResto();
	}


	private void informarAtacarConMagiaAlResto() throws IOException {
		JsonObject mensaje = new JsonObject();
		mensaje.addProperty("Accion", "ataqueConMagiaRealizado");
		
		JsonObject ataque = new JsonObject();
		ataque.addProperty("atacante", personajeActual.getNombre());
		ataque.addProperty("atacado",personajeEnemigo.getNombre());
		ataque.addProperty("hechizo", hechizo);
		
		
		Iterator<Personaje> iteratorSocket1 = listaDePersonajes.iterator();
			
		while (iteratorSocket1.hasNext()) {
			Personaje jugador = iteratorSocket1.next();
			if(!jugador.getNombre().equals(personajeActual.getNombre())){
				System.out.println("jugador avisado " + jugador.getNombre());
				DataOutputStream salidaJugador = new DataOutputStream(jugadoresBatalla.get(jugador).getOutputStream());				
				salidaJugador.writeUTF(mensaje.toString());
				salidaJugador.writeUTF(ataque.toString());
			}
		}
		
	}



	private Personaje obtenerPersonaje(String enemigo, Alianza alianza) {
		for (Personaje personaje : alianza.getPersonajes()) {
			if (personaje.getNombre().equals(enemigo)) {
				return personaje;
			}
		}
		return null;
	}

	private void recibirAccionPersonaje() throws IOException {
		JsonParser parser = new JsonParser();
		JsonElement elemento = parser.parse(entradaJugadorActual.readUTF());
		accion = elemento.getAsJsonObject().get("Accion").getAsString();
	}

	private void darTurno() throws IOException {
		personajeActual = listaDePersonajes.get(numeroDePersonajeAlQueLeCorrespondeElTurno);
		while (!personajeActual.estaVivo()) {
			personajeActual = listaDePersonajes.get(++numeroDePersonajeAlQueLeCorrespondeElTurno);
		}
		JsonObject personajeConTurno = new JsonObject();
		personajeConTurno.addProperty("turno", true);
		
		socketActual=jugadoresBatalla.get(personajeActual);
		salidaJugadorActual = new DataOutputStream(socketActual.getOutputStream());
		entradaJugadorActual=new DataInputStream(socketActual.getInputStream());
		
		enviarAccion("turnoOtorgado",salidaJugadorActual);
		salidaJugadorActual.writeUTF(personajeConTurno.toString());
		
		
		numeroDePersonajeAlQueLeCorrespondeElTurno++;
		if(numeroDePersonajeAlQueLeCorrespondeElTurno==listaDePersonajes.size()){
			numeroDePersonajeAlQueLeCorrespondeElTurno=0;
		}
	}

	private void enviarAccion(String accion, DataOutputStream salida) throws IOException {
		JsonObject usuario = new JsonObject();
		usuario.addProperty("Accion", accion);
		salida.writeUTF(usuario.toString());		
	}



	private boolean estaEnLaAlianzaUno(Personaje personaje) {
		return alianza1.getPersonajes().contains(personaje);
	}

	
}
