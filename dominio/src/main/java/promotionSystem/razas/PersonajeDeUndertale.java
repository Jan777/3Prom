package promotionSystem.razas;

import promotionSystem.Personaje;

public abstract class PersonajeDeUndertale extends Personaje{
	
	
	public void despuesDeAtacar(){
		ataque+=1;
		energia+=1;
		
	}

	@Override
	public abstract void subirStats(int nivel);
		

}
