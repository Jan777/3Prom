package promotionSystem.mapa;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Punto;

public class MapaTest {

		@Test
		public void siSePasaUnPuntoValidoEsCorrecto(){
			Mapa mapa = new Mapa(100,100);
			Assert.assertTrue(mapa.posicionValida(new Punto (0,0)));
		}
		
		@Test
		public void siSePasaUnPuntoQueSupereElLargoNoEsCorrecto(){
			Mapa mapa = new Mapa(100,100);
			Assert.assertFalse(mapa.posicionValida(new Punto (101,0)));
		}
		
		@Test
		public void siSePasaUnPuntoQueSupereElAnchoNoEsCorrecto(){
			Mapa mapa = new Mapa(100,100);
			Assert.assertFalse(mapa.posicionValida(new Punto (0,101)));
		}
		
		@Test
		public void siSePasaUnPuntoConNumerosNegativosNoEsCorrecto(){
			Mapa mapa = new Mapa(100,100);
			Assert.assertFalse(mapa.posicionValida(new Punto (-1,-5)));
		}
		
		
}
