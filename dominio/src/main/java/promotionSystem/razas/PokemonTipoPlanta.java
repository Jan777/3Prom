package promotionSystem.razas;

import promotionSystem.Circulo;
import promotionSystem.Punto;

public class PokemonTipoPlanta extends PersonajesDePokemon {

	public PokemonTipoPlanta(){
		energia=1000;
		salud=150;
		ataque=150;
		defensa=70;
		magia=100;
		velocidad=100;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
	}


	@Override
	public void subirStats(int nivel) {
		energia+=nivel*5;
		salud+=+nivel*10;
		ataque+=nivel*10;
		defensa+=nivel*5;
		magia+=nivel*5;
		velocidad+=nivel*5;
		
	}
}
