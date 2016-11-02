package promotionSystem.alianzas;

import org.junit.Test;
import promotionSystem.Alianza;
import promotionSystem.builder.AlianzaBuilder;

import static org.junit.Assert.assertEquals;
import static promotionSystem.Constantes.*;
import static promotionSystem.builder.AlianzaBuilder.crearAlianzaDeHumanosConEnemigos;

public class AlianzaDeHumanosTest {

    @Test
    public void siHay3HumanosEnLaAlianzaDebenAtacarATresEnemigosDeLaOtraAlianza(){
        Alianza alianzaEnemiga = AlianzaBuilder.crearAlianza(3);
        AlianzaDeHumanos alianzaDeHumanos = crearAlianzaDeHumanosConEnemigos(3, alianzaEnemiga);
        alianzaDeHumanos.atacar(alianzaEnemiga);
        alianzaDeHumanos.atacar(alianzaEnemiga);
        alianzaDeHumanos.atacar(alianzaEnemiga);
        assertEquals(SaludGuerreroHumano- AtaqueGuerreroHumano+ DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(0).getSalud());
        assertEquals(SaludGuerreroHumano- AtaqueGuerreroHumano+ DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(1).getSalud());
        assertEquals(SaludGuerreroHumano- AtaqueGuerreroHumano+ DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(2).getSalud());
    }

    @Test
    public void siHay3HumanosQueAtacanDosPersonajesElPrimeroYElTerceroDebenAtacarAlPrimero(){
        Alianza alianzaEnemiga = AlianzaBuilder.crearAlianza(2);
        AlianzaDeHumanos alianzaDeHumanos = crearAlianzaDeHumanosConEnemigos(3, alianzaEnemiga);
        alianzaDeHumanos.atacar(alianzaEnemiga);
        alianzaDeHumanos.atacar(alianzaEnemiga);
        alianzaDeHumanos.atacar(alianzaEnemiga);
        assertEquals(SaludGuerreroHumano- AtaqueGuerreroHumano+ DefensaGuerreroHumano- AtaqueGuerreroHumano+ DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(0).getSalud());
        assertEquals(SaludGuerreroHumano- AtaqueGuerreroHumano+ DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(1).getSalud());
    }

    @Test
    public void siHay3HumanosQueAtacanA4PersonajesElCuartoNoRecibeDano(){
        Alianza alianzaEnemiga = AlianzaBuilder.crearAlianza(4);
        AlianzaDeHumanos alianzaDeHumanos = crearAlianzaDeHumanosConEnemigos(3, alianzaEnemiga);
        alianzaDeHumanos.atacar(alianzaEnemiga);
        alianzaDeHumanos.atacar(alianzaEnemiga);
        alianzaDeHumanos.atacar(alianzaEnemiga);
        assertEquals(SaludGuerreroHumano- AtaqueGuerreroHumano+ DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(0).getSalud());
        assertEquals(SaludGuerreroHumano- AtaqueGuerreroHumano+ DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(1).getSalud());
        assertEquals(SaludGuerreroHumano- AtaqueGuerreroHumano+ DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(2).getSalud());
        assertEquals(SaludGuerreroHumano, alianzaEnemiga.getPersonajes().get(3).getSalud());
    }
}