package promotionSystem.razas;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public abstract class PersonajesDeUndertale extends Personaje{
	
	
	public void despuesDeAtacar(){
		ataque+=1;
		
	}

	@Override
	public abstract void subirStatsCadaVezQueSeSubeNivel();
		

}
