package promotionSystem.razas;

import promotionSystem.Punto;

public class Droide extends PersonajesDeStarWars{
	
	public Droide(){
		energia=1200;
		salud=80;
		ataque=80;
		defensa=100;
		magia=120;
		velocidad=80;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
	}

	@Override
	public void subirStats(int nivel) {
		energia+=nivel*10;
		salud+=+nivel*5;
		ataque+=nivel*5;
		defensa+=nivel*10;
		magia+=nivel*10;
		velocidad+=nivel*10;
	}
}
