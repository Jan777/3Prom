package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Personaje;
import promotionSystem.razas.castas.starWars.Jedi;

public class PersonajesDeStarWarsTest {
	
	@Test
	public void debeDevolverLaRaza(){
		Personaje riku=new Jedi();
		Assert.assertEquals("PersonajeDeStarWars",riku.getRaza());
	}

}
