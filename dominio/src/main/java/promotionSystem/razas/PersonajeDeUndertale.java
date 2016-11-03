package promotionSystem.razas;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public abstract class PersonajeDeUndertale extends Personaje{


	public PersonajeDeUndertale(Punto posicion) {
		super(posicion);
	}

	public void despuesDeAtacar(){
		ataque+=1;
		energia+=1;
		
	}

	@Override
	public abstract void subirStats(int nivel);
		

}
