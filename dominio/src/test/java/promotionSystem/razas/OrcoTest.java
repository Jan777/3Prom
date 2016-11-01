package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.castas.orco.MagoOrco;

public class OrcoTest {

	@Test
	public void SiUnOrcoAtacaAOtroPersonajeDespuesDeAtacarAumentaEn10SuAtaque(){
		
		Orco orcoAtacado=new MagoOrco();
		Orco orcoAtacante=new MagoOrco();
		Assert.assertEquals(Constantes.AtaqueMagoOrco,orcoAtacante.obtenerPuntosDeAtaque());
		orcoAtacante.atacar(orcoAtacado);
		Assert.assertEquals(Constantes.AtaqueMagoOrco+10,orcoAtacante.obtenerPuntosDeAtaque());
		
	}
}
