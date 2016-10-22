package promotionSystem.personajeEquipado;

import org.junit.Test;

import org.junit.Assert;
import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.ConCasco;
import promotionSystem.razas.Humano;
import promotionSystem.razas.PokemonTipoFuego;

public class ConCascoTests {

	@Test
	public void siConCascoModificaElValorDeLaDefensa() {
		Personaje Braixen = new PokemonTipoFuego();
		Assert.assertEquals(60, Braixen.obtenerPuntosDeDefensa());
		Braixen = new ConCasco(Braixen,1,0,2,0,1,0,1,0);
		Assert.assertEquals(60 * 2, Braixen.obtenerPuntosDeDefensa());
	}
}
