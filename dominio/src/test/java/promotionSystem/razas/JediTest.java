package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class JediTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajeDeStarWars personaje=new Jedi();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1200+3*10, personaje.getEnergia());
		Assert.assertEquals(110+3*5, personaje.getSalud());
		Assert.assertEquals(150+3*10, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(30+3*5, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(120+3*10, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(100+3*10, personaje.obtenerPuntosDeVelocidad());
	}
	@Test
	public void siAtacaAumentaLaMagia(){
		PersonajeDeStarWars personajeAtacante=new Jedi();
		PersonajeDeStarWars personajeAtacado=new Droide();
		
		Assert.assertEquals(120,personajeAtacante.obtenerPuntosDeMagia());
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(120+2,personajeAtacante.obtenerPuntosDeMagia());
	}


}
