package promotionSystem.razas;

import org.junit.Assert;

import org.junit.Test;

public class PersonajesDeKingdomHeartsTest {

	@Test
	public void siAtacaAumentaUnicamenteLaDefensa(){
		PersonajesDeKingdomHearts atacante=new Sora();
		PersonajesDeKingdomHearts atacado=new Riku();
		Assert.assertEquals(100, atacante.obtenerPuntosDeDefensa());
		atacante.atacar(atacado);
		Assert.assertEquals(112, atacante.obtenerPuntosDeDefensa());		
	}
	
}
