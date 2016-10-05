package promotionSystem.personajeEquipado;

import org.junit.Test;

import junit.framework.Assert;
import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.ConArma;

public class ConArmaTests {

	@Test
	public void siConArmaDuplicaElValorDelAtaque(){
		Personaje Braixen = new Personaje();
		Assert.assertEquals(10, Braixen.obtenerPuntosDeAtaque());
		Braixen = new ConArma(Braixen);
		Assert.assertEquals(10 * 2, Braixen.obtenerPuntosDeAtaque());
	}
}
