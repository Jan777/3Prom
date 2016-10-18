package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class DroideTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajesDeStarWars personaje=new Droide();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		personaje.subirNivel();
		
		Assert.assertEquals(1, personaje.getNivel());
		
		Assert.assertEquals(85, personaje.obtenerPuntosDeAtaque());	
		Assert.assertEquals(110, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(130, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(90, personaje.obtenerPuntosDeVelocidad());
		Assert.assertEquals(85, personaje.getSalud());
		Assert.assertEquals(1210, personaje.getEnergia());
	}


}
