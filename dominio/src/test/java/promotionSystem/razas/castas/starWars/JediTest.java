package promotionSystem.razas.castas.starWars;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.PersonajeDeStarWars;

import static promotionSystem.Constantes.INICIO_MAPA;

public class JediTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajeDeStarWars personaje=new Jedi(INICIO_MAPA);
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getEnergia());
		Assert.assertEquals(Constantes.SALUD_JEDI +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getSalud());
		Assert.assertEquals(Constantes.ATAQUE_JEDI +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DEFENSA_JEDI +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MAGIA_JEDI +2*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VELOCIDAD_JEDI +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeVelocidad());
	}
	@Test
	public void siAtacaAumentaLaMagia(){
		PersonajeDeStarWars personajeAtacante=new Jedi(INICIO_MAPA);
		PersonajeDeStarWars personajeAtacado=new Droide(INICIO_MAPA);
		
		Assert.assertEquals(Constantes.MAGIA_JEDI,personajeAtacante.obtenerPuntosDeMagia());
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(Constantes.MAGIA_JEDI +2,personajeAtacante.obtenerPuntosDeMagia());
	}


}
