package promotionSystem.razas.castas.pokemon;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.PersonajeDePokemon;

import static promotionSystem.Constantes.INICIO_MAPA;

public class PokemonTipoFuegoTest {

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajeDePokemon personaje=new PokemonTipoFuego(INICIO_MAPA);
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getEnergia());
		Assert.assertEquals(Constantes.SALUD_POKEMON_DE_FUEGO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getSalud());
		Assert.assertEquals(Constantes.ATAQUE_POKEMON_DE_FUEGO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DEFENSA_POKEMON_DE_FUEGO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MAGIA_POKEMON_DE_FUEGO +2*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VELOCIDAD_POKEMON_DE_FUEGO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeVelocidad());
	}
}
