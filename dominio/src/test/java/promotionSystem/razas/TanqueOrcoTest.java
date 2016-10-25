package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class TanqueOrcoTest {

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Orco personaje=new TanqueOrco();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1000+3*10, personaje.getEnergia());
		Assert.assertEquals(400+3*10, personaje.getSalud());
		Assert.assertEquals(70+3*5, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(200+3*10, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(20+3*5, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(20+3*5, personaje.obtenerPuntosDeVelocidad());
	}
	
	
}
