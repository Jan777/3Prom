package promotionSystem.builder;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Constantes;
import promotionSystem.Personaje;
import promotionSystem.razas.GuerreroHumano;
import promotionSystem.razas.PokemonTipoFuego;

public class ItemBuilderTests {

	
	@Test
	public void siEquipoUnArmaYSeModificanLosStats(){
		Personaje Emeritus = new GuerreroHumano();
		Assert.assertEquals(Constantes.AtaqueGuerreroHumano, Emeritus.obtenerPuntosDeAtaque());
		Emeritus = ItemBuilder.ConEspadaGorgoroth(Emeritus);
		Assert.assertEquals(Constantes.AtaqueGuerreroHumano*2, Emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.MagiaGuerreroHumano+10, Emeritus.obtenerPuntosDeMagia());
	}
	
	@Test
	public void siEquipo2TiposDeItemYSeModificanLosStats2(){ 
		Personaje Emeritus = new GuerreroHumano();
		Emeritus = ItemBuilder.ConEspadaGorgoroth(Emeritus);
		Emeritus = ItemBuilder.ConEscudoHyrule(Emeritus);
		Assert.assertEquals(Constantes.AtaqueGuerreroHumano*2, Emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals((Constantes.DefensaGuerreroHumano+10)*2, Emeritus.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MagiaGuerreroHumano+10, Emeritus.obtenerPuntosDeMagia());
		Assert.assertEquals((int)((Constantes.VelocidadGuerreroHumano+10)*0.5), Emeritus.obtenerPuntosDeVelocidad());
	}
	
	
	@Test
	public void siEquipoBotasFloberAumentaVelocidad(){ 
		Personaje Emeritus = new GuerreroHumano();
		Assert.assertEquals(Constantes.VelocidadGuerreroHumano, Emeritus.obtenerPuntosDeVelocidad());
		Emeritus = ItemBuilder.ConBotasFlober(Emeritus);
		Assert.assertEquals((Constantes.VelocidadGuerreroHumano+15)*2, Emeritus.obtenerPuntosDeVelocidad());
		
	}
	
	@Test
	public void siEquipoVaritaMissignoAumentaMagia(){ 
		Personaje Emeritus = new GuerreroHumano();
		Assert.assertEquals(Constantes.MagiaGuerreroHumano, Emeritus.obtenerPuntosDeMagia());
		Emeritus = ItemBuilder.ConVaritaMissingno(Emeritus);
		Assert.assertEquals((Constantes.MagiaGuerreroHumano+5)*2, Emeritus.obtenerPuntosDeMagia());
	}
	
}
