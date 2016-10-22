package promotionSystem;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.razas.PokemonTipoFuego;

import java.util.ArrayList;
import java.util.List;

public class PersonajeTest {
	Personaje personajeAtacante;
	Personaje personajeAtacado;
	Alianza alianzaAtacante;
	
	public void crearPersonajes(){
		 personajeAtacante=new PokemonTipoFuego();
		 personajeAtacado=new PokemonTipoFuego();
	}
	
	private Alianza crearAlianza(Personaje personaje) {
		List<Personaje> personajes = new ArrayList<Personaje>();
		personajes.add(personaje);
		personaje.setAlianza(new Alianza(personajes));
		return personaje.getAlianza();
	}
	@Test
	public void siAtacaDisminuyeEnergiaPropiaYSaludDelRival(){
		crearPersonajes();
		personajeAtacado.setDefensa(0);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(0,personajeAtacado.getSalud());
		Assert.assertEquals(1050,personajeAtacante.getEnergia());
	
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
		personajeAtacado=new PokemonTipoFuego();	
		personajeAtacado.setSalud(10);
		personajeAtacado.serCurado();
		Assert.assertEquals(100,personajeAtacado.getSalud());
	}
	


	@Test
	public void siTieneMenosEnergiaQueLaInicialYEsEnergizadoLaVuelveAlMaximo(){
		personajeAtacante=new PokemonTipoFuego();		
		personajeAtacante.setEnergia(10);
		personajeAtacante.serEnergizado();
		Assert.assertEquals(1200,personajeAtacante.getEnergia());
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
		personajeAtacado=new PokemonTipoFuego();
		Assert.assertEquals(100,personajeAtacado.getSalud());
		personajeAtacado.serCurado();
		Assert.assertEquals(100,personajeAtacado.getSalud());
	}
	
	@Test
	public void siTieneEnergiaAlMaximoNoPuedeAumentarSuEnergiaAlSerEnergizado(){
		personajeAtacante=new PokemonTipoFuego();
		Assert.assertEquals(1200,personajeAtacante.getEnergia());
		personajeAtacante.serEnergizado();
		Assert.assertEquals(1200,personajeAtacante.getEnergia());
	}
	
	@Test
	public void siLaDefensaDelAtacadoEsMayorAlAtaqueDelAtacadoNoRecibeDano(){
		crearPersonajes();
		personajeAtacado.setDefensa(1500);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(100,personajeAtacado.getSalud());
	}
	
	//FIXME corregir nombre del metodo 
	@Test
	public void siLaDefensaEsMenorQueElAtaqueLaSaludDisminuyePeroNoTanto(){
		crearPersonajes();
		personajeAtacado.setDefensa(145);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(95,personajeAtacado.getSalud());
	}
	
	@Test
	public void debeDevolverLosPuntosDeAtaque(){
		personajeAtacante=new PokemonTipoFuego();
		Assert.assertEquals(150,personajeAtacante.obtenerPuntosDeAtaque());
	}
	
	@Test
	public void debeDevolverLosPuntosDeDefensa(){
		personajeAtacante=new PokemonTipoFuego();
		Assert.assertEquals(80,personajeAtacante.obtenerPuntosDeDefensa());
	}
	
	@Test
	public void debeDevolverLosPuntosDeMagia(){
		personajeAtacante=new PokemonTipoFuego();
		
		Assert.assertEquals(20,personajeAtacante.obtenerPuntosDeMagia());
	}
	
	@Test
	public void debeAumentarExperiencia(){
		personajeAtacante=new PokemonTipoFuego();
		Assert.assertEquals(0,personajeAtacante.getExperiencia());
		personajeAtacante.subirExperiencia(1);
		Assert.assertEquals(1,personajeAtacante.getExperiencia());
	}

	@Test
	public void siPoseeLaExperienciaSuficienteElPersonajeDebeAumentarNivel(){
		personajeAtacante=new PokemonTipoFuego();
		personajeAtacante.subirExperiencia(20);
		Assert.assertEquals(4,personajeAtacante.getNivel());
	}
	
