package promotionSystem.razas;

import promotionSystem.Punto;

public class GuerreroOrco extends Orco{

	public GuerreroOrco(){
		energia = 1200;
		salud=150;
		ataque=175;
		defensa=100;
		velocidad=70;
		magia=20;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
	}
	
	@Override
	public void subirStats(int nivel) {
		energia+=nivel*10;
		salud+=nivel*10;
		ataque+=nivel*10;
		defensa+=nivel*5;
		magia+=nivel*5;
		velocidad+=nivel*5;
	}
}
