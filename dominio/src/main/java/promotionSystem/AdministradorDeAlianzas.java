package promotionSystem;


import java.util.HashMap;


public class AdministradorDeAlianzas {
	
	private HashMap<Integer, Alianza> alianzas;
	private static AdministradorDeAlianzas instance=new AdministradorDeAlianzas();
	
		private AdministradorDeAlianzas(){
			alianzas=new HashMap<>();
		}
		
		public static AdministradorDeAlianzas getInstance(){
			return instance;
		}
		
		public void sacarPersonajeDeAlianza(int idAlianza, Personaje personaje){
				if(alianzas.containsValue(idAlianza)){
					alianzas.get(idAlianza).sacarPersonaje(personaje);					
				}
		}
		
		public void agregarPersonajeAAlianza(int idAlianza, Personaje personaje){
			if(alianzas.containsValue(idAlianza)){
				alianzas.get(idAlianza).agregarPersonaje(personaje);					
			}
		}

		public void agregarAlianza(Alianza alianza) {
			alianzas.put(alianzas.size(),alianza);			
		}
		
		
}
