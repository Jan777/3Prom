package promotionSystem.razas;


import org.junit.Assert;

import org.junit.Test;

public class PersonajesDeStarWarsTest {
	
	@Test
	public void siAtacaAOtroPersonajeMantieneSuAtaque(){
		PersonajesDeStarWars atacante=new PersonajesDeStarWars();
		PersonajesDeStarWars  atacado=new PersonajesDeStarWars();
		Assert.assertEquals(15, atacante.obtenerPuntosDeAtaque());
		atacante.atacar(atacado);
		Assert.assertEquals(15, atacante.obtenerPuntosDeAtaque());
	}

}
