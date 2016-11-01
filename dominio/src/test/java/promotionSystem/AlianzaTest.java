package promotionSystem;

import org.junit.Assert;
import org.junit.Test;

import static promotionSystem.builder.AlianzaBuilder.crearAlianza;

public class AlianzaTest {
    private Alianza alianza;
    private Item item;

    @Test
    public void siLaAlianzaTieneTresPersonasDebeEntregar3Items() throws ClassNotFoundException {
        alianza = crearAlianza(3);
        darItemsAPersonaje(1, 1);
        darItemsAPersonaje(2, 1);
        darItemsAPersonaje(3, 1);
        Assert.assertEquals(3,alianza.entregarItems().size());
    }

    private void darItemsAPersonaje(int numeroDePersonaje, int cantidadDeItems) throws ClassNotFoundException {
        item = new Item("ConEspadaGorgoroth");
        for(int i=0; i < cantidadDeItems; i++){
            alianza.getPersonajes().get(numeroDePersonaje-1).recibirItem(item);
        }
    }

    @Test
    public void debeDarLaVictimaQueLeSolicito(){
        alianza = crearAlianza(3);
        Personaje victima = alianza.darVictima(2);
        Assert.assertEquals(2, alianza.getPersonajes().indexOf(victima));
    }
}