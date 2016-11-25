package promotionSystem.hilos;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.runners.MockitoJUnitRunner;
import promotionSystem.Alianza;
import promotionSystem.Personaje;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static promotionSystem.builder.AlianzaBuilder.crearAlianza;

@RunWith(MockitoJUnitRunner.class)
public class BatallaHiloTest {

    @InjectMocks
    private BatallaHilo batalla;

    private Class<BatallaHilo> batallaReflection = BatallaHilo.class;

    @Test
    public void siLaAlianza1GanaSusIntegrantesDebenRecibirExperiencia() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Method metodo = batallaReflection.getDeclaredMethod("aumentarExperienciaDeLosGanadores");
        metodo.setAccessible(true);
        set("cantidadMuertesAlianza1", 0);
        set("alianza1", crearAlianza(2));
        set("subirExperienciaConMuertesDeAlianza2", 50);
        metodo.invoke(batalla);
        Field alianzaReflection = batallaReflection.getDeclaredField("alianza1");
        alianzaReflection.setAccessible(true);
        Alianza alianza1 = (Alianza)alianzaReflection.get(batalla);
        assertEquals(20, alianza1.getPersonajes().get(0).getExperiencia());
        assertEquals(5, alianza1.getPersonajes().get(0).getNivel());
        assertEquals(20, alianza1.getPersonajes().get(1).getExperiencia());
        assertEquals(5, alianza1.getPersonajes().get(1).getNivel());
    }
    
    @Test
    public void siLaAlianza2GanaSusIntegrantesDebenRecibirExperiencia() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, NoSuchFieldException {
        Method metodo = batallaReflection.getDeclaredMethod("aumentarExperienciaDeLosGanadores");
        metodo.setAccessible(true);
        set("cantidadMuertesAlianza1", 2);
        set("alianza1", crearAlianza(2));
        set("alianza2", crearAlianza(2));
        set("subirExperienciaConMuertesDeAlianza1", 50);
        metodo.invoke(batalla);
        Field alianzaReflection = batallaReflection.getDeclaredField("alianza2");
        alianzaReflection.setAccessible(true);
        Alianza alianza2 = (Alianza)alianzaReflection.get(batalla);
        assertEquals(20, alianza2.getPersonajes().get(0).getExperiencia());
        assertEquals(5, alianza2.getPersonajes().get(0).getNivel());
        assertEquals(20, alianza2.getPersonajes().get(1).getExperiencia());
        assertEquals(5, alianza2.getPersonajes().get(1).getNivel());
    }
    
    @Test
    public void losMuertosDebenRevivirConTodaLaVida() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {
        Method metodo = batallaReflection.getDeclaredMethod("recuperarVidaABatallantes");
        metodo.setAccessible(true);
        List<Personaje> muertos = crearAlianza(2).getPersonajes();
        for(Personaje muerto : muertos){
            muerto.setSalud(0);
        }
        set("muertos", muertos);
        assertEquals(0, muertos.get(0).getSalud());
        assertEquals(0, muertos.get(1).getSalud());
    }

    private void set(String campo, Object valor) throws NoSuchFieldException, IllegalAccessException {
        Field cantidadMuertesAlianza1 = batallaReflection.getDeclaredField(campo);
        cantidadMuertesAlianza1.setAccessible(true);
        cantidadMuertesAlianza1.set(batalla, valor);
    }


}