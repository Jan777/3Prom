package promotionSystem.razas;

import java.util.ArrayList;

import promotionSystem.Personaje;

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
	}
	
	public void despuesDeAtacar(){
		// raza sin efectos despues de atacar
	}
	
	public void subirStatsCadaVezQueSeSubeNivel(){
		energia=100+nivel;
		salud=100+nivel;
		ataque=10+nivel;
		defensa=2+nivel;
		magia=5+nivel;
	}
	
}
