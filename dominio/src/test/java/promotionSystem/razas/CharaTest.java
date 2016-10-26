package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Constantes;

public class CharaTest {
	
		@Test
		public void siAumentaDeNivelAumentaLosStats(){
			Chara personaje=new Chara();
			Assert.assertEquals(1, personaje.getNivel());
			personaje.subirExperiencia(10);
			Assert.assertEquals(3, personaje.getNivel());

			Assert.assertEquals(Constantes.SaludChara+Constantes.MultiplicadorDeNivelNormal*2, personaje.getSalud());
			Assert.assertEquals(100+Constantes.MultiplicadorDeNivelNormal*2, personaje.getEnergia());
			Assert.assertEquals(Constantes.AtaqueChara+Constantes.MultiplicadorDeNivelEspecial*2, personaje.obtenerPuntosDeAtaque());
			Assert.assertEquals(Constantes.DefensaChara+Constantes.MultiplicadorDeNivelNormal*2, personaje.obtenerPuntosDeDefensa());
			Assert.assertEquals(Constantes.MagiaChara+Constantes.MultiplicadorDeNivelNormal*2, personaje.obtenerPuntosDeMagia());
			Assert.assertEquals(Constantes.VelocidadChara+Constantes.MultiplicadorDeNivelNormal*2, personaje.obtenerPuntosDeVelocidad());
		}
		
		@Test
		public void siAtacaAumentaElAtaqueYEnergia(){
			PersonajeDeUndertale personajeAtacante=new Chara();
			PersonajeDeStarWars personajeAtacado=new Droide();
			
			Assert.assertEquals(Constantes.AtaqueChara,personajeAtacante.obtenerPuntosDeAtaque());
			Assert.assertEquals(100,personajeAtacante.getEnergia());
			personajeAtacante.atacar(personajeAtacado);
			Assert.assertEquals(Constantes.AtaqueChara+1,personajeAtacante.obtenerPuntosDeAtaque());
			Assert.assertEquals(100-Constantes.AtaqueChara+1,personajeAtacante.getEnergia());
			
		}

}
