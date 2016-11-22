package promotionSystem.razas.castas.humano;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.Humano;

public class TanqueHumanoTest {
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Humano personaje=new TanqueHumano();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getEnergia());
		Assert.assertEquals(Constantes.SALUD_TANQUE_HUMANO +2*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL, personaje.getSalud());
		Assert.assertEquals(Constantes.ATAQUE_TANQUE_HUMANO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DEFENSA_TANQUE_HUMANO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MAGIA_TANQUE_HUMANO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VELOCIDAD_TANQUE_HUMANO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeVelocidad());
	}

}
