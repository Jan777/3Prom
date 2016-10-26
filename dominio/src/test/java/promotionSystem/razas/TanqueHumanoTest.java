package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Constantes;

public class TanqueHumanoTest {
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Humano personaje=new TanqueHumano();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MultiplicadorDeNivelNormal, personaje.getEnergia());
		Assert.assertEquals(Constantes.SaludTanqueHumano+2*Constantes.MultiplicadorDeNivelEspecial, personaje.getSalud());
		Assert.assertEquals(Constantes.AtaqueTanqueHumano+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DefensaTanqueHumano+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MagiaTanqueHumano+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VelocidadTanqueHumano+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeVelocidad());
	}

}
