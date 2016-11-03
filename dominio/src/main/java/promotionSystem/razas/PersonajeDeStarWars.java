package promotionSystem.razas;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public abstract class PersonajeDeStarWars extends Personaje {


	public PersonajeDeStarWars(Punto posicion) {
		super(posicion);
	}

	@Override
	public abstract void subirStats(int nivel);
}

