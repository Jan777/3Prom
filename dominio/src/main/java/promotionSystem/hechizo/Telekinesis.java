package promotionSystem.hechizo;

import promotionSystem.Personaje;

public class Telekinesis extends Hechizo{

	@Override
	public void afectar(Personaje personajeAtacado, int efecto) {
		personajeAtacado.serRalentizado(efecto/2);
		
	}

}
