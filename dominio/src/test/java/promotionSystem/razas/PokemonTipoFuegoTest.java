package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class PokemonTipoFuegoTest {

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajesDePokemon personaje=new PokemonTipoFuego();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		personaje.subirNivel();
		Assert.assertEquals(1, personaje.getNivel());
		
		Assert.assertEquals(160, personaje.obtenerPuntosDeAtaque());	
		Assert.assertEquals(61, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(160, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(80, personaje.obtenerPuntosDeVelocidad());
		Assert.assertEquals(95, personaje.getSalud());
		Assert.assertEquals(1010, personaje.getEnergia());
	}

}
