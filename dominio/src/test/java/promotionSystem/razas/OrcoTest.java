package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.castas.orco.MagoOrco;

import static promotionSystem.Constantes.INICIO_MAPA;

public class OrcoTest {

	@Test
	public void SiUnOrcoAtacaAOtroPersonajeDespuesDeAtacarAumentaEn10SuAtaque(){
		
		Orco orcoAtacado=new MagoOrco(INICIO_MAPA);
		Orco orcoAtacante=new MagoOrco(INICIO_MAPA);
		Assert.assertEquals(Constantes.ATAQUE_MAGO_ORCO,orcoAtacante.obtenerPuntosDeAtaque());
		orcoAtacante.atacar(orcoAtacado);
		Assert.assertEquals(Constantes.ATAQUE_MAGO_ORCO +10,orcoAtacante.obtenerPuntosDeAtaque());
		
	}
}
