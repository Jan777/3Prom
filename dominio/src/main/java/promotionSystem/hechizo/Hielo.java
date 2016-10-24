package promotionSystem.hechizo;

import promotionSystem.Personaje;

public class Hielo extends Hechizo{

	@Override
	public void afectar(Personaje personaje) {
		personaje.setSalud(personaje.getSalud()-15);
		personaje.setVelocidad(personaje.obtenerPuntosDeVelocidad()/2);
	}

}
