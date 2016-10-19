package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class WookieTest{

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajesDeStarWars personaje=new Wookie();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1000+3*10, personaje.getEnergia());
		Assert.assertEquals(110+3*10, personaje.getSalud());
		Assert.assertEquals(150+3*10, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(70+3*5, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(50+3*5, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(50+3*5, personaje.obtenerPuntosDeVelocidad());
	}

}
