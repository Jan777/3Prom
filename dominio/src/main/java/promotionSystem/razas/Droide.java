package promotionSystem.razas;

import promotionSystem.Punto;

public class Droide extends PersonajeDeStarWars{
	
	public Droide(){
		energia=1200;
		energiaMaxima=1200;
		saludMaxima=80;
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
		energiaMaxima+=nivel*10;
		saludMaxima+=nivel*5;
		salud+=+nivel*5;
		ataque+=nivel*5;
		defensa+=nivel*10;
		magia+=nivel*10;
		velocidad+=nivel*10;
	}

	@Override
	public void despuesDeAtacar() {
		velocidad+=2;
		
	}
}
