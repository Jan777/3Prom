package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Constantes;

public class GuerreroOrcoTest {
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Orco personaje=new GuerreroOrco();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MultiplicadorDeNivelNormal, personaje.getEnergia());
		Assert.assertEquals(Constantes.SaludGuerreroOrco+2*Constantes.MultiplicadorDeNivelNormal, personaje.getSalud());
		Assert.assertEquals(Constantes.AtaqueGuerreroOrco+2*Constantes.MultiplicadorDeNivelEspecial, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DefensaGuerreroOrco+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MagiaGuerreroOrco+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VelocidadGuerreroOrco+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeVelocidad());
	}

}
