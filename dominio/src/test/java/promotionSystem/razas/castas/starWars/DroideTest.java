package promotionSystem.razas.castas.starWars;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Constantes;
import promotionSystem.razas.PersonajeDeStarWars;
import promotionSystem.razas.castas.starWars.Droide;

public class DroideTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajeDeStarWars personaje=new Droide();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MultiplicadorDeNivelNormal, personaje.getEnergia());
		Assert.assertEquals(Constantes.SaludDroide+2*Constantes.MultiplicadorDeNivelNormal, personaje.getSalud());
		Assert.assertEquals(Constantes.AtaqueDroide+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DefensaDroide+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MagiaDroide+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VelocidadDroide+2*Constantes.MultiplicadorDeNivelEspecial, personaje.obtenerPuntosDeVelocidad());
	}
	
	@Test
	public void siAtacaAumentaLaVelocidad(){
		PersonajeDeStarWars personajeAtacante=new Droide();
		PersonajeDeStarWars personajeAtacado=new Droide();
		
		Assert.assertEquals(Constantes.VelocidadDroide,personajeAtacante.obtenerPuntosDeVelocidad());
	
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(Constantes.VelocidadDroide+2,personajeAtacante.obtenerPuntosDeVelocidad());

		
	}


}
