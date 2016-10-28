package promotionSystem.razas.castas.kingdomHearts;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Constantes;
import promotionSystem.Personaje;
import promotionSystem.razas.PersonajeDeKingdomHearts;
import promotionSystem.razas.PersonajeDeStarWars;
import promotionSystem.razas.castas.kingdomHearts.Sora;
import promotionSystem.razas.castas.starWars.Droide;


public class SoraTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Sora personaje=new Sora();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(3, personaje.getNivel());
		
		Assert.assertEquals(100+2*Constantes.MultiplicadorDeNivelNormal, personaje.getEnergia());
		Assert.assertEquals(Constantes.SaludSora+2*Constantes.MultiplicadorDeNivelNormal, personaje.getSalud());
		Assert.assertEquals(Constantes.AtaqueSora+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DefensaSora+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MagiaSora+2*Constantes.MultiplicadorDeNivelEspecial, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VelocidadSora+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeVelocidad());	
	}

	@Test
	public void siAtacaAumentaDefensa(){
		PersonajeDeKingdomHearts personajeAtacante=new Sora();
		PersonajeDeStarWars personajeAtacado=new Droide();

		Assert.assertEquals(Constantes.DefensaSora,personajeAtacante.obtenerPuntosDeDefensa());
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals((int) (Constantes.DefensaSora*1.125),personajeAtacante.obtenerPuntosDeDefensa());

	}
}
