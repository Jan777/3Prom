package promotionSystem.hechizo;

import promotionSystem.Personaje;

public class Electrificar extends Hechizo{

	@Override
	public void afectar(Personaje personajeAtacado, int efecto) {
		
		personajeAtacado.serAtacado(efecto);
		int restar=personajeAtacado.obtenerPuntosDeDefensa()/20;
		personajeAtacado.serReducidoLaDefensa(restar);
	}
	

}
