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

		Assert.assertEquals(100+Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL *2, personaje.getEnergia());
		Assert.assertEquals(Constantes.SALUD_ROXAS +Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL *2, personaje.getSalud());
		Assert.assertEquals(Constantes.ATAQUE_ROXAS +Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL *2, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DEFENSA_ROXAS +Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL *2, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MAGIA_ROXAS +Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL *2, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VELOCIDAD_ROXAS +Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL *2, personaje.obtenerPuntosDeVelocidad());
	}
	
	
	

	@Test
	public void siAtacaAumentaDefensa(){
		PersonajeDeKingdomHearts personajeAtacante=new Roxas();
		PersonajeDeStarWars personajeAtacado=new Droide();

		Assert.assertEquals(Constantes.DEFENSA_ROXAS,personajeAtacante.obtenerPuntosDeDefensa());
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals((int) (Constantes.DEFENSA_ROXAS *1.125),personajeAtacante.obtenerPuntosDeDefensa());
	}
}
