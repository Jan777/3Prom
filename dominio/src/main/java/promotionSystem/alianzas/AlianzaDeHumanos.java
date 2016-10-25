package promotionSystem.alianzas;

import promotionSystem.Alianza;
import promotionSystem.Personaje;

import java.util.List;

public class AlianzaDeHumanos extends Alianza {

    public AlianzaDeHumanos(List<Personaje> personajes) {
        super(personajes);
    }

    @Override
    public void atacar(Alianza alianzaEnemiga){
        for(Personaje personaje : personajes){
            Personaje victima = getVictima(alianzaEnemiga, personaje);
            personaje.atacar(victima);
        }
    }

    private Personaje getVictima(Alianza alianzaEnemiga, Personaje personaje) {
        int idPersonaje = personajes.indexOf(personaje);
        int idVictima = idPersonaje > alianzaEnemiga.cantidadDePersonajes()-1 ? personajes.indexOf(personaje) - alianzaEnemiga.cantidadDePersonajes() : personajes.indexOf(personaje);
        return alianzaEnemiga.darVictima(idVictima);
    }
}
