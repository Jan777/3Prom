//package promotionSystem;
//import java.util.*;
//
//import static java.lang.Integer.MAX_VALUE;
//
//public class Dijkstra{
//    private Grafo grafo;
//    private List<List<Punto>> adyacentes = new ArrayList<>();
//    private List<Integer> distancia = new ArrayList<>();
//    private List<Boolean> visitado = new ArrayList<>();
//    private PriorityQueue<Punto> colaDePrioridad = new PriorityQueue<>();
//    private int vertices;
//    private List<Integer> previo = new ArrayList<>();
//    private boolean dijkstraEjecutado;
//
//    Dijkstra(int vertices){
//        this.vertices = vertices;
//        for(int i = 0; i <= vertices; ++i ){
//            adyacentes.add(new ArrayList<>());
//        }
//    }
//
//    public Dijkstra(Grafo grafo){
//        this.grafo = grafo;
//    }
//
//    private void init(){
//        for(int i = 0; i <= vertices; ++i ){
//            distancia.set(i, MAX_VALUE);
//            visitado.set(i, false);
//            previo.set(i, -1);
//        }
//    }
//
//    private void relajacion( int actual , int adyacente , int peso ){
//        if( distancia.get(actual) + peso < distancia.get(adyacente)){
//            distancia.set(adyacente, distancia.get(actual) + peso);
//            previo.set(adyacente, actual);
//            colaDePrioridad.add( new Punto( adyacente , distancia.get(adyacente)) );
//        }
//    }
//
//    void dijkstra( int inicial ){
//        init();
//        colaDePrioridad.add(new Punto(inicial, 0));
//        distancia.set(inicial, 0);
//        int actual , adyacente , peso;
//        while( !colaDePrioridad.isEmpty() ){
//            actual = colaDePrioridad.element().getX();
//            colaDePrioridad.remove();
//            if( visitado.get(actual)) continue;
//            visitado.set(actual, true);
//
//            for(int i = 0; i < adyacentes.get( actual ).size() ; ++i ){
//                adyacente = adyacentes.get( actual ).get( i ).getX();
//                peso = adyacentes.get( actual ).get( i ).getY();
//                if( !visitado.get(adyacente)){
//                    relajacion( actual , adyacente , peso );
//                }
//            }
//        }
//
//        System.out.printf( "Distancias mas cortas iniciando en vertice %d\n" , inicial );
//        for(int i = 1; i <= vertices; ++i ){
//            System.out.printf("Vertice %d , distancia mas corta = %d\n" , i , distancia.get(i));
//        }
//        dijkstraEjecutado = true;
//    }
//}