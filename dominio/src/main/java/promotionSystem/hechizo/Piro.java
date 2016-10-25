package promotionSystem.hechizo;

import promotionSystem.Personaje;

public  class Piro extends Hechizo{

	@Override
	public void afectar(Personaje personaje,int efecto) {
		personaje.serAtacado(efecto);
		
	}

}
