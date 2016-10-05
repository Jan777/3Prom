package promotionSystem;

import org.junit.Test;
import promotionSystem.builder.AlianzaBuilder;

import static org.junit.Assert.*;
import static promotionSystem.builder.AlianzaBuilder.crearAlianzaDeHumanos;

public class AlianzaDeHumanosTest {

    @Test
    public void siHay3HumanosEnLaAlianzaDebenAtacarATresEnemigosDeLaOtraAlianza(){
        AlianzaDeHumanos alianzaDeHumanos = crearAlianzaDeHumanos(3);
        Alianza alianzaEnemiga = AlianzaBuilder.crearAlianza(3);
        alianzaDeHumanos.atacar(alianzaEnemiga);
        assertEquals(92, alianzaEnemiga.getPersonajes().get(0).getSalud());
        assertEquals(92, alianzaEnemiga.getPersonajes().get(1).getSalud());
        assertEquals(92, alianzaEnemiga.getPersonajes().get(2).getSalud());
    }

    @Test
    public void siHay3HumanosQueAtacanDosPersonajesElPrimeroYElTerceroDebenAtacarAlPrimero(){
        AlianzaDeHumanos alianzaDeHumanos = crearAlianzaDeHumanos(3);
        Alianza alianzaEnemiga = AlianzaBuilder.crearAlianza(2);
        alianzaDeHumanos.atacar(alianzaEnemiga);
        assertEquals(84, alianzaEnemiga.getPersonajes().get(0).getSalud());
        assertEquals(92, alianzaEnemiga.getPersonajes().get(1).getSalud());
    }

    @Test
    public void siHay3HumanosQueAtacanA4PersonajesElCuartoNoRecibeDaño(){
        AlianzaDeHumanos alianzaDeHumanos = crearAlianzaDeHumanos(3);
        Alianza alianzaEnemiga = AlianzaBuilder.crearAlianza(4);
        alianzaDeHumanos.atacar(alianzaEnemiga);
        assertEquals(92, alianzaEnemiga.getPersonajes().get(0).getSalud());
        assertEquals(92, alianzaEnemiga.getPersonajes().get(1).getSalud());
        assertEquals(92, alianzaEnemiga.getPersonajes().get(2).getSalud());
        assertEquals(100, alianzaEnemiga.getPersonajes().get(3).getSalud());
    }
}