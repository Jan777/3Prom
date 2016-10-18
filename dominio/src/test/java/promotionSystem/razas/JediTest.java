package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class JediTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajesDeStarWars personaje=new Jedi();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		personaje.subirNivel();
		
		Assert.assertEquals(1, personaje.getNivel());
		
		Assert.assertEquals(160, personaje.obtenerPuntosDeAtaque());	
		Assert.assertEquals(35, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(130, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(110, personaje.obtenerPuntosDeVelocidad());
		Assert.assertEquals(115, personaje.getSalud());
		Assert.assertEquals(1210, personaje.getEnergia());
	}


}
