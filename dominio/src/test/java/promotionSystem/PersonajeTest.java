package promotionSystem;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.razas.Humano;

import static promotionSystem.builder.AlianzaBuilder.crearAlianza;

import java.util.ArrayList;
import java.util.List;

public class PersonajeTest {
	Personaje personajeAtacante;
	Personaje personajeAtacado;
	Alianza alianzaAtacante;
	public void crearPersonajes(){
		 personajeAtacante=new Humano();
		 personajeAtacado=new Humano();
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
		personajeAtacado=new Humano();	
		personajeAtacado.setSalud(10);
		personajeAtacado.serCurado();
		Assert.assertEquals(100,personajeAtacado.getSalud());
	}
	


	@Test
	public void siTieneMenosEnergiaQueLaInicialYEsEnergizadoLaVuelveAlMaximo(){
		personajeAtacante=new Humano();		
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
		personajeAtacado=new Humano();
		Assert.assertEquals(100,personajeAtacado.getSalud());
		personajeAtacado.serCurado();
		Assert.assertEquals(100,personajeAtacado.getSalud());
	}
	
	@Test
	public void siTieneEnergiaAlMaximoNoPuedeAumentarSuEnergiaAlSerEnergizado(){
		personajeAtacante=new Humano();
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
		personajeAtacante=new Humano();
		Assert.assertEquals(10,personajeAtacante.obtenerPuntosDeAtaque());
	}
	
	@Test
	public void debeDevolverLosPuntosDeDefensa(){
		personajeAtacante=new Humano();
		Assert.assertEquals(2,personajeAtacante.obtenerPuntosDeDefensa());
	}
	
	@Test
	public void debeDevolverLosPuntosDeMagia(){
		personajeAtacante=new Humano();
		
		Assert.assertEquals(5,personajeAtacante.obtenerPuntosDeMagia());
	}
	
	@Test
	public void debeAumentarExperiencia(){
		personajeAtacante=new Humano();
		Assert.assertEquals(0,personajeAtacante.getExperiencia());
		personajeAtacante.subirExperiencia(200);
		Assert.assertEquals(200,personajeAtacante.getExperiencia());
	}
	
	@Test
	public void SiPoseeLaExperienciaSuficienteElPersonajeDebeAumentarNivel(){
		personajeAtacante=new Humano();
		personajeAtacante.subirExperiencia(20);
		personajeAtacante.subirNivel();
		Assert.assertEquals(1,personajeAtacante.getNivel());
		
	}
	
	@Test
	public void SiNoPoseeLaExperienciaSuficienteElPersonajeDebeAumentarNivel(){
		personajeAtacante=new Humano();
		personajeAtacante.subirExperiencia(9);
		personajeAtacante.subirNivel();
		Assert.assertEquals(0,personajeAtacante.getNivel());
		
	}
	

	@Test
	public void debeElegirElPrimerPersonajeComoVictima(){
		Alianza alianzaEnemiga = crearAlianza(1);
        personajeAtacante = new Humano();
        Personaje victima = personajeAtacante.elegirVictima(alianzaEnemiga, 0);
		Assert.assertEquals(0, alianzaEnemiga.getPersonajes().indexOf(victima));
	}


	private Alianza crearAlianza(int cantidadPersonajes) {
		List<Personaje> personajes=new ArrayList<>();
		for(int i=0;i<cantidadPersonajes;i++){
			personajes.add(new Humano());
		}
		return new Alianza(personajes);
	}

	@Test
	public void siElPersonajePoseeUnaAlianzaYLaAbandonaDejaraDeAparecerEsaAlianza(){
		personajeAtacante = new Humano();
		Alianza alianzaNueva=crearAlianza(personajeAtacante);
		personajeAtacante.abandonarAlianza();
		Assert.assertEquals(-1,personajeAtacante.getAlianza());
		Assert.assertEquals(0, alianzaNueva.getPersonajes().size());

	}

	private Alianza crearAlianza(Personaje personaje) {
		List<Personaje> personajes=new ArrayList<>();
		personajes.add(personaje);
		return new Alianza(personajes);
	}
	
	@Test
	public void siElPersonajeNoTieneAlianzasYAceptaUnaNuevaAlianzaPasaATenerla(){
		crearPersonajes();
	    alianzaAtacante = crearAlianza(personajeAtacante);
		personajeAtacado.aceptarAlianza(personajeAtacante);
		Assert.assertEquals(personajeAtacante.getAlianza(), personajeAtacado.getAlianza());
		Assert.assertEquals(2, alianzaAtacante.getPersonajes().size());

	}
	
	@Test
	public void siElPersonajeTieneAlianzasYAceptaUnaNuevaAlianzaAmbasAlianzasSeUnen(){
		crearPersonajes();
		alianzaAtacante =crearAlianza(personajeAtacante);
		Alianza alianzaAtacado=crearAlianza(personajeAtacado);
		personajeAtacado.aceptarAlianza(personajeAtacante);
		Assert.assertEquals(personajeAtacante.getAlianza(), personajeAtacado.getAlianza());
		Assert.assertEquals(2, alianzaAtacante.getPersonajes().size());
	}

	@Test
	public void siNingunoDeLosDosPersonajesTieneAlianzaSeCreaUnaNueva(){
		crearPersonajes();
		personajeAtacante.invitarAAlianza(personajeAtacado);
		Assert.assertNotEquals(-1, personajeAtacante.getAlianza());
		Assert.assertNotEquals(-1, personajeAtacado.getAlianza());
		Assert.assertEquals(personajeAtacante.getAlianza(), personajeAtacado.getAlianza());
	}
	
	
	
}
