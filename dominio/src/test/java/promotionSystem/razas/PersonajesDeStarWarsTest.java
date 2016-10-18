package promotionSystem.razas;


import org.junit.Assert;

import org.junit.Test;

public class PersonajesDeStarWarsTest {
	
	@Test
	public void siAtacaAOtroPersonajeAumentaSuSalud(){
		PersonajesDeStarWars atacante=new Wookie();
		PersonajesDeStarWars  atacado=new Droide();
		Assert.assertEquals(110, atacante.getSalud());
		atacante.atacar(atacado);
		Assert.assertEquals(112, atacante.getSalud());
	}

}
