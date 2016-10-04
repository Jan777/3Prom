package promotionSystem;

import org.junit.Assert;
import org.junit.Test;

import static promotionSystem.builder.AlianzaBuilder.crearAlianza;

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
		personajeAtacado.setDefensa(0);
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
	public void siElAtacadoTieneMenosVidaQueElAtaqueDelPersonajeAtacanteElPersonajeAtacadoMuere(){
		crearPersonajes();
		Assert.assertTrue(personajeAtacado.estaVivo());
		personajeAtacado.setDefensa(0);
		personajeAtacado.setSalud(9);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertFalse(personajeAtacado.estaVivo());
	}
	
	@Test
	public void siElAtacadoTieneIgualVidaQueElAtaqueDelPersonajeAtacanteElPersonajeAtacadoMuere(){
		crearPersonajes();
		Assert.assertTrue(personajeAtacado.estaVivo());
		personajeAtacado.setDefensa(0);
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
	
	@Test
	public void siLaDefensaDelAtacadoEsMayorAlAtaqueDelAtacadoNoRecibeDano(){
		crearPersonajes();
		personajeAtacado.setDefensa(15);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertTrue(personajeAtacado.getSalud()==100);
	}
	
	//FIXME corregir nombre del metodo 
	@Test
	public void siLaDefensaEsMenorQueElAtaqueLaSaludDisminuyePeroNoTanto(){
		crearPersonajes();
		personajeAtacado.setDefensa(5);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertTrue(personajeAtacado.getSalud()==95);
	}
	
	@Test
	public void debeDevolverLosPuntosDeAtaque(){
		personajeAtacante=new Personaje();
		Assert.assertTrue(personajeAtacante.obtenerPuntosDeAtaque()==10);
	}
	
	@Test
	public void debeDevolverLosPuntosDeDefensa(){
		personajeAtacante=new Personaje();
		Assert.assertTrue(personajeAtacante.obtenerPuntosDeDefensa()==2);
	}
	
	@Test
	public void debeDevolverLosPuntosDeMagia(){
		personajeAtacante=new Personaje();
		Assert.assertTrue(personajeAtacante.obtenerPuntosDeMagia()==5);
	}
	
	@Test
	public void debeAumentarExperiencia(){
		personajeAtacante=new Personaje();
		Assert.assertTrue(personajeAtacante.getExperiencia()==0);
		personajeAtacante.subirExperiencia(200);
		Assert.assertTrue(personajeAtacante.getExperiencia()==200);
	}
	
	@Test
	public void SiPoseeLaExperienciaSuficienteElPersonajeDebeAumentarNivel(){
		personajeAtacante=new Personaje();
		personajeAtacante.subirExperiencia(20);
		personajeAtacante.subirNivel();
		Assert.assertTrue(personajeAtacante.getNivel()==1);
	}
	
	@Test
	public void SiNoPoseeLaExperienciaSuficienteElPersonajeDebeAumentarNivel(){
		personajeAtacante=new Personaje();
		personajeAtacante.subirExperiencia(9);
		personajeAtacante.subirNivel();
		Assert.assertTrue(personajeAtacante.getNivel()==0);
	}

	@Test
	public void debeElegirElPrimerPersonajeComoVictima(){
		Alianza alianzaEnemiga = crearAlianza(1);
        personajeAtacante = new Personaje();
        Personaje victima = personajeAtacante.elegirVictima(alianzaEnemiga, 1);
		Assert.assertEquals(0, alianzaEnemiga.getPersonajes().indexOf(victima));
	}
}
