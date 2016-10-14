package promotionSystem.razas;

import java.util.ArrayList;

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
		nivel=0;
		items = new ArrayList<>();
		this.idAlianza=-1;
		posicion=new Punto(0,0);
	}
	
	public void despuesDeAtacar(){
		// raza sin efectos despues de atacar
	}
	
	public void subirStatsCadaVezQueSeSubeNivel(){
		energia+=1;
		salud+=1;
		ataque+=1;
		defensa+=1;
		magia+=1;
	}
	
}
