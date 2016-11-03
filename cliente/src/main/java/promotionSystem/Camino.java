package promotionSystem;

public class Camino {
    private Punto salida;
    private Punto destino;
    private Double distancia;

    public Camino(Punto salida, Punto destino) {
        this.salida = salida;
        this.destino = destino;
        this.distancia = salida.distanciaCon(destino);
    }

    public Double getDistancia() {
        return distancia;
    }
}
