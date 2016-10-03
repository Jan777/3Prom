import java.util.ArrayList;
import java.util.List;

public class Batalla {

    private Batallon batallon1;
    private Batallon batallon2;

    public Batalla(Batallon batallon1, Batallon batallon2) {
        this.batallon1 = batallon1;
        this.batallon2 = batallon2;
    }

    public Batallon definirGanador() {
        return batallon1;
    }

    public List<Item> definirPremio() {
        return new ArrayList<>();
    }
}
