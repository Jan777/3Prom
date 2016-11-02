package promotionSystem;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.items.*;
import promotionSystem.razas.castas.kingdomHearts.Riku;
import promotionSystem.razas.castas.pokemon.PokemonTipoFuego;

import static promotionSystem.Constantes.*;


public class PersonajeEquipadoTests {
	
	@Test
	public void siPuedoEquiparmeUnItemDeCadaTipo() throws Exception {
		Personaje louie = new PokemonTipoFuego();
		Assert.assertEquals(AtaquePokemonDeFuego, louie.obtenerPuntosDeAtaque());
		Assert.assertEquals(DEFENSA_POKEMON_DE_FUEGO, louie.obtenerPuntosDeDefensa());
		Assert.assertEquals(MagiaPokemonDeFuego, louie.obtenerPuntosDeMagia());
		Assert.assertEquals(VelocidadPokemonDeFuego, louie.obtenerPuntosDeVelocidad());
		agregarAInventario(louie);
		louie.equiparItem(new EspadaGorgoroth());
		louie.equiparItem(new BotasFlober());
		louie.equiparItem(new CascoAdamantium());
		louie.equiparItem(new ChalecoKevlar());
		louie.equiparItem(new EscudoHyrule());
		Assert.assertEquals(AtaquePokemonDeFuego+ATAQUE_ESPADA_GORGOROTH+ATAQUE_CHALECO_KEVLAR+ATAQUE_CASCO_ADAMANTIUM, louie.getAtaque());
		Assert.assertEquals(DEFENSA_POKEMON_DE_FUEGO+DEFENSA_BOTAS_FLOBER+DEFENSA_CASCO_ADAMANTIUM+DEFENSA_ESCUDO_HYRULE+DEFENSA_CHALECO_KEVLAR , louie.obtenerPuntosDeDefensa());
		Assert.assertEquals(MagiaPokemonDeFuego+MAGIA_BOTAS_FLOBER+MAGIA_ESPADA_GORGOROTH, louie.obtenerPuntosDeMagia());
		Assert.assertEquals(VelocidadPokemonDeFuego+VELOCIDAD_BOTAS_FLOBER+VELOCIDAD_CHALECO_KEVLAR+VELOCIDAD_ESCUDO_HYRULE+VELOCIDAD_ESPADA_GORGOROTH, louie.obtenerPuntosDeVelocidad());
	}

	private void agregarAInventario(Personaje louie) throws Exception {
		louie.recibirItem(new EspadaGorgoroth());
		louie.recibirItem(new BotasFlober());
		louie.recibirItem(new CascoAdamantium());
		louie.recibirItem(new ChalecoKevlar());
		louie.recibirItem(new EscudoHyrule());
	}

	@Test
	public void siPuedoEquiparmeUnItemDeCadaTipoEnElInventario() throws Exception {
		Personaje louie = new PokemonTipoFuego();
		louie.recibirItem(new EspadaGorgoroth());
		louie.recibirItem(new BotasFlober());
		louie.recibirItem(new CascoAdamantium());
		louie.recibirItem(new ChalecoKevlar());
		louie.recibirItem(new EscudoHyrule());
		louie.recibirItem(new EspadaGorgoroth());
		louie.recibirItem(new BotasFlober());
		louie.recibirItem(new CascoAdamantium());
		louie.recibirItem(new ChalecoKevlar());
		louie.recibirItem(new EscudoHyrule());

		louie.equiparItem(new EspadaGorgoroth());
		louie.equiparItem(new BotasFlober());
		louie.equiparItem(new CascoAdamantium());
		louie.equiparItem(new ChalecoKevlar());
		louie.equiparItem(new EscudoHyrule());
		louie.equiparItem(new EspadaGorgoroth());
		louie.equiparItem(new BotasFlober());
		louie.equiparItem(new CascoAdamantium());
		louie.equiparItem(new ChalecoKevlar());
		louie.equiparItem(new EscudoHyrule());

		Assert.assertEquals(5, louie.getInventario().size());
	}
	
	@Test
	public void siEquipoItemDeAtaqueSubeElStat() throws Exception {
		Personaje louie = new PokemonTipoFuego();
		louie.recibirItem(new EspadaKokiri());
		louie.equiparItem(new EspadaKokiri());
		Assert.assertEquals(AtaquePokemonDeFuego+ATAQUE_ESPADA_KOKIRI, louie.obtenerPuntosDeAtaque());
	}

	@Test
	public void siEquipoItemDeDefensaSubeElStat() throws Exception {
		Personaje louie = new PokemonTipoFuego();
		louie.recibirItem(new ChalecoKevlar());
		louie.equiparItem(new ChalecoKevlar());
		Assert.assertEquals(DEFENSA_POKEMON_DE_FUEGO +DEFENSA_CHALECO_KEVLAR, louie.obtenerPuntosDeDefensa());
	}

	@Test
	public void siEquipoItemDeMagiaSubeElStat() throws Exception {
		Personaje louie = new PokemonTipoFuego();
		louie.recibirItem(new VaritaMissingno());
		louie.equiparItem(new VaritaMissingno());
		Assert.assertEquals(MagiaPokemonDeFuego+MAGIA_VARITA_MISSIGNO,louie.obtenerPuntosDeMagia());
	}

	@Test
	public void siEquipoItemDeVelocidadSubeElStat() throws Exception {
		Personaje louie = new PokemonTipoFuego();
		louie.recibirItem(new BotasFlober());
		louie.equiparItem(new BotasFlober());
		Assert.assertEquals(VelocidadPokemonDeFuego+VELOCIDAD_BOTAS_FLOBER, louie.obtenerPuntosDeVelocidad());
	}

	@Test
	public void siEquipoItemYTiraHechizo() throws Exception {
		Personaje pokemon = new PokemonTipoFuego();
		Personaje riku=new Riku();
		riku.recibirItem(new EspadaGorgoroth());
		riku.equiparItem(new EspadaGorgoroth());
		Assert.assertEquals(SaludPokemonDeFuego, pokemon.getSalud());
		Assert.assertEquals(VelocidadPokemonDeFuego, pokemon.obtenerPuntosDeVelocidad());
		riku.atacarConMagia(pokemon, "Hielo");
		Assert.assertEquals(SaludPokemonDeFuego - MagiaRiku + DEFENSA_POKEMON_DE_FUEGO - MAGIA_ESPADA_GORGOROTH, pokemon.getSalud());
		Assert.assertEquals(VelocidadPokemonDeFuego/2, pokemon.obtenerPuntosDeVelocidad());
	}
}
