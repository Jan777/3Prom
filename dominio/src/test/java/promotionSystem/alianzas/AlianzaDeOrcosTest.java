package promotionSystem.alianzas;

import static org.junit.Assert.assertEquals;
import static promotionSystem.builder.AlianzaBuilder.crearAlianzaDeHumanos;

import org.junit.Test;

import promotionSystem.Alianza;
import promotionSystem.Constantes;
import promotionSystem.builder.AlianzaBuilder;

public class AlianzaDeOrcosTest {
	
	 @Test
	    public void siHay3OrcosEnLaAlianzaDebenAtacarAUnEnemigoDeLaOtraAlianza(){
	        AlianzaDeOrcos alianzaDeOrcos = AlianzaBuilder.crearAlianzaDeOrcos(3);
	        Alianza alianzaEnemiga = AlianzaBuilder.crearAlianza(3);
	        alianzaDeOrcos.atacar(alianzaEnemiga);
	        assertEquals(0, alianzaEnemiga.getPersonajes().get(0).getSalud());
	    }

	    @Test
	    public void siHay3OrcosEnLaAlianzaDebenAtacarA4EnemigosDeLaOtraAlianzaLos3UltimosNoRecibeDanio(){
	        AlianzaDeOrcos alianzaDeOrcos = AlianzaBuilder.crearAlianzaDeOrcos(3);
	        Alianza alianzaEnemiga = AlianzaBuilder.crearAlianza(4);
	        alianzaDeOrcos.atacar(alianzaEnemiga);
	        assertEquals(0, alianzaEnemiga.getPersonajes().get(0).getSalud());
	        assertEquals(Constantes.SaludGuerreroHumano, alianzaEnemiga.getPersonajes().get(1).getSalud());
	        assertEquals(Constantes.SaludGuerreroHumano, alianzaEnemiga.getPersonajes().get(2).getSalud());
	        assertEquals(Constantes.SaludGuerreroHumano, alianzaEnemiga.getPersonajes().get(3).getSalud());
	    }
	 
	 @Test
	    public void siHay20OrcosEnLaAlianzaDebenAtacarA4EnemigosDeLaOtraAlianzaTodosMueren(){
	        AlianzaDeOrcos alianzaDeOrcos = AlianzaBuilder.crearAlianzaDeOrcos(20);
	        Alianza alianzaEnemiga = AlianzaBuilder.crearAlianza(4);
	        alianzaDeOrcos.atacar(alianzaEnemiga);
	        assertEquals(0, alianzaEnemiga.getPersonajes().get(0).getSalud());
	        assertEquals(0, alianzaEnemiga.getPersonajes().get(1).getSalud());
	        assertEquals(0, alianzaEnemiga.getPersonajes().get(2).getSalud());
	        assertEquals(0, alianzaEnemiga.getPersonajes().get(3).getSalud());
	    }

}
