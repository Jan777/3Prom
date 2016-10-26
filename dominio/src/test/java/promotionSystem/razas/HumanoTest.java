package promotionSystem.razas;

import org.junit.Assert;

import org.junit.Test;

import promotionSystem.Constantes;

public class HumanoTest {
	
	@Test
	public void siHumanoAtacaNoCambiaLosStatsDespuesDeAtacar(){
		Humano man=new GuerreroHumano();
		Humano man2=new MagoHumano();
		Assert.assertEquals(Constantes.AtaqueGuerreroHumano, man.obtenerPuntosDeAtaque());
		man.atacar(man2);
		Assert.assertEquals(Constantes.AtaqueGuerreroHumano, man.obtenerPuntosDeAtaque());
	}
}
