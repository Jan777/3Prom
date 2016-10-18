package promotionSystem.razas;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public abstract class PersonajesDePokemon extends Personaje {
	
	

	public void despuesDeAtacar(){
		magia+=10;
	}

	@Override
	public abstract void subirStatsCadaVezQueSeSubeNivel() ;
}
