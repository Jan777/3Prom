package promotionSystem.razas;

import org.junit.Assert;

import org.junit.Test;
public class PersonajesDeUndertaleTest {
	
	
	@Test
	public void siAtacaAOtroPersonajeMantieneSusPuntosDeAtaque(){
		
		PersonajesDeUndertale atacante=new Chara();
		PersonajesDeUndertale atacado=new Chara();
		Assert.assertEquals(150, atacante.obtenerPuntosDeAtaque());
		atacante.atacar(atacado);
		Assert.assertEquals(151, atacante.obtenerPuntosDeAtaque());
	}

}
