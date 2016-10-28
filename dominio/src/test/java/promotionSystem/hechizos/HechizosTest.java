package promotionSystem.hechizos;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Constantes;
import promotionSystem.Personaje;
import promotionSystem.razas.castas.kingdomhearts.Riku;
import promotionSystem.razas.castas.kingdomhearts.Roxas;
import promotionSystem.razas.castas.kingdomhearts.Sora;
import promotionSystem.razas.castas.orco.GuerreroOrco;
import promotionSystem.razas.castas.pokemon.PokemonTipoAgua;
import promotionSystem.razas.castas.pokemon.PokemonTipoFuego;
import promotionSystem.razas.castas.pokemon.PokemonTipoPlanta;
import promotionSystem.razas.castas.starwars.Jedi;
import promotionSystem.razas.castas.starwars.Wookie;

public class HechizosTest {
	
	@Test
	public void siUsoHechizoHieloAfectaASuOponente(){
		Personaje riku =new Riku();
		Personaje pokemon=new PokemonTipoFuego();
		Assert.assertEquals(Constantes.SaludPokemonDeFuego, pokemon.getSalud());
		Assert.assertEquals(Constantes.VelocidadPokemonDeFuego, pokemon.obtenerPuntosDeVelocidad());
		riku.atacarConMagia(pokemon, "Hielo");
		Assert.assertEquals(Constantes.SaludPokemonDeFuego-Constantes.MagiaRiku+Constantes.DefensaPokemonDeFuego, pokemon.getSalud());
		Assert.assertEquals(Constantes.VelocidadPokemonDeFuego/2, pokemon.obtenerPuntosDeVelocidad());
	}
	
	@Test
	public void siLoAtacoLoPuedoCurar(){
		Personaje Riku =new Riku();
		Personaje roxas =new Roxas();
		Assert.assertEquals(Constantes.SaludRoxas, roxas.getSalud());
		Riku.atacar(roxas);
		Assert.assertEquals(Constantes.SaludRoxas-Constantes.AtaqueRiku+Constantes.DefensaRoxas, roxas.getSalud());
		Riku.usarMagiaSupport(roxas, "Cura");
		Assert.assertEquals(Constantes.SaludRoxas, roxas.getSalud());

	}
	
	@Test
	public void siUsoHechizoTruenoAfectaASuOponente(){
		Personaje roxas =new Roxas();
		Personaje pokemon=new PokemonTipoAgua();
		Assert.assertEquals(Constantes.SaludPokemonDeAgua, pokemon.getSalud());
		Assert.assertEquals(Constantes.VelocidadPokemonDeAgua, pokemon.obtenerPuntosDeVelocidad());
		roxas.atacarConMagia(pokemon, "Trueno");
		Assert.assertEquals(Constantes.SaludPokemonDeAgua-Constantes.MagiaRoxas+Constantes.DefensaPokemonDeAgua, pokemon.getSalud());
		Assert.assertEquals((int)(Constantes.VelocidadPokemonDeAgua/1.5), pokemon.obtenerPuntosDeVelocidad());
		
	}
	
	@Test
	public void siUsoHechizoPiroAfectaASuOponente(){
		Personaje sora =new Sora();
		Personaje pokemon=new PokemonTipoPlanta();
		Assert.assertEquals(Constantes.SaludPokemonDePlanta, pokemon.getSalud());
		sora.atacarConMagia(pokemon, "Piro");
		Assert.assertEquals(Constantes.SaludPokemonDePlanta-Constantes.MagiaSora+Constantes.DefensaPokemonDePlanta, pokemon.getSalud());
		
	}
	
	@Test
	public void siUsoHechizoIraWookeanaAfectaASuFuerza(){
		Personaje wookie =new Wookie();
		Assert.assertEquals(Constantes.AtaqueWookie, wookie.obtenerPuntosDeAtaque());
		wookie.usarMagiaDeAlteracion("IraWookeana");
		Assert.assertEquals(Constantes.AtaqueWookie+(int)(Constantes.MagiaWookie/3)+5, wookie.obtenerPuntosDeAtaque());
		
	}
	
	@Test
	public void siUsoHechizoEmpujonDeFuerzaAfectaASuOponente(){
		Personaje jedi =new Jedi();
		Personaje pokemon=new PokemonTipoPlanta();
		Assert.assertEquals(Constantes.SaludPokemonDePlanta, pokemon.getSalud());
		jedi.atacarConMagia(pokemon, "EmpujonDeFuerza");
		Assert.assertEquals(Constantes.SaludPokemonDePlanta-Constantes.MagiaJedi+Constantes.DefensaPokemonDePlanta, pokemon.getSalud());
		
	}
	
	@Test
	public void siUsoHechizoDeAtaqueAfectaASuEnergia(){
		Personaje jedi =new Jedi();
		Personaje pokemon=new PokemonTipoPlanta();
		Assert.assertEquals(100, jedi.getEnergia());
		jedi.atacarConMagia(pokemon, "EmpujonDeFuerza");
		Assert.assertEquals(100-Constantes.MagiaJedi, jedi.getEnergia());
		
	}
	
	@Test
	public void siUsoHechizoSupportAfectaASuEnergia(){
		Personaje riku =new Riku();
		Personaje roxas =new GuerreroOrco();
		Assert.assertEquals(100, riku.getEnergia());
		riku.usarMagiaSupport(roxas, "Cura");
		Assert.assertEquals(100-Constantes.MagiaRiku, riku.getEnergia());
		
	}
	
	@Test
	public void siUsoHechizoDeAlteracionAfectaASuEnergia(){
		Personaje jedi =new Wookie();
		Assert.assertEquals(100, jedi.getEnergia());
		jedi.usarMagiaDeAlteracion("IraWookeana");
		Assert.assertEquals(100-Constantes.MagiaWookie, jedi.getEnergia());
	}
}
