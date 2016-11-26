package promotionSystem.mapagrafico.dijkstra;

import org.junit.Test;

import static org.junit.Assert.*;

public class GrafoTest {

    @Test
    public void debeCrear16Nodos(){
        boolean[][] matrizBooleana = new boolean[4][4];
        MatrizBoolean obstaculos = new MatrizBoolean(matrizBooleana, 4, 4);
        Grafo grafo = new Grafo(obstaculos);
        assertEquals(16, grafo.getListaNodos().size());
    }
}