package promotionSystem.razas;

import promotionSystem.Circulo;
import promotionSystem.Punto;

public class MagoOrco extends Orco{
	
	public MagoOrco(){
		energia = 1200;
		energiaMaxima=1200;
		saludMaxima=100;
		salud=100;
		ataque=40;
		defensa=75;
		velocidad=80;
		magia=100;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
	}
	
	@Override
	public void subirStats(int nivel) {
		energia+=nivel*10;
		energiaMaxima+=nivel*10;
		saludMaxima+=nivel*5;
		salud+=nivel*5;
		ataque+=nivel*5;
		defensa+=nivel*5;
		magia+=nivel*10;
		velocidad+=nivel*10;
	}

}
