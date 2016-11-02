package promotionSystem.razas.castas.kingdomHearts;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.PersonajeDeKingdomHearts;
import promotionSystem.razas.PersonajeDeStarWars;
import promotionSystem.razas.castas.starWars.Droide;

public class RikuTest {

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Riku personaje=new Riku();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(5, personaje.getExperiencia());
		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getEnergia());
		Assert.assertEquals(Constantes.SALUD_RIKU +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getSalud());
		Assert.assertEquals(Constantes.ATAQUE_RIKU +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DEFENSA_RIKU +2*Constantes.MULTIPLICADOR_DE_NIVEL_PLEBE, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MAGIA_RIKU +2*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VELOCIDAD_RIKU +2*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL, personaje.obtenerPuntosDeVelocidad());
	}
	
	
	
	@Test
	public void siAtacaAumentaDefensa(){
		PersonajeDeKingdomHearts personajeAtacante=new Riku();
		PersonajeDeStarWars personajeAtacado=new Droide();
		
		Assert.assertEquals(Constantes.DEFENSA_RIKU,personajeAtacante.obtenerPuntosDeDefensa());
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals((int) (Constantes.DEFENSA_RIKU *1.125),personajeAtacante.obtenerPuntosDeDefensa());
		
	}
	
	
}
