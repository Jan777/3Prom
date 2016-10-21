package promotionSystem.razas;

import org.junit.Assert;

import org.junit.Test;

public class HumanoTest {
	
	@Test
	public void siHumanoAtacaNoCambiaLosStatsDespuesDeAtacar(){
		Humano man=new GuerreroHumano();
		Humano man2=new MagoHumano();
		Assert.assertEquals(150, man.obtenerPuntosDeAtaque());
		man.atacar(man2);
		Assert.assertEquals(150, man.obtenerPuntosDeAtaque());
	}
}
