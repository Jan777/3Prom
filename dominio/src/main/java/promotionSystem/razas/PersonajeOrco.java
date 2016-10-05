package promotionSystem.razas;

import promotionSystem.Personaje;

public class PersonajeOrco extends Personaje {

	public PersonajeOrco(){
		energia = 100;
		salud=120;
		ataque=40;
		defensa=5;
		magia=1;
		experiencia=0;
		nivel=1;
	}
	
	public void despuesDeAtacar(){
		ataque+=2;
	}
	
	
	
}
