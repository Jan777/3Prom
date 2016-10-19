package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class PokemonTipoAguaTest {
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajesDePokemon personaje=new PokemonTipoAgua();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1000+3*10, personaje.getEnergia());
		Assert.assertEquals(100+3*5, personaje.getSalud());
		Assert.assertEquals(100+3*5, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(70+3*5, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(150+3*10, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(100+3*5, personaje.obtenerPuntosDeVelocidad());
	}

}
