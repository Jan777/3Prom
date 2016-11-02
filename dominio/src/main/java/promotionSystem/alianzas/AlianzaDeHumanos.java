package promotionSystem.alianzas;

import promotionSystem.Alianza;
import promotionSystem.Personaje;

import java.util.List;

public class AlianzaDeHumanos extends AlianzaNPC {
    public AlianzaDeHumanos(List<Personaje> personajes) {
        super(personajes);
    }

    public AlianzaDeHumanos(List<Personaje> personajes, Alianza alianzaEnemiga) {
        super(personajes, alianzaEnemiga);
    }

    @Override
    protected void despuesDeAtacar() {
        objetivo = proximoObjetivo();
    }
}
