package promotionSystem.alianzas;

import promotionSystem.Alianza;
import promotionSystem.Personaje;

import java.util.List;

public abstract class AlianzaNPC extends Alianza{
    public AlianzaNPC(List<Personaje> personajes, Alianza alianzaEnemiga) {
        super(personajes, alianzaEnemiga);
        objetivo = alianzaEnemiga.getDefensor();
    }

    public AlianzaNPC(List<Personaje> personajes) {
        super(personajes);
    }

    @Override
    public void atacar(Alianza alianzaEnemiga){
        objetivo = getVictima(alianzaEnemiga, personajeActivo);
        personajeActivo.atacar(objetivo);
        personajeActivo = proximoPersonaje();
        despuesDeAtacar();
    }

    protected abstract void despuesDeAtacar();

    protected Personaje getVictima(Alianza alianzaEnemiga, Personaje personaje) {
        return alianzaEnemiga.darVictima(objetivo);
    }

    protected Personaje proximoObjetivo() {
        int siguienteObjetivo = alianzaEnemiga.getPersonajes().indexOf(objetivo) + 1;
        int idVictima = siguienteObjetivo > alianzaEnemiga.cantidadDePersonajes()-1 ? 0 : siguienteObjetivo;
        return alianzaEnemiga.getPersonajes().get(idVictima);
    }
}
