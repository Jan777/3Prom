package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class TanqueHumanoTest {
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Humano personaje=new TanqueHumano();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1000+3*10, personaje.getEnergia());
		Assert.assertEquals(300+3*10, personaje.getSalud());
		Assert.assertEquals(50+3*5, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(150+3*10, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(20+3*5, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(20+3*5, personaje.obtenerPuntosDeVelocidad());
	}

}
