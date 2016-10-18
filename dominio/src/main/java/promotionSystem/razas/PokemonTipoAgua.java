package promotionSystem.razas;

import promotionSystem.Punto;

public class PokemonTipoAgua extends PersonajesDePokemon{
	
	public PokemonTipoAgua(){
		energia=1000;
		salud=100;
		ataque=100;
		defensa=70;
		magia=150;
		velocidad=100;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
	}

	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		energia+=10;
		salud+=+5;
		ataque+=5;
		defensa+=5;
		magia+=10;
		velocidad+=5;
		
	}
	}


