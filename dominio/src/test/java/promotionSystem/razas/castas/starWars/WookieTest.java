package promotionSystem.razas.castas.starWars;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.PersonajeDeStarWars;

public class WookieTest{

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajeDeStarWars personaje=new Wookie();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(Constantes.ENERGIA_MAXIMA_WOOKIE+2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getEnergia());
		Assert.assertEquals(Constantes.SALUD_WOOKIE +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getSalud());
		Assert.assertEquals(Constantes.ATAQUE_WOOKIE +2*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DEFENSA_WOOKIE +2*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MAGIA_WOOKIE +2*Constantes.MULTIPLICADOR_DE_NIVEL_PLEBE, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VELOCIDAD_WOOKIE +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeVelocidad());
	}
	
	@Test
	public void siAtacaAumentaElAtaquePeroDisminuyeDefensa(){
		PersonajeDeStarWars personajeAtacante=new Wookie();
		PersonajeDeStarWars personajeAtacado=new Droide();
		
		Assert.assertEquals(Constantes.ATAQUE_WOOKIE,personajeAtacante.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DEFENSA_WOOKIE,personajeAtacante.obtenerPuntosDeDefensa());
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(Constantes.ATAQUE_WOOKIE +5,personajeAtacante.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DEFENSA_WOOKIE -2,personajeAtacante.obtenerPuntosDeDefensa());
		
	}


}
