package promotionSystem.razasTest;

import junit.framework.Assert;

import org.junit.Test;

import promotionSystem.razas.PersonajeOrco;

public class OrcoTest {

	@Test
	public void SiUnOrcoAtacaAOtroPersonajeDespuesDeAtacarAumentaEn2SuAtaque(){
		
		PersonajeOrco orcoAtacado=new PersonajeOrco();
		PersonajeOrco orcoAtacante=new PersonajeOrco();
		Assert.assertEquals(40,orcoAtacante.obtenerPuntosDeAtaque());
		orcoAtacante.atacar(orcoAtacado);
		Assert.assertEquals(42,orcoAtacante.obtenerPuntosDeAtaque());
		
	}
	
	/* Este personaje no tiene sentido seguir testeando ya que
	 * no hay nada mas de especial en este personaje
	 */
	
	
}
