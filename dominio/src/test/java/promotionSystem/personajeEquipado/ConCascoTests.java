package promotionSystem.personajeEquipado;

import org.junit.Test;

import junit.framework.Assert;
import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.ConCasco;

public class ConCascoTests {

	@Test
	public void siConCascoModificaElValorDeLaDefensa(){
		Personaje Braixen = new Personaje();
		Assert.assertEquals(2, Braixen.obtenerPuntosDeDefensa());
		Braixen = new ConCasco(Braixen);
		Assert.assertEquals(2 * 2, Braixen.obtenerPuntosDeDefensa());
	}
}
