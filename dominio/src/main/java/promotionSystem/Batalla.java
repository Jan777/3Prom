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

    public Alianza definirGanador() {
        return alianza1;
    }

    public List<Item> definirPremio() {
        return new ArrayList<>();
    }
}