package promotionSystem.alianzas;

import org.junit.Test;
import promotionSystem.Alianza;
import promotionSystem.Constantes;
import promotionSystem.builder.AlianzaBuilder;

import static org.junit.Assert.assertEquals;
import static promotionSystem.builder.AlianzaBuilder.crearAlianzaDeOrcosConEnemigos;

public class AlianzaDeOrcosTest {

    private AlianzaDeOrcos alianzaDeOrcos;
    private Alianza alianzaEnemiga;

    @Test
        public void siHay3OrcosEnLaAlianzaDebenAtacarAUnEnemigoDeLaOtraAlianza(){
        alianzaEnemiga = AlianzaBuilder.crearAlianza(3);
        alianzaDeOrcos = crearAlianzaDeOrcosConEnemigos(3, alianzaEnemiga);
        alianzaDeOrcos.atacar(alianzaEnemiga);
        alianzaDeOrcos.atacar(alianzaEnemiga);
        alianzaDeOrcos.atacar(alianzaEnemiga);
        assertEquals(0, alianzaEnemiga.getPersonajes().get(0).getSalud());
    }

    @Test
    public void si3OrcosEnLaAlianzaDebenAtacarA4EnemigosDeLaOtraAlianzaLos3UltimosNoRecibeDanio(){
        alianzaEnemiga = AlianzaBuilder.crearAlianza(4);
        alianzaDeOrcos = AlianzaBuilder.crearAlianzaDeOrcosConEnemigos(3, alianzaEnemiga);
        alianzaDeOrcos.atacar(alianzaEnemiga);
        alianzaDeOrcos.atacar(alianzaEnemiga);
        alianzaDeOrcos.atacar(alianzaEnemiga);
        assertEquals(0, alianzaEnemiga.getPersonajes().get(0).getSalud());
        assertEquals(Constantes.SaludGuerreroHumano, alianzaEnemiga.getPersonajes().get(1).getSalud());
        assertEquals(Constantes.SaludGuerreroHumano, alianzaEnemiga.getPersonajes().get(2).getSalud());
        assertEquals(Constantes.SaludGuerreroHumano, alianzaEnemiga.getPersonajes().get(3).getSalud());
    }
	 
    @Test
    public void siHay20OrcosEnLaAlianzaDebenAtacarA4EnemigosDeLaOtraAlianzaTodosMueren(){
        alianzaEnemiga = AlianzaBuilder.crearAlianza(4);
        alianzaDeOrcos = AlianzaBuilder.crearAlianzaDeOrcosConEnemigos(20, alianzaEnemiga);
        ataqueMultiple(20);
        assertEquals(0, alianzaEnemiga.getPersonajes().get(0).getSalud());
        assertEquals(0, alianzaEnemiga.getPersonajes().get(1).getSalud());
        assertEquals(0, alianzaEnemiga.getPersonajes().get(2).getSalud());
        assertEquals(0, alianzaEnemiga.getPersonajes().get(3).getSalud());
    }

    private void ataqueMultiple(int numeroDeAtaques){
        for(int i = 0; i< numeroDeAtaques ; i++){
            alianzaDeOrcos.atacar(alianzaEnemiga);
        }
    }
}
