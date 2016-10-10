package promotionSystem.personajeEquipado;

import org.junit.Test;

import org.junit.Assert;
import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.ConCasco;
import promotionSystem.razas.Humano;

public class ConCascoTests {

	@Test
	public void siConCascoModificaElValorDeLaDefensa() {
		Personaje Braixen = new Humano();
		Assert.assertEquals(2, Braixen.obtenerPuntosDeDefensa());
		Braixen = new ConCasco(Braixen);
		Assert.assertEquals(2 * 2, Braixen.obtenerPuntosDeDefensa());
	}
}
