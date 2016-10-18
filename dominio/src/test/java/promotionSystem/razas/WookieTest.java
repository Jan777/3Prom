package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class WookieTest{

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajesDeStarWars personaje=new Wookie();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		personaje.subirNivel();
		
		Assert.assertEquals(1, personaje.getNivel());
		
		Assert.assertEquals(160, personaje.obtenerPuntosDeAtaque());	
		Assert.assertEquals(75, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(55, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(55, personaje.obtenerPuntosDeVelocidad());
		Assert.assertEquals(120, personaje.getSalud());
		Assert.assertEquals(1010, personaje.getEnergia());
	}

}
