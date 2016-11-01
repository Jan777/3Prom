package promotionSystem.personajeEquipado;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.Personaje;
import promotionSystem.razas.castas.pokemon.PokemonTipoFuego;

public class ConArmaTests {

	@Test
	public void siConArmaDuplicaElValorDelAtaque(){
		Personaje Braixen = new PokemonTipoFuego();
		Assert.assertEquals(Constantes.AtaquePokemonDeFuego, Braixen.obtenerPuntosDeAtaque());
		Braixen = new ConArma(Braixen,2,0,1,0,1,0,1,0);
		Assert.assertEquals(Constantes.AtaquePokemonDeFuego * 2, Braixen.obtenerPuntosDeAtaque());
	}
}
