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

	public BatallaHilo(HashMap<Socket, Personaje> jugadores, Alianza alianza1, Alianza alianza2) {
		this.alianza1 = alianza1;
		this.alianza2 = alianza2;
		socketAlianza1 = invocarSocket(jugadores, alianza1);
		socketAlianza2 = invocarSocket(jugadores, alianza2);
	}

	private HashMap<Personaje, Socket> invocarSocket(HashMap<Socket, Personaje> jugadores, Alianza alianza) {
		HashMap<Personaje, Socket> lista = new HashMap<Personaje, Socket>();
		for (Personaje personaje : alianza.getPersonajes()) {
			boolean encontro = false;
			Iterator<Socket> iterador = jugadores.keySet().iterator();
			while (!encontro && iterador.hasNext()) {
				Socket jugador = iterador.next();
				if (jugadores.get(jugador).equals(personaje)) {
					lista.put(personaje, jugador);
					encontro = true;
				}
			}
		}
		return lista;
	}

	public void run() {
		int cantidadMuertesAlianza1 = 0;
		int cantidadMuertesAlianza2 = 0;
		listaDePersonajes = alianza1.getPersonajes();
		listaDePersonajes.addAll(alianza2.getPersonajes());
		Collections.sort(listaDePersonajes, Collections.reverseOrder());
		/*
		 * Collections.sort(alianza1.getPersonajes(),Collections.reverseOrder())
		 * ;
		 * Collections.sort(alianza2.getPersonajes(),Collections.reverseOrder())
		 * ;
		 */

		while (cantidadMuertesAlianza1 < alianza1.cantidadDePersonajes()
				&& cantidadMuertesAlianza2 < alianza2.cantidadDePersonajes()) {
			try {
				darTurno();
				recibirAccionPersonaje();
				realizarAccion();
				informarAccion();
				// despuesDelTurno(); por ahora esta vacio
			} catch (IOException e) {
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				e.printStackTrace();
			}
		}
		revisarSiAlgunPersonajeMurioYEnEseCasoSacarleLosItems();
		tratarEntregaDeItems();
		reasignarPersonajesAlMapa();
	}

	// FIXME no se como saber quien me manda la solicitud de item
	private void tratarEntregaDeItems() {
		JsonParser parser = new JsonParser();
		JsonElement elemento;
		String recibirItem, item;
		// if(estaEnLaAlianzaUno()){//personajeQueSeComunicoQueNoSeQuienEs)){
		// elemento = parser.parse(new
		// DataInputStream(socketAlianza1.get(personajeActual).getInputStream()).readUTF());
		// }
		// else{
		// elemento = parser.parse(new
		// DataInputStream(socketAlianza1.get(personajeActual).getInputStream()).readUTF());
		// }
		// recibirItem = elemento.getAsJsonObject().get("accion").getAsString();
		// item = elemento.getAsJsonObject().get("item").getAsString();

		confirmarItemSeleccionado();
		enviarNotificacionDeItemSeleccionadoATodosLosPersonajes();
	}

	private void enviarNotificacionDeItemSeleccionadoATodosLosPersonajes() {
		// TODO Auto-generated method stub

	}

	private void confirmarItemSeleccionado() {
		// TODO Auto-generated method stub

	}

	// FIXME falta hacer el metodo
	private void reasignarPersonajesAlMapa() {

	}

	private void revisarSiAlgunPersonajeMurioYEnEseCasoSacarleLosItems() {
		Iterator<Personaje> iteratorPersonajes = listaDePersonajes.iterator();
		while (iteratorPersonajes.hasNext()) {
			Personaje personajeActual = iteratorPersonajes.next();
			if (!personajeActual.estaVivo()) {
				muertos.add(personajeActual);
				pozoDeItems.addAll(personajeActual.getItems());
			}
		}
	}

	private void informarAccion() throws IOException {
		boolean alianza = true;
		enviarNotificacionDeAccionATodosLosParticipantesDeUnaAlianza(alianza);
		alianza = false;
		enviarNotificacionDeAccionATodosLosParticipantesDeUnaAlianza(alianza);
	}

	private void realizarAccion()
			throws NoSuchMethodException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method miMetodo = BatallaHilo.class.getMethod(accion);
		miMetodo.invoke(this);
	}

	public void atacar() throws JsonSyntaxException, IOException {
		JsonParser parser = new JsonParser();
		JsonElement elemento;
		Personaje personajeEnemigo;
		if (estaEnLaAlianzaUno(personajeActual)) {
			elemento = parser
					.parse(new DataInputStream(socketAlianza1.get(personajeActual).getInputStream()).readUTF());
			String enemigo = elemento.getAsJsonObject().get("enemigo").getAsString();
			personajeEnemigo = obtenerPersonaje(enemigo, alianza2);
		} else {
			elemento = parser
					.parse(new DataInputStream(socketAlianza2.get(personajeActual).getInputStream()).readUTF());
			String enemigo = elemento.getAsJsonObject().get("enemigo").getAsString();
			personajeEnemigo = obtenerPersonaje(enemigo, alianza1);
		}
		personajeActual.atacar(personajeEnemigo);
	}

	public void atacarConMagia() throws JsonSyntaxException, IOException {
		JsonParser parser = new JsonParser();
		JsonElement elemento;
		Personaje personajeEnemigo;
		String conjuro;
		if (estaEnLaAlianzaUno(personajeActual)) {
			elemento = parser
					.parse(new DataInputStream(socketAlianza1.get(personajeActual).getInputStream()).readUTF());
			String enemigo = elemento.getAsJsonObject().get("enemigo").getAsString();
			conjuro = elemento.getAsJsonObject().get("conjuro").getAsString();
			personajeEnemigo = obtenerPersonaje(enemigo, alianza2);
		} else {
			elemento = parser
					.parse(new DataInputStream(socketAlianza2.get(personajeActual).getInputStream()).readUTF());
			String enemigo = elemento.getAsJsonObject().get("enemigo").getAsString();
			conjuro = elemento.getAsJsonObject().get("conjuro").getAsString();
			personajeEnemigo = obtenerPersonaje(enemigo, alianza1);
		}
		personajeActual.atacarConMagia(personajeEnemigo, conjuro);
	}

	public void usarMagiaSupport() throws JsonSyntaxException, IOException {
		JsonParser parser = new JsonParser();
		JsonElement elemento;
		Personaje personajeEnemigo;
		String conjuro;
		if (estaEnLaAlianzaUno(personajeActual)) {
			elemento = parser
					.parse(new DataInputStream(socketAlianza1.get(personajeActual).getInputStream()).readUTF());
			String enemigo = elemento.getAsJsonObject().get("enemigo").getAsString();
			conjuro = elemento.getAsJsonObject().get("conjuro").getAsString();
			personajeEnemigo = obtenerPersonaje(enemigo, alianza2);
		} else {
			elemento = parser
					.parse(new DataInputStream(socketAlianza2.get(personajeActual).getInputStream()).readUTF());
			String enemigo = elemento.getAsJsonObject().get("enemigo").getAsString();
			conjuro = elemento.getAsJsonObject().get("conjuro").getAsString();
			personajeEnemigo = obtenerPersonaje(enemigo, alianza1);
		}
		personajeActual.usarMagiaSupport(personajeEnemigo, conjuro);
	}

	public void usarMagiaDeAlteracion() throws JsonSyntaxException, IOException {
		JsonParser parser = new JsonParser();
		JsonElement elemento;
		String conjuro;
		if (estaEnLaAlianzaUno(personajeActual)) {
			elemento = parser
					.parse(new DataInputStream(socketAlianza1.get(personajeActual).getInputStream()).readUTF());
			conjuro = elemento.getAsJsonObject().get("conjuro").getAsString();
		} else {
			elemento = parser
					.parse(new DataInputStream(socketAlianza2.get(personajeActual).getInputStream()).readUTF());
			conjuro = elemento.getAsJsonObject().get("conjuro").getAsString();
		}
		personajeActual.usarMagiaDeAlteracion(conjuro);
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
		JsonElement elemento = parser
				.parse(new DataInputStream(socketAlianza1.get(personajeActual).getInputStream()).readUTF());
		accion = elemento.getAsJsonObject().get("accion").getAsString();
	}

	private void darTurno() throws IOException {
		personajeActual = listaDePersonajes.get(numeroDePersonajeAlQueLeCorrespondeElTurno);
		while (!personajeActual.estaVivo()) {
			personajeActual = listaDePersonajes.get(++numeroDePersonajeAlQueLeCorrespondeElTurno);
		}
		JsonObject personajeConTurno = new JsonObject();
		personajeConTurno.addProperty("turno", true);
		if (estaEnLaAlianzaUno(personajeActual)) {
			new DataOutputStream(socketAlianza1.get(personajeActual).getOutputStream())
					.writeUTF(personajeConTurno.toString());
		} else {
			new DataOutputStream(socketAlianza2.get(personajeActual).getOutputStream())
					.writeUTF(personajeConTurno.toString());
		}
	}

	private boolean estaEnLaAlianzaUno(Personaje personaje) {
		return alianza1.getPersonajes().contains(personaje);
	}

	public void enviarNotificacionDeAccionATodosLosParticipantesDeUnaAlianza(boolean alianza) throws IOException {
		JsonObject mensaje = new JsonObject();
		mensaje.addProperty("accion", accion);
		Iterator<Socket> iteratorSocket;
		if (alianza) {
			iteratorSocket = socketAlianza1.values().iterator();
		} else {
			iteratorSocket = socketAlianza2.values().iterator();
		}
		boolean encontro = false;
		while (!encontro && iteratorSocket.hasNext()) {
			Socket jugador = iteratorSocket.next();
			new DataOutputStream(jugador.getOutputStream()).writeUTF(mensaje.toString());
			;
			encontro = true;
		}
	}
}
