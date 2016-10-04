package promotionSystem.builder;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Alianza;
import promotionSystem.Personaje;

import static promotionSystem.builder.AlianzaBuilder.crearAlianza;

public class AlianzaBuilderTest {
    @Test
    public void debeCrearUnaAlianzaConUnPersonaje(){
        Alianza alianza = crearAlianza(1);
        Assert.assertEquals(1, alianza.getPersonajes().size());
        Assert.assertEquals(Personaje.class, alianza.getPersonajes().get(0).getClass());
    }

    @Test
    public void debeCrearUnaAlianzaConDiezPersonajes(){
        Alianza alianza = crearAlianza(10);
        Assert.assertEquals(10, alianza.getPersonajes().size());
        for(Personaje personaje : alianza.getPersonajes()){
            Assert.assertEquals(Personaje.class, personaje.getClass());
        }
    }
}