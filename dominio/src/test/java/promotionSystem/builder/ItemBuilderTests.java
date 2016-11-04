package promotionSystem.builder;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import promotionSystem.Personaje;
import promotionSystem.items.BotasFlober;
import promotionSystem.items.EscudoHyrule;
import promotionSystem.items.EspadaGorgoroth;
import promotionSystem.items.VaritaMissingno;
import promotionSystem.razas.castas.humano.GuerreroHumano;

import static promotionSystem.Constantes.*;

public class ItemBuilderTests {
	
	Personaje emeritus;
	@Before
	public void crearemeritus(){
		 emeritus = new GuerreroHumano();
		 emeritus.setPosicion(INICIO_MAPA);
	}
	@Test
	public void siEquipoUnArmaYSeModificanLosStats() throws Exception {
		crearemeritus();
		Assert.assertEquals(ATAQUE_GUERRERO_HUMANO, emeritus.obtenerPuntosDeAtaque());
		emeritus.recibirItem(new EspadaGorgoroth());
		emeritus.equiparItem(new EspadaGorgoroth());
		Assert.assertEquals(ATAQUE_GUERRERO_HUMANO +ATAQUE_ESPADA_GORGOROTH, emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals(MAGIA_GUERRERO_HUMANO +MAGIA_ESPADA_GORGOROTH, emeritus.obtenerPuntosDeMagia());
	}
	
	@Test
	public void siEquipo2TiposDeItemYSeModificanLosStats2() throws Exception {
		crearemeritus();
		emeritus.recibirItem(new EspadaGorgoroth());
		emeritus.equiparItem(new EspadaGorgoroth());
		emeritus.recibirItem(new EscudoHyrule());
		emeritus.equiparItem(new EscudoHyrule());
		Assert.assertEquals(ATAQUE_GUERRERO_HUMANO +ATAQUE_ESPADA_GORGOROTH, emeritus.obtenerPuntosDeAtaque());
		Assert.assertEquals(DEFENSA_GUERRERO_HUMANO +DEFENSA_ESCUDO_HYRULE, emeritus.obtenerPuntosDeDefensa());
		Assert.assertEquals(MAGIA_GUERRERO_HUMANO +MAGIA_ESPADA_GORGOROTH, emeritus.obtenerPuntosDeMagia());
		Assert.assertEquals(VELOCIDAD_GUERRERO_HUMANO +VELOCIDAD_ESPADA_GORGOROTH+VELOCIDAD_ESCUDO_HYRULE, emeritus.obtenerPuntosDeVelocidad());
	}
	
	
	@Test
	public void siEquipoBotasFloberAumentaVelocidad() throws Exception {
		crearemeritus();
		Assert.assertEquals(VELOCIDAD_GUERRERO_HUMANO, emeritus.obtenerPuntosDeVelocidad());
		emeritus.recibirItem(new BotasFlober());
		emeritus.equiparItem(new BotasFlober());
		Assert.assertEquals((VELOCIDAD_GUERRERO_HUMANO +VELOCIDAD_BOTAS_FLOBER), emeritus.obtenerPuntosDeVelocidad());

	}
	
	@Test
	public void siEquipoVaritaMissignoAumentaMagia() throws Exception {
		crearemeritus();
		Assert.assertEquals(MAGIA_GUERRERO_HUMANO, emeritus.obtenerPuntosDeMagia());
		emeritus.recibirItem(new VaritaMissingno());
		emeritus.equiparItem(new VaritaMissingno());
		Assert.assertEquals((MAGIA_GUERRERO_HUMANO +MAGIA_VARITA_MISSIGNO), emeritus.obtenerPuntosDeMagia());
	}
	
}
