package promotionSystem.hechizos;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Constantes;
import promotionSystem.Personaje;
import promotionSystem.razas.GuerreroOrco;
import promotionSystem.razas.Jedi;
import promotionSystem.razas.PokemonTipoAgua;
import promotionSystem.razas.PokemonTipoFuego;
import promotionSystem.razas.PokemonTipoPlanta;
import promotionSystem.razas.Riku;
import promotionSystem.razas.Roxas;
import promotionSystem.razas.Sora;
import promotionSystem.razas.Wookie;

public class HechizosTest {
	
	@Test
	public void siUsoHechizoHieloAfectaASuOponente(){
		Personaje riku =new Riku();
		Personaje pokemon=new PokemonTipoFuego();
		Assert.assertEquals(Constantes.SaludPokemonDeFuego, pokemon.getSalud());
		Assert.assertEquals(Constantes.VelocidadPokemonDeFuego, pokemon.obtenerPuntosDeVelocidad());
		riku.atacarConMagia(pokemon, "Hielo");
		Assert.assertEquals(47, pokemon.getSalud());
		Assert.assertEquals(2, pokemon.obtenerPuntosDeVelocidad());
	}
	
	@Test
	public void siLoAtacoLoPuedoCurar(){
		Personaje Riku =new Riku();
		Personaje roxas =new GuerreroOrco();
		Assert.assertEquals(Constantes.SaludRoxas, roxas.getSalud());
		Riku.atacar(roxas);
		Assert.assertEquals(41, roxas.getSalud());
		Riku.usarMagiaSupport(roxas, "Cura");
		Assert.assertEquals(50, roxas.getSalud());

	}
	
	@Test
	public void siUsoHechizoTruenoAfectaASuOponente(){
		Personaje roxas =new Roxas();
		Personaje pokemon=new PokemonTipoAgua();
		Assert.assertEquals(Constantes.SaludPokemonDeAgua, pokemon.getSalud());
		Assert.assertEquals(Constantes.VelocidadPokemonDeAgua, pokemon.obtenerPuntosDeVelocidad());
		roxas.atacarConMagia(pokemon, "Trueno");
		Assert.assertEquals(56, pokemon.getSalud());
		Assert.assertEquals(2, pokemon.obtenerPuntosDeVelocidad());
		
	}
	
	@Test
	public void siUsoHechizoPiroAfectaASuOponente(){
		Personaje sora =new Sora();
		Personaje pokemon=new PokemonTipoPlanta();
		Assert.assertEquals(Constantes.SaludPokemonDePlanta, pokemon.getSalud());
		sora.atacarConMagia(pokemon, "Piro");
		Assert.assertEquals(45, pokemon.getSalud());
		
	}
	
	@Test
	public void siUsoHechizoIraWookeanaAfectaASuFuerza(){
		Personaje wookie =new Wookie();
		Assert.assertEquals(Constantes.AtaqueWookie, wookie.obtenerPuntosDeAtaque());
		wookie.usarMagiaDeAlteracion("IraWookeana");
		Assert.assertEquals(21, wookie.obtenerPuntosDeAtaque());
		
	}
	
	@Test
	public void siUsoHechizoEmpujonDeFuerzaAfectaASuOponente(){
		Personaje jedi =new Jedi();
		Personaje pokemon=new PokemonTipoPlanta();
		Assert.assertEquals(Constantes.SaludPokemonDePlanta, pokemon.getSalud());
		jedi.atacarConMagia(pokemon, "EmpujonDeFuerza");
		Assert.assertEquals(47, pokemon.getSalud());
		
	}
	
	@Test
	public void siUsoHechizoDeAtaqueAfectaASuEnergia(){
		Personaje jedi =new Jedi();
		Personaje pokemon=new PokemonTipoPlanta();
		Assert.assertEquals(100, jedi.getEnergia());
		jedi.atacarConMagia(pokemon, "EmpujonDeFuerza");
		Assert.assertEquals(84, jedi.getEnergia());
		
	}
	
	@Test
	public void siUsoHechizoSupportAfectaASuEnergia(){
		Personaje riku =new Riku();
		Personaje roxas =new GuerreroOrco();
		Assert.assertEquals(100, riku.getEnergia());
		riku.usarMagiaSupport(roxas, "Cura");
		Assert.assertEquals(87, riku.getEnergia());
		
	}
	
	@Test
	public void siUsoHechizoDeAlteracionAfectaASuEnergia(){
		Personaje jedi =new Wookie();
		Assert.assertEquals(100, jedi.getEnergia());
		jedi.usarMagiaDeAlteracion("IraWookeana");
		Assert.assertEquals(95, jedi.getEnergia());
	}
}
