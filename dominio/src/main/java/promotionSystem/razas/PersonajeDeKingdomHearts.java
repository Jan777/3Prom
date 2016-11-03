package promotionSystem.razas;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public abstract class PersonajeDeKingdomHearts extends Personaje{

	public PersonajeDeKingdomHearts(Punto posicion) {
		super(posicion);
	}

	public void despuesDeAtacar(){
		defensa+=defensa*(0.125);
	}

	@Override
	public abstract void subirStats(int nivel);
		
		
		
	
}
