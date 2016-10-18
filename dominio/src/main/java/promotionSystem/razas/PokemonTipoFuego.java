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
	public void subirStatsCadaVezQueSeSubeNivel() {
		energia+=10;
		salud+=+5;
		ataque+=10;
		defensa+=1;
		magia+=10;
		velocidad+=5;
		
	}

}
