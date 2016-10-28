package promotionSystem.razas.castas.orco;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Constantes;
import promotionSystem.razas.Orco;
import promotionSystem.razas.castas.orco.TanqueOrco;

public class TanqueOrcoTest {

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Orco personaje=new TanqueOrco();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MultiplicadorDeNivelNormal, personaje.getEnergia());
		Assert.assertEquals(Constantes.SaludTanqueOrco+2*Constantes.MultiplicadorDeNivelEspecial, personaje.getSalud());
		Assert.assertEquals(Constantes.AtaqueTanqueOrco+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DefensaTanqueOrco+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MagiaTanqueOrco+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VelocidadTanqueOrco+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeVelocidad());
	}
	
	
}
