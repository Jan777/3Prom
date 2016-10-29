package promotionSystem.alianzas;

import promotionSystem.Alianza;
import promotionSystem.Personaje;

import java.util.List;

public class AlianzaDeHumanos extends Alianza {

    public AlianzaDeHumanos(List<Personaje> personajes) {
        super(personajes);
        personajeActivo = personajes.get(0);
    }


    @Override
    public void atacar(Alianza alianzaEnemiga){
        objetivo = getVictima(alianzaEnemiga, personajeActivo);
        personajeActivo.atacar(objetivo);
        personajeActivo = personajes.get(proximoPersonaje());
    }

    private int proximoPersonaje() {
        int personajeActual = personajes.indexOf(personajeActivo);
        int siguientePersonaje = personajeActual + 1;
        return personajeActual == personajes.size()-1 ? 0 : siguientePersonaje;
    }

    private Personaje getVictima(Alianza alianzaEnemiga, Personaje personaje) {
        int idPersonaje = personajes.indexOf(personaje);
        int idVictima = idPersonaje > alianzaEnemiga.cantidadDePersonajes()-1 ? personajes.indexOf(personaje) - alianzaEnemiga.cantidadDePersonajes() : personajes.indexOf(personaje);
        return alianzaEnemiga.darVictima(idVictima);
    }
}
