package promotionSystem.interfazGrafica;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import promotionSystem.Cliente;
import promotionSystem.Personaje;
import promotionSystem.razas.castas.humano.GuerreroHumano;

import javax.swing.*;
import java.lang.reflect.Field;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class VerPersonajeTest {

    @Mock
    public Cliente cliente;
    private Class<VerPersonaje> verPersonajeReflection = VerPersonaje.class;

    @Test
    public void debePonerLaRazaYLaCastaEnElLabelCorrespondiente() throws NoSuchFieldException, IllegalAccessException {
        Personaje guerrero = new GuerreroHumano();
        when(cliente.getRaza()).thenReturn("Humano");
        when(cliente.getCasta()).thenReturn("GuerreroHumano");
        when(cliente.getPersonaje()).thenReturn(guerrero);
        VerPersonaje verPersonaje = new VerPersonaje(cliente);
        Field lblRaza = verPersonajeReflection.getDeclaredField("lblRaza");
        lblRaza.setAccessible(true);
        Field lblCasta = verPersonajeReflection.getDeclaredField("lblCasta");
        lblCasta.setAccessible(true);
        assertEquals("Raza: Humano" ,((JLabel) (lblRaza.get(verPersonaje))).getText());
        assertEquals("Casta: GuerreroHumano" ,((JLabel) (lblCasta.get(verPersonaje))).getText());
    }

    @Test
    public void debePonerElAtaqueEnElLabelCorrespondiente() throws NoSuchFieldException, IllegalAccessException {
        Personaje guerrero = new GuerreroHumano();
        when(cliente.getRaza()).thenReturn("Humano");
        when(cliente.getCasta()).thenReturn("GuerreroHumano");
        when(cliente.getPersonaje()).thenReturn(guerrero);
        VerPersonaje verPersonaje = new VerPersonaje(cliente);
        Field lblAtaque = verPersonajeReflection.getDeclaredField("lblAtaque");
        lblAtaque.setAccessible(true);
        assertEquals("Ataque: 20" ,((JLabel) (lblAtaque.get(verPersonaje))).getText());
    }

    @Test
    public void debePonerElNivelEnElLabelCorrespondiente() throws NoSuchFieldException, IllegalAccessException {
        Personaje guerrero = new GuerreroHumano();
        when(cliente.getRaza()).thenReturn("Humano");
        when(cliente.getCasta()).thenReturn("GuerreroHumano");
        when(cliente.getPersonaje()).thenReturn(guerrero);
        VerPersonaje verPersonaje = new VerPersonaje(cliente);
        Field lblNivel = verPersonajeReflection.getDeclaredField("lblNivel");
        lblNivel.setAccessible(true);
        assertEquals("Nivel: 1" ,((JLabel) (lblNivel.get(verPersonaje))).getText());
    }
}