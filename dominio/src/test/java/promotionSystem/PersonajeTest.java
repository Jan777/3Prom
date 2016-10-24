package promotionSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import promotionSystem.razas.GuerreroHumano;


import java.util.ArrayList;
import java.util.List;

public class PersonajeTest {
	private Personaje personajeAtacante;
    private Personaje personajeAtacado;
	private Alianza alianzaAtacante;

    @Before
	public void crearPersonajes(){
		 personajeAtacante=new GuerreroHumano();
		 personajeAtacado=new GuerreroHumano();
	}
	
	private Alianza crearAlianza(Personaje personaje) {
		List<Personaje> personajes = new ArrayList<>();
		personajes.add(personaje);
		personaje.setAlianza(new Alianza(personajes));
		return personaje.getAlianza();
	}

	@Test
	public void siAtacaDisminuyeEnergiaPropiaYSaludDelRival(){
		personajeAtacado.setDefensa(0);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(0,personajeAtacado.getSalud());
		Assert.assertEquals(1050,personajeAtacante.getEnergia());
	}
	
	@Test
	public void siAtacaUnaVezElPersonajeAtacadoTodaviaSigueVivo(){
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertTrue(personajeAtacado.estaVivo());
	}
	
	@Test
	public void siElAtacadoTieneMenosVidaQueElAtaqueDelPersonajeAtacanteElPersonajeAtacadoMuere(){
		Assert.assertTrue(personajeAtacado.estaVivo());
		personajeAtacado.setDefensa(0);
		personajeAtacado.setSalud(9);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertFalse(personajeAtacado.estaVivo());
	}
	
	@Test
	public void siElAtacadoTieneIgualVidaQueElAtaqueDelPersonajeAtacanteElPersonajeAtacadoMuere(){
		Assert.assertTrue(personajeAtacado.estaVivo());
		personajeAtacado.setDefensa(0);
		personajeAtacado.setSalud(10);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertFalse(personajeAtacado.estaVivo());
	}
	
	@Test
	public void siTieneMenosSaludQueLaInicialYEsCuradoLaSaludVuelveAlMaximo(){
		personajeAtacado.setSalud(10);
		personajeAtacado.serCurado();
		Assert.assertEquals(100,personajeAtacado.getSalud());
	}

	@Test
	public void siTieneMenosEnergiaQueLaInicialYEsEnergizadoLaVuelveAlMaximo(){
		personajeAtacante.setEnergia(10);
		personajeAtacante.serEnergizado();
		Assert.assertEquals(1200,personajeAtacante.getEnergia());
	}
	
	@Test
	public void siSeQuedoSinEnergiaNoPuedeAtacar(){
		personajeAtacante.setEnergia(0);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(100,personajeAtacado.getSalud());
	}
	
	@Test
	public void siTieneVidaAlMaximoNoPuedeAumentarSuSaludAlSerCurado(){
		personajeAtacado=new GuerreroHumano();
		Assert.assertEquals(100,personajeAtacado.getSalud());
		personajeAtacado.serCurado();
		Assert.assertEquals(100,personajeAtacado.getSalud());
	}
	
	@Test
	public void siTieneEnergiaAlMaximoNoPuedeAumentarSuEnergiaAlSerEnergizado(){
		personajeAtacante=new GuerreroHumano();
		Assert.assertEquals(1200,personajeAtacante.getEnergia());
		personajeAtacante.serEnergizado();
		Assert.assertEquals(1200,personajeAtacante.getEnergia());
	}
	
	@Test
	public void siLaDefensaDelAtacadoEsMayorAlAtaqueDelAtacadoNoRecibeDano(){
		personajeAtacado.setDefensa(1500);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(100,personajeAtacado.getSalud());
	}
	
	@Test
	public void siUnPersonajeAtacaYLeQuitaVidaAOtro(){
		personajeAtacado.setDefensa(145);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(95,personajeAtacado.getSalud());
	}

