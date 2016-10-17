package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class RikuTest {

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Riku personaje=new Riku();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		personaje.subirNivel();
		Assert.assertEquals(10, personaje.getExperiencia());
		Assert.assertEquals(1, personaje.getNivel());
		
		Assert.assertEquals(210, personaje.obtenerPuntosDeAtaque());	
		Assert.assertEquals(55, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(80, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(160, personaje.obtenerPuntosDeVelocidad());
		Assert.assertEquals(210, personaje.getSalud());
		Assert.assertEquals(110, personaje.getEnergia());
	}

}
