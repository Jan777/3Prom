package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class PokemonTipoFuegoTest {

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajesDePokemon personaje=new PokemonTipoFuego();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1000+3*10, personaje.getEnergia());
		Assert.assertEquals(90+3*5, personaje.getSalud());
		Assert.assertEquals(150+3*10, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(60+3*2, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(150+3*10, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(75+3*5, personaje.obtenerPuntosDeVelocidad());
	}

}
