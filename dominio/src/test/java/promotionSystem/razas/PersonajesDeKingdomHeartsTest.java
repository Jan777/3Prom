package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Personaje;
import promotionSystem.razas.castas.kingdomHearts.Riku;

public class PersonajesDeKingdomHeartsTest {

	@Test
	public void debeDevolverLaRaza(){
		Personaje riku=new Riku();
		Assert.assertEquals("PersonajeDeKingdomHearts",riku.getRaza());
	}
	
}
