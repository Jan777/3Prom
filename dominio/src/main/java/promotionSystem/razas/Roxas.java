package promotionSystem.razas;

import promotionSystem.Punto;

public class Roxas extends PersonajesDeKingdomHearts{

	public Roxas(){
		 energia=1000;
		 ataque=50;
		 defensa=200;
		 experiencia=0;
		 nivel=0;
		 velocidad=150;
		 salud=100;
		 posicion=new Punto(0,0);
		 magia=200;
			
		}
	
	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		energia+=10;
		salud+=5;
		ataque+=5;
		defensa+=10;
		magia+=10;
		velocidad+=10;
	}

}
