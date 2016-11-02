package promotionSystem.hechizo;

import promotionSystem.Personaje;

public class Hidrobomba extends Hechizo {

	@Override
	public void afectar(Personaje personaje, int efecto) {
		double aumento=Math.random();
		personaje.serAumentadoLaFuerza((int)(efecto + aumento));
	}

}
