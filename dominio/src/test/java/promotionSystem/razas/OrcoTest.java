package promotionSystem.razas;

import org.junit.Assert;

import org.junit.Test;

public class OrcoTest {

	@Test
	public void SiUnOrcoAtacaAOtroPersonajeDespuesDeAtacarAumentaEn2SuAtaque(){
		
		Orco orcoAtacado=new Orco();
		Orco orcoAtacante=new Orco();
		Assert.assertEquals(40,orcoAtacante.obtenerPuntosDeAtaque());
		orcoAtacante.atacar(orcoAtacado);
		Assert.assertEquals(42,orcoAtacante.obtenerPuntosDeAtaque());
		
	}
}
