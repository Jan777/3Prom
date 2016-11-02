package promotionSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import promotionSystem.items.EspadaGorgoroth;
import promotionSystem.mapa.Mapa;
import promotionSystem.mapa.Obstaculo;
import promotionSystem.razas.castas.humano.GuerreroHumano;
import promotionSystem.razas.castas.pokemon.PokemonTipoAgua;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static promotionSystem.Constantes.*;
import static promotionSystem.builder.AlianzaBuilder.*;

public class PersonajeTest {
	private Personaje personajeAtacante;
    private Personaje personajeAtacado;
	private Alianza alianzaAtacante;

    @Before
	public void crearPersonajes(){
		 personajeAtacante=new GuerreroHumano();
		 personajeAtacado=new GuerreroHumano();
	}

	@Test
	public void siAtacaDisminuyeEnergiaPropiaYSaludDelRival(){
		personajeAtacante.atacar(personajeAtacado);
		assertEquals(Constantes.SaludGuerreroHumano- AtaqueGuerreroHumano+Constantes.DefensaGuerreroHumano,personajeAtacado.getSalud());
		assertEquals(100- AtaqueGuerreroHumano,personajeAtacante.getEnergia());
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
		assertEquals(Constantes.SaludGuerreroHumano,personajeAtacado.getSalud());
	}

	@Test
	public void siTieneMenosEnergiaQueLaInicialYEsEnergizadoLaVuelveAlMaximo(){
		personajeAtacante.setEnergia(10);
		personajeAtacante.serEnergizado();
		assertEquals(100,personajeAtacante.getEnergia());
	}
	
	@Test
	public void siSeQuedoSinEnergiaNoPuedeAtacar(){
		personajeAtacante.setEnergia(0);
		personajeAtacante.atacar(personajeAtacado);
		assertEquals(Constantes.SaludGuerreroHumano,personajeAtacado.getSalud());
	}
	
	@Test
	public void siTieneVidaAlMaximoNoPuedeAumentarSuSaludAlSerCurado(){
		personajeAtacado=new GuerreroHumano();
		assertEquals(Constantes.SaludGuerreroHumano,personajeAtacado.getSalud());
		personajeAtacado.serCurado();
		assertEquals(Constantes.SaludGuerreroHumano,personajeAtacado.getSalud());
	}
	
	@Test
	public void siTieneEnergiaAlMaximoNoPuedeAumentarSuEnergiaAlSerEnergizado(){
		personajeAtacante=new GuerreroHumano();
		assertEquals(100,personajeAtacante.getEnergia());
		personajeAtacante.serEnergizado();
		assertEquals(100,personajeAtacante.getEnergia());
	}
	
	@Test
	public void siLaDefensaDelAtacadoEsMayorAlAtaqueDelAtacadoNoRecibeDano(){
		personajeAtacado.setDefensa(1500);
		personajeAtacante.atacar(personajeAtacado);
		assertEquals(Constantes.SaludGuerreroHumano,personajeAtacado.getSalud());
	}
	
	@Test
	public void siUnPersonajeAtacaYLeQuitaVidaAOtro(){
		personajeAtacado.setDefensa(145);
		personajeAtacante.atacar(personajeAtacado);
		assertEquals(Constantes.SaludGuerreroHumano,personajeAtacado.getSalud());
	}

	@Test
	public void siEstaMuertoNoDebeAtacar(){
		personajeAtacante.setSalud(0);
		if(personajeAtacante.estaVivo()){
			personajeAtacante.atacar(personajeAtacado);
		}
		assertEquals(Constantes.SaludGuerreroHumano, personajeAtacado.getSalud());
	}

	@Test
	public void debeDevolverLosPuntosDeAtaque(){
		assertEquals(AtaqueGuerreroHumano,personajeAtacante.obtenerPuntosDeAtaque());
	}
	
	@Test
	public void debeDevolverLosPuntosDeDefensa(){
		assertEquals(Constantes.DefensaGuerreroHumano,personajeAtacante.obtenerPuntosDeDefensa());
	}
	
	@Test
	public void debeDevolverLosPuntosDeMagia(){
		assertEquals(MagiaGuerreroHumano,personajeAtacante.obtenerPuntosDeMagia());
	}
	
	@Test
	public void debeAumentarExperiencia(){
		assertEquals(0,personajeAtacante.getExperiencia());
		personajeAtacante.subirExperiencia(1);
		assertEquals(1,personajeAtacante.getExperiencia());
	}

