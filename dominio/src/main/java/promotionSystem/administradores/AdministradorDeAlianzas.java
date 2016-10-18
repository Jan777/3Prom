package promotionSystem.administradores;


import promotionSystem.Alianza;
import promotionSystem.Personaje;
import promotionSystem.builder.AlianzaBuilder;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class AdministradorDeAlianzas {
	
	private HashMap<Integer, Alianza> alianzas;
	private int indicadorDeIDs;
	private static AdministradorDeAlianzas instance=new AdministradorDeAlianzas();
	
		private AdministradorDeAlianzas(){
			alianzas=new HashMap<Integer, Alianza>();
			indicadorDeIDs=0;
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
				alianzas.get(idAlianza).agregarPersonajes(personaje);
			}
			
		}

		public void agregarAlianza(Alianza alianza) {
		
			alianzas.put(indicadorDeIDs,alianza);
			alianza.setId(indicadorDeIDs);
			for(Personaje personaje: alianza.getPersonajes()){
				personaje.setAlianza(indicadorDeIDs);
			}
			indicadorDeIDs++;
		}

		public void juntarAlianzas(int alianza1, int alianza2) {
			if(alianzas.containsKey(alianza1)&&alianzas.containsKey(alianza2)){
				Alianza alianzaDestruida=alianzas.get(alianza2);//FIXME refactorizar nombre de la alianzaDestruida
				alianzas.get(alianza1).agregarPersonajes(alianzaDestruida.getPersonajes());	
				eliminarAlianza(alianzaDestruida);
			}
			
		}

		private void eliminarAlianza(Alianza alianzaDestruida) {
			alianzas.remove(alianzaDestruida);
		}

		public void informarBatalla(Personaje desafiante, Personaje desafiado) {
			if(alianzas.containsKey(desafiante.getAlianza())&&alianzas.containsKey(desafiado.getAlianza())){
				alianzas.get(desafiante.getAlianza()).atacar(alianzas.get(desafiante.getAlianza()));
			}
		}

		public int cantidadDeAlianzas(){
			return alianzas.size();
		}
		

}
