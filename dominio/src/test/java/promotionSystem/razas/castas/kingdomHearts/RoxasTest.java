package promotionSystem.razas.castas.kingdomHearts;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.PersonajeDeKingdomHearts;
import promotionSystem.razas.PersonajeDeStarWars;
import promotionSystem.razas.castas.starWars.Droide;

public class RoxasTest {
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Roxas personaje=new Roxas();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+Constantes.MultiplicadorDeNivelNormal*2, personaje.getEnergia());
		Assert.assertEquals(Constantes.SaludRoxas+Constantes.MultiplicadorDeNivelNormal*2, personaje.getSalud());
		Assert.assertEquals(Constantes.AtaqueRoxas+Constantes.MultiplicadorDeNivelEspecial*2, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DefensaRoxas+Constantes.MultiplicadorDeNivelNormal*2, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MagiaRoxas+Constantes.MultiplicadorDeNivelNormal*2, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VelocidadRoxas+Constantes.MultiplicadorDeNivelNormal*2, personaje.obtenerPuntosDeVelocidad());
	}
	
	
	

	@Test
	public void siAtacaAumentaDefensa(){
		PersonajeDeKingdomHearts personajeAtacante=new Roxas();
		PersonajeDeStarWars personajeAtacado=new Droide();

		Assert.assertEquals(Constantes.DefensaRoxas,personajeAtacante.obtenerPuntosDeDefensa());
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals((int) (Constantes.DefensaRoxas*1.125),personajeAtacante.obtenerPuntosDeDefensa());
	}
}
