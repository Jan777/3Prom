package promotionSystem.personajeEquipado;

import org.junit.Test;

import junit.framework.Assert;
import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.ConEscudo;

public class ConEscudoTests {

	@Test
	public void siConEscudoModificaElValorDeLaDefensa(){
		Personaje Braixen = new Personaje();
		Assert.assertEquals(2, Braixen.obtenerPuntosDeDefensa());
		Braixen = new ConEscudo(Braixen);
		Assert.assertEquals(2 + 2, Braixen.obtenerPuntosDeDefensa());
	}
}
