package promotionSystem.habilidades;

public class CuerpoFuerte extends Habilidad {
    public CuerpoFuerte() {
        super("Cuerpo fuerte", 0, 0, 2, 0);
    }
    @Override
    public boolean puedeSubirNivel() {
        return nivel == 0;
    }
}
