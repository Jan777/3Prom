package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class RoxasTest {
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Roxas personaje=new Roxas();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		personaje.subirNivel();
		Assert.assertEquals(1, personaje.getNivel());
		
		Assert.assertEquals(55, personaje.obtenerPuntosDeAtaque());	
		Assert.assertEquals(210, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(210, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(160, personaje.obtenerPuntosDeVelocidad());
		Assert.assertEquals(105, personaje.getSalud());
		Assert.assertEquals(1010, personaje.getEnergia());
	}
}
