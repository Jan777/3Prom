package promotionSystem.hilos;

import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import promotionSystem.Alianza;
import promotionSystem.Personaje;

public class BatallaHilo extends Thread{
	private Alianza alianza1;
	private Alianza alianza2;
	private HashMap<Personaje,Socket> socketAlianza1;
	private HashMap<Personaje,Socket> socketAlianza2;

	
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
		List<Personaje> listaDePersonajes = alianza1.getPersonajes();
		listaDePersonajes.addAll(alianza2.getPersonajes());
		Collections.sort(listaDePersonajes,Collections.reverseOrder());
		/*
		Collections.sort(alianza1.getPersonajes(),Collections.reverseOrder());
		Collections.sort(alianza2.getPersonajes(),Collections.reverseOrder());*/

		while(cantidadMuertesAlianza1<alianza1.cantidadDePersonajes()&&cantidadMuertesAlianza2<alianza2.cantidadDePersonajes()){
				darTurno();
				recibirAccionPersonaje();
				realizarAccion();
				informarAccion();			
		}
	}

	private void informarAccion() {
		
	}

	private void realizarAccion() {
		
	}

	private void recibirAccionPersonaje() {
		
	}

	private void darTurno() {
	
	}
}
