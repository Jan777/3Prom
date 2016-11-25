package promotionSystem.hechizos;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.Personaje;
import promotionSystem.razas.castas.kingdomHearts.Riku;
import promotionSystem.razas.castas.kingdomHearts.Roxas;
import promotionSystem.razas.castas.kingdomHearts.Sora;
import promotionSystem.razas.castas.pokemon.PokemonTipoAgua;
import promotionSystem.razas.castas.pokemon.PokemonTipoFuego;
import promotionSystem.razas.castas.pokemon.PokemonTipoPlanta;
import promotionSystem.razas.castas.starWars.Jedi;
import promotionSystem.razas.castas.starWars.Wookie;

import static promotionSystem.Constantes.INICIO_MAPA;

public class HechizosTest {
	
	Personaje riku;
	Personaje jedi;
	Personaje roxas;
	Personaje wookie;
	@Before
	public void crearPersonajes(){
		riku =new Riku();
		riku.setPosicion(INICIO_MAPA);
		 jedi =new Jedi();
		 jedi.setPosicion(INICIO_MAPA);
		 roxas =new Roxas();
		 roxas.setPosicion(INICIO_MAPA);
		 wookie=new Wookie();
		 wookie.setPosicion(INICIO_MAPA);
	}
	
	@Test
	public void siUsoHechizoHieloAfectaASuOponente(){
		Personaje pokemon=new PokemonTipoFuego();
		pokemon.setPosicion(INICIO_MAPA);
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_FUEGO, pokemon.getSalud());
		Assert.assertEquals(Constantes.VELOCIDAD_POKEMON_DE_FUEGO, pokemon.obtenerPuntosDeVelocidad());
		riku.atacarConMagia(pokemon, "Hielo");
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_FUEGO -Constantes.MAGIA_RIKU +Constantes.DEFENSA_POKEMON_DE_FUEGO, pokemon.getSalud());
		Assert.assertEquals(Constantes.VELOCIDAD_POKEMON_DE_FUEGO /2, pokemon.obtenerPuntosDeVelocidad());
	}
	
	/*@Test
	public void siLoAtacoLoPuedoCurar(){
	
		Assert.assertEquals(Constantes.SALUD_ROXAS, roxas.getSalud());
		riku.atacar(roxas);
		Assert.assertEquals(Constantes.SALUD_ROXAS -Constantes.ATAQUE_RIKU +Constantes.DEFENSA_ROXAS, roxas.getSalud());
		riku.usarMagiaSupport(roxas, "Cura");
		Assert.assertEquals(Constantes.SALUD_ROXAS, roxas.getSalud());

	}*/
	
	@Test
	public void siUsoHechizoTruenoAfectaASuOponente(){
		Personaje pokemon=new PokemonTipoAgua();
		pokemon.setPosicion(INICIO_MAPA);
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_AGUA, pokemon.getSalud());
		Assert.assertEquals(Constantes.VELOCIDAD_POKEMON_DE_AGUA, pokemon.obtenerPuntosDeVelocidad());
		roxas.atacarConMagia(pokemon, "Trueno");
		int puntosARestar=Constantes.MAGIA_ROXAS -Constantes.DEFENSA_POKEMON_DE_AGUA<0?0:Constantes.MAGIA_ROXAS -Constantes.DEFENSA_POKEMON_DE_AGUA;
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_AGUA -puntosARestar, pokemon.getSalud());
		Assert.assertEquals((int)(Constantes.VELOCIDAD_POKEMON_DE_AGUA /1.5), pokemon.obtenerPuntosDeVelocidad());
		
	}
	
	@Test
	public void siUsoHechizoPiroAfectaASuOponente(){
		Personaje sora =new Sora();
		sora.setPosicion(INICIO_MAPA);
		Personaje pokemon=new PokemonTipoPlanta();
		pokemon.setPosicion(INICIO_MAPA);
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_PLANTA, pokemon.getSalud());
		sora.atacarConMagia(pokemon, "Piro");
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_PLANTA -Constantes.MAGIA_SORA +Constantes.DEFENSA_POKEMON_DE_PLANTA, pokemon.getSalud());
		
	}
	
/*	@Test
	public void siUsoHechizoIraWookeanaAfectaASuFuerza(){
		Assert.assertEquals(Constantes.ATAQUE_WOOKIE, wookie.obtenerPuntosDeAtaque());
		wookie.usarMagiaDeAlteracion("IraWookeana");
		Assert.assertEquals(Constantes.ATAQUE_WOOKIE + Constantes.MAGIA_WOOKIE /3 +5, wookie.obtenerPuntosDeAtaque());
		
	}*/
	
	@Test
	public void siUsoHechizoEmpujonDeFuerzaAfectaASuOponente(){
		Personaje pokemon=new PokemonTipoPlanta();
		pokemon.setPosicion(INICIO_MAPA);
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_PLANTA, pokemon.getSalud());
		jedi.atacarConMagia(pokemon, "EmpujonDeFuerza");
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_PLANTA -Constantes.MAGIA_JEDI +Constantes.DEFENSA_POKEMON_DE_PLANTA, pokemon.getSalud());
		
	}
	
	@Test
	public void siUsoHechizoDeAtaqueAfectaASuEnergia(){
		crearPersonajes();
		Personaje pokemon=new PokemonTipoPlanta();
		pokemon.setPosicion(INICIO_MAPA);
		Assert.assertEquals(Constantes.ENERGIA_MAXIMA_JEDI, jedi.getEnergia());
		jedi.atacarConMagia(pokemon, "EmpujonDeFuerza");
		Assert.assertEquals(Constantes.ENERGIA_MAXIMA_JEDI-Constantes.MAGIA_JEDI, jedi.getEnergia());
		
	}
	
	/*@Test
	public void siUsoHechizoSupportAfectaASuEnergia(){
		crearPersonajes();
		Assert.assertEquals(100, riku.getEnergia());
		riku.usarMagiaSupport(roxas, "Cura");
		Assert.assertEquals(100-Constantes.MAGIA_RIKU, riku.getEnergia());
		
	}*/
	
/*	@Test
	public void siUsoHechizoDeAlteracionAfectaASuEnergia(){
		crearPersonajes();
		Assert.assertEquals(100, wookie.getEnergia());
		wookie.usarMagiaDeAlteracion("IraWookeana");
		Assert.assertEquals(100-Constantes.MAGIA_WOOKIE, wookie.getEnergia());
	}*/
}
