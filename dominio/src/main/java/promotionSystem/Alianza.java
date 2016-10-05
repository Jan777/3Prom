package promotionSystem;

import java.util.ArrayList;
import java.util.List;

public class Alianza {
    private List<Personaje> personajes;
    private Personaje personajeActivo;
    private List<Item> items;

    public Personaje getPersonajeActivo() {
        return personajeActivo;
    }

    public Alianza(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    public List<Personaje> getPersonajes() {
        return personajes;
    }

    public List<Item> getItems() {
        return items;
    }

    public int cantidadDePersonajes() {
        return personajes.size();
    }

    public void entrarEnBatalla(){
        //Carga de interfaz de batalla.
    }

    public Personaje darVictima(int numeroDePersonaje) {
        return personajes.get(numeroDePersonaje-1);
    }

    public List<Item> entregarItems(){
        List<Item> itemsPerdidos = new ArrayList<>();
        for(Personaje personaje : personajes){
        	if(personaje.puedeDarItem()){
        		itemsPerdidos.add(personaje.entregarItem());        		
         	}
        }
        return itemsPerdidos;
    }

    public void recibirItems(List<Item> items){
        this.items = items;
    }
}
