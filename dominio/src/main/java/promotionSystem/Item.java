package promotionSystem;

import promotionSystem.habilidades.Habilidad;

import java.util.List;

import static promotionSystem.builder.ItemBuilder.crearItems;

public class Item {
    private String nombreItem;
    private Personaje personajeEquipado;

    public Item(String nombreItem, Personaje personajeEquipado) {
        this.nombreItem = nombreItem;
        this.personajeEquipado = personajeEquipado;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public Personaje getPersonajeEquipado() {
        return personajeEquipado;
    }

    public Personaje equiparPersonaje(Personaje personaje) {
        for(Item itemAEquipar : crearItems(personaje)){
            if(this.nombreItem.equals(itemAEquipar.nombreItem)){
                return itemAEquipar.personajeEquipado;
            }
        }
        return null;
    }
}
