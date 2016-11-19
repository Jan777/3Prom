package promotionSystem.hilos;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.net.Socket;
import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import com.google.gson.reflect.TypeToken;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public class Escuchador extends Thread {
	private Socket cliente;
	private String nombre;
	private Personaje personaje;
	private DataOutputStream salida;
	private DataInputStream entrada;
	private String raza;
	private String casta;
	private ArrayList<Personaje> jugadoresEnPartida;
	private boolean continuar = true;

	public Escuchador(Socket cliente, String nombre, Personaje personaje, String raza, String casta,
			ArrayList<Personaje> jugadoresEnPartida) throws IOException {
		this.cliente = cliente;
		this.nombre = nombre;
		this.personaje = personaje;
		this.raza = raza;
		this.casta = casta;
		this.jugadoresEnPartida = jugadoresEnPartida;// creo que no va;
		salida = new DataOutputStream(cliente.getOutputStream());
		entrada = new DataInputStream(cliente.getInputStream());

	}

	public void run() {
		while (continuar) {
			try {

				while (continuar) {
					Method miMetodo = Escuchador.class.getMethod(recibirAccion());
					miMetodo.invoke(this);
				}

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public String recibirAccion() throws IOException {
		JsonElement elemento = recibirObjetoJson();
		return elemento.getAsJsonObject().get("Accion").getAsString();
	}

	public JsonElement recibirObjetoJson() throws IOException {
		JsonParser parser = new JsonParser();
		return parser.parse(entrada.readUTF());
	}

	public void recibirListaDePersonajes() throws Exception {

		JsonParser parser = new JsonParser();
		JsonArray json = parser.parse(entrada.readUTF()).getAsJsonArray();
		Type tipoListaRazas = new TypeToken<ArrayList<JsonObject>>() {
		}.getType();
		ArrayList<JsonObject> crearPersonajes = new Gson().fromJson(json, tipoListaRazas);
		for (JsonObject personaje : crearPersonajes) {
			Personaje personajeAAgregar = crearPersonaje(personaje);
			jugadoresEnPartida.add(personajeAAgregar);
		}

	}

	public void movimientoDePersonaje() throws IOException {
		JsonParser parser = new JsonParser();
		JsonObject objeto = parser.parse(entrada.readUTF()).getAsJsonObject();
		String nombrePersonaje = objeto.get("nombre").getAsString();
		Punto puntoNuevo = new Punto(objeto.get("x").getAsInt(), objeto.get("y").getAsInt());
		asignarPuntoAPersonaje(nombrePersonaje, puntoNuevo);
	}

	public void asignarPuntoAPersonaje(String nombrePersonaje, Punto puntoNuevo) {
		boolean encontro = false;
		int i = 0;

		while (!encontro) {
			if (jugadoresEnPartida.get(i).getNombre().equals(nombrePersonaje)) {
				jugadoresEnPartida.get(i).setPosicion(puntoNuevo);
				encontro = true;
			}
		}
	}

	public void agregarPersonaje() throws Exception {
		JsonParser parser = new JsonParser();
		JsonObject objeto = parser.parse(entrada.readUTF()).getAsJsonObject();
		Personaje personaje = crearPersonaje(objeto);
		jugadoresEnPartida.add(personaje);
	}

	private Personaje crearPersonaje(JsonObject objeto) throws Exception {
		Personaje personaje = crearPersonajeAPartirDeRazaCasta(objeto.get("raza").getAsString(),
				objeto.get("casta").getAsString());
		personaje.subirStats(objeto.get("nivel").getAsInt() - 1);
		personaje.setNombre(objeto.get("nombre").getAsString());
		personaje.setPosicion(new Punto(objeto.get("x").getAsInt(), objeto.get("y").getAsInt()));
		return personaje;
	}

	public Personaje crearPersonajeAPartirDeRazaCasta(String asString, String asString2)
			throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		return (Personaje) Class.forName("promotionSystem.razas.castas." + raza + "." + casta).newInstance();
	}

	public void cerrar() {
		continuar = false;
	}

}
