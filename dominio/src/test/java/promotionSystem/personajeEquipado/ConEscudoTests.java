package promotionSystem.personajeEquipado;

import org.junit.Test;

import org.junit.Assert;
import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.ConEscudo;
import promotionSystem.razas.Humano;
import promotionSystem.razas.PokemonTipoFuego;

public class ConEscudoTests {

	@Test
	public void siConEscudoModificaElValorDeLaDefensa(){
		Personaje Braixen = new PokemonTipoFuego();
		Assert.assertEquals(80, Braixen.obtenerPuntosDeDefensa());
		Braixen = new ConEscudo(Braixen,1,0,1,2,1,0,1,0);
		Assert.assertEquals(80 + 2, Braixen.obtenerPuntosDeDefensa());
	}
}
