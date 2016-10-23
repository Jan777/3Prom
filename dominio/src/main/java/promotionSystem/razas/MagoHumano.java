package promotionSystem.razas;

import java.util.ArrayList;

import promotionSystem.Circulo;
import promotionSystem.Item;
import promotionSystem.Punto;

public class MagoHumano extends Humano {

	public MagoHumano (){
		energia=1200;
		energiaMaxima=1200;
		saludMaxima=75;
		salud=75;
		ataque=20;
		defensa=50;
		velocidad=100;
		magia=100;
		experiencia=0;
		nivel=0;
		//items = new ArrayList<Item>();
		this.alianza=null;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
	}
	
	public void subirStats(int nivel){
		energia+=nivel*10;
		energiaMaxima+=nivel*10;
		saludMaxima+=nivel*5;
		salud+=nivel*5;
		ataque+=nivel*5;
		defensa+=nivel*5;
		magia+=nivel*10;
		velocidad+=nivel*10;
	}
}
