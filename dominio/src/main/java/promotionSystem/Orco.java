package promotionSystem;

public class Orco extends Personaje {

	public Orco(){
		energia = 100;
		salud=120;
		ataque=140;
		defensa=5;
		magia=1;
		experiencia=0;
		nivel=1;
	}
	
	public void despuesDeAtacar(){
		ataque+=2;
	}
	
	
	
}
