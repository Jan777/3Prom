package promotionSystem;

import java.util.ArrayList;
import java.util.List;

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

    public void remove(Item item){
        listaDeItems.remove(item);
    }

    public Item buscarItem(Item item) throws ClassNotFoundException {
        for(Item itemEnInventario : listaDeItems){
            if(item.equals(itemEnInventario)){
                return itemEnInventario;
            }
        }
        return null;
    }

    public List<Item> getListaDeItems() {
        return listaDeItems;
    }
}
