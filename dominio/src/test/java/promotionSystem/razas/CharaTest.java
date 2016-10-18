package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class CharaTest {
	
		@Test
		public void siAumentaDeNivelAumentaLosStats(){
			Chara personaje=new Chara();
			Assert.assertEquals(0, personaje.getNivel());
			personaje.subirExperiencia(10);
			personaje.subirNivel();
			Assert.assertEquals(1, personaje.getNivel());
			
			Assert.assertEquals(160, personaje.obtenerPuntosDeAtaque());	
			Assert.assertEquals(105, personaje.obtenerPuntosDeDefensa());
			Assert.assertEquals(55, personaje.obtenerPuntosDeMagia());
			Assert.assertEquals(110, personaje.obtenerPuntosDeVelocidad());
			Assert.assertEquals(110, personaje.getSalud());
			Assert.assertEquals(1010, personaje.getEnergia());
		}

}
