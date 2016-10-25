package promotionSystem.razas;

import promotionSystem.Circulo;
import promotionSystem.Punto;

public class PokemonTipoFuego extends PersonajeDePokemon {
	public PokemonTipoFuego(){
		energia=1000;
		energiaMaxima=1000;
		saludMaxima=90;
		salud=90;
		ataque=150;
		defensa=60;
		magia=150;
		velocidad=75;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
	}
	
	@Override
	public void subirStats(int nivel) {
		energia+=nivel*10;
		energiaMaxima+=nivel*10;
		saludMaxima+=nivel*5;
		salud+=+nivel*5;
		ataque+=nivel*10;
		defensa+=nivel*2;
		magia+=nivel*10;
		velocidad+=nivel*5;
		
	}

}
