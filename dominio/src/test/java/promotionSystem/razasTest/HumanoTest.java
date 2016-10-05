package promotionSystem.razasTest;

import junit.framework.Assert;

import org.junit.Test;

import promotionSystem.razas.Humano;

public class HumanoTest {
	
	@Test
	public void siHumanoAtacaNoCambiaLosStasDespuesDeAtacar(){
		Humano man=new Humano();
		Humano man2=new Humano();
		Assert.assertEquals(10, man.obtenerPuntosDeAtaque());
		man.atacar(man2);
		Assert.assertEquals(10, man.obtenerPuntosDeAtaque());
	}
	
	//No tiene sentido seguir haciendo Test de humano ya que 
	//serian los mismos Test de personaje, hice este para que
	//al menos haya algo.

}
