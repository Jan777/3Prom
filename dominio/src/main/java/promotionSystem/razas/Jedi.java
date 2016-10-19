package promotionSystem.razas;

import promotionSystem.Punto;

public class Jedi extends PersonajesDeStarWars{
	
	public Jedi(){
		energia=1200;
		salud=110;
		ataque=150;
		defensa=30;
		magia=120;
		velocidad=100;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
	}
	
	@Override
	public void subirStats(int nivel) {
		energia+=nivel*10;
		salud+=+nivel*5;
		ataque+=nivel*10;
		defensa+=nivel*5;
		magia+=nivel*10;
		velocidad+=nivel*10;
	}
}
