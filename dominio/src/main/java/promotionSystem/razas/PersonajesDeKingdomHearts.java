package promotionSystem.razas;

import promotionSystem.Personaje;

public abstract class PersonajesDeKingdomHearts extends Personaje{
	
	public void despuesDeAtacar(){
		defensa+=defensa*(0.125);
	}

	@Override
	public abstract void subirStats(int nivel);
		
		
		
	
}
