package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Personaje;

public class RoxasTest {
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Roxas personaje=new Roxas();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1000+10*3, personaje.getEnergia());
		Assert.assertEquals(100+5*3, personaje.getSalud());
		Assert.assertEquals(55+5*3, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(200+10*3, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(200+10*3, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(150+10*3, personaje.obtenerPuntosDeVelocidad());
	}
	
	@Test
	public void siUsoHechizoTruenoAfectaASuOponente(){
		Personaje roxas =new Roxas();
		Personaje pokemon=new PokemonTipoAgua();
		Assert.assertEquals(100, pokemon.getSalud());
		Assert.assertEquals(100, pokemon.obtenerPuntosDeVelocidad());
		roxas.hechizar("Trueno", pokemon);
		Assert.assertEquals(80, pokemon.getSalud());
		Assert.assertEquals(66, pokemon.obtenerPuntosDeVelocidad());
		roxas.hechizar("Cura", pokemon);
		Assert.assertEquals(100, pokemon.getSalud());
	}
	
	@Test
	public void siLoAtacoLoPuedoCurar(){
		Personaje Roxas =new Roxas();
		Personaje roxas =new MagoHumano();
		Assert.assertEquals(75, roxas.getSalud());
		Roxas.atacar(roxas);
		Assert.assertEquals(70, roxas.getSalud());
		Roxas.hechizar("Cura", roxas);
		Assert.assertEquals(75, roxas.getSalud());
	}

	@Test
	public void siAtacaAumentaDefensa(){
		PersonajeDeKingdomHearts personajeAtacante=new Roxas();
		PersonajeDeStarWars personajeAtacado=new Droide();

		Assert.assertEquals(200,personajeAtacante.obtenerPuntosDeDefensa());
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals((int) (200*1.125),personajeAtacante.obtenerPuntosDeDefensa());
	}
}
