package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Personaje;
import promotionSystem.razas.castas.undertale.Chara;

public class PersonajesDeUndertaleTest {
	
	
	@Test
	public void debeDevolverLaRaza(){
		Personaje riku=new Chara();
		Assert.assertEquals("PersonajeDeUndertale",riku.getRaza());
	}
}
