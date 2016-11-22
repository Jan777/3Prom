package promotionSystem.mapagrafico.dijkstra;

import java.util.*;



public class MetodoDijkstra {
	
	protected Nodo actualW;
	protected Nodo aux;
	protected Map<Nodo,Nodo> predecesores; 
	protected ArrayList<Nodo> pendientes; 
	protected ArrayList<Nodo> solucion; 
	private Map<Nodo, Integer> distancias = new HashMap<Nodo, Integer>(); 

	public void calcularDijkstra(Grafo grafo, Nodo inicial,Nodo destino) {
		predecesores = new HashMap<Nodo,Nodo>();

		pendientes = new ArrayList<Nodo>();
		solucion = new ArrayList<Nodo>();

		distancias.put(inicial, 0); 
		pendientes.add(inicial);

		while (pendientes.size() > 0) {
			actualW = obtenerMinimo(pendientes); 
			if(actualW == destino) 
				break;
			solucion.add(actualW); 
			pendientes.remove(actualW);  
			encontrarDistanciasMinimas(actualW);  

		}

	}

	public void encontrarDistanciasMinimas(Nodo actual) {

		for (Nodo vecino : actual.nodosAdyacentes) {
			if (!yaVisitado(vecino)) {
				if (obtenerDistancia(vecino) > obtenerDistancia(actual) + actual.getPeso(vecino)) {
					distancias.put(vecino, obtenerDistancia(actual) + actual.getPeso(vecino));
					predecesores.put(vecino, actual);
					pendientes.add(vecino);
				}
			}
		}
	}

	public Nodo obtenerMinimo(ArrayList<Nodo> nodosAdyacentes) {
		Nodo minimo = nodosAdyacentes.get(0);

		for (Nodo nodo : nodosAdyacentes) {
			if (obtenerDistancia(nodo) < obtenerDistancia(minimo)) 
				minimo = nodo;
		}
		return minimo;
	}

	private int obtenerDistancia(Nodo nodo) {
		Integer distancia = distancias.get(nodo);
		if (distancia == null)
			return Integer.MAX_VALUE;
		return distancia;
	}

	public Map<Nodo,Nodo> getPredecesores() {
		return predecesores;
	}

	public boolean yaVisitado(Nodo nodo) {
		return solucion.contains(nodo);
	}

	public LinkedList<Nodo> obtenerCamino(Nodo destino){
		LinkedList<Nodo> camino = new LinkedList<Nodo>();
		Nodo nodo = destino;
		if(predecesores.get(nodo)==null)
			return null;

		camino.add(nodo);
		while(predecesores.get(nodo)!=null){
			nodo = predecesores.get(nodo);
			camino.add(nodo);

		}

		Collections.reverse(camino);
		return camino;
	}

	public String mostrarCamino(Nodo destino){
		LinkedList<Nodo> camino = obtenerCamino(destino);
		String aux = "";
		if(camino==null)
			return aux;

		for (int i = 0; i < camino.size(); i++) {
			aux += " " + camino.get(i).getPunto();
		}
		return aux;
	}

}
