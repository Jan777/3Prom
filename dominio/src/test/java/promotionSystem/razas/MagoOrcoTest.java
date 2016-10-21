package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class MagoOrcoTest {

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Orco personaje=new MagoOrco();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1200+3*10, personaje.getEnergia());
		Assert.assertEquals(100+3*5, personaje.getSalud());
		Assert.assertEquals(40+3*5, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(75+3*5, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(100+3*10, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(80+3*10, personaje.obtenerPuntosDeVelocidad());
	}
}