	@Test
	public void siPoseeLaExperienciaSuficienteElPersonajeDebeAumentarNivel(){
		personajeAtacante.subirExperiencia(20);
		assertEquals(4,personajeAtacante.getNivel());
	}
	
	@Test
	public void siNoPoseeLaExperienciaSuficienteElPersonajeNoDebeAumentarNivel(){
		personajeAtacante.subirExperiencia(1);
		assertEquals(1,personajeAtacante.getNivel());
	}

	@Test
    public void debeGanarUnPuntoDeHabilidadCuandoSubaDeNivel(){
	    personajeAtacante.subirNivel();
        assertEquals(1, personajeAtacante.getPuntosDeHabilidad());
    }

	@Test
	public void debeSubirHabilidadYLosStatsCorrespondientes(){
		personajeAtacante.subirHabilidad("Ataque certero");
        Assert.assertTrue(personajeAtacante.habilidades().contains("Ataque certero"));
        assertEquals(22, personajeAtacante.getAtaque());
	}

	@Test
	public void siRecibeUnItemLoDebePonerEnElInventario() throws ClassNotFoundException {
		personajeAtacante.recibirItem(new EspadaGorgoroth());
		assertEquals(1, personajeAtacante.getItems().size());
	}

	@Test
	public void siTieneItemsPuedeDarlos() throws ClassNotFoundException {
		personajeAtacante.recibirItem(new EspadaGorgoroth());
		Assert.assertTrue(personajeAtacante.puedeDarItem());
	}

	@Test
	public void siNoTieneItemsNoPuedeDarlos(){
		Assert.assertTrue(!personajeAtacante.puedeDarItem());
	}

	@Test
    public void siEntregaUnItemDebeEliminarseDelInventario() throws ClassNotFoundException {
        personajeAtacante.recibirItem(new EspadaGorgoroth());
        personajeAtacante.entregarItem();
        assertEquals(0, personajeAtacante.getItems().size());
    }

    @Test
	public void debeDesequiparItem() throws Exception {
		personajeAtacante.recibirItem(new EspadaGorgoroth());
		personajeAtacante.equiparItem(new EspadaGorgoroth());
		personajeAtacante.desequiparItem(personajeAtacante.getArma());
		assertEquals(null, personajeAtacante.getArma());
		assertEquals(AtaqueGuerreroHumano, personajeAtacante.getAtaque());
		assertEquals(MagiaGuerreroHumano, personajeAtacante.getMagia());
		assertEquals(VelocidadGuerreroHumano, personajeAtacante.getVelocidad());
	}

	@Test
	public void debeElegirElPrimerPersonajeComoVictima(){
		Alianza alianzaEnemiga = crearAlianzaDeHumanos(1);
        alianzaAtacante = crearAlianzaDeHumanosConEnemigos(1, alianzaEnemiga);
        Personaje victima = alianzaAtacante.getObjetivo();
		assertEquals(0, alianzaEnemiga.getPersonajes().indexOf(victima));
	}

	private Alianza crearAlianza(int cantidadPersonajes) {
		List<Personaje> listaDePersonajes = new ArrayList<>();
		for(int i=0;i<cantidadPersonajes;i++){
			GuerreroHumano personaje = new GuerreroHumano();
			listaDePersonajes.add(personaje);
		}
		return new Alianza(listaDePersonajes);
	}

	@Test
	public void siElPersonajePoseeUnaAlianzaYLaAbandonaDejaraDeAparecerEsaAlianza(){
		Alianza alianzaNueva= crearAlianzaCon(personajeAtacante);
		personajeAtacante.abandonarAlianza();
		assertEquals(null,personajeAtacante.getAlianza());
		assertEquals(0, alianzaNueva.getPersonajes().size());
	}

	
	@Test
	public void siElPersonajeNoTieneAlianzasYAceptaUnaNuevaAlianzaPasaATenerla(){
	    alianzaAtacante = crearAlianzaCon(personajeAtacante);
		personajeAtacado.aceptarAlianza(personajeAtacante);
		assertEquals(personajeAtacante.getAlianza(), personajeAtacado.getAlianza());
		assertEquals(2, alianzaAtacante.getPersonajes().size());
	}
	
	@Test
	public void siElPersonajeTieneAlianzasYAceptaUnaNuevaAlianzaAmbasAlianzasSeUnen(){
		alianzaAtacante =crearAlianzaCon(personajeAtacante);
		Alianza alianzaAtacado=crearAlianzaCon(personajeAtacado);
		personajeAtacado.aceptarAlianza(personajeAtacante);
		assertEquals(personajeAtacante.getAlianza(), personajeAtacado.getAlianza());
		assertEquals(2, alianzaAtacante.getPersonajes().size());
	}

