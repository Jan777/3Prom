package promotionSystem.razas;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public abstract class Orco extends Personaje {

	
	
	public void despuesDeAtacar(){
		ataque+=10;
	}

	@Override
	public abstract void subirStats(int nivel) ;
	
	
	
	
}
