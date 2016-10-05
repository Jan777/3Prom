package promotionSystem.razas;

import org.junit.Assert;

import org.junit.Test;
public class PersonajesDeUndertaleTest {
	
	
	@Test
	public void siAtacaAOtroPersonajeMantieneSusPuntosDeAtaque(){
		
		PersonajesDeUndertale atacante=new PersonajesDeUndertale();
		PersonajesDeUndertale atacado=new PersonajesDeUndertale();
		Assert.assertEquals(8, atacante.obtenerPuntosDeAtaque());
		atacante.atacar(atacado);
		Assert.assertEquals(8, atacante.obtenerPuntosDeAtaque());
	}

}
