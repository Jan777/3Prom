package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Constantes;
import promotionSystem.razas.castas.pokemon.PokemonTipoAgua;
import promotionSystem.razas.castas.pokemon.PokemonTipoFuego;

public class PersonajesDePokemonTest {
	
	@Test
	public void siAtacaAOtroPersonajeAumentaSuMagia(){
		PersonajeDePokemon atacante=new PokemonTipoAgua();
		PersonajeDePokemon atacado=new PokemonTipoFuego();
		Assert.assertEquals(Constantes.MagiaPokemonDeAgua, atacante.obtenerPuntosDeMagia());
		atacante.atacar(atacado);
		Assert.assertEquals(Constantes.MagiaPokemonDeAgua+10, atacante.obtenerPuntosDeMagia());
	}

}
