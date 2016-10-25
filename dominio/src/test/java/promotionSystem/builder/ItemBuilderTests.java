package promotionSystem.builder;

import org.junit.Assert;
import org.junit.Test;


import promotionSystem.Personaje;
import promotionSystem.razas.GuerreroHumano;
import promotionSystem.razas.PokemonTipoFuego;

public class ItemBuilderTests {

	
	@Test
	public void siEquipoUnArmaYSeModificanLosStats(){
		Personaje Emeritus = new GuerreroHumano();
		Assert.assertEquals(150, Emeritus.obtenerPuntosDeAtaque());
		Emeritus = ItemBuilder.ConEspadaGorgoroth(Emeritus);
		Assert.assertEquals(300, Emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals(30, Emeritus.obtenerPuntosDeMagia());
	}
	
	@Test
	public void siEquipo2TiposDeItemYSeModificanLosStats2(){ 
		Personaje Emeritus = new GuerreroHumano();
		Emeritus = ItemBuilder.ConEspadaGorgoroth(Emeritus);
		Emeritus = ItemBuilder.ConEscudoHyrule(Emeritus);
		Assert.assertEquals(300, Emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals(180, Emeritus.obtenerPuntosDeDefensa());
		Assert.assertEquals(30, Emeritus.obtenerPuntosDeMagia());
		Assert.assertEquals(50, Emeritus.obtenerPuntosDeVelocidad());
	}
	
	
	@Test
	public void siEquipoBotasFloberAumentaVelocidad(){ 
		Personaje Emeritus = new GuerreroHumano();
		Assert.assertEquals(90, Emeritus.obtenerPuntosDeVelocidad());
		Emeritus = ItemBuilder.ConBotasFlober(Emeritus);
		Assert.assertEquals((90+15)*2, Emeritus.obtenerPuntosDeVelocidad());
		
	}
	
	@Test
	public void siEquipoVaritaMissignoAumentaMagia(){ 
		Personaje Emeritus = new GuerreroHumano();
		Assert.assertEquals(20, Emeritus.obtenerPuntosDeMagia());
		Emeritus = ItemBuilder.ConVaritaMissingno(Emeritus);
		Assert.assertEquals((20+5)*2, Emeritus.obtenerPuntosDeMagia());
	}
	
}
