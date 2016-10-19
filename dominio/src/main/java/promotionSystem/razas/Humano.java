package promotionSystem.razas;

import java.util.ArrayList;

import promotionSystem.Item;
import promotionSystem.Personaje;
import promotionSystem.Punto;

public class Humano extends Personaje {

	public Humano(){
		energia=100;
		salud=100;
		ataque=10;
		defensa=2;
		magia=5;
		experiencia=0;
		nivel=1;
		items = new ArrayList<>();
		this.idAlianza=-1;
		posicion=new Punto(0,0);
	}
	
	public void despuesDeAtacar(){
		// raza sin efectos despues de atacar
	}
	
	public void subirStats(int nivel){
		energia+=nivel;
		salud+=nivel;
		ataque+=nivel;
		defensa+=nivel;
		magia+=nivel;
	}
}
