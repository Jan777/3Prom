package promotionSystem.personajeEquipado;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.Personaje;
import promotionSystem.razas.castas.humano.GuerreroHumano;

public class ConEscudoTests {

	@Test
	public void siConEscudoModificaElValorDeLaDefensa(){
		Personaje Braixen = new GuerreroHumano();
		Assert.assertEquals(Constantes.DefensaGuerreroHumano, Braixen.obtenerPuntosDeDefensa());
		Braixen = new ConEscudo(Braixen,1,0,1,2,1,0,1,0);
		Assert.assertEquals(Constantes.DefensaGuerreroHumano + 2, Braixen.obtenerPuntosDeDefensa());
	}
}
