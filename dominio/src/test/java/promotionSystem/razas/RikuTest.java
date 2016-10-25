package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Personaje;

public class RikuTest {

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Riku personaje=new Riku();
		Assert.assertEquals(0, personaje.getNivel());
		personaje.subirExperiencia(10);
		Assert.assertEquals(5, personaje.getExperiencia());
		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(1000+3*10, personaje.getEnergia());
		Assert.assertEquals(200+3*10, personaje.getSalud());
		Assert.assertEquals(200+3*10, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(50+3*5, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(75+3*5, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(150+3*5, personaje.obtenerPuntosDeVelocidad());
	}
	
	@Test
	public void siUsoHechizoHieloAfectaASuOponente(){
		Personaje riku =new Riku();
		Personaje pokemon=new PokemonTipoFuego();
		Assert.assertEquals(90, pokemon.getSalud());
		Assert.assertEquals(75, pokemon.obtenerPuntosDeVelocidad());
		riku.hechizar("Hielo", pokemon);
		Assert.assertEquals(75, pokemon.getSalud());
		Assert.assertEquals(37, pokemon.obtenerPuntosDeVelocidad());
		riku.hechizar("Cura", pokemon);
		Assert.assertEquals(90, pokemon.getSalud());
	}
	
	@Test
	public void siLoAtacoLoPuedoCurar(){
		Personaje Riku =new Riku();
		Personaje roxas =new GuerreroOrco();
		Assert.assertEquals(150, roxas.getSalud());
		Riku.atacar(roxas);
		Assert.assertEquals(50, roxas.getSalud());
		Riku.hechizar("Cura", roxas);
		Assert.assertEquals(70, roxas.getSalud());
		
	}
	
	@Test
	public void siAtacaAumentaDefensa(){
		PersonajeDeKingdomHearts personajeAtacante=new Riku();
		PersonajeDeStarWars personajeAtacado=new Droide();
		
		Assert.assertEquals(50,personajeAtacante.obtenerPuntosDeDefensa());
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals((int) (50*1.125),personajeAtacante.obtenerPuntosDeDefensa());
		
	}
	
	
}
