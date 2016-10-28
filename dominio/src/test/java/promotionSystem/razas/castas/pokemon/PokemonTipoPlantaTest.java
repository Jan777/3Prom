package promotionSystem.razas.castas.pokemon;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Constantes;
import promotionSystem.razas.PersonajeDePokemon;
import promotionSystem.razas.castas.pokemon.PokemonTipoPlanta;

public class PokemonTipoPlantaTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajeDePokemon personaje=new PokemonTipoPlanta();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MultiplicadorDeNivelNormal, personaje.getEnergia());
		Assert.assertEquals(Constantes.SaludPokemonDePlanta+2*Constantes.MultiplicadorDeNivelNormal, personaje.getSalud());
		Assert.assertEquals(Constantes.AtaquePokemonDePlanta+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DefensaPokemonDePlanta+2*Constantes.MultiplicadorDeNivelEspecial, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MagiaPokemonDePlanta+2*Constantes.MultiplicadorDeNivelEspecial, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VelocidadPokemonDePlanta+2*Constantes.MultiplicadorDeNivelPlebe, personaje.obtenerPuntosDeVelocidad());
	}
}
