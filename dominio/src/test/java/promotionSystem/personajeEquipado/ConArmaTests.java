package promotionSystem.personajeEquipado;

import org.junit.Test;

import org.junit.Assert;
import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.ConArma;
import promotionSystem.razas.Humano;

public class ConArmaTests {

	@Test
	public void siConArmaDuplicaElValorDelAtaque(){
		Personaje Braixen = new Humano();
		Assert.assertEquals(10, Braixen.obtenerPuntosDeAtaque());
		Braixen = new ConArma(Braixen,2,0,1,0,1,0,1,0);
		Assert.assertEquals(10 * 2, Braixen.obtenerPuntosDeAtaque());
	}
}
