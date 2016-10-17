package promotionSystem.razas;

import promotionSystem.Punto;

public class Sora extends PersonajesDeKingdomHearts {
	
	public Sora(){
	 energia=100;
	 ataque=100;
	 defensa=100;
	 experiencia=0;
	 nivel=0;
	 velocidad=100;
	 salud=100;
	 posicion=new Punto(0,0);
	 magia=100;
		
	}
	
	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		energia+=10;
		salud+=10;
		ataque+=10;
		defensa+=10;
		magia+=10;
		velocidad+=10;
	}

}
