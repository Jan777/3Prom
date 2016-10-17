package promotionSystem.razas;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public abstract class PersonajesDeKingdomHearts extends Personaje{
	
	public void despuesDeAtacar(){
		defensa+=(int)defensa*(1/8);
	}

	@Override
	public abstract void subirStatsCadaVezQueSeSubeNivel();
		
		
		
	
}
