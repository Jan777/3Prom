package promotionSystem.hechizo;

import promotionSystem.Personaje;

public class Cura extends Hechizo{

	@Override
	public void afectar(Personaje personaje,int efecto) {
		personaje.serCuradoConMagia(efecto);
		
	}

}
