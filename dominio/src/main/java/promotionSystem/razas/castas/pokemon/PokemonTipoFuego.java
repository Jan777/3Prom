package promotionSystem.razas.castas.pokemon;

import promotionSystem.Constantes;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Llamarada;
import promotionSystem.razas.PersonajeDePokemon;

import java.util.HashMap;

public class PokemonTipoFuego extends PersonajeDePokemon {
	
	public PokemonTipoFuego(){
		casta="PokemonTipoFuego";
		energia=Constantes.ENERGIA_POKEMON_DE_FUEGO;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_POKEMON_DE_FUEGO;
		salud=Constantes.SALUD_POKEMON_DE_FUEGO;
		saludMaxima=Constantes.SALUD_MAXIMA_POKEMON_DE_FUEGO;
		ataque=Constantes.ATAQUE_POKEMON_DE_FUEGO;
		defensa=Constantes.DEFENSA_POKEMON_DE_FUEGO;
		magia=Constantes.MAGIA_POKEMON_DE_FUEGO;
		velocidad=Constantes.VELOCIDAD_POKEMON_DE_FUEGO;
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("Llamarada",new Llamarada());
        
	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		salud+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		ataque+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		defensa+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		magia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
	}
}
