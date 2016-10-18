package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class PokemonTipoPlantaTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		PersonajesDePokemon personaje=new PokemonTipoPlanta();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		personaje.subirNivel();
		Assert.assertEquals(1, personaje.getNivel());
		
		Assert.assertEquals(160, personaje.obtenerPuntosDeAtaque());	
		Assert.assertEquals(75, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(105, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(105, personaje.obtenerPuntosDeVelocidad());
		Assert.assertEquals(160, personaje.getSalud());
		Assert.assertEquals(1010, personaje.getEnergia());
	}


}
