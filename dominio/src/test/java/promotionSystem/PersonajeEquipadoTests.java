package promotionSystem;

import org.junit.Test;

import org.junit.Assert;

import promotionSystem.builder.ItemBuilder;
import promotionSystem.personajeEquipado.*;
import promotionSystem.razas.PokemonTipoFuego;

public class PersonajeEquipadoTests {
	
	@Test
	public void siPuedoEquiparmeUnItemDeCadaTipo(){
		Personaje louie = new PokemonTipoFuego();
		Assert.assertEquals(150, louie.obtenerPuntosDeAtaque());
		Assert.assertEquals(60, louie.obtenerPuntosDeDefensa());
		Assert.assertEquals(150, louie.obtenerPuntosDeMagia());
		Assert.assertEquals(75, louie.obtenerPuntosDeVelocidad());
		louie = ItemBuilder.ConEspadaGorgoroth(louie);
		louie = ItemBuilder.ConBotasFlober(louie);
		louie = ItemBuilder.ConCascoAdamantium(louie);
		louie = ItemBuilder.ConChalecoKevlar(louie);
		louie = ItemBuilder.ConEscudoHyrule(louie);
		Assert.assertEquals(320, louie.obtenerPuntosDeAtaque());
		Assert.assertEquals(920, louie.obtenerPuntosDeDefensa());
		Assert.assertEquals(165, louie.obtenerPuntosDeMagia());
		Assert.assertEquals(95, louie.obtenerPuntosDeVelocidad());
	}
	
	@Test
	public void siPuedoEquiparmeUnItemDeCadaTipoEnElInventario(){
		Personaje louie = new PokemonTipoFuego();
		louie = ItemBuilder.ConEspadaGorgoroth(louie);
		louie = ItemBuilder.ConBotasFlober(louie);
		louie = ItemBuilder.ConCascoAdamantium(louie);
		louie = ItemBuilder.ConChalecoKevlar(louie);
		louie = ItemBuilder.ConEscudoHyrule(louie);
		louie = ItemBuilder.ConEspadaGorgoroth(louie);
		louie = ItemBuilder.ConBotasFlober(louie);
		louie = ItemBuilder.ConCascoAdamantium(louie);
		louie = ItemBuilder.ConChalecoKevlar(louie);
		louie = ItemBuilder.ConEscudoHyrule(louie);
		Assert.assertNotEquals(null, louie.getArmaDelInventario());
		Assert.assertNotEquals(null, louie.getBotasDelInventario());
		Assert.assertNotEquals(null, louie.getCascoDelInventario());
		Assert.assertNotEquals(null, louie.getChalecoDelInventario());
		Assert.assertNotEquals(null, louie.getEscudoDelInventario());
	}
	
	@Test
	public void siPuedoAgregarDosItemsQueModifiquenElMismoStat() {
		Personaje louie = new PokemonTipoFuego();
		Assert.assertEquals(60, louie.obtenerPuntosDeDefensa());
		// agrego escudo de defensa (+2)
		louie = new ConEscudo(louie,1,0,1,2,1,0,1,0);
		Assert.assertEquals(60 + 2, louie.obtenerPuntosDeDefensa());
		// agrego casco de defensa (*2)
		louie = new ConCasco(louie,1,0,2,0,1,0,1,0);
		Assert.assertEquals((60 + 2) * 2, louie.obtenerPuntosDeDefensa());
	}
	
	@Test
	public void siPuedoAgregarDosItemsDeDistintoTipo() {
		Personaje louie = new PokemonTipoFuego();
		// agrego escudo de ataque (*2)
		louie = new ConArma(louie,2,0,1,0,1,0,1,0);
		Assert.assertEquals(150 * 2, louie.obtenerPuntosDeAtaque());
		// agrego casco de defensa (*2)
		Assert.assertEquals(60, louie.obtenerPuntosDeDefensa());
		louie = new ConCasco(louie,1,0,1,2,1,0,1,0);
		Assert.assertEquals(60 + 2, louie.obtenerPuntosDeDefensa());
	}
	
	@Test
	public void siEquipoItemDeAtaqueSubeElStat(){
		Personaje louie = new PokemonTipoFuego();
		louie = ItemBuilder.ConEspadaGorgoroth(louie);
		Assert.assertEquals(150 * 2, louie.obtenerPuntosDeAtaque());
	}
	
	@Test
	public void siEquipoItemDeDefensaSubeElStat(){
		Personaje louie = new PokemonTipoFuego();
		louie = ItemBuilder.ConChalecoKevlar(louie);
		Assert.assertEquals(60 * 3, louie.obtenerPuntosDeDefensa());
	}
	
	@Test
	public void siEquipoItemDeMagiaSubeElStat(){
		Personaje louie = new PokemonTipoFuego();
		louie = ItemBuilder.ConVaritaMissingno(louie);
		Assert.assertEquals((150+5) * 2, louie.obtenerPuntosDeMagia());
	}
	
	@Test
	public void siEquipoItemDeVelocidadSubeElStat(){
		Personaje louie = new PokemonTipoFuego();
		louie = ItemBuilder.ConBotasFlober(louie);
		Assert.assertEquals((75+15) * 2, louie.obtenerPuntosDeVelocidad());
	}
}