	@Test
	public void siEstaMuertoNoDebeAtacar(){
		personajeAtacante.setSalud(0);
		if(personajeAtacante.estaVivo()){
			personajeAtacante.atacar(personajeAtacado);
		}
		Assert.assertEquals(100, personajeAtacado.getSalud());
	}

	@Test
	public void debeDevolverLosPuntosDeAtaque(){
		Assert.assertEquals(150,personajeAtacante.obtenerPuntosDeAtaque());
	}
	
	@Test
	public void debeDevolverLosPuntosDeDefensa(){
		Assert.assertEquals(80,personajeAtacante.obtenerPuntosDeDefensa());
	}
	
	@Test
	public void debeDevolverLosPuntosDeMagia(){
		Assert.assertEquals(20,personajeAtacante.obtenerPuntosDeMagia());
	}
	
	@Test
	public void debeAumentarExperiencia(){
		Assert.assertEquals(0,personajeAtacante.getExperiencia());
		personajeAtacante.subirExperiencia(1);
		Assert.assertEquals(1,personajeAtacante.getExperiencia());
	}

	@Test
	public void siPoseeLaExperienciaSuficienteElPersonajeDebeAumentarNivel(){
		personajeAtacante.subirExperiencia(20);
		Assert.assertEquals(4,personajeAtacante.getNivel());
	}
	
	@Test
	public void siNoPoseeLaExperienciaSuficienteElPersonajeNoDebeAumentarNivel(){
		personajeAtacante.subirExperiencia(1);
		Assert.assertEquals(1,personajeAtacante.getNivel());
	}
	
	@Test
	public void debeElegirElPrimerPersonajeComoVictima(){
		Alianza alianzaEnemiga = crearAlianza(1);
        Personaje victima = personajeAtacante.elegirVictima(alianzaEnemiga, 0);
		Assert.assertEquals(0, alianzaEnemiga.getPersonajes().indexOf(victima));
	}


	private Alianza crearAlianza(int cantidadPersonajes) {
		List<Personaje> personajes=new ArrayList<>();
		Alianza alianza = new Alianza(personajes);
		for(int i=0;i<cantidadPersonajes;i++){
			GuerreroHumano personaje = new GuerreroHumano();
			personaje.alianza=alianza;
			personajes.add(personaje);
		}
		return alianza;
	}

	@Test
	public void siElPersonajePoseeUnaAlianzaYLaAbandonaDejaraDeAparecerEsaAlianza(){
		Alianza alianzaNueva=crearAlianza(personajeAtacante);
		personajeAtacante.abandonarAlianza();
		Assert.assertEquals(null,personajeAtacante.getAlianza());
		Assert.assertEquals(0, alianzaNueva.getPersonajes().size());

	}

	
	@Test
	public void siElPersonajeNoTieneAlianzasYAceptaUnaNuevaAlianzaPasaATenerla(){
	    alianzaAtacante = crearAlianza(personajeAtacante);
		personajeAtacado.aceptarAlianza(personajeAtacante);
		Assert.assertEquals(personajeAtacante.getAlianza(), personajeAtacado.getAlianza());
		Assert.assertEquals(2, alianzaAtacante.getPersonajes().size());

	}
	
	@Test
	public void siElPersonajeTieneAlianzasYAceptaUnaNuevaAlianzaAmbasAlianzasSeUnen(){
		alianzaAtacante =crearAlianza(personajeAtacante);
		Alianza alianzaAtacado=crearAlianza(personajeAtacado);
		personajeAtacado.aceptarAlianza(personajeAtacante);
		Assert.assertEquals(personajeAtacante.getAlianza(), personajeAtacado.getAlianza());
		Assert.assertEquals(2, alianzaAtacante.getPersonajes().size());
	}

	@Test
	public void siNingunoDeLosDosPersonajesTieneAlianzaSeCreaUnaNueva(){
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
