package promotionSystem.hilos;

import com.google.gson.JsonObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import promotionSystem.Personaje;
import promotionSystem.razas.castas.humano.GuerreroHumano;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

@RunWith(MockitoJUnitRunner.class)
public class EscuchadorTest {

    @Mock
    Escuchador escuchador;

    private Class<Escuchador> escuchadorReflection = Escuchador.class;

    @Test
    public void debeEquiparTodosLosItems() throws Exception {
        Method metodo = escuchadorReflection.getDeclaredMethod("setearItemsDePersonaje", JsonObject.class, Personaje.class);
        metodo.setAccessible(true);
        JsonObject objeto = new JsonObject();
        objeto.addProperty("arma", "Espada Kokiri");
        objeto.addProperty("casco", "Casco Adamantium");
        objeto.addProperty("botas", "Botas Flober");
        objeto.addProperty("escudo", "Escudo Hyrule");
        objeto.addProperty("chaleco", "Chaleco Kevlar");
        Personaje personaje = new GuerreroHumano();
        metodo.invoke(escuchador, objeto, personaje);
        assertEquals("Espada Kokiri", personaje.getArma().getNombreItem());
        assertEquals("Casco Adamantium", personaje.getCasco().getNombreItem());
        assertEquals("Botas Flober", personaje.getBotas().getNombreItem());
        assertEquals("Escudo Hyrule", personaje.getEscudo().getNombreItem());
        assertEquals("Chaleco Kevlar", personaje.getChaleco().getNombreItem());
    }

    @Test
    public void debeEquiparSoloElArma() throws Exception {
        Method metodo = escuchadorReflection.getDeclaredMethod("setearItemsDePersonaje", JsonObject.class, Personaje.class);
        metodo.setAccessible(true);
        JsonObject objeto = new JsonObject();
        objeto.addProperty("arma", "Espada Kokiri");
        objeto.addProperty("casco", "null");
        objeto.addProperty("botas", "null");
        objeto.addProperty("escudo", "null");
        objeto.addProperty("chaleco", "null");
        Personaje personaje = new GuerreroHumano();
        metodo.invoke(escuchador, objeto, personaje);
        assertEquals("Espada Kokiri", personaje.getArma().getNombreItem());
        assertEquals(null, personaje.getCasco());
        assertEquals(null, personaje.getBotas());
        assertEquals(null, personaje.getEscudo());
        assertEquals(null, personaje.getChaleco());
    }
}