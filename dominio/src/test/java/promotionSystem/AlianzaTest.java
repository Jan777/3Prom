package promotionSystem;

import org.junit.Assert;
import org.junit.Test;

import static promotionSystem.builder.AlianzaBuilder.crearAlianza;

public class AlianzaTest {
    private Alianza alianza;

    @Test
    public void siLaAlianzaTieneTresPersonasDebeEntregar3Items(){
        alianza = crearAlianza(3);
        darItemsAPersonaje(1, 1);
        darItemsAPersonaje(2, 1);
        darItemsAPersonaje(3, 1);
        Assert.assertEquals(3,alianza.entregarItems().size());
    }

    private void darItemsAPersonaje(int numeroDePersonaje, int cantidadDeItems) {
        for(int i=0; i < cantidadDeItems; i++){
            alianza.getPersonajes().get(numeroDePersonaje-1).recibirItem(new Item());
        }
    }

    @Test
    public void debeDarLaVictimaQueLeSolicito(){
        alianza = crearAlianza(3);
        Personaje victima = alianza.darVictima(3);
        Assert.assertEquals(2, alianza.getPersonajes().indexOf(victima));
    }
}