package promotionSystem;
import java.util.ArrayList;
import java.util.List;

public class Alianza {
    protected List<Personaje> personajes;
    protected Personaje personajeActivo;
    protected Personaje objetivo;
    private List<Item> items;
    private int id;

    public Personaje getPersonajeActivo() {
        return personajeActivo;
    }

    public Personaje getObjetivo() {
        return objetivo;
    }

    public void setObjetivo(Personaje objetivo) {
        this.objetivo = objetivo;
    }

    public Alianza(){

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
        return personajes.get(numeroDePersonaje);
    }

    public List<Item> entregarItems(){
        List<Item> itemsPerdidos = new ArrayList<Item>();
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
		personaje.setAlianza(this);
	}

    public void atacar(Alianza alianzaEnemiga){
        personajeActivo.atacar(objetivo);
    }

	public void agregarPersonaje(List<Personaje> personajes) {
		for(Personaje personaje:personajes){
			personaje.setAlianza(this);
			this.personajes.add(personaje);
		}		
	}

	public void setId(int id) {
		this.id=id;
		
	}

	public int getId() {
		return id;
	}
}
