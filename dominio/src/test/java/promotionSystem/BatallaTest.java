package promotionSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

import static promotionSystem.builder.AlianzaBuilder.crearAlianza;

public class BatallaTest {
    private Alianza alianza1;
    private Alianza alianza2;

    @Before
    public void setUp(){
        Alianza alianza1 = crearAlianza(1);
        Alianza alianza2 = crearAlianza(1);
    }

    @Test
    public void debeDefinirElGanadorEntreDosBatallones(){
        Batalla batalla = crearBatalla();
        Assert.assertEquals(alianza1, batalla.definirGanador());
    }

    @Test
    public void debeDefinirElPremioDeUnaBatalla(){
        Batalla batalla = crearBatalla();
        Assert.assertEquals(new ArrayList<>(),batalla.definirPremio());
    }

    private Batalla crearBatalla(){
        return new Batalla(alianza1, alianza2);
    }

    //FIXME Codigo para ejecutar una batalla, se tiene que mover a los distintos elementos de JForm.
    public void asd(){
        alianza2 = crearAlianza(2);
        Batalla batalla = crearBatalla();
        alianza1.entrarEnBatalla();
        alianza2.entrarEnBatalla();
        batalla.darTurno(alianza1);
        Personaje atacante =  alianza1.getPersonajeActivo();
        Personaje victima = atacante.elegirVictima(alianza2, 0);
        atacante.atacar(victima);
        if(victima.estaVivo())
            Assert.assertEquals(alianza2, batalla.definirGanador());
    }
}