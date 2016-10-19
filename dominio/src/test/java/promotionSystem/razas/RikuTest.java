package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class RikuTest {

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Riku personaje=new Riku();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(5, personaje.getExperiencia());
		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1000+3*10, personaje.getEnergia());
		Assert.assertEquals(200+3*10, personaje.getSalud());
		Assert.assertEquals(200+3*10, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(50+3*5, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(75+3*5, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(150+3*5, personaje.obtenerPuntosDeVelocidad());
	}
}
