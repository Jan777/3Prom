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
		Personaje Emeritus = new GuerreroHumano(INICIO_MAPA);
		Assert.assertEquals(ATAQUE_GUERRERO_HUMANO, Emeritus.obtenerPuntosDeAtaque());
		Emeritus.recibirItem(new EspadaGorgoroth());
		Emeritus.equiparItem(new EspadaGorgoroth());
		Assert.assertEquals(ATAQUE_GUERRERO_HUMANO +ATAQUE_ESPADA_GORGOROTH, Emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals(MAGIA_GUERRERO_HUMANO +MAGIA_ESPADA_GORGOROTH, Emeritus.obtenerPuntosDeMagia());
	}
	
	@Test
	public void siEquipo2TiposDeItemYSeModificanLosStats2() throws Exception {
		Personaje Emeritus = new GuerreroHumano(INICIO_MAPA);
		Emeritus.recibirItem(new EspadaGorgoroth());
		Emeritus.equiparItem(new EspadaGorgoroth());
		Emeritus.recibirItem(new EscudoHyrule());
		Emeritus.equiparItem(new EscudoHyrule());
		Assert.assertEquals(ATAQUE_GUERRERO_HUMANO +ATAQUE_ESPADA_GORGOROTH, Emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals(DEFENSA_GUERRERO_HUMANO +DEFENSA_ESCUDO_HYRULE, Emeritus.obtenerPuntosDeDefensa());
		Assert.assertEquals(MAGIA_GUERRERO_HUMANO +MAGIA_ESPADA_GORGOROTH, Emeritus.obtenerPuntosDeMagia());
		Assert.assertEquals(VELOCIDAD_GUERRERO_HUMANO +VELOCIDAD_ESPADA_GORGOROTH+VELOCIDAD_ESCUDO_HYRULE, Emeritus.obtenerPuntosDeVelocidad());
	}
	
	
	@Test
	public void siEquipoBotasFloberAumentaVelocidad() throws Exception {
		Personaje Emeritus = new GuerreroHumano(INICIO_MAPA);
		Assert.assertEquals(VELOCIDAD_GUERRERO_HUMANO, Emeritus.obtenerPuntosDeVelocidad());
		Emeritus.recibirItem(new BotasFlober());
		Emeritus.equiparItem(new BotasFlober());
		Assert.assertEquals((VELOCIDAD_GUERRERO_HUMANO +VELOCIDAD_BOTAS_FLOBER), Emeritus.obtenerPuntosDeVelocidad());

	}
	
	@Test
	public void siEquipoVaritaMissignoAumentaMagia() throws Exception {
		Personaje Emeritus = new GuerreroHumano(INICIO_MAPA);
		Assert.assertEquals(MAGIA_GUERRERO_HUMANO, Emeritus.obtenerPuntosDeMagia());
		Emeritus.recibirItem(new VaritaMissingno());
		Emeritus.equiparItem(new VaritaMissingno());
		Assert.assertEquals((MAGIA_GUERRERO_HUMANO +MAGIA_VARITA_MISSIGNO), Emeritus.obtenerPuntosDeMagia());
	}
	
}
