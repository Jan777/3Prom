package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Personaje;


public class SoraTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Sora personaje=new Sora();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(3, personaje.getNivel());
		
		Assert.assertEquals(100+3*10, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(100+3*10, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(100+3*10, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(100+3*10, personaje.obtenerPuntosDeVelocidad());
		Assert.assertEquals(100+3*10, personaje.getSalud());
		Assert.assertEquals(1000+3*10, personaje.getEnergia());
	}

	
	
	

	@Test
	public void siAtacaAumentaDefensa(){
		PersonajeDeKingdomHearts personajeAtacante=new Sora();
		PersonajeDeStarWars personajeAtacado=new Droide();

		Assert.assertEquals(100,personajeAtacante.obtenerPuntosDeDefensa());
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals((int) (100*1.125),personajeAtacante.obtenerPuntosDeDefensa());

	}
}
