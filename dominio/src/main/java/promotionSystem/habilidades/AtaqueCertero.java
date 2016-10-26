package promotionSystem.habilidades;

public class AtaqueCertero extends Habilidad {
    public AtaqueCertero() {
        super("Ataque certero", 2, 0, 0, 0);
    }

    @Override
    public boolean puedeSubirNivel() {
        return super.nivel == 0;
    }
}

