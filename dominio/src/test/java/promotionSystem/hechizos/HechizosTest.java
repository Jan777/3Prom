package promotionSystem.hechizos;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.Personaje;
import promotionSystem.razas.castas.kingdomHearts.Riku;
import promotionSystem.razas.castas.kingdomHearts.Roxas;
import promotionSystem.razas.castas.kingdomHearts.Sora;
import promotionSystem.razas.castas.orco.GuerreroOrco;
import promotionSystem.razas.castas.pokemon.PokemonTipoAgua;
import promotionSystem.razas.castas.pokemon.PokemonTipoFuego;
import promotionSystem.razas.castas.pokemon.PokemonTipoPlanta;
import promotionSystem.razas.castas.starWars.Jedi;
import promotionSystem.razas.castas.starWars.Wookie;

import static promotionSystem.Constantes.INICIO_MAPA;

public class HechizosTest {
	
	@Test
	public void siUsoHechizoHieloAfectaASuOponente(){
		Personaje riku =new Riku(INICIO_MAPA);
		Personaje pokemon=new PokemonTipoFuego(INICIO_MAPA);
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_FUEGO, pokemon.getSalud());
		Assert.assertEquals(Constantes.VELOCIDAD_POKEMON_DE_FUEGO, pokemon.obtenerPuntosDeVelocidad());
		riku.atacarConMagia(pokemon, "Hielo");
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_FUEGO -Constantes.MAGIA_RIKU +Constantes.DEFENSA_POKEMON_DE_FUEGO, pokemon.getSalud());
		Assert.assertEquals(Constantes.VELOCIDAD_POKEMON_DE_FUEGO /2, pokemon.obtenerPuntosDeVelocidad());
	}
	
	@Test
	public void siLoAtacoLoPuedoCurar(){
		Personaje Riku =new Riku(INICIO_MAPA);
		Personaje roxas =new Roxas(INICIO_MAPA);
		Assert.assertEquals(Constantes.SALUD_ROXAS, roxas.getSalud());
		Riku.atacar(roxas);
		Assert.assertEquals(Constantes.SALUD_ROXAS -Constantes.ATAQUE_RIKU +Constantes.DEFENSA_ROXAS, roxas.getSalud());
		Riku.usarMagiaSupport(roxas, "Cura");
		Assert.assertEquals(Constantes.SALUD_ROXAS, roxas.getSalud());

	}
	
	@Test
	public void siUsoHechizoTruenoAfectaASuOponente(){
		Personaje roxas =new Roxas(INICIO_MAPA);
		Personaje pokemon=new PokemonTipoAgua(INICIO_MAPA);
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_AGUA, pokemon.getSalud());
		Assert.assertEquals(Constantes.VELOCIDAD_POKEMON_DE_AGUA, pokemon.obtenerPuntosDeVelocidad());
		roxas.atacarConMagia(pokemon, "Trueno");
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_AGUA -Constantes.MAGIA_ROXAS +Constantes.DEFENSA_POKEMON_DE_AGUA, pokemon.getSalud());
		Assert.assertEquals((int)(Constantes.VELOCIDAD_POKEMON_DE_AGUA /1.5), pokemon.obtenerPuntosDeVelocidad());
		
	}
	
	@Test
	public void siUsoHechizoPiroAfectaASuOponente(){
		Personaje sora =new Sora(INICIO_MAPA);
		Personaje pokemon=new PokemonTipoPlanta(INICIO_MAPA);
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_PLANTA, pokemon.getSalud());
		sora.atacarConMagia(pokemon, "Piro");
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_PLANTA -Constantes.MAGIA_SORA +Constantes.DEFENSA_POKEMON_DE_PLANTA, pokemon.getSalud());
		
	}
	
	@Test
	public void siUsoHechizoIraWookeanaAfectaASuFuerza(){
		Personaje wookie =new Wookie(INICIO_MAPA);
		Assert.assertEquals(Constantes.ATAQUE_WOOKIE, wookie.obtenerPuntosDeAtaque());
		wookie.usarMagiaDeAlteracion("IraWookeana");
		Assert.assertEquals(Constantes.ATAQUE_WOOKIE + Constantes.MAGIA_WOOKIE /3 +5, wookie.obtenerPuntosDeAtaque());
		
	}
	
	@Test
	public void siUsoHechizoEmpujonDeFuerzaAfectaASuOponente(){
		Personaje jedi =new Jedi(INICIO_MAPA);
		Personaje pokemon=new PokemonTipoPlanta(INICIO_MAPA);
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_PLANTA, pokemon.getSalud());
		jedi.atacarConMagia(pokemon, "EmpujonDeFuerza");
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_PLANTA -Constantes.MAGIA_JEDI +Constantes.DEFENSA_POKEMON_DE_PLANTA, pokemon.getSalud());
		
	}
	
	@Test
	public void siUsoHechizoDeAtaqueAfectaASuEnergia(){
		Personaje jedi =new Jedi(INICIO_MAPA);
		Personaje pokemon=new PokemonTipoPlanta(INICIO_MAPA);
		Assert.assertEquals(100, jedi.getEnergia());
		jedi.atacarConMagia(pokemon, "EmpujonDeFuerza");
		Assert.assertEquals(100-Constantes.MAGIA_JEDI, jedi.getEnergia());
		
	}
	
	@Test
	public void siUsoHechizoSupportAfectaASuEnergia(){
		Personaje riku =new Riku(INICIO_MAPA);
		Personaje roxas =new GuerreroOrco(INICIO_MAPA);
		Assert.assertEquals(100, riku.getEnergia());
		riku.usarMagiaSupport(roxas, "Cura");
		Assert.assertEquals(100-Constantes.MAGIA_RIKU, riku.getEnergia());
		
	}
	
	@Test
	public void siUsoHechizoDeAlteracionAfectaASuEnergia(){
		Personaje jedi =new Wookie(INICIO_MAPA);
		Assert.assertEquals(100, jedi.getEnergia());
		jedi.usarMagiaDeAlteracion("IraWookeana");
		Assert.assertEquals(100-Constantes.MAGIA_WOOKIE, jedi.getEnergia());
	}
}
