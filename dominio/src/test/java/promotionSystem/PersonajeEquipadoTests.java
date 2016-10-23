package promotionSystem;

import org.junit.Test;

import org.junit.Assert;

import promotionSystem.builder.ItemBuilder;
import promotionSystem.personajeEquipado.*;
import promotionSystem.razas.PokemonTipoFuego;

public class PersonajeEquipadoTests {

	private PersonajeEquipado personajeEquipado;
	
	@Test
	public void siPuedoAgregarDosItemsDelMismoTipo() {
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
	public void siPuedoGuardarUnArmaEnElInventario(){
		Personaje louie = new PokemonTipoFuego();
		louie = ItemBuilder.ConEspadaGorgoroth(louie);
		louie = ItemBuilder.ConEspadaKokiri(louie);
		Assert.assertEquals(150 * 2, louie.obtenerPuntosDeAtaque());
		Assert.assertEquals("ConEspadaKokiri", louie.getArmaDelInventario());
	}
	
}
