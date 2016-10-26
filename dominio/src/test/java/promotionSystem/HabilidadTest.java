package promotionSystem;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.habilidades.AtaqueCertero;
import promotionSystem.habilidades.Habilidad;

public class HabilidadTest {
    @Test
    public void subeDeNivelSiPuede(){
        Habilidad habilidad = new AtaqueCertero();
        habilidad.subirNivel();
        Assert.assertEquals(1, habilidad.getNivel());
    }

    @Test
    public void noSubeDeNivelSiNoPuede(){
        Habilidad habilidad = new AtaqueCertero();
        habilidad.subirNivel();
        habilidad.subirNivel();
        Assert.assertEquals(1, habilidad.getNivel());
    }
}