package promotionSystem;

import org.junit.Test;

import junit.framework.Assert;

public class ConCascoTests {

	@Test
	public void siConCascoModificaElValorDeLaDefensa(){
		Personaje Braixen = new Personaje();
		Assert.assertEquals(2, Braixen.obtenerPuntosDeDefensa());
		Braixen = new ConCasco(Braixen);
		Assert.assertEquals(2 * 2, Braixen.obtenerPuntosDeDefensa());
	}
}
