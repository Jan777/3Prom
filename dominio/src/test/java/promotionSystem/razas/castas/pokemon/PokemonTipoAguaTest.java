package promotionSystem.razas.castas.pokemon;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Constantes;
import promotionSystem.razas.PersonajeDePokemon;
import promotionSystem.razas.castas.pokemon.PokemonTipoAgua;

public class PokemonTipoAguaTest {
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajeDePokemon personaje=new PokemonTipoAgua();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MultiplicadorDeNivelNormal, personaje.getEnergia());
		Assert.assertEquals(Constantes.SaludPokemonDeAgua+2*Constantes.MultiplicadorDeNivelNormal, personaje.getSalud());
		Assert.assertEquals(Constantes.AtaquePokemonDeAgua+2*Constantes.MultiplicadorDeNivelEspecial, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DefensaPokemonDeAgua+2*Constantes.MultiplicadorDeNivelEspecial, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MagiaPokemonDeAgua+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VelocidadPokemonDeAgua+2*Constantes.MultiplicadorDeNivelPlebe, personaje.obtenerPuntosDeVelocidad());
	}

}
