package promotionSystem.razas;

import promotionSystem.Punto;

public class Riku extends PersonajesDeKingdomHearts{
	
	public Riku(){
		 energia=100;
		 ataque=200;
		 defensa=50;
		 experiencia=0;
		 nivel=0;
		 velocidad=150;
		 salud=200;
		 posicion=new Punto(0,0);
		 magia=75;
			
		}

	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		energia+=10;
		salud+=10;
		ataque+=10;
		defensa+=5;
		magia+=5;
		velocidad+=10;
	}
	
	
}
