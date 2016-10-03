package promotionSystemTest;
import org.junit.Assert;
import org.junit.Test;

import promotionSystem.Batalla;
import promotionSystem.Batallon;

import java.util.ArrayList;

public class BatallaTest {

    @Test
    public void debeDefinirElGanadorEntreDosBatallones(){
        Batallon batallon1 = new Batallon();
        Batallon batallon2 = new Batallon();
        Batalla batalla = new Batalla(batallon1, batallon2);
        Assert.assertEquals(batallon1, batalla.definirGanador());
    }

    @Test
    public void debeDefinirElPremioDeUnaBatalla(){
        Batalla batalla = crearBatalla();
        Assert.assertEquals(new ArrayList<>(),batalla.definirPremio());
    }

    private Batalla crearBatalla(){
        Batallon batallon1 = new Batallon();
        Batallon batallon2 = new Batallon();
        return new Batalla(batallon1, batallon2);
    }
}