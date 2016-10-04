package promotionSystem;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;

public class BatallaTest {

    @Test
    public void debeDefinirElGanadorEntreDosBatallones(){
        Alianza alianza1 = new Alianza();
        Alianza alianza2 = new Alianza();
        Batalla batalla = new Batalla(alianza1, alianza2);
        Assert.assertEquals(alianza1, batalla.definirGanador());
    }

    @Test
    public void debeDefinirElPremioDeUnaBatalla(){
        Batalla batalla = crearBatalla();
        Assert.assertEquals(new ArrayList<>(),batalla.definirPremio());
    }

    private Batalla crearBatalla(){
        Alianza alianza1 = new Alianza();
        Alianza alianza2 = new Alianza();
        return new Batalla(alianza1, alianza2);
    }
}