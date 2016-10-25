package promotionSystem.hechizos;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Personaje;
import promotionSystem.razas.GuerreroOrco;
import promotionSystem.razas.PokemonTipoAgua;
import promotionSystem.razas.PokemonTipoFuego;
import promotionSystem.razas.PokemonTipoPlanta;
import promotionSystem.razas.Riku;
import promotionSystem.razas.Roxas;
import promotionSystem.razas.Sora;

public class HechizosTest {
	
	@Test
	public void siUsoHechizoHieloAfectaASuOponente(){
		Personaje riku =new Riku();
		Personaje pokemon=new PokemonTipoFuego();
		Assert.assertEquals(90, pokemon.getSalud());
		Assert.assertEquals(75, pokemon.obtenerPuntosDeVelocidad());
		riku.atacarConMagia(pokemon, "Hielo");
		Assert.assertEquals(75, pokemon.getSalud());
		Assert.assertEquals(37, pokemon.obtenerPuntosDeVelocidad());
		
	}
	
	@Test
	public void siLoAtacoLoPuedoCurar(){
		Personaje Riku =new Riku();
		Personaje roxas =new GuerreroOrco();
		Assert.assertEquals(150, roxas.getSalud());
		Riku.atacar(roxas);
		Assert.assertEquals(50, roxas.getSalud());
		Riku.usarMagiaSupport(roxas, "Cura");
		Assert.assertEquals(125, roxas.getSalud());
		
	}
	
	@Test
	public void siUsoHechizoTruenoAfectaASuOponente(){
		Personaje roxas =new Roxas();
		Personaje pokemon=new PokemonTipoAgua();
		Assert.assertEquals(100, pokemon.getSalud());
		Assert.assertEquals(100, pokemon.obtenerPuntosDeVelocidad());
		roxas.atacarConMagia(pokemon, "Trueno");
		Assert.assertEquals(0, pokemon.getSalud());
		Assert.assertEquals(66, pokemon.obtenerPuntosDeVelocidad());
		
	}
	
	@Test
	public void siUsoHechizoPiroAfectaASuOponente(){
		Personaje sora =new Sora();
		Personaje pokemon=new PokemonTipoPlanta();
		Assert.assertEquals(150, pokemon.getSalud());
		sora.atacarConMagia(pokemon, "Piro");
		Assert.assertEquals(120, pokemon.getSalud());
		
	}

}
