package promotionSystem.razas;

import promotionSystem.Punto;

public class Droide extends PersonajesDeStarWars{
	
	public Droide(){
		energia=1200;
		salud=80;
		ataque=80;
		defensa=100;
		velocidad=80;
		magia=120;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
	}

	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		energia+=10;
		salud+=+5;
		ataque+=5;
		defensa+=10;
		magia+=10;
		velocidad+=10;
		
		
	}

}
