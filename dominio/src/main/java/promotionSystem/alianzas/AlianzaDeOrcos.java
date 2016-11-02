package promotionSystem.alianzas;

import promotionSystem.Alianza;
import promotionSystem.Personaje;

import java.util.List;

public class AlianzaDeOrcos extends AlianzaNPC{
    public AlianzaDeOrcos(List<Personaje> personajes) {
        super(personajes);
    }

    public AlianzaDeOrcos(List<Personaje> personajes, Alianza alianzaEnemiga) {
		super(personajes, alianzaEnemiga);
	}

    @Override
    protected void despuesDeAtacar() {
        objetivo = objetivo.estaVivo() ? objetivo : proximoObjetivo();
    }
}
