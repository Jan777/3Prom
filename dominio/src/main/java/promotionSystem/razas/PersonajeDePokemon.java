package promotionSystem.razas;

import promotionSystem.Personaje;

public abstract class PersonajeDePokemon extends Personaje {
	
	

	public void despuesDeAtacar(){
		magia+=10;
	}

	@Override
	public abstract void subirStats(int nivel);
}
