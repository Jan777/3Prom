package promotionSystem.razas;

import promotionSystem.Punto;

public class Chara extends PersonajesDeUndertale{
	public Chara(){
		energia=1000;
		salud=100; 
		ataque=150;
		defensa=100;
		magia=50;
		experiencia=0;
		velocidad=100;
		nivel=0;
		posicion=new Punto(0,0);
	}

	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		energia+=10;
		ataque+=10;
		defensa+=5;
		magia+=5;
		velocidad+=10;
		salud+=10;
		
	}
}
