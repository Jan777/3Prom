package promotionSystem;
import java.util.List;

public class Batalla {

    private Alianza alianza1;
    private Alianza alianza2;
    private Alianza ganador;
    private Alianza perdedor;

    public Batalla(Alianza alianza1, Alianza alianza2) {
        this.alianza1 = alianza1;
        this.alianza2 = alianza2;
    }

    public void darTurno(Alianza alianza){
        alianza.atacar(alianza2);
    }

    public Alianza definirGanador() {
        ganador = alianza1.cantidadDePersonajes() > alianza2.cantidadDePersonajes() ? alianza1 : alianza2;
        return ganador;
    }

    public Alianza definirPerdedor() {
        perdedor = alianza1.cantidadDePersonajes() < alianza2.cantidadDePersonajes() ? alianza1 : alianza2;
        return perdedor;
    }

    public List<Item> entregarPremio() {
        definirGanador();
        List<Item> premio = definirPremio();
        ganador.recibirItems(premio);
        return premio;
    }

    private List<Item> definirPremio() {
        definirPerdedor();
        return perdedor.entregarItems();
    }


}