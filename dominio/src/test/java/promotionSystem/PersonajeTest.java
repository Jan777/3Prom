package promotionSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import promotionSystem.mapa.Mapa;
import promotionSystem.mapa.Obstaculo;
import promotionSystem.razas.castas.humano.GuerreroHumano;
import promotionSystem.razas.castas.pokemon.PokemonTipoAgua;

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
		List<Personaje> personajes = new ArrayList<Personaje>();
		personajes.add(personaje);
		personaje.setAlianza(new Alianza(personajes));
		return personaje.getAlianza();
	}

	@Test
	public void siAtacaDisminuyeEnergiaPropiaYSaludDelRival(){
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(Constantes.SaludGuerreroHumano-Constantes.AtaqueGuerreroHumano+Constantes.DefensaGuerreroHumano,personajeAtacado.getSalud());
		Assert.assertEquals(100-Constantes.AtaqueGuerreroHumano,personajeAtacante.getEnergia());
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
		Assert.assertEquals(Constantes.SaludGuerreroHumano,personajeAtacado.getSalud());
	}

	@Test
	public void siTieneMenosEnergiaQueLaInicialYEsEnergizadoLaVuelveAlMaximo(){
		personajeAtacante.setEnergia(10);
		personajeAtacante.serEnergizado();
		Assert.assertEquals(100,personajeAtacante.getEnergia());
	}
	
	@Test
	public void siSeQuedoSinEnergiaNoPuedeAtacar(){
		personajeAtacante.setEnergia(0);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(Constantes.SaludGuerreroHumano,personajeAtacado.getSalud());
	}
	
	@Test
	public void siTieneVidaAlMaximoNoPuedeAumentarSuSaludAlSerCurado(){
		personajeAtacado=new GuerreroHumano();
		Assert.assertEquals(Constantes.SaludGuerreroHumano,personajeAtacado.getSalud());
		personajeAtacado.serCurado();
		Assert.assertEquals(Constantes.SaludGuerreroHumano,personajeAtacado.getSalud());
	}
	
	@Test
	public void siTieneEnergiaAlMaximoNoPuedeAumentarSuEnergiaAlSerEnergizado(){
		personajeAtacante=new GuerreroHumano();
		Assert.assertEquals(100,personajeAtacante.getEnergia());
		personajeAtacante.serEnergizado();
		Assert.assertEquals(100,personajeAtacante.getEnergia());
	}
	
	@Test
	public void siLaDefensaDelAtacadoEsMayorAlAtaqueDelAtacadoNoRecibeDano(){
		personajeAtacado.setDefensa(1500);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(Constantes.SaludGuerreroHumano,personajeAtacado.getSalud());
	}
	
	@Test
	public void siUnPersonajeAtacaYLeQuitaVidaAOtro(){
		personajeAtacado.setDefensa(145);
		personajeAtacante.atacar(personajeAtacado);
		Assert.assertEquals(Constantes.SaludGuerreroHumano,personajeAtacado.getSalud());
	}

	@Test
	public void siEstaMuertoNoDebeAtacar(){
		personajeAtacante.setSalud(0);
		if(personajeAtacante.estaVivo()){
			personajeAtacante.atacar(personajeAtacado);
		}
		Assert.assertEquals(Constantes.SaludGuerreroHumano, personajeAtacado.getSalud());
	}

	@Test
	public void debeDevolverLosPuntosDeAtaque(){
		Assert.assertEquals(Constantes.AtaqueGuerreroHumano,personajeAtacante.obtenerPuntosDeAtaque());
	}
	
	@Test
	public void debeDevolverLosPuntosDeDefensa(){
		Assert.assertEquals(Constantes.DefensaGuerreroHumano,personajeAtacante.obtenerPuntosDeDefensa());
	}
	
	@Test
	public void debeDevolverLosPuntosDeMagia(){
		Assert.assertEquals(Constantes.MagiaGuerreroHumano,personajeAtacante.obtenerPuntosDeMagia());
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
    public void debeGanarUnPuntoDeHabilidadCuandoSubaDeNivel(){
	    personajeAtacante.subirNivel();
        Assert.assertEquals(1, personajeAtacante.getPuntosDeHabilidad());
    }

	@Test
	public void debeSubirHabilidadYLosStatsCorrespondientes(){
		personajeAtacante.subirHabilidad("Ataque certero");
        Assert.assertTrue(personajeAtacante.habilidades().contains("Ataque certero"));
        Assert.assertEquals(22, personajeAtacante.getAtaque());
	}

	@Test
	public void siRecibeUnItemLoDebePonerEnElInventario() throws ClassNotFoundException {
		personajeAtacante.recibirItem(new Item("ConEspadaGorgoroth"));
		Assert.assertEquals(1, personajeAtacante.getItems().size());
	}

	@Test
	public void siTieneItemsPuedeDarlos() throws ClassNotFoundException {
		personajeAtacante.recibirItem(new Item("ConEspadaGorgoroth"));
		Assert.assertTrue(personajeAtacante.puedeDarItem());
	}

	@Test
	public void siNoTieneItemsNoPuedeDarlos(){
		Assert.assertTrue(!personajeAtacante.puedeDarItem());
	}

	@Test
    public void siEntregaUnItemDebeEliminarseDelInventario() throws ClassNotFoundException {
        personajeAtacante.recibirItem(new Item("ConEspadaGorgoroth"));
        personajeAtacante.entregarItem();
        Assert.assertEquals(0, personajeAtacante.getItems().size());
    }

	@Test
	public void debeElegirElPrimerPersonajeComoVictima(){
		Alianza alianzaEnemiga = crearAlianza(1);
        alianzaAtacante = crearAlianza(1);
        personajeAtacante.alianza = alianzaAtacante;
        personajeAtacante.elegirVictima(alianzaEnemiga, 0);
        Personaje victima = alianzaAtacante.getObjetivo();
		Assert.assertEquals(0, alianzaEnemiga.getPersonajes().indexOf(victima));
	}


	private Alianza crearAlianza(int cantidadPersonajes) {
		List<Personaje> personajes=new ArrayList<Personaje>();
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
		Assert.assertNotEquals(null, personajeAtacante.getAlianza());
		Assert.assertNotEquals(null, personajeAtacado.getAlianza());
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
	public void siSeInvocaALosAliadosDentroDelRadioYUnoEstaFueraDeEseRadioNoDebeSerLlamado(){
		Alianza alianza=crearAlianza(3);
		alianza.getPersonajes().get(0).setPosicion(new Punto(100,100));
		
		Alianza aliadosEnCombate= alianza.getPersonajes().get(1).invocarAliados();
		Assert.assertEquals(2, aliadosEnCombate.getPersonajes().size());
	}
	
	@Test
	public void siSeInvocaALosAliadosDentroDelRadioYNingunoEstaEnElRadioElUnicoEnLaListaSeraElInvocador(){
		Alianza alianza=crearAlianza(3);
		alianza.getPersonajes().get(0).setPosicion(new Punto(100,100));
		alianza.getPersonajes().get(2).setPosicion(new Punto(100,100));
		Alianza aliadosEnCombate= alianza.getPersonajes().get(1).invocarAliados();
		Assert.assertEquals(1, aliadosEnCombate.getPersonajes().size());
		
	}
	
	@Test
	public void siSeInvocaALosAliadosDentroDelRadioYHayMasAliadosDentroDelRadioQueElMaximoPermitidoSoloSeLlamaraAEseMaximoDePersonajes(){
		Alianza alianza=crearAlianza(10);
		Alianza aliadosEnCombate= alianza.getPersonajes().get(1).invocarAliados();
		Assert.assertEquals(5, aliadosEnCombate.getPersonajes().size());
		
	}
	
	@Test
	public void siChocaConObstaculoNoSeMueve(){
		Mapa mapa = new Mapa(100, 100);
		Obstaculo obstaculo = new Obstaculo(new Punto(1,1), 2, 3);
		mapa.agregarObstaculo(obstaculo);
		Personaje blastoise = new PokemonTipoAgua();
		blastoise.setMapa(mapa);
		blastoise.mover(new Punto(2,2));
		Assert.assertEquals(0, blastoise.getPosicion().getX(),0);
		Assert.assertEquals(0, blastoise.getPosicion().getY(),0);
	}
	
	@Test
	public void siNoChocaConObstaculoYSeMueve(){
		Mapa mapa = new Mapa(100, 100);
		Obstaculo obstaculo = new Obstaculo(new Punto(1,1), 2, 3);
		mapa.agregarObstaculo(obstaculo);
		Personaje blastoise = new PokemonTipoAgua();
		blastoise.setMapa(mapa);
		blastoise.mover(new Punto(0,1));
		Assert.assertEquals(0, blastoise.getPosicion().getX(),0);
		Assert.assertEquals(1, blastoise.getPosicion().getY(),0);
	}
}
