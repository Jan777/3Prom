package promotionSystem.hechizo;

import promotionSystem.Personaje;

public class Hielo extends Hechizo{

	@Override
	public void afectar(Personaje personajeAtacado,int efecto) {
		personajeAtacado.serAtacado(efecto);
		personajeAtacado.serRalentizado(2);
	}

}
