package promotionSystem;

import org.junit.Test;

import junit.framework.Assert;

public class PersonajeEquipadoTests {

	private PersonajeEquipado personajeEquipado;
	
	@Test
	public void siPuedoAgregarDosItemsDelMismoTipo() {
		Personaje Louie = new Personaje();
		Assert.assertEquals(2, Louie.obtenerPuntosDeDefensa());
		// agrego escudo de defensa (+2)
		Louie = new ConEscudo(Louie);
		Assert.assertEquals(2 + 2, Louie.obtenerPuntosDeDefensa());
		// agrego casco de defensa (*2)
		Louie = new ConCasco(Louie);
		Assert.assertEquals((2 + 2) * 2, Louie.obtenerPuntosDeDefensa());
	}
	
	@Test
	public void siPuedoAgregarDosItemsDeDistintoTipo() {
		Personaje Louie = new Personaje();
		// agrego escudo de ataque (*2)
		Louie = new ConArma(Louie);
		Assert.assertEquals(10 * 2, Louie.obtenerPuntosDeAtaque());
		// agrego casco de defensa (*2)
		Louie = new ConCasco(Louie);
		Assert.assertEquals(2 * 2, Louie.obtenerPuntosDeDefensa());
	}
	
	/*
	@Test
	public void siPersonajeEquipadoAumentaSuAtaquePorTenerUnaEspada(){
		personajeEquipado.recibirItem(new Item("Espada"));
		Assert.assertTrue();
	}
	*/
}
