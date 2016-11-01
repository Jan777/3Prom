package promotionSystem.builder;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.Personaje;
import promotionSystem.razas.castas.humano.GuerreroHumano;

public class ItemBuilderTests {

	
	@Test
	public void siEquipoUnArmaYSeModificanLosStats() throws Exception {
		Personaje Emeritus = new GuerreroHumano();
		Assert.assertEquals(Constantes.AtaqueGuerreroHumano, Emeritus.obtenerPuntosDeAtaque());
		Emeritus = Emeritus.equiparItem("ConEspadaGorgoroth");
		Assert.assertEquals(Constantes.AtaqueGuerreroHumano*2, Emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.MagiaGuerreroHumano+10, Emeritus.obtenerPuntosDeMagia());
	}
	
	@Test
	public void siEquipo2TiposDeItemYSeModificanLosStats2() throws Exception {
		Personaje Emeritus = new GuerreroHumano();
		Emeritus = Emeritus.equiparItem("ConEspadaGorgoroth");
		Emeritus = Emeritus.equiparItem("ConEscudoHyrule");
		Assert.assertEquals(Constantes.AtaqueGuerreroHumano*2, Emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals((Constantes.DefensaGuerreroHumano+10)*2, Emeritus.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MagiaGuerreroHumano+10, Emeritus.obtenerPuntosDeMagia());
		Assert.assertEquals((int)((Constantes.VelocidadGuerreroHumano+10)*0.5), Emeritus.obtenerPuntosDeVelocidad());
	}
	
	
	@Test
	public void siEquipoBotasFloberAumentaVelocidad() throws Exception {
		Personaje Emeritus = new GuerreroHumano();
		Assert.assertEquals(Constantes.VelocidadGuerreroHumano, Emeritus.obtenerPuntosDeVelocidad());
		Emeritus = Emeritus.equiparItem("ConBotasFlober");
		Assert.assertEquals((Constantes.VelocidadGuerreroHumano+15)*2, Emeritus.obtenerPuntosDeVelocidad());
		
	}
	
	@Test
	public void siEquipoVaritaMissignoAumentaMagia() throws Exception {
		Personaje Emeritus = new GuerreroHumano();
		Assert.assertEquals(Constantes.MagiaGuerreroHumano, Emeritus.obtenerPuntosDeMagia());
		Emeritus = Emeritus.equiparItem("ConVaritaMissingno");
		Assert.assertEquals((Constantes.MagiaGuerreroHumano+5)*2, Emeritus.obtenerPuntosDeMagia());
	}
	
}
