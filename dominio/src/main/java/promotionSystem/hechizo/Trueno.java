package promotionSystem.hechizo;

import promotionSystem.Personaje;

public class Trueno extends Hechizo{

	@Override
	public void afectar(Personaje personaje) {
		personaje.setSalud(personaje.getSalud()-20);
		personaje.setVelocidad((int) (personaje.obtenerPuntosDeVelocidad()/1.5));
		
	}

}
