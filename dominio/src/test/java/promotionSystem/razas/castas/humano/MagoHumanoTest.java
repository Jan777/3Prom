package promotionSystem.razas.castas.humano;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.Humano;

public class MagoHumanoTest {

	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Humano personaje=new MagoHumano();
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getEnergia());
		Assert.assertEquals(Constantes.SALUD_MAGO_HUMANO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getSalud());
		Assert.assertEquals(Constantes.ATAQUE_MAGO_HUMANO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DEFENSA_MAGO_HUMANO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MAGIA_MAGO_HUMANO +2*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VELOCIDAD_MAGO_HUMANO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeVelocidad());
	}
	
}
