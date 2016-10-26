package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Constantes;

public class WookieTest{

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajeDeStarWars personaje=new Wookie();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MultiplicadorDeNivelNormal, personaje.getEnergia());
		Assert.assertEquals(Constantes.SaludWookie+2*Constantes.MultiplicadorDeNivelNormal, personaje.getSalud());
		Assert.assertEquals(Constantes.AtaqueWookie+2*Constantes.MultiplicadorDeNivelEspecial, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DefensaWookie+2*Constantes.MultiplicadorDeNivelEspecial, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MagiaWookie+2*Constantes.MultiplicadorDeNivelPlebe, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VelocidadWookie+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeVelocidad());
	}
	
	@Test
	public void siAtacaAumentaElAtaquePeroDisminuyeDefensa(){
		PersonajeDeStarWars personajeAtacante=new Wookie();
		PersonajeDeStarWars personajeAtacado=new Droide();
		
		Assert.assertEquals(Constantes.AtaqueWookie,personajeAtacante.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DefensaWookie,personajeAtacante.obtenerPuntosDeDefensa());
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(Constantes.AtaqueWookie+5,personajeAtacante.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DefensaWookie-2,personajeAtacante.obtenerPuntosDeDefensa());
		
	}


}
