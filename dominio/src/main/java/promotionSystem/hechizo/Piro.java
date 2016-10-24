package promotionSystem.hechizo;

import promotionSystem.Personaje;

public  class Piro extends Hechizo{

	@Override
	public void afectar(Personaje personaje) {
		personaje.setSalud(personaje.getSalud()-30);
		
	}

}
