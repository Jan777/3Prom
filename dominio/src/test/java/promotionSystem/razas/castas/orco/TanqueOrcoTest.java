package promotionSystem.razas.castas.orco;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.Orco;

public class TanqueOrcoTest {

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Orco personaje=new TanqueOrco();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(Constantes.ENERGIA_MAXIMA_TANQUE_ORCO+2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getEnergia());
		Assert.assertEquals(Constantes.SALUD_TANQUE_ORCO +2*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL, personaje.getSalud());
		Assert.assertEquals(Constantes.ATAQUE_TANQUE_ORCO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DEFENSA_TANQUE_ORCO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MAGIA_TANQUE_ORCO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VELOCIDAD_TANQUE_ORCO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeVelocidad());
	}
	
	
}
