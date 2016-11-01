package promotionSystem.razas;

import promotionSystem.Personaje;

public abstract class Humano extends Personaje {

	
	
	public void despuesDeAtacar(){
		// raza sin efectos despues de atacar
	}
	
	public abstract void subirStats(int nivel);
}
