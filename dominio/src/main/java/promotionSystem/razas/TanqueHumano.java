package promotionSystem.razas;

import java.util.ArrayList;

import promotionSystem.Circulo;
import promotionSystem.Item;
import promotionSystem.Punto;

public class TanqueHumano extends Humano{
	
	public TanqueHumano(){
		energia=1000;
		energiaMaxima=1000;
		saludMaxima=300;
		salud=300;
		ataque=50;
		defensa=150;
		velocidad=20;
		magia=20;
		experiencia=0;
		nivel=0;
//		items = new ArrayList<Item>();
		this.alianza=null;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
	}

	@Override
	public void subirStats(int nivel) {
		energia+=nivel*10;
		energiaMaxima+=nivel*10;
		saludMaxima+=nivel*10;
		salud+=nivel*10;
		ataque+=nivel*5;
		defensa+=nivel*10;
		magia+=nivel*5;
		velocidad+=nivel*5;
		
	}

}
