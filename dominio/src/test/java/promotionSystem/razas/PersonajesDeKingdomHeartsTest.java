package promotionSystem.razas;

import org.junit.Assert;

import org.junit.Test;

public class PersonajesDeKingdomHeartsTest {

	@Test
	public void siAtacaMantieneLosPuntosDeAtaque(){
		PersonajesDeKingdomHearts atacante=new PersonajesDeKingdomHearts();
		PersonajesDeKingdomHearts atacado=new PersonajesDeKingdomHearts();
		Assert.assertEquals(9, atacante.obtenerPuntosDeAtaque());
		atacante.atacar(atacado);
		Assert.assertEquals(9, atacante.obtenerPuntosDeAtaque());		
	}
	
}
