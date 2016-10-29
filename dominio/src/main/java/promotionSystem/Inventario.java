package promotionSystem;

import java.util.ArrayList;
import java.util.List;

import static promotionSystem.builder.ItemBuilder.crearItems;

public class Inventario {
    private List<Item> listaDeItems = new ArrayList<>();

    public void add(Item item){
        listaDeItems.add(item);
    }

    public int size(){
        return listaDeItems.size();
    }

    public Item remove(){
        return listaDeItems.remove((int)(Math.random() * size()));
    }

    public Item buscarItem(Personaje personaje, String nombreItem){
        for(Item item : crearItems(personaje)){
            if(item.getNombreItem().equals(nombreItem)){
                return item;
            }
        }
        return null;
    }

    public List<Item> getListaDeItems() {
        return listaDeItems;
    }
}
