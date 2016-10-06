package promotionSystem.administradores;


import promotionSystem.Alianza;
import promotionSystem.Personaje;

import java.util.HashMap;


public class AdministradorDeAlianzas {
	
	private HashMap<Integer, Alianza> alianzas;
	private int cantidadAlianzas;
	private static AdministradorDeAlianzas instance=new AdministradorDeAlianzas();
	
		private AdministradorDeAlianzas(){
			alianzas=new HashMap<>();
			cantidadAlianzas=0;
		}
		
		public static AdministradorDeAlianzas getInstance(){
			return instance;
		}
		
		public void sacarPersonajeDeAlianza(int idAlianza, Personaje personaje){
				if(alianzas.containsKey(idAlianza)){
					alianzas.get(idAlianza).sacarPersonaje(personaje);					
				}
		}
		
		public void agregarPersonajeAAlianza(int idAlianza, Personaje personaje){
			if(alianzas.containsKey(idAlianza)){
				alianzas.get(idAlianza).agregarPersonaje(personaje);	
			}
			
		}

		public void agregarAlianza(Alianza alianza) {
		
			alianzas.put(cantidadAlianzas,alianza);
			for(Personaje personaje: alianza.getPersonajes()){
				personaje.setAlianza(cantidadAlianzas);
			}
			cantidadAlianzas++;
		}

		public void juntarAlianzas(int alianza1, int alianza2) {
			if(alianzas.containsKey(alianza1)&&alianzas.containsKey(alianza2)){
				Alianza alianzaDestruida=alianzas.get(alianza2);//FIXME refactorizar nombre de la alianzaDestruida
				alianzas.get(alianza1).agregarPersonaje(alianzaDestruida.getPersonajes());	
				alianzas.remove(alianzaDestruida);
			}
			
		}

}
