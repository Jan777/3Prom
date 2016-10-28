package promotionSystem;

import org.junit.Test;
import org.junit.Assert;

import promotionSystem.builder.ItemBuilder;
import promotionSystem.personajeEquipado.*;
import promotionSystem.razas.castas.pokemon.PokemonTipoFuego;

public class PersonajeEquipadoTests {
	
	@Test
	public void siPuedoEquiparmeUnItemDeCadaTipo(){
		Personaje louie = new PokemonTipoFuego();
		Assert.assertEquals(Constantes.AtaquePokemonDeFuego, louie.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DefensaPokemonDeFuego, louie.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MagiaPokemonDeFuego, louie.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VelocidadPokemonDeFuego, louie.obtenerPuntosDeVelocidad());
		louie = ItemBuilder.ConEspadaGorgoroth(louie);
		louie = ItemBuilder.ConBotasFlober(louie);
		louie = ItemBuilder.ConCascoAdamantium(louie);
		louie = ItemBuilder.ConChalecoKevlar(louie);
		louie = ItemBuilder.ConEscudoHyrule(louie);
		Assert.assertEquals((Constantes.AtaquePokemonDeFuego*2)+10+10, louie.obtenerPuntosDeAtaque());
		Assert.assertEquals((((Constantes.DefensaPokemonDeFuego-10)*3*3)+10)*2, louie.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MagiaPokemonDeFuego+10+5, louie.obtenerPuntosDeMagia());
		Assert.assertEquals((int)((((Constantes.VelocidadPokemonDeFuego+10+15)*2)-10)*0.5), louie.obtenerPuntosDeVelocidad());
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
	public void siEquipoItemDeAtaqueSubeElStat(){
		Personaje louie = new PokemonTipoFuego();
		louie = ItemBuilder.ConEspadaGorgoroth(louie);
		Assert.assertEquals(Constantes.AtaquePokemonDeFuego * 2, louie.obtenerPuntosDeAtaque());
	}
	
	@Test
	public void siEquipoItemDeDefensaSubeElStat(){
		Personaje louie = new PokemonTipoFuego();
		louie = ItemBuilder.ConChalecoKevlar(louie);
		Assert.assertEquals(Constantes.DefensaPokemonDeFuego * 3, louie.obtenerPuntosDeDefensa());
	}
	
	@Test
	public void siEquipoItemDeMagiaSubeElStat(){
		Personaje louie = new PokemonTipoFuego();
		louie = ItemBuilder.ConVaritaMissingno(louie);
		Assert.assertEquals((Constantes.MagiaPokemonDeFuego+5) * 2, louie.obtenerPuntosDeMagia());
	}
	
	@Test
	public void siEquipoItemDeVelocidadSubeElStat(){
		Personaje louie = new PokemonTipoFuego();
		louie = ItemBuilder.ConBotasFlober(louie);
		Assert.assertEquals((Constantes.VelocidadPokemonDeFuego+15) * 2, louie.obtenerPuntosDeVelocidad());
	}
}