	@Test
	public void siNoPoseeLaExperienciaSuficienteElPersonajeNoDebeAumentarNivel(){
		personajeAtacante=new PokemonTipoFuego();
		personajeAtacante.subirExperiencia(1);
		Assert.assertEquals(1,personajeAtacante.getNivel());
	}
	
	@Test
	public void debeElegirElPrimerPersonajeComoVictima(){
		Alianza alianzaEnemiga = crearAlianza(1);
        personajeAtacante = new PokemonTipoFuego();
        Personaje victima = personajeAtacante.elegirVictima(alianzaEnemiga, 0);
		Assert.assertEquals(0, alianzaEnemiga.getPersonajes().indexOf(victima));
	}


	private Alianza crearAlianza(int cantidadPersonajes) {
		List<Personaje> personajes=new ArrayList<Personaje>();
		Alianza alianza = new Alianza(personajes);
		for(int i=0;i<cantidadPersonajes;i++){
			PokemonTipoFuego personaje = new PokemonTipoFuego();
			personaje.alianza=alianza;
			personajes.add(personaje);
		}
		return alianza;
	}

	@Test
	public void siElPersonajePoseeUnaAlianzaYLaAbandonaDejaraDeAparecerEsaAlianza(){
		personajeAtacante = new PokemonTipoFuego();
		Alianza alianzaNueva=crearAlianza(personajeAtacante);
		personajeAtacante.abandonarAlianza();
		Assert.assertEquals(null,personajeAtacante.getAlianza());
		Assert.assertEquals(0, alianzaNueva.getPersonajes().size());

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
	
	@Test
	public void siExisteUnaAlianzaDe3PersonajesYOtraDe2yEstasSeJuntanQuedaUnaDe5(){
		alianzaAtacante = crearAlianza(3);
		Alianza alianzaAtacada = crearAlianza(2);
		alianzaAtacante.getPersonajes().get(0).invitarAAlianza(alianzaAtacada.getPersonajes().get(0));
		Assert.assertEquals(5, alianzaAtacante.getPersonajes().size());				
	}
	
	@Test
	public void siLePasoUnaPosicionValidaElPersonajeSeMueveAEsaPosicion(){
		personajeAtacante=new PokemonTipoFuego();
		Punto posicionNueva=new Punto(3,2);
		
		personajeAtacante.mover(posicionNueva);
		
		Assert.assertEquals(3,personajeAtacante.getPosicion().getX(),0);
		Assert.assertEquals(2,personajeAtacante.getPosicion().getY(),0);
	}
	
	@Test
	public void siSeInvocaALosAliadosDentroDelRadioYUnoEstaFueraDeEseRadioNoDebeSerLlamado(){
		Alianza alianza=crearAlianza(3);
		alianza.getPersonajes().get(0).mover(new Punto(100,100));
		
		ArrayList<Personaje>aliadosEnCombate=(ArrayList<Personaje>) alianza.getPersonajes().get(1).invocarAliados();
		Assert.assertEquals(2, aliadosEnCombate.size());
		
	}
	
	@Test
	public void siSeInvocaALosAliadosDentroDelRadioYNingunoEstaEnElRadioElUnicoEnLaListaSeraElInvocador(){
		Alianza alianza=crearAlianza(3);
		alianza.getPersonajes().get(0).mover(new Punto(100,100));
		alianza.getPersonajes().get(2).mover(new Punto(100,100));
		ArrayList<Personaje>aliadosEnCombate=(ArrayList<Personaje>) alianza.getPersonajes().get(1).invocarAliados();
		Assert.assertEquals(1, aliadosEnCombate.size());
		
	}
	
	@Test
	public void siSeInvocaALosAliadosDentroDelRadioYHayMasAliadosDentroDelRadioQueElMaximoPermitidoSoloSeLlamaraAEseMaximoDePersonajes(){
		Alianza alianza=crearAlianza(10);
		ArrayList<Personaje>aliadosEnCombate=(ArrayList<Personaje>) alianza.getPersonajes().get(1).invocarAliados();
		Assert.assertEquals(5, aliadosEnCombate.size());
		
	}
	
	
	
	
}
