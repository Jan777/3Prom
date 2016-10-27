package promotionSystem.hechizo;

import promotionSystem.Personaje;

public class Gigadrenado extends Hechizo{

	@Override
	public void afectar(Personaje personaje, int efecto) {
		int diez= personaje.getSaludMaxima()/10;
		
		personaje.serCuradoConMagia(diez);
		
	}

}
