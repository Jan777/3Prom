package promotionSystem.razas;

import org.junit.Assert;
import org.junit.Test;

public class PersonajesDePokemonTest {
	
	@Test
	public void siAtacaAOtroPersonajeAumentaSuMagia(){
		PersonajeDePokemon atacante=new PokemonTipoAgua();
		PersonajeDePokemon atacado=new PokemonTipoFuego();
		Assert.assertEquals(150, atacante.obtenerPuntosDeMagia());
		atacante.atacar(atacado);
		Assert.assertEquals(160, atacante.obtenerPuntosDeMagia());
	}

}
