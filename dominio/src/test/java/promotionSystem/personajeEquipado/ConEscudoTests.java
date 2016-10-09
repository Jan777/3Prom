package promotionSystem.personajeEquipado;

import org.junit.Test;

import org.junit.Assert;
import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.ConEscudo;
import promotionSystem.razas.Humano;

public class ConEscudoTests {

	@Test
	public void siConEscudoModificaElValorDeLaDefensa(){
		Personaje Braixen = new Humano();
		Assert.assertEquals(2, Braixen.obtenerPuntosDeDefensa());
		Braixen = new ConEscudo(Braixen);
		Assert.assertEquals(2 + 2, Braixen.obtenerPuntosDeDefensa());
	}
}
