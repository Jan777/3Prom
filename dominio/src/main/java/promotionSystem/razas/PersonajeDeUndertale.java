package promotionSystem.razas;

import promotionSystem.Personaje;

public abstract class PersonajeDeUndertale extends Personaje{
	
	public PersonajeDeUndertale(){
		raza="raza";
	}

	public void despuesDeAtacar(){
		ataque+=1;
		energia+=1;
		
	}

		

}
