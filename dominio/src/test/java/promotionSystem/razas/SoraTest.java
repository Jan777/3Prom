package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Personaje;


public class SoraTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Sora personaje=new Sora();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(3, personaje.getNivel());
		
		Assert.assertEquals(100+3*10, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(100+3*10, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(100+3*10, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(100+3*10, personaje.obtenerPuntosDeVelocidad());
		Assert.assertEquals(100+3*10, personaje.getSalud());
		Assert.assertEquals(1000+3*10, personaje.getEnergia());
	}

	@Test
	public void siUsoHechizoPiroAfectaASuOponente(){
		Personaje sora =new Sora();
		Personaje pokemon=new PokemonTipoPlanta();
		Assert.assertEquals(150, pokemon.getSalud());
		sora.hechizar("Piro", pokemon);
		Assert.assertEquals(120, pokemon.getSalud());
		
	}
	
	@Test
	public void siLoAtacoLoPuedoCurar(){
		Personaje sora =new Sora();
		Personaje roxas =new MagoHumano();
		Assert.assertEquals(75, roxas.getSalud());
		sora.atacar(roxas);
		Assert.assertEquals(25, roxas.getSalud());
		sora.hechizar("Cura", roxas);
		Assert.assertEquals(45, roxas.getSalud());
		
	}
}
