package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.castas.pokemon.PokemonTipoAgua;
import promotionSystem.razas.castas.pokemon.PokemonTipoFuego;

import static promotionSystem.Constantes.INICIO_MAPA;

public class PersonajesDePokemonTest {
	
	@Test
	public void siAtacaAOtroPersonajeAumentaSuMagia(){
		PersonajeDePokemon atacante=new PokemonTipoAgua(INICIO_MAPA);
		PersonajeDePokemon atacado=new PokemonTipoFuego(INICIO_MAPA);
		Assert.assertEquals(Constantes.MAGIA_POKEMON_DE_AGUA, atacante.obtenerPuntosDeMagia());
		atacante.atacar(atacado);
		Assert.assertEquals(Constantes.MAGIA_POKEMON_DE_AGUA +10, atacante.obtenerPuntosDeMagia());
	}

}
