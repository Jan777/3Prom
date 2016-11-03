package promotionSystem.razas;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public abstract class Humano extends Personaje {

	public Humano(Punto posicion) {
		super(posicion);
	}

	public void despuesDeAtacar(){
		// raza sin efectos despues de atacar
	}
	
	public abstract void subirStats(int nivel);
}
