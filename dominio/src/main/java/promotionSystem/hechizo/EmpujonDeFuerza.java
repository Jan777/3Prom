package promotionSystem.hechizo;

import promotionSystem.Personaje;

public class EmpujonDeFuerza extends Hechizo{

	@Override
	public void afectar(Personaje personajeAtacado, int efecto) {
		personajeAtacado.serAtacado(efecto);
		
	}

}
