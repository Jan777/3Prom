package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;


public class SoraTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Sora personaje=new Sora();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		personaje.subirNivel();
		Assert.assertEquals(1, personaje.getNivel());
		
		Assert.assertEquals(110, personaje.obtenerPuntosDeAtaque());	
		Assert.assertEquals(110, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(110, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(110, personaje.obtenerPuntosDeVelocidad());
		Assert.assertEquals(110, personaje.getSalud());
		Assert.assertEquals(1010, personaje.getEnergia());
	}

}
