package promotionSystem.razas;

import java.util.HashMap;

import promotionSystem.Circulo;
import promotionSystem.Punto;
import promotionSystem.hechizo.EmpujonDeFuerza;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.IraWookeana;

public class Jedi extends PersonajeDeStarWars{
	
	public Jedi(){
		energia=1200;
		energiaMaxima=1200;
		saludMaxima=110;
		salud=110;
		ataque=150;
		defensa=30;
		magia=120;
		velocidad=100;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
	    agregarHechizo("EmpujonDeFuerza",new EmpujonDeFuerza());
	}
	
	@Override
	public void subirStats(int nivel) {
		energia+=nivel*10;
		energiaMaxima+=nivel*10;
		saludMaxima+=nivel*5;
		salud+=+nivel*5;
		ataque+=nivel*10;
		defensa+=nivel*5;
		magia+=nivel*10;
		velocidad+=nivel*10;
	}

	@Override
	public void despuesDeAtacar() {
		magia+=2;
		
	}
}
