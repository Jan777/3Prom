package promotionSystem.razas;

import org.junit.Assert;

import org.junit.Test;

public class OrcoTest {

	@Test
	public void SiUnOrcoAtacaAOtroPersonajeDespuesDeAtacarAumentaEn2SuAtaque(){
		
		Orco orcoAtacado=new MagoOrco();
		Orco orcoAtacante=new MagoOrco();
		Assert.assertEquals(40,orcoAtacante.obtenerPuntosDeAtaque());
		orcoAtacante.atacar(orcoAtacado);
		Assert.assertEquals(50,orcoAtacante.obtenerPuntosDeAtaque());
		
	}
}
