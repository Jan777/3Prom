package promotionSystem.razas;

import promotionSystem.Circulo;
import promotionSystem.Punto;

public class Chara extends PersonajeDeUndertale{
	public Chara(){
		energia=1000;
		energiaMaxima=1000;
		salud=100; 
		saludMaxima=100;
		ataque=150;
		defensa=100;
		magia=50;
		velocidad=100;
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
		ataque+=nivel*10;
		defensa+=nivel*5;
		magia+=nivel*5;
		velocidad+=nivel*10;
	}
}
