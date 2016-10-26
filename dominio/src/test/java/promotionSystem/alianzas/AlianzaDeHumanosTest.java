package promotionSystem.alianzas;

import org.junit.Test;
import promotionSystem.Alianza;
import promotionSystem.Constantes;
import promotionSystem.alianzas.AlianzaDeHumanos;
import promotionSystem.builder.AlianzaBuilder;

import static org.junit.Assert.*;
import static promotionSystem.builder.AlianzaBuilder.crearAlianzaDeHumanos;

public class AlianzaDeHumanosTest {

    @Test
    public void siHay3HumanosEnLaAlianzaDebenAtacarATresEnemigosDeLaOtraAlianza(){
        AlianzaDeHumanos alianzaDeHumanos = crearAlianzaDeHumanos(3);
        Alianza alianzaEnemiga = AlianzaBuilder.crearAlianza(3);
        alianzaDeHumanos.atacar(alianzaEnemiga);
        assertEquals(Constantes.SaludGuerreroHumano-Constantes.AtaqueGuerreroHumano+Constantes.DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(0).getSalud());
        assertEquals(Constantes.SaludGuerreroHumano-Constantes.AtaqueGuerreroHumano+Constantes.DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(1).getSalud());
        assertEquals(Constantes.SaludGuerreroHumano-Constantes.AtaqueGuerreroHumano+Constantes.DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(2).getSalud());
    }

    @Test
    public void siHay3HumanosQueAtacanDosPersonajesElPrimeroYElTerceroDebenAtacarAlPrimero(){
        AlianzaDeHumanos alianzaDeHumanos = crearAlianzaDeHumanos(3);
        Alianza alianzaEnemiga = AlianzaBuilder.crearAlianza(2);
        alianzaDeHumanos.atacar(alianzaEnemiga);
        assertEquals(Constantes.SaludGuerreroHumano-Constantes.AtaqueGuerreroHumano+Constantes.DefensaGuerreroHumano-Constantes.AtaqueGuerreroHumano+Constantes.DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(0).getSalud());
        assertEquals(Constantes.SaludGuerreroHumano-Constantes.AtaqueGuerreroHumano+Constantes.DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(1).getSalud());
    }

    @Test
    public void siHay3HumanosQueAtacanA4PersonajesElCuartoNoRecibeDano(){
        AlianzaDeHumanos alianzaDeHumanos = crearAlianzaDeHumanos(3);
        Alianza alianzaEnemiga = AlianzaBuilder.crearAlianza(4);
        alianzaDeHumanos.atacar(alianzaEnemiga);
        assertEquals(Constantes.SaludGuerreroHumano-Constantes.AtaqueGuerreroHumano+Constantes.DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(0).getSalud());
        assertEquals(Constantes.SaludGuerreroHumano-Constantes.AtaqueGuerreroHumano+Constantes.DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(1).getSalud());
        assertEquals(Constantes.SaludGuerreroHumano-Constantes.AtaqueGuerreroHumano+Constantes.DefensaGuerreroHumano, alianzaEnemiga.getPersonajes().get(2).getSalud());
        assertEquals(Constantes.SaludGuerreroHumano, alianzaEnemiga.getPersonajes().get(3).getSalud());
    }
}