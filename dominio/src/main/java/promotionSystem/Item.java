package promotionSystem;

import java.lang.reflect.InvocationTargetException;

import static promotionSystem.builder.ItemBuilder.crearItems;

public class Item {
    private Class<? extends PersonajeEquipado> item;
    private String nombreItem;

    public Item(String nombreItem) throws ClassNotFoundException {
        this.nombreItem = nombreItem;
        this.item = (Class<? extends PersonajeEquipado>) Class.forName("promotionSystem.items." + nombreItem);
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public Personaje equiparPersonaje(Personaje personaje) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, InstantiationException, ClassNotFoundException {
        for(Item itemAEquipar : crearItems()){
            if(this.nombreItem.equals(itemAEquipar.nombreItem)){
                return item.newInstance().equipar(personaje);
            }
        }
        return null;
    }
}
