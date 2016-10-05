package promotionSystem;

import java.util.ArrayList;
import java.util.List;

public class Alianza {
    protected List<Personaje> personajes;
    private Personaje personajeActivo;
    private List<Item> items;

    public Personaje getPersonajeActivo() {
        return personajeActivo;
    }

    public Alianza(List<Personaje> personajes) {
        this.personajes = personajes;
    }

    public Alianza() {
    	AdministradorDeAlianzas administrador = AdministradorDeAlianzas.getInstance();
    	administrador.agregarAlianza(this);
    	personajes=new ArrayList<>();

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
        return personajes.get(numeroDePersonaje);
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

	public void sacarPersonaje(Personaje personaje) {
		personajes.remove(personaje);
	}

	public void agregarPersonaje(Personaje personaje) {
		personajes.add(personaje);

	}

    public void atacar(Alianza alianzaEnemiga){

    }
}
