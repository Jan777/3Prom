package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Constantes;
import promotionSystem.razas.castas.humano.GuerreroHumano;

public class GuerreroHumanoTest {
	
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Humano personaje=new GuerreroHumano();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MultiplicadorDeNivelNormal, personaje.getEnergia());
		Assert.assertEquals(Constantes.SaludGuerreroHumano+2*Constantes.MultiplicadorDeNivelNormal, personaje.getSalud());
		Assert.assertEquals(Constantes.AtaqueGuerreroHumano+2*Constantes.MultiplicadorDeNivelEspecial, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DefensaGuerreroHumano+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MagiaGuerreroHumano+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VelocidadGuerreroHumano+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeVelocidad());
	}

}
