package promotionSystem.builder;

import org.junit.Assert;
import org.junit.Test;
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
		Assert.assertEquals(AtaqueGuerreroHumano+ATAQUE_ESPADA_GORGOROTH, Emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals(MagiaGuerreroHumano+MAGIA_ESPADA_GORGOROTH, Emeritus.obtenerPuntosDeMagia());
	}
	
	@Test
	public void siEquipo2TiposDeItemYSeModificanLosStats2() throws Exception {
		Personaje Emeritus = new GuerreroHumano();
		Emeritus.recibirItem(new EspadaGorgoroth());
		Emeritus.equiparItem(new EspadaGorgoroth());
		Emeritus.recibirItem(new EscudoHyrule());
		Emeritus.equiparItem(new EscudoHyrule());
		Assert.assertEquals(AtaqueGuerreroHumano+ATAQUE_ESPADA_GORGOROTH, Emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals(DefensaGuerreroHumano+DEFENSA_ESCUDO_HYRULE, Emeritus.obtenerPuntosDeDefensa());
		Assert.assertEquals(MagiaGuerreroHumano+MAGIA_ESPADA_GORGOROTH, Emeritus.obtenerPuntosDeMagia());
		Assert.assertEquals(VelocidadGuerreroHumano+VELOCIDAD_ESPADA_GORGOROTH+VELOCIDAD_ESCUDO_HYRULE, Emeritus.obtenerPuntosDeVelocidad());
	}
	
	
	@Test
	public void siEquipoBotasFloberAumentaVelocidad() throws Exception {
		Personaje Emeritus = new GuerreroHumano();
		Assert.assertEquals(VelocidadGuerreroHumano, Emeritus.obtenerPuntosDeVelocidad());
		Emeritus.recibirItem(new BotasFlober());
		Emeritus.equiparItem(new BotasFlober());
		Assert.assertEquals((VelocidadGuerreroHumano+VELOCIDAD_BOTAS_FLOBER), Emeritus.obtenerPuntosDeVelocidad());

	}
	
	@Test
	public void siEquipoVaritaMissignoAumentaMagia() throws Exception {
		Personaje Emeritus = new GuerreroHumano();
		Assert.assertEquals(MagiaGuerreroHumano, Emeritus.obtenerPuntosDeMagia());
		Emeritus.recibirItem(new VaritaMissingno());
		Emeritus.equiparItem(new VaritaMissingno());
		Assert.assertEquals((MagiaGuerreroHumano+MAGIA_VARITA_MISSIGNO), Emeritus.obtenerPuntosDeMagia());
	}
	
}
