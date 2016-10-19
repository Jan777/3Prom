package promotionSystem.razas;

import promotionSystem.Punto;

public class PokemonTipoFuego extends PersonajesDePokemon {
	public PokemonTipoFuego(){
		energia=1000;
		salud=90;
		ataque=150;
		defensa=60;
		magia=150;
		velocidad=75;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
	}
	
	@Override
	public void subirStats(int nivel) {
		energia+=nivel*10;
		salud+=+nivel*5;
		ataque+=nivel*10;
		defensa+=nivel*2;
		magia+=nivel*10;
		velocidad+=nivel*5;
		
	}

}
