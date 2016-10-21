package promotionSystem.razas;

import promotionSystem.Circulo;
import promotionSystem.Punto;

public class TanqueOrco extends Orco{

	public TanqueOrco(){
		energia = 1000;
		energiaMaxima=1000;
		saludMaxima=400;
		salud=400;
		ataque=70;
		defensa=200;
		velocidad=20;
		magia=20;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
	}
	
	
	
	@Override
	public void subirStats(int nivel) {
		energia+=nivel*10;
		energiaMaxima+=nivel*10;
		saludMaxima+=nivel*10;
		salud+=nivel*10;
		ataque+=nivel*5;
		defensa+=nivel*10;
		magia+=nivel*5;
		velocidad+=nivel*5;
		
	}

}
