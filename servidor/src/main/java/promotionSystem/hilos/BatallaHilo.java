package promotionSystem.hilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;

import promotionSystem.Alianza;
import promotionSystem.Item;
import promotionSystem.Personaje;

public class BatallaHilo extends Thread{
	private Alianza alianza1;
	private Alianza alianza2;
	private List<Personaje> listaDePersonajes;
	private HashMap<Personaje,Socket> socketAlianza1;
	private HashMap<Personaje,Socket> socketAlianza2;
	private int numeroDePersonajeAlQueLeCorrespondeElTurno;
	private String accion;
	private ArrayList<Item> pozoDeItems;
	private ArrayList<Personaje> muertos;

	
	public BatallaHilo(HashMap<Socket,Personaje> jugadores, Alianza alianza1, Alianza alianza2){
		this.alianza1=alianza1;
		this.alianza2=alianza2;
		socketAlianza1=invocarSocket(jugadores,alianza1);
		socketAlianza2=invocarSocket(jugadores,alianza2);
	}

	private HashMap<Personaje,Socket> invocarSocket(HashMap<Socket,Personaje> jugadores,Alianza alianza) {
		HashMap<Personaje,Socket> lista= new HashMap<Personaje,Socket> ();
			for(Personaje personaje : alianza.getPersonajes()){
				boolean encontro=false;
				Iterator<Socket> iterador = jugadores.keySet().iterator();
				while(!encontro&&iterador.hasNext()){
					Socket jugador = iterador.next();
					if(jugadores.get(jugador).equals(personaje)){
						lista.put(personaje,jugador);
						encontro=true;
					}
				}
			}
			return lista;	
	}
	
	public void run(){
		int cantidadMuertesAlianza1=0;
		int cantidadMuertesAlianza2=0;
		listaDePersonajes = alianza1.getPersonajes();
		listaDePersonajes.addAll(alianza2.getPersonajes());
		Collections.sort(listaDePersonajes,Collections.reverseOrder());
		/*
		Collections.sort(alianza1.getPersonajes(),Collections.reverseOrder());
		Collections.sort(alianza2.getPersonajes(),Collections.reverseOrder());*/

		while(cantidadMuertesAlianza1<alianza1.cantidadDePersonajes()&&cantidadMuertesAlianza2<alianza2.cantidadDePersonajes()){
				try {
					darTurno();
					recibirAccionPersonaje();
					realizarAccion();
					informarAccion();
					despuesDelTurno();
				} 
				catch (IOException e) {
					e.printStackTrace();
				} 
				catch (NoSuchMethodException e) {
					e.printStackTrace();
				}
		}
		reasignarPersonajesAlMapa();
	}
	//FIXME falta hacer el metodo
	private void reasignarPersonajesAlMapa() {
		
	}

	private void despuesDelTurno() {
		revisarSiAlgunPersonajeMurioYEnEseCasoSacarleLosItems();
		//remover de ambas alianzas, lista de personajes y lista de sockets correspondiente?
		//asignar punto random de reaparicion a los muertos
	}

	private void revisarSiAlgunPersonajeMurioYEnEseCasoSacarleLosItems() {
		Iterator<Personaje> iteratorPersonajes = listaDePersonajes.iterator();
		while(iteratorPersonajes.hasNext()){
			Personaje personajeActual = iteratorPersonajes.next();
			if(!personajeActual.estaVivo()){
				muertos.add(personajeActual);
				pozoDeItems.addAll(personajeActual.getItems());
			}
		}
	}

	//FIXME no me gusta mucho que digamos pero bueno, el metodo que uso quedo lindo(?)
	private void informarAccion() throws IOException {
		boolean alianza=true;
		enviarNotificacionDeAccionATodosLosParticipantesDeUnaAlianza(alianza);
		alianza=false;
		enviarNotificacionDeAccionATodosLosParticipantesDeUnaAlianza(alianza);
	}

	//FIXME no se bien como hacer la parte de accionar dependiendo si ataca normal/con magia/hace algo con magia/hechizar
	private void realizarAccion() throws NoSuchMethodException {
		Personaje personaje = listaDePersonajes.get(numeroDePersonajeAlQueLeCorrespondeElTurno);
		if(accion.equals("atacar")){
			personaje.getClass().getMethod(accion);
		}
	}

	private void recibirAccionPersonaje() throws IOException {
		Personaje personaje = listaDePersonajes.get(numeroDePersonajeAlQueLeCorrespondeElTurno);
		JsonParser parser = new JsonParser();
		JsonElement elemento = parser.parse(new DataInputStream(socketAlianza1.get(personaje).getInputStream()).readUTF());
		accion = elemento.getAsJsonObject().get("accion").getAsString();
	}

	private void darTurno() throws IOException {
		Personaje personaje = listaDePersonajes.get(numeroDePersonajeAlQueLeCorrespondeElTurno);
		while(!personaje.estaVivo()){
			personaje = listaDePersonajes.get(++numeroDePersonajeAlQueLeCorrespondeElTurno);
		}
		JsonObject personajeConTurno = new JsonObject();
		personajeConTurno.addProperty("turno", true);
		if(determinarAlianza(personaje)){
			new DataOutputStream(socketAlianza1.get(personaje).getOutputStream()).writeUTF(personajeConTurno.toString());
		}
		else{
			new DataOutputStream(socketAlianza2.get(personaje).getOutputStream()).writeUTF(personajeConTurno.toString());
		}
	}

	private boolean determinarAlianza(Personaje personaje) {
		return alianza1.getPersonajes().contains(personaje);
	}
	
	public void enviarNotificacionDeAccionATodosLosParticipantesDeUnaAlianza(boolean alianza) throws IOException{
		JsonObject mensaje = new JsonObject();
		mensaje.addProperty("accion", accion);
		Iterator<Socket> iteratorSocket;
		if(alianza){
			iteratorSocket= socketAlianza1.values().iterator();
		}
		else{
			iteratorSocket= socketAlianza2.values().iterator();
		}
		boolean encontro=false;
		while(!encontro && iteratorSocket.hasNext()){
			Socket jugador = iteratorSocket.next();
			new DataOutputStream(jugador.getOutputStream()).writeUTF(mensaje.toString());;
			encontro = true;
		}
	}
}
