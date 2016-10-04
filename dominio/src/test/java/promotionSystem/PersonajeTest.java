package promotionSystem;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Personaje;

public class PersonajeTest {
	Personaje personajeAtacante;
	Personaje personajeAtacado;
	
	public void crearPersonajes(){
		 personajeAtacante=new Personaje();
		 personajeAtacado=new Personaje();
	}
	
	@Test
	public void siAtacaDisminuyeEnergiaPropiaYSaludDelRival(){
		crearPersonajes();
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertTrue(personajeAtacado.getSalud()==90 && personajeAtacante.getEnergia()==90);
	}
	
	@Test
	public void siAtacaUnaVezElPersonajeAtacadoTodaviaSigueVivo(){
		crearPersonajes();
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertTrue(personajeAtacado.estaVivo());
	}
	
	@Test
	public void siElAtacadoTieneMenosVidaQueElAtacantePersonajeAtacadoMuere(){
		crearPersonajes();
		Assert.assertTrue(personajeAtacado.estaVivo());
		personajeAtacado.setSalud(10);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertFalse(personajeAtacado.estaVivo());
	}
	
	@Test
	public void siTieneMenosSaludQueLaInicialYEsCuradoLaSaludVuelveAlMaximo(){
		personajeAtacado=new Personaje();	
		personajeAtacado.setSalud(10);
		personajeAtacado.serCurado();
		Assert.assertTrue(personajeAtacado.getSalud()==100);
	}

	@Test
	public void siTieneMenosEnergiaQueLaInicialYEsEnergizadoLaVuelveAlMaximo(){
		personajeAtacante=new Personaje();		
		personajeAtacante.setEnergia(10);
		personajeAtacante.serEnergizado();
		Assert.assertTrue(personajeAtacante.getEnergia()==100);
	}
	
	@Test
	public void siSeQuedoSinEnergiaNoPuedeAtacar(){
		crearPersonajes();
		personajeAtacante.setEnergia(0);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertTrue(personajeAtacado.getSalud()==100);
	}
	
	@Test
	public void siTieneVidaAlMaximoNoPuedeAumentarSuSaludAlSerCurado(){
		personajeAtacado=new Personaje();
		Assert.assertTrue(personajeAtacado.getSalud()==100);
		personajeAtacado.serCurado();
		Assert.assertTrue(personajeAtacado.getSalud()==100);
	}
	
	@Test
	public void siTieneEnergiaAlMaximoNoPuedeAumentarSuEnergiaAlSerEnergizado(){
		personajeAtacante=new Personaje();
		Assert.assertTrue(personajeAtacante.getEnergia()==100);
		personajeAtacante.serEnergizado();
		Assert.assertTrue(personajeAtacante.getEnergia()==100);
	}
	
	
}
