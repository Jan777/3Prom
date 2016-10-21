package promotionSystem.razas;

import java.util.ArrayList;

import promotionSystem.Item;
import promotionSystem.Personaje;
import promotionSystem.Punto;

public abstract class Humano extends Personaje {

	
	
	public void despuesDeAtacar(){
		// raza sin efectos despues de atacar
	}
	
	public abstract void subirStats(int nivel);
}
