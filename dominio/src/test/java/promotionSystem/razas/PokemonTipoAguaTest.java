package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class PokemonTipoAguaTest {
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajesDePokemon personaje=new PokemonTipoAgua();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		personaje.subirNivel();
		Assert.assertEquals(1, personaje.getNivel());
		
		Assert.assertEquals(105, personaje.obtenerPuntosDeAtaque());	
		Assert.assertEquals(75, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(160, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(105, personaje.obtenerPuntosDeVelocidad());
		Assert.assertEquals(105, personaje.getSalud());
		Assert.assertEquals(1010, personaje.getEnergia());
	}

}
