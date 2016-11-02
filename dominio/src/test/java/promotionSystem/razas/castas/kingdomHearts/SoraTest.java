package promotionSystem.razas.castas.kingdomHearts;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.PersonajeDeKingdomHearts;
import promotionSystem.razas.PersonajeDeStarWars;
import promotionSystem.razas.castas.starWars.Droide;


public class SoraTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Sora personaje=new Sora();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(3, personaje.getNivel());
		
		Assert.assertEquals(100+2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getEnergia());
		Assert.assertEquals(Constantes.SALUD_SORA +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getSalud());
		Assert.assertEquals(Constantes.ATAQUE_SORA +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DEFENSA_SORA +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MAGIA_SORA +2*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VELOCIDAD_SORA +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeVelocidad());
	}

	@Test
	public void siAtacaAumentaDefensa(){
		PersonajeDeKingdomHearts personajeAtacante=new Sora();
		PersonajeDeStarWars personajeAtacado=new Droide();

		Assert.assertEquals(Constantes.DEFENSA_SORA,personajeAtacante.obtenerPuntosDeDefensa());
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals((int) (Constantes.DEFENSA_SORA *1.125),personajeAtacante.obtenerPuntosDeDefensa());

	}
}
