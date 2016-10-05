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
			if(alianzas.containsValue(idAlianza)){
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


	public static class PersonajesDeUndertale extends Personaje {

        public PersonajesDeUndertale(String casta) {
            if(casta.equals("Sans")){
                energia=110;
                salud=1;
                ataque=8;
                defensa=1;
                magia=7;
                experiencia=0;
                nivel=1;
            }
            else if(casta.equals("Flowie")){
                energia=115;
                salud=130;
                ataque=11;
                defensa=6;
                magia=9;
                experiencia=0;
                nivel=1;
            }
            else if(casta.equals("Chara")){
                energia=110;
                salud=1;
                ataque=8;
                defensa=1;
                magia=7;
                experiencia=0;
                nivel=1;
            }
    //		else{
    //			throws PersonajeInvalidoException();
    //		}
        }
    }
}
