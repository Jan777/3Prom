package promotionSystem.razas;

import promotionSystem.Punto;

public class Wookie extends PersonajesDeStarWars{
	
	public Wookie(){
		energia=1000;
		salud=110;
		ataque=150;
		defensa=70;
		velocidad=50;
		magia=50;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
	}

	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		energia+=10;
		salud+=+10;
		ataque+=10;
		defensa+=5;
		magia+=5;
		velocidad+=5;
		
	}

}
