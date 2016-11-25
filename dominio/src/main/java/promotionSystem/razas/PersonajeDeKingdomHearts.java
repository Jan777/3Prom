package promotionSystem.razas;

import promotionSystem.Personaje;

public abstract class PersonajeDeKingdomHearts extends Personaje{

	public PersonajeDeKingdomHearts(){
		raza="PersonajeDeKingdomHearts";
	}

	public void despuesDeAtacar(){
		defensa+=defensa*(0.125);
	}


		
		
		
	
}
