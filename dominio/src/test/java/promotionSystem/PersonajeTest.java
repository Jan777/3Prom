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
		Assert.assertEquals(90,personajeAtacado.getSalud());
		Assert.assertEquals(90,personajeAtacante.getEnergia());
	
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
		Assert.assertEquals(100,personajeAtacado.getSalud());
	}
	


	@Test
	public void siTieneMenosEnergiaQueLaInicialYEsEnergizadoLaVuelveAlMaximo(){
		personajeAtacante=new Personaje();		
		personajeAtacante.setEnergia(10);
		personajeAtacante.serEnergizado();
		Assert.assertEquals(100,personajeAtacante.getEnergia());
	}
	
	@Test
	public void siSeQuedoSinEnergiaNoPuedeAtacar(){
		crearPersonajes();
		personajeAtacante.setEnergia(0);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(100,personajeAtacado.getSalud());
	}
	
	@Test
	public void siTieneVidaAlMaximoNoPuedeAumentarSuSaludAlSerCurado(){
		personajeAtacado=new Personaje();
		Assert.assertEquals(100,personajeAtacado.getSalud());
		personajeAtacado.serCurado();
		Assert.assertEquals(100,personajeAtacado.getSalud());
	}
	
	@Test
	public void siTieneEnergiaAlMaximoNoPuedeAumentarSuEnergiaAlSerEnergizado(){
		personajeAtacante=new Personaje();
		Assert.assertEquals(100,personajeAtacante.getEnergia());
		personajeAtacante.serEnergizado();
		Assert.assertEquals(100,personajeAtacante.getEnergia());
	}
	
	@Test
	public void siLaDefensaDelAtacadoEsMayorAlAtaqueDelAtacadoNoRecibeDano(){
		crearPersonajes();
		personajeAtacado.setDefensa(15);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(100,personajeAtacado.getSalud());
	}
	
	//FIXME corregir nombre del metodo 
	@Test
	public void siLaDefensaEsMenorQueElAtaqueLaSaludDisminuyePeroNoTanto(){
		crearPersonajes();
		personajeAtacado.setDefensa(5);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(95,personajeAtacado.getSalud());
	}
	
	@Test
	public void debeDevolverLosPuntosDeAtaque(){
		personajeAtacante=new Personaje();
		Assert.assertEquals(10,personajeAtacante.obtenerPuntosDeAtaque());
	}
	
	@Test
	public void debeDevolverLosPuntosDeDefensa(){
		personajeAtacante=new Personaje();
		Assert.assertEquals(2,personajeAtacante.obtenerPuntosDeDefensa());
	}
	
	@Test
	public void debeDevolverLosPuntosDeMagia(){
		personajeAtacante=new Personaje();
		
		Assert.assertEquals(5,personajeAtacante.obtenerPuntosDeMagia());
	}
	
	@Test
	public void debeAumentarExperiencia(){
		personajeAtacante=new Personaje();
		Assert.assertEquals(0,personajeAtacante.getExperiencia());
		personajeAtacante.subirExperiencia(200);
		Assert.assertEquals(200,personajeAtacante.getExperiencia());
	}
	
	@Test
	public void SiPoseeLaExperienciaSuficienteElPersonajeDebeAumentarNivel(){
		personajeAtacante=new Personaje();
		personajeAtacante.subirExperiencia(20);
		personajeAtacante.subirNivel();
		Assert.assertEquals(1,personajeAtacante.getNivel());
		
	}
	
	@Test
	public void SiNoPoseeLaExperienciaSuficienteElPersonajeDebeAumentarNivel(){
		personajeAtacante=new Personaje();
		personajeAtacante.subirExperiencia(9);
		personajeAtacante.subirNivel();
		Assert.assertEquals(0,personajeAtacante.getNivel());
		
	}
	

	@Test
	public void debeElegirElPrimerPersonajeComoVictima(){
		Alianza alianzaEnemiga = crearAlianza(1);
        personajeAtacante = new Personaje();
        Personaje victima = personajeAtacante.elegirVictima(alianzaEnemiga, 0);
		Assert.assertEquals(0, alianzaEnemiga.getPersonajes().indexOf(victima));
	}


	@Test
	public void siElPersonajePoseeUnaAlianzaYLaAbandonaDejaraDeAparecerEsaAlianza(){
		personajeAtacante = new Personaje();
		Alianza alianzaNueva=new Alianza();
		alianzaNueva.agregarPersonaje(personajeAtacante);
		personajeAtacante.abandonarAlianza();
		Assert.assertEquals(-1,personajeAtacante.getAlianza());

	}

	
	
}
