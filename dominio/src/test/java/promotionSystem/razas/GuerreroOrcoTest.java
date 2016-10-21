package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class GuerreroOrcoTest {
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Orco personaje=new GuerreroOrco();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1200+3*10, personaje.getEnergia());
		Assert.assertEquals(150+3*10, personaje.getSalud());
		Assert.assertEquals(175+3*10, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(100+3*5, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(20+3*5, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(70+3*5, personaje.obtenerPuntosDeVelocidad());
	}

}
