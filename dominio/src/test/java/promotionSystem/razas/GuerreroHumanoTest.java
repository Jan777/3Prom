package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class GuerreroHumanoTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Humano personaje=new GuerreroHumano();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1200+3*10, personaje.getEnergia());
		Assert.assertEquals(100+3*10, personaje.getSalud());
		Assert.assertEquals(150+3*10, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(80+3*5, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(20+3*5, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(90+3*5, personaje.obtenerPuntosDeVelocidad());
	}

}
