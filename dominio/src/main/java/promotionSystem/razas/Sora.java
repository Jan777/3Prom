package promotionSystem.razas;

import promotionSystem.Circulo;
import promotionSystem.Punto;

public class Sora extends PersonajesDeKingdomHearts {
	
	public Sora(){
	 energia=1000;
	 ataque=100;
	 defensa=100;
	 experiencia=0;
	 nivel=0;
	 velocidad=100;
	 salud=100;
	 posicion=new Punto(0,0);
	 magia=100;
	 radioDeAcccion=new Circulo(posicion,20);
		
	}
	
	@Override
	public void subirStats(int nivel) {
		energia+=nivel*10;
		salud+=nivel*10;
		ataque+=nivel*10;
		defensa+=nivel*10;
		magia+=nivel*10;
		velocidad+=nivel*10;
	}

}
