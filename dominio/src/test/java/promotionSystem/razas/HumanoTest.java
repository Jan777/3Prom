package promotionSystem.razas;

import org.junit.Assert;

import org.junit.Test;

public class HumanoTest {
	
	@Test
	public void siHumanoAtacaNoCambiaLosStatsDespuesDeAtacar(){
		Humano man=new Humano();
		Humano man2=new Humano();
		Assert.assertEquals(10, man.obtenerPuntosDeAtaque());
		man.atacar(man2);
		Assert.assertEquals(10, man.obtenerPuntosDeAtaque());
	}
}
