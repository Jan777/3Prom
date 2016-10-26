package promotionSystem.personajeEquipado;

import org.junit.Test;

import org.junit.Assert;

import promotionSystem.Constantes;
import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.ConArma;
import promotionSystem.razas.Humano;
import promotionSystem.razas.PokemonTipoFuego;

public class ConArmaTests {

	@Test
	public void siConArmaDuplicaElValorDelAtaque(){
		Personaje Braixen = new PokemonTipoFuego();
		Assert.assertEquals(Constantes.AtaquePokemonDeFuego, Braixen.obtenerPuntosDeAtaque());
		Braixen = new ConArma(Braixen,2,0,1,0,1,0,1,0);
		Assert.assertEquals(Constantes.AtaquePokemonDeFuego * 2, Braixen.obtenerPuntosDeAtaque());
	}
}
