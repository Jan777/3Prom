package promotionSystem.razasTest;

import junit.framework.Assert;

import org.junit.Test;

import promotionSystem.razas.Orco;

public class OrcoTest {

	@Test
	public void SiUnOrcoAtacaAOtroPersonajeDespuesDeAtacarAumentaEn2SuAtaque(){
		
		Orco orcoAtacado=new Orco();
		Orco orcoAtacante=new Orco();
		Assert.assertEquals(40,orcoAtacante.obtenerPuntosDeAtaque());
		orcoAtacante.atacar(orcoAtacado);
		Assert.assertEquals(42,orcoAtacante.obtenerPuntosDeAtaque());
		
	}
	
	/* Este personaje no tiene sentido seguir testeando ya que
	 * no hay nada mas de especial en este personaje
	 */
	
	
}
