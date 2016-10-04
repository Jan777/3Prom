package promotionSystem;

import org.junit.Assert;
import org.junit.Test;

import static promotionSystem.builder.AlianzaBuilder.crearAlianza;

public class AlianzaTest {
    @Test
    public void debeElegirElPrimerPersonajeComoVictima(){
        Alianza alianza = crearAlianza(1);
        Assert.assertEquals(0, alianza.getPersonajes().indexOf(alianza.elegirVictima(1)));
    }
}