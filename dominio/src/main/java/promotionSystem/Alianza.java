package promotionSystem;

import java.util.List;

public class Alianza {
    private List<Personaje> personajes;
    private Personaje personajeActivo;

    public Personaje getPersonajeActivo() {
        return personajeActivo;
    }

    public Alianza(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public void entrarEnBatalla(){
        //Carga de interfaz de batalla.
    }

    public Personaje darVictima(int numeroDePersonaje) {
        return personajes.get(numeroDePersonaje-1);
    }

    public void repartirItems(List<Item> premio){
        for(Item item : premio){
            //FIXME A definir -> Inventario - Random
        }
    }
}
