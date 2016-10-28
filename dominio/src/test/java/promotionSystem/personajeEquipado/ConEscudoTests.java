package promotionSystem.personajeEquipado;

import org.junit.Test;
import org.junit.Assert;

import promotionSystem.Constantes;
import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.ConEscudo;
import promotionSystem.razas.Humano;
import promotionSystem.razas.castas.humano.GuerreroHumano;
import promotionSystem.razas.castas.pokemon.PokemonTipoFuego;

public class ConEscudoTests {

	@Test
	public void siConEscudoModificaElValorDeLaDefensa(){
		Personaje Braixen = new GuerreroHumano();
		Assert.assertEquals(Constantes.DefensaGuerreroHumano, Braixen.obtenerPuntosDeDefensa());
		Braixen = new ConEscudo(Braixen,1,0,1,2,1,0,1,0);
		Assert.assertEquals(Constantes.DefensaGuerreroHumano + 2, Braixen.obtenerPuntosDeDefensa());
	}
}
