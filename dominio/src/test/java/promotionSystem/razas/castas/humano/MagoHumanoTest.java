package promotionSystem.razas.castas.humano;

import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Constantes;
import promotionSystem.razas.Humano;
import promotionSystem.razas.castas.humano.MagoHumano;

public class MagoHumanoTest {

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Humano personaje=new MagoHumano();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MultiplicadorDeNivelNormal, personaje.getEnergia());
		Assert.assertEquals(Constantes.SaludMagoHumano+2*Constantes.MultiplicadorDeNivelNormal, personaje.getSalud());
		Assert.assertEquals(Constantes.AtaqueMagoHumano+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DefensaMagoHumano+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MagiaMagoHumano+2*Constantes.MultiplicadorDeNivelEspecial, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VelocidadMagoHumano+2*Constantes.MultiplicadorDeNivelNormal, personaje.obtenerPuntosDeVelocidad());
	}
	
}
