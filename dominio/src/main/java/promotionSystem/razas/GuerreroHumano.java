package promotionSystem.razas;

import java.util.ArrayList;

import promotionSystem.Item;
import promotionSystem.Punto;

public class GuerreroHumano extends Humano{
	
	public GuerreroHumano(){
		energia=1200;
		salud=100;
		ataque=150;
		defensa=80;
		velocidad=90;
		magia=20;
		experiencia=0;
		nivel=0;
		items = new ArrayList<Item>();
		this.alianza=null;
		posicion=new Punto(0,0);
	}

	@Override
	public void subirStats(int nivel) {
		energia+=nivel*10;
		salud+=nivel*10;
		ataque+=nivel*10;
		defensa+=nivel*5;
		magia+=nivel*5;
		velocidad+=nivel*5;
		
	}

}
