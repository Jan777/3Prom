package promotionSystem.builder;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.Personaje;
import promotionSystem.items.BotasFlober;
import promotionSystem.items.EscudoHyrule;
import promotionSystem.items.EspadaGorgoroth;
import promotionSystem.items.VaritaMissingno;
import promotionSystem.razas.castas.humano.GuerreroHumano;

import static promotionSystem.Constantes.*;

public class ItemBuilderTests {

	
	@Test
	public void siEquipoUnArmaYSeModificanLosStats() throws Exception {
		Personaje Emeritus = new GuerreroHumano();
		Assert.assertEquals(AtaqueGuerreroHumano, Emeritus.obtenerPuntosDeAtaque());
		Emeritus.recibirItem(new EspadaGorgoroth());
		Emeritus.equiparItem(new EspadaGorgoroth());
		Assert.assertEquals(AtaqueGuerreroHumano*2, Emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals(MagiaGuerreroHumano+10, Emeritus.obtenerPuntosDeMagia());
	}
	
	@Test
	public void siEquipo2TiposDeItemYSeModificanLosStats2() throws Exception {
		Personaje Emeritus = new GuerreroHumano();
		Emeritus.recibirItem(new EspadaGorgoroth());
		Emeritus.equiparItem(new EspadaGorgoroth());
		Emeritus.recibirItem(new EscudoHyrule());
		Emeritus.equiparItem(new EscudoHyrule());
		Assert.assertEquals(AtaqueGuerreroHumano*2, Emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals((DefensaGuerreroHumano+10)*2, Emeritus.obtenerPuntosDeDefensa());
		Assert.assertEquals(MagiaGuerreroHumano+10, Emeritus.obtenerPuntosDeMagia());
		Assert.assertEquals((int)((VelocidadGuerreroHumano+10)*0.5), Emeritus.obtenerPuntosDeVelocidad());
	}
	
	
	@Test
	public void siEquipoBotasFloberAumentaVelocidad() throws Exception {
		Personaje Emeritus = new GuerreroHumano();
		Assert.assertEquals(Constantes.VelocidadGuerreroHumano, Emeritus.obtenerPuntosDeVelocidad());
		Emeritus.recibirItem(new BotasFlober());
		Emeritus.equiparItem(new BotasFlober());
		Assert.assertEquals((Constantes.VelocidadGuerreroHumano+15)*2, Emeritus.obtenerPuntosDeVelocidad());

	}
	
	@Test
	public void siEquipoVaritaMissignoAumentaMagia() throws Exception {
		Personaje Emeritus = new GuerreroHumano();
		Assert.assertEquals(Constantes.MagiaGuerreroHumano, Emeritus.obtenerPuntosDeMagia());
		Emeritus.recibirItem(new VaritaMissingno());
		Emeritus.equiparItem(new VaritaMissingno());
		Assert.assertEquals((Constantes.MagiaGuerreroHumano+5)*2, Emeritus.obtenerPuntosDeMagia());
	}
	
}
