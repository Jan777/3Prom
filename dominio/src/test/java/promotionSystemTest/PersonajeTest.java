package promotionSystemTest;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Personaje;

public class PersonajeTest {
	@Test
	public void siAtacaDisminuyeEnergiaPropiaYSaludDelRival(){
		Personaje personajeAtacante=new Personaje();
		Personaje personajeAtacado=new Personaje();
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertTrue(personajeAtacado.getSalud()==90 && personajeAtacante.getEnergia()==90);
	}
	
	@Test
	public void siAtacaUnaVezElPersonajeAtacadoTodaviaSigueVivo(){
		Personaje personajeAtacante=new Personaje();
		Personaje personajeAtacado=new Personaje();
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertTrue(personajeAtacado.estaVivo());
	}
	
	@Test
	public void siAtacaMuchasVecesElPersonajeAtacadoMuere(){
		Personaje personajeAtacante=new Personaje();
		Personaje personajeAtacado=new Personaje();
		Assert.assertTrue(personajeAtacado.estaVivo());
		for(int i=0;i<10;i++){			
			personajeAtacante.atacar(personajeAtacado);
		}
		Assert.assertFalse(personajeAtacado.estaVivo());
	}
	
	@Test
	public void siEsCuradoLuegoDeSerAtacadoLaSaludVuelveAlMaximo(){
		Personaje personajeAtacante=new Personaje();
		Personaje personajeAtacado=new Personaje();			
			personajeAtacante.atacar(personajeAtacado);
			Assert.assertTrue(personajeAtacado.getSalud()==90);
			personajeAtacado.serCurado();
			Assert.assertTrue(personajeAtacado.getSalud()==100);
	}
	
	@Test
	public void siEsEnergizadoLuegoDeAtacarLaEnergiaVuelveAlMaximo(){
		Personaje personajeAtacante=new Personaje();
		Personaje personajeAtacado=new Personaje();			
			personajeAtacante.atacar(personajeAtacado);
			Assert.assertTrue(personajeAtacante.getEnergia()==90);
			personajeAtacante.serEnergizado();
			Assert.assertTrue(personajeAtacante.getEnergia()==100);
	}
	
	@Test
	public void siSeQuedoSinEnergiaNoPuedeAtacar(){
		Personaje personajeAtacante=new Personaje();
		Personaje personajeAtacado=new Personaje();
	    
		for(int i=0;i<10;i++){
			personajeAtacante.atacar(personajeAtacado);
			personajeAtacado.serCurado();
		}
		
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertTrue(personajeAtacado.getSalud()==100);
	}
	
	
	
}
