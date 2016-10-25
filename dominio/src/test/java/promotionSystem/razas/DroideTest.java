package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class DroideTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajeDeStarWars personaje=new Droide();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1200+3*10, personaje.getEnergia());
		Assert.assertEquals(80+3*5, personaje.getSalud());
		Assert.assertEquals(80+3*5, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(100+3*10, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(120+3*10, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(80+3*10, personaje.obtenerPuntosDeVelocidad());
	}
	
	@Test
	public void siAtacaAumentaLaVelocidad(){
		PersonajeDeStarWars personajeAtacante=new Droide();
		PersonajeDeStarWars personajeAtacado=new Droide();
		
		Assert.assertEquals(80,personajeAtacante.obtenerPuntosDeVelocidad());
	
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(80+2,personajeAtacante.obtenerPuntosDeVelocidad());

		
	}


}
