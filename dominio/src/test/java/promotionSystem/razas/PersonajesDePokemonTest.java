package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class PersonajesDePokemonTest {
	
	@Test
	public void siAtacaAOtroPersonajeMantieneSuAtaque(){
		PersonajesDePokemon atacante=new PersonajesDePokemon();
		PersonajesDePokemon atacado=new PersonajesDePokemon();
		Assert.assertEquals(7, atacante.obtenerPuntosDeAtaque());
		atacante.atacar(atacado);
		Assert.assertEquals(7, atacante.obtenerPuntosDeAtaque());
	}

}
