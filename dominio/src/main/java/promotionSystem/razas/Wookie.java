package promotionSystem.razas;

import java.util.HashMap;

import promotionSystem.Circulo;
import promotionSystem.Punto;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.IraWookeana;
import promotionSystem.hechizo.Piro;

public class Wookie extends PersonajeDeStarWars{
	
	public Wookie(){
		energia=1000;
		energiaMaxima=1000;
		saludMaxima=110;
		salud=110;
		ataque=150;
		defensa=70;
		magia=50;
		velocidad=50;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
	    agregarHechizo("IraWookeana",new IraWookeana());
	}
	

	@Override
	public void subirStats(int nivel) {
		energia+=nivel*10;
		energiaMaxima+=nivel*10;
		saludMaxima+=nivel*10;
		salud+=+nivel*10;
		ataque+=nivel*10;
		defensa+=nivel*5;
		magia+=nivel*5;
		velocidad+=nivel*5;
	}


	@Override
	public void despuesDeAtacar() {
		ataque+=5;
		defensa-=2;
		
	}

}
