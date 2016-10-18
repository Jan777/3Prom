package promotionSystem.razas;

import promotionSystem.Punto;

public class Jedi extends PersonajesDeStarWars{
	
	public Jedi(){
		energia=1200;
		salud=110;
		ataque=150;
		defensa=30;
		velocidad=100;
		magia=120;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
	}
	
	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		energia+=10;
		salud+=+5;
		ataque+=10;
		defensa+=5;
		magia+=10;
		velocidad+=10;
		
	}

}
