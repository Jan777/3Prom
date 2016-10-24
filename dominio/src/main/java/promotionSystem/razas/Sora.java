package promotionSystem.razas;

import java.util.HashMap;

import promotionSystem.Circulo;
import promotionSystem.Punto;
import promotionSystem.hechizo.Cura;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Piro;
import promotionSystem.hechizo.Trueno;

public class Sora extends PersonajesDeKingdomHearts {
	
	public Sora(){
	 energia=1000;
	 energiaMaxima=1000;
	 saludMaxima=100;
	 ataque=100;
	 defensa=100;
	 experiencia=0;
	 nivel=0;
	 velocidad=100;
	 salud=100;
	 posicion=new Punto(0,0);
	 magia=100;
	 radioDeAcccion=new Circulo(posicion,20);
	 hechizos = new HashMap<String, Hechizo>();
     agregarHechizo("Piro",new Piro());
     agregarHechizo("Cura",new Cura());
		
	}
	
	@Override
	public void subirStats(int nivel) {
		energia+=nivel*10;
		energiaMaxima+=nivel*10;
		saludMaxima+=nivel*10;
		salud+=nivel*10;
		ataque+=nivel*10;
		defensa+=nivel*10;
		magia+=nivel*10;
		velocidad+=nivel*10;
	}

}
