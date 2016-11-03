package promotionSystem.razas.castas.orco;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.Orco;

import static promotionSystem.Constantes.INICIO_MAPA;

public class GuerreroOrcoTest {
	@Test
	public void siAumentaDeNivelAumentaLosStats(){
		Orco personaje=new GuerreroOrco(INICIO_MAPA);
		Assert.assertEquals(1, personaje.getNivel());
		personaje.subirExperiencia(10);

		Assert.assertEquals(3, personaje.getNivel());

		Assert.assertEquals(100+2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getEnergia());
		Assert.assertEquals(Constantes.SALUD_GUERRERO_ORCO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.getSalud());
		Assert.assertEquals(Constantes.ATAQUE_GUERRERO_ORCO +2*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL, personaje.obtenerPuntosDeAtaque());
		Assert.assertEquals(Constantes.DEFENSA_GUERRERO_ORCO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeDefensa());
		Assert.assertEquals(Constantes.MAGIA_GUERRERO_ORCO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeMagia());
		Assert.assertEquals(Constantes.VELOCIDAD_GUERRERO_ORCO +2*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL, personaje.obtenerPuntosDeVelocidad());
	}

}
