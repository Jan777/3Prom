package promotionSystem.razas.castas.starWars;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.PersonajeDeStarWars;

import static promotionSystem.Constantes.INICIO_MAPA;

public class DroideTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajeDeStarWars personaje=new Droide(INICIO_MAPA);
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getEnergia());
		Assert.assertEquals(Constantes.SALUD_DROIDE +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getSalud());
		Assert.assertEquals(Constantes.ATAQUE_DROIDE +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DEFENSA_DROIDE +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MAGIA_DROIDE +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VELOCIDAD_DROIDE +2*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL, personaje.obtenerPuntosDeVelocidad());
	}
	
	@Test
	public void siAtacaAumentaLaVelocidad(){
		PersonajeDeStarWars personajeAtacante=new Droide(INICIO_MAPA);
		PersonajeDeStarWars personajeAtacado=new Droide(INICIO_MAPA);
		
		Assert.assertEquals(Constantes.VELOCIDAD_DROIDE,personajeAtacante.obtenerPuntosDeVelocidad());
	
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(Constantes.VELOCIDAD_DROIDE +2,personajeAtacante.obtenerPuntosDeVelocidad());

		
	}


}
