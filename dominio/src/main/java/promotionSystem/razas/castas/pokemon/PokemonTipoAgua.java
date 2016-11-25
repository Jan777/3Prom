package promotionSystem.razas.castas.pokemon;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Hidrobomba;
import promotionSystem.razas.PersonajeDePokemon;

import java.util.HashMap;

public class PokemonTipoAgua extends PersonajeDePokemon{
	
	public PokemonTipoAgua(){
		casta="PokemonTipoAgua";
		energia=Constantes.ENERGIA_POKEMON_DE_AGUA;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_POKEMON_DE_AGUA;
		salud=Constantes.SALUD_POKEMON_DE_AGUA;
		saludMaxima=Constantes.SALUD_MAXIMA_POKEMON_DE_AGUA;
		ataque=Constantes.ATAQUE_POKEMON_DE_AGUA;
		defensa=Constantes.DEFENSA_POKEMON_DE_AGUA;
		magia=Constantes.MAGIA_POKEMON_DE_AGUA;
		velocidad=Constantes.VELOCIDAD_POKEMON_DE_AGUA;
		hechizos = new HashMap<String, Hechizo>();
//        agregarHechizo("Hidrobomba",new Hidrobomba());
	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		salud+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		ataque+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
		defensa+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
		magia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_PLEBE;
	}
}


