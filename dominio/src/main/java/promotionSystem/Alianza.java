package promotionSystem;
import java.util.ArrayList;
import java.util.List;

public class Alianza {
    protected List<Personaje> personajes;
    protected Personaje personajeActivo;
    protected Personaje objetivo;
    protected Personaje defensor;
    protected Alianza alianzaEnemiga;
    private List<Item> items;
    private int id;

    public Alianza(){
        personajes = new ArrayList<>();
    }

    public Alianza(List<Personaje> personajes) {
        this.personajes = personajes;
        asignarAlianza(personajes);
        personajeActivo = personajes.get(0);
        defensor = personajes.get(0);
    }

    public Alianza(List<Personaje> personajes, Alianza alianzaEnemiga) {
        this.personajes = personajes;
        asignarAlianza(personajes);
        this.alianzaEnemiga = alianzaEnemiga;
        personajeActivo = personajes.get(0);
        defensor = personajes.get(0);
    }

    private void asignarAlianza(List<Personaje> personajes) {
        for(Personaje personaje : personajes){
            personaje.alianza = this;
        }
    }

    public Personaje getPersonajeActivo() {
        return personajeActivo;
    }

    public Personaje getObjetivo() {
        return objetivo;
    }

    public Personaje getDefensor() {
        return defensor;
    }

    public void setObjetivo(Personaje objetivo) {
        this.objetivo = objetivo;
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

    public Personaje darVictima(Personaje personajeEnemigo) {
        return personajeEnemigo;
    }

    protected Personaje proximoPersonaje() {
        int personajeActual = personajes.indexOf(personajeActivo);
        int siguientePersonaje = personajeActual + 1;
        return personajeActual == personajes.size()-1 ? personajes.get(0) : personajes.get(siguientePersonaje);
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
