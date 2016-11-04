package promotionSystem;

import promotionSystem.mapa.Mapa;
import promotionSystem.mapa.Rectangulo;

import java.util.ArrayList;
import java.util.List;

public class Grafo {
    private List<Punto> nodos;
    List<List<Punto>> adyacentes;

    public Grafo(Mapa mapa, Rectangulo rectanguloDeVision){
        nodos = new ArrayList<>();
        for(Punto punto : rectanguloDeVision.getPuntos()){
            if(mapa.posicionValida(punto)){
                nodos.add(punto);
            }
        }
    }

    public Camino caminoMasCorto(){
        Dijkstra dijkstra = new Dijkstra(this);
        //TODO Hay que hacer la lógica del camino
        return new Camino(nodos.get(0), nodos.get(1));
    }
}
