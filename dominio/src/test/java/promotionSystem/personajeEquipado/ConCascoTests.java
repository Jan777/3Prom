package promotionSystem.personajeEquipado;

import org.junit.Test;
import org.junit.Assert;

import promotionSystem.Constantes;
import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.ConCasco;
import promotionSystem.razas.Humano;
import promotionSystem.razas.castas.pokemon.PokemonTipoFuego;

public class ConCascoTests {

	@Test
	public void siConCascoModificaElValorDeLaDefensa() {
		Personaje Braixen = new PokemonTipoFuego();
		Assert.assertEquals(Constantes.DefensaPokemonDeFuego, Braixen.obtenerPuntosDeDefensa());
		Braixen = new ConCasco(Braixen,1,0,2,0,1,0,1,0);
		Assert.assertEquals(Constantes.DefensaPokemonDeFuego * 2, Braixen.obtenerPuntosDeDefensa());
	}
}
