package promotionSystem.razas;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public abstract class PersonajesDeStarWars extends Personaje {

	
	public void despuesDeAtacar(){
		salud+=2;
	}

	@Override
	public abstract void subirStatsCadaVezQueSeSubeNivel() ;
}

