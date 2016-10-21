package promotionSystem.personajeEquipado;

import org.junit.Test;

import org.junit.Assert;
import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.ConCasco;
import promotionSystem.razas.GuerreroHumano;
import promotionSystem.razas.Humano;

public class ConCascoTests {

	@Test
	public void siConCascoModificaElValorDeLaDefensa() {
		Personaje Braixen = new GuerreroHumano();
		Assert.assertEquals(80, Braixen.obtenerPuntosDeDefensa());
		Braixen = new ConCasco(Braixen,1,0,2,0,1,0,1,0);
		Assert.assertEquals(80 * 2, Braixen.obtenerPuntosDeDefensa());
	}
}
