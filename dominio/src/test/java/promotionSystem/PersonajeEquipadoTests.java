package promotionSystem;

import org.junit.Test;

import org.junit.Assert;
import promotionSystem.personajeEquipado.*;
import promotionSystem.razas.GuerreroHumano;

public class PersonajeEquipadoTests {

	private PersonajeEquipado personajeEquipado;
	
	@Test
	public void siPuedoAgregarDosItemsDelMismoTipo() {
		Personaje Louie = new GuerreroHumano();
		Assert.assertEquals(80, Louie.obtenerPuntosDeDefensa());
		// agrego escudo de defensa (+2)
		Louie = new ConEscudo(Louie,1,0,1,2,1,0,1,0);
		Assert.assertEquals(82, Louie.obtenerPuntosDeDefensa());
		// agrego casco de defensa (*2)
		Louie = new ConCasco(Louie,1,0,2,0,1,0,1,0);
		Assert.assertEquals((80 + 2) * 2, Louie.obtenerPuntosDeDefensa());
	}
	
	@Test
	public void siPuedoAgregarDosItemsDeDistintoTipo() {
		Personaje Louie = new GuerreroHumano();
		// agrego escudo de ataque (*2)
		Louie = new ConArma(Louie,2,0,1,0,1,0,1,0);
		Assert.assertEquals(150 * 2, Louie.obtenerPuntosDeAtaque());
		// agrego casco de defensa (*2)
		Assert.assertEquals(80, Louie.obtenerPuntosDeDefensa());
		Louie = new ConCasco(Louie,1,0,1,2,1,0,1,0);
		Assert.assertEquals(82, Louie.obtenerPuntosDeDefensa());
	}
}
