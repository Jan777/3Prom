package promotionSystem.hilos;

import com.google.gson.*;
import promotionSystem.*;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.net.Socket;
import java.sql.SQLException;
import java.util.*;

public class BatallaHilo extends Thread {
	private Alianza alianza1;
	private Alianza alianza2;
	private List<Personaje> listaDePersonajes;
	private HashMap<Personaje, Socket> socketAlianza1;
	private HashMap<Personaje, Socket> socketAlianza2;
	private int numeroDePersonajeAlQueLeCorrespondeElTurno;
	private String accion;
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
	private int subirExperienciaConMuertesDeAlianza1;
	private int subirExperienciaConMuertesDeAlianza2;
	private ArrayList<Punto> puntosIniciales;
	private ArrayList<Socket> jugadoresPorMapa;
	private List<String> items;
	private Conector conector;
	
	public BatallaHilo(HashMap<Personaje, Socket> jugadoresBatalla, Alianza alianza1, Alianza alianza2, ArrayList<Socket> arrayList, Conector conector) throws SQLException {
		this.alianza1 = alianza1;
		this.alianza2 = alianza2;
		this.jugadoresBatalla=jugadoresBatalla;
		 cantidadMuertesAlianza1 = 0;
		 cantidadMuertesAlianza2 = 0;
		 muertos=new ArrayList<>();
		 this.jugadoresPorMapa = arrayList;
		 items = conector.obtenerItem();
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
				recibirAccionPersonaje();
				realizarAccion();
				despuesDelTurno();
			}
			entregarItemsAGanadores();
			recuperarVidaABatallantes();
			recuperarEnergiaABatallantes();
			aumentarExperienciaDeLosGanadores();
			reasignarPersonajesAlMapa();
			Thread.sleep(1000);
			
			informarDatosAlResto();
			
		}
		catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error en la batalla","Error",JOptionPane.ERROR_MESSAGE);
		} 

	}

	private void recuperarEnergiaABatallantes() {
		for(Personaje personaje: listaDePersonajes){
			personaje.setEnergia(personaje.getEnergiaMaxima());
		}
		
	}



	private void reasignarPersonajesAlMapa() {
		agregarPuntosIniciales();
		Random random = new Random();
		for(Personaje batallante : muertos){
			int randomNumero = random.nextInt(puntosIniciales.size());
			Punto puntoInicial = puntosIniciales.get(randomNumero);
			batallante.setPosicion(puntoInicial);
		}
	}

	private void agregarPuntosIniciales() {
		puntosIniciales = new ArrayList<>();
		puntosIniciales.add(new Punto(1, 1));
		puntosIniciales.add(new Punto(10, 10));
		puntosIniciales.add(new Punto(20, 20));
		puntosIniciales.add(new Punto(30, 30));
		puntosIniciales.add(new Punto(40, 40));
	}

	private void entregarItemsAGanadores() throws Exception {
		Random random = new Random();
		for(Personaje personaje : listaDePersonajes){
			if(personaje.estaVivo()){
				int numeroRandom = random.nextInt(items.size());
				Item reflectionItem = (Item) Class.forName("promotionSystem.items." + items.get(numeroRandom)).newInstance();
				reflectionItem.setNombreItem(reflectionItem.getNombreItem().replaceAll(" ", ""));
				personaje.recibirItem(reflectionItem);
				if(reflectionItem!=null){
					personaje.equiparItem(reflectionItem);
				}
			}
		}
	}

	private void informarDatosAlResto() throws IOException {
		JsonObject mensaje = new JsonObject();
		mensaje.addProperty("Accion", "recibirResultadoDeBatalla");
		JsonArray personajes = new JsonArray();
		
		for(Personaje participante : listaDePersonajes){
			JsonObject personaje = new JsonObject();
			personaje.addProperty("nombre", participante.getNombre());
			if(cantidadMuertesAlianza1 < alianza1.cantidadDePersonajes()){
				if(alianza1.getPersonajes().contains(participante)){
					personaje.addProperty("experienciaGanada", subirExperienciaConMuertesDeAlianza2);
				}
				else{
					personaje.addProperty("experienciaGanada", 0);
				}	
			}
			else{
				if(alianza2.getPersonajes().contains(participante)){
					personaje.addProperty("experienciaGanada", subirExperienciaConMuertesDeAlianza1);
				}
				else{
					personaje.addProperty("experienciaGanada", 0);
				}
			}
			personaje.addProperty("x", participante.getPosicion().getX());
			personaje.addProperty("y", participante.getPosicion().getY());
			personaje.addProperty("salud", participante.getSalud());
			personaje.addProperty("arma", participante.getArma()!=null ? participante.getArma().getNombreItem() : "null");
			personaje.addProperty("botas", participante.getBotas()!=null ? participante.getBotas().getNombreItem() : "null");
			personaje.addProperty("escudo", participante.getEscudo()!=null ? participante.getEscudo().getNombreItem() : "null");
			personaje.addProperty("casco", participante.getCasco()!=null ? participante.getCasco().getNombreItem() : "null");
			personaje.addProperty("chaleco", participante.getChaleco()!=null ? participante.getChaleco().getNombreItem() : "null");
			personajes.add(personaje);
		}
		for(Socket cliente : jugadoresPorMapa){
			DataOutputStream salidaJugador = new DataOutputStream(cliente.getOutputStream());
			salidaJugador.writeUTF(mensaje.toString());
			salidaJugador.writeUTF(personajes.toString());
		}
	}



	private void recuperarVidaABatallantes() {
		for(Personaje muerto : muertos){
			muerto.setSalud(muerto.getSaludMaxima());
		}
	}

	private void aumentarExperienciaDeLosGanadores() {
		if(cantidadMuertesAlianza1 < alianza1.cantidadDePersonajes()){
			for(Personaje personaje:alianza1.getPersonajes()){
				personaje.subirExperiencia(subirExperienciaConMuertesDeAlianza2);
			}
		}else{
			for(Personaje personaje:alianza2.getPersonajes()){
				personaje.subirExperiencia(subirExperienciaConMuertesDeAlianza1);
			}
		}
	}

	private void despuesDelTurno() {
		if(!personajeEnemigo.estaVivo()){
			if(alianza1.getPersonajes().contains(personajeEnemigo)){
				cantidadMuertesAlianza1++;
				subirExperienciaConMuertesDeAlianza1+=personajeEnemigo.getSaludMaxima();
			}
			else{
				cantidadMuertesAlianza2++;
				subirExperienciaConMuertesDeAlianza2+=personajeEnemigo.getSaludMaxima();
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
