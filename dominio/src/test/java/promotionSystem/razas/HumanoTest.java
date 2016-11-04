package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.castas.humano.GuerreroHumano;
import promotionSystem.razas.castas.humano.MagoHumano;

import static promotionSystem.Constantes.INICIO_MAPA;

public class HumanoTest {
	
	@Test
	public void siHumanoAtacaNoCambiaLosStatsDespuesDeAtacar(){
		Humano man=new GuerreroHumano();
		Humano man2=new MagoHumano();
		Assert.assertEquals(Constantes.ATAQUE_GUERRERO_HUMANO, man.obtenerPuntosDeAtaque());
		man.atacar(man2);
		Assert.assertEquals(Constantes.ATAQUE_GUERRERO_HUMANO, man.obtenerPuntosDeAtaque());
	}
}
