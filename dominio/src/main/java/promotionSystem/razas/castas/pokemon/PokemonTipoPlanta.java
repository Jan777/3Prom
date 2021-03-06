package promotionSystem.razas.castas.pokemon;

import promotionSystem.Constantes;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.razas.PersonajeDePokemon;

import java.util.HashMap;

public class PokemonTipoPlanta extends PersonajeDePokemon {

	public PokemonTipoPlanta(){
		casta="PokemonTipoPlanta";
		energia=Constantes.ENERGIA_POKEMON_DE_PLANTA;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_POKEMON_DE_PLANTA;
		salud=Constantes.SALUD_POKEMON_DE_PLANTA;
		saludMaxima=Constantes.SALUD_MAXIMA_POKEMON_DE_PLANTA;
		ataque=Constantes.ATAQUE_POKEMON_DE_PLANTA;
		defensa=Constantes.DEFENSA_POKEMON_DE_PLANTA;
		magia=Constantes.MAGIA_POKEMON_DE_PLANTA;
		velocidad=Constantes.VELOCIDAD_POKEMON_DE_PLANTA;
		hechizos = new HashMap<String, Hechizo>();
	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		salud+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		ataque+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		defensa+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
		magia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_PLEBE;
	}
}
