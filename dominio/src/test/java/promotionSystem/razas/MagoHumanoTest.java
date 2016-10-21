package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class MagoHumanoTest {

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Humano personaje=new MagoHumano();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1200+3*10, personaje.getEnergia());
		Assert.assertEquals(75+3*5, personaje.getSalud());
		Assert.assertEquals(20+3*5, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(50+3*5, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(100+3*10, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(100+3*10, personaje.obtenerPuntosDeVelocidad());
	}
	
}
