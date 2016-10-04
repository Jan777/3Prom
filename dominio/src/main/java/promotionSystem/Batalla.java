package promotionSystem;
import java.util.ArrayList;
import java.util.List;

public class Batalla {

    private Alianza alianza1;
    private Alianza alianza2;

    public Batalla(Alianza alianza1, Alianza alianza2) {
        this.alianza1 = alianza1;
        this.alianza2 = alianza2;
    }

    public void darTurno(Alianza alianza){
        //Cargar interfaz para que el usuario ataque.
    }

    public Alianza definirGanador() {
        //FIXME Se define con el JForm, borrar lo de abajo.
        return alianza1;
    }

    public List<Item> definirPremio() {
        return new ArrayList<>();
    }
}