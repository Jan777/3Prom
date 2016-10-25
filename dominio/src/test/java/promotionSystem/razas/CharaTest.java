package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class CharaTest {
	
		@Test
		public void siAumentaDeNivelAumentaLosStats(){
			Chara personaje=new Chara();
			Assert.assertEquals(0, personaje.getNivel());
			personaje.subirExperiencia(10);
			Assert.assertEquals(3, personaje.getNivel());

			Assert.assertEquals(100+10*3, personaje.getSalud());
			Assert.assertEquals(1000+10*3, personaje.getEnergia());
			Assert.assertEquals(150+10*3, personaje.obtenerPuntosDeAtaque());
			Assert.assertEquals(100+5*3, personaje.obtenerPuntosDeDefensa());
			Assert.assertEquals(50+5*3, personaje.obtenerPuntosDeMagia());
			Assert.assertEquals(100+10*3, personaje.obtenerPuntosDeVelocidad());
		}
		
		@Test
		public void siAtacaAumentaElAtaqueYEnergia(){
			PersonajeDeUndertale personajeAtacante=new Chara();
			PersonajeDeStarWars personajeAtacado=new Droide();
			
			Assert.assertEquals(150,personajeAtacante.obtenerPuntosDeAtaque());
			Assert.assertEquals(1000,personajeAtacante.getEnergia());
			personajeAtacante.atacar(personajeAtacado);
			Assert.assertEquals(150+1,personajeAtacante.obtenerPuntosDeAtaque());
			Assert.assertEquals(1000-150+1,personajeAtacante.getEnergia());
			
		}

}
