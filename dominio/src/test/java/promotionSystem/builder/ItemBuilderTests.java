package promotionSystem.builder;

import org.junit.Assert;
import org.junit.Test;


import promotionSystem.Personaje;
import promotionSystem.razas.Humano;

public class ItemBuilderTests {

	
	@Test
	public void siEquipoUnArmaYSeModificanLosStats(){
		Personaje Emeritus = new Humano();
		Assert.assertEquals(10, Emeritus.obtenerPuntosDeAtaque());
		Emeritus = ItemBuilder.ConEspadaGorgoroth(Emeritus);
		Assert.assertEquals(20, Emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals(15, Emeritus.obtenerPuntosDeMagia());
	}//veo que modifique adecuadamente varios stat que esa arma modifica
	
	@Test
	public void siEquipo2TiposDeItemYSeModificanLosStats2(){ 
		Personaje Emeritus = new Humano();
		Emeritus = ItemBuilder.ConEspadaGorgoroth(Emeritus);
		Emeritus = ItemBuilder.ConEscudoHyrule(Emeritus);
		Assert.assertEquals(20, Emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals(24, Emeritus.obtenerPuntosDeDefensa());
		Assert.assertEquals(15, Emeritus.obtenerPuntosDeMagia());
		Assert.assertEquals(1, Emeritus.obtenerPuntosDeVelocidad());
	}//veo que modifique adecuadamente un stat que ambos items modifican
}
