package promotionSystem;

import java.util.List;

public class Alianza {
    private List<Personaje> personajes;

    public Alianza(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public Personaje elegirVictima(int numeroDePersonaje) {
        return personajes.get(numeroDePersonaje-1);
    }
}
