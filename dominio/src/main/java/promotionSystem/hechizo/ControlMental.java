package promotionSystem.hechizo;

import promotionSystem.Personaje;

public class ControlMental extends Hechizo{

	@Override
	public void afectar(Personaje personajeAtacado, int efecto) {
		personajeAtacado.atacar(personajeAtacado);
		
	}

}
