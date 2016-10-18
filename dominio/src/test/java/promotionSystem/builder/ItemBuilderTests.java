package promotionSystem.builder;

import org.junit.Assert;
import org.junit.Test;


import promotionSystem.Personaje;
import promotionSystem.razas.Humano;

public class ItemBuilderTests {

	
	@Test
	public void siCreaUnTipoDeArmaYSeModificanLosStats(){
		Personaje Emeritus = new Humano();
		Assert.assertEquals(10, Emeritus.obtenerPuntosDeAtaque());
		///Emeritus = new ItemBuilder();
		//FIXME este test esta incompleto, hay que terminarlo.
		Assert.assertEquals(10, Emeritus.obtenerPuntosDeAtaque());
	}
	///como hacer que Emeritus se transforme en un personaje Equipado con un item creado por el builder (espadaGorgoroth)
}
