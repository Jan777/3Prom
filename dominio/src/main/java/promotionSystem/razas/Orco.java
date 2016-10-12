package promotionSystem.razas;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public class Orco extends Personaje {

	public Orco(){
		energia = 100;
		salud=120;
		ataque=40;
		defensa=5;
		magia=1;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
	}
	
	public void despuesDeAtacar(){
		ataque+=2;
	}

	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		energia+=5;
		salud+=+5;
		ataque+=10;
		defensa+=5;
		magia+=1;
		
	}
	
	
	
	
}
