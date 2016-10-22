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
		Personaje Louie = new PokemonTipoFuego();
		Assert.assertEquals(60, Louie.obtenerPuntosDeDefensa());
		// agrego escudo de defensa (+2)
		Louie = new ConEscudo(Louie,1,0,1,2,1,0,1,0);
		Assert.assertEquals(60 + 2, Louie.obtenerPuntosDeDefensa());
		// agrego casco de defensa (*2)
		Louie = new ConCasco(Louie,1,0,2,0,1,0,1,0);
		Assert.assertEquals((60 + 2) * 2, Louie.obtenerPuntosDeDefensa());
	}
	
	@Test
	public void siPuedoAgregarDosItemsDeDistintoTipo() {
		Personaje Louie = new PokemonTipoFuego();
		// agrego escudo de ataque (*2)
		Louie = new ConArma(Louie,2,0,1,0,1,0,1,0);
		Assert.assertEquals(150 * 2, Louie.obtenerPuntosDeAtaque());
		// agrego casco de defensa (*2)
		Assert.assertEquals(60, Louie.obtenerPuntosDeDefensa());
		Louie = new ConCasco(Louie,1,0,1,2,1,0,1,0);
		Assert.assertEquals(60 + 2, Louie.obtenerPuntosDeDefensa());
	}
	
	//FIXME ARREGLAR TEST COMENTADOS
	/*@Test
	public void siPuedoGuardarUnArmaEnElInventario(){
		Personaje Louie = new PokemonTipoFuego();
		Louie = ItemBuilder.ConEspadaGorgoroth(Louie);
		Assert.assertEquals(150 * 2, Louie.obtenerPuntosDeAtaque());
		Louie = ItemBuilder.ConEspadaKokiri(Louie);
		Assert.assertEquals(150 * 2, Louie.obtenerPuntosDeAtaque());
	}*/
}
