package promotionSystem.hechizo;

import promotionSystem.Personaje;

public class CampoDeFuerza extends Hechizo{

	@Override
	public void afectar(Personaje personajeAtacado, int efecto) {
		
		personajeAtacado.serAumentadoLaDefensa(efecto);
		
	}

}
