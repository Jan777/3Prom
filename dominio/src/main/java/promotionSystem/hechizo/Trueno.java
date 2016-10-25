package promotionSystem.hechizo;

import promotionSystem.Personaje;

public class Trueno extends Hechizo{

	@Override
	public void afectar(Personaje personaje,int efecto) {
		personaje.serAtacado(efecto);
		personaje.serRalentizado(1.5);
		
	}

}
