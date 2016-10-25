package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class WookieTest{

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajeDeStarWars personaje=new Wookie();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1000+3*10, personaje.getEnergia());
		Assert.assertEquals(110+3*10, personaje.getSalud());
		Assert.assertEquals(150+3*10, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(70+3*5, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(50+3*5, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(50+3*5, personaje.obtenerPuntosDeVelocidad());
	}
	
	@Test
	public void siAtacaAumentaElAtaquePeroDisminuyeDefensa(){
		PersonajeDeStarWars personajeAtacante=new Wookie();
		PersonajeDeStarWars personajeAtacado=new Droide();
		
		Assert.assertEquals(150,personajeAtacante.obtenerPuntosDeAtaque());
		Assert.assertEquals(70,personajeAtacante.obtenerPuntosDeDefensa());
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(150+5,personajeAtacante.obtenerPuntosDeAtaque());
		Assert.assertEquals(70-2,personajeAtacante.obtenerPuntosDeDefensa());
		
	}


}
