package promotionSystem.alianzas;

import java.util.List;

import promotionSystem.Alianza;
import promotionSystem.Personaje;

public class AlianzaDeOrcos extends Alianza{

	public AlianzaDeOrcos(List<Personaje> personajes) {
		super(personajes);
		
	}

	
	 @Override
	    public void atacar(Alianza alianzaEnemiga){
		 int index=0;
	        for(Personaje personaje : personajes){
	        	if(personaje.estaVivo()){
	            Personaje victima = getVictima(alianzaEnemiga, index);
	            while(index<alianzaEnemiga.getPersonajes().size()-1 && !victima.estaVivo()){
	            	index++;
	            	 victima = getVictima(alianzaEnemiga, index);
	            }
	            if(victima.estaVivo())
	             personaje.atacar(victima);
	        	}
	        }
	    }

	    private Personaje getVictima(Alianza alianzaEnemiga, int index) {
	        
	        return alianzaEnemiga.darVictima(index);
	        
	    }
	    
	   
}