	@Test
	public void siNingunoDeLosDosPersonajesTieneAlianzaSeCreaUnaNueva(){
		personajeAtacante.invitarAAlianza(personajeAtacado);
		Assert.assertNotEquals(null, personajeAtacante.getAlianza());
		Assert.assertNotEquals(null, personajeAtacado.getAlianza());
		assertEquals(personajeAtacante.getAlianza(), personajeAtacado.getAlianza());
	}
	
	@Test
	public void siExisteUnaAlianzaDe3PersonajesYOtraDe2yEstasSeJuntanQuedaUnaDe5(){
		alianzaAtacante = crearAlianza(3);
		Alianza alianzaAtacada = crearAlianza(2);
		alianzaAtacante.getPersonajes().get(0).invitarAAlianza(alianzaAtacada.getPersonajes().get(0));
		assertEquals(5, alianzaAtacante.getPersonajes().size());
	}
	
	@Test
	public void siSeInvocaALosAliadosDentroDelRadioYUnoEstaFueraDeEseRadioNoDebeSerLlamado(){
		Alianza alianza=crearAlianza(3);
		alianza.getPersonajes().get(0).setPosicion(new Punto(100,100));
		
		Alianza aliadosEnCombate= alianza.getPersonajes().get(1).invocarAliados();
		assertEquals(2, aliadosEnCombate.getPersonajes().size());
	}
	
	@Test
	public void siSeInvocaALosAliadosDentroDelRadioYNingunoEstaEnElRadioElUnicoEnLaListaSeraElInvocador(){
		Alianza alianza=crearAlianza(3);
		alianza.getPersonajes().get(0).setPosicion(new Punto(100,100));
		alianza.getPersonajes().get(2).setPosicion(new Punto(100,100));
		Alianza aliadosEnCombate= alianza.getPersonajes().get(1).invocarAliados();
		assertEquals(1, aliadosEnCombate.getPersonajes().size());
		
	}
	
	@Test
	public void siSeInvocaALosAliadosDentroDelRadioYHayMasAliadosDentroDelRadioQueElMaximoPermitidoSoloSeLlamaraAEseMaximoDePersonajes(){
		Alianza alianza=crearAlianza(10);
		Alianza aliadosEnCombate= alianza.getPersonajes().get(1).invocarAliados();
		assertEquals(5, aliadosEnCombate.getPersonajes().size());
	}
	
	@Test
	public void siChocaConObstaculoNoSeMueve(){
		Mapa mapa = new Mapa(100, 100);
		Obstaculo obstaculo = new Obstaculo(new Punto(1,1), 2, 3);
		mapa.agregarObstaculo(obstaculo);
		Personaje blastoise = new PokemonTipoAgua();
		blastoise.setMapa(mapa);
		blastoise.mover(new Punto(2,2));
		assertEquals(0, blastoise.getPosicion().getX(),0);
		assertEquals(0, blastoise.getPosicion().getY(),0);
	}
	
	@Test
	public void siNoChocaConObstaculoYSeMueve(){
		Mapa mapa = new Mapa(100, 100);
		Obstaculo obstaculo = new Obstaculo(new Punto(1,1), 2, 3);
		mapa.agregarObstaculo(obstaculo);
		Personaje blastoise = new PokemonTipoAgua();
		blastoise.setMapa(mapa);
		blastoise.mover(new Punto(0,1));
		assertEquals(0, blastoise.getPosicion().getX(),0);
		assertEquals(1, blastoise.getPosicion().getY(),0);
	}
	
	@Test
	public void siEquipoUnItemSuboDeNivelYDesequipoItemMisStatsSubenSegunElNivelSubido() throws Exception{
		personajeAtacante.recibirItem(new EspadaGorgoroth());
		personajeAtacante.equiparItem(new EspadaGorgoroth());
		personajeAtacante.subirExperiencia(5);
		assertEquals(2,personajeAtacante.getNivel());
		personajeAtacante.desequiparItem(personajeAtacante.getArma());
		
		assertEquals(AtaqueGuerreroHumano+Constantes.MultiplicadorDeNivelEspecial,personajeAtacante.getAtaque());
		Assert.assertEquals(Constantes.MagiaGuerreroHumano+Constantes.MultiplicadorDeNivelNormal, personajeAtacante.getMagia());
		Assert.assertEquals(Constantes.VelocidadGuerreroHumano+Constantes.MultiplicadorDeNivelNormal, personajeAtacante.getVelocidad());
	}
}
