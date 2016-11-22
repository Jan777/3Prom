package promotionSystem.mapagrafico.dijkstra;

import promotionSystem.Punto;

import java.util.ArrayList;
import java.util.List;



public class Grafo {

	private ArrayList<Nodo> nodos;
	private Nodo[][] nodosVistados;
	

	public Grafo(MatrizBoolean obstaculos) {
		this.nodos  = new ArrayList<Nodo>();
		nodosVistados = new Nodo[obstaculos.getFilas()][obstaculos.getColumnas()];
		Nodo actual;
		for (int i = 0; i < obstaculos.getFilas(); i++) {    	
			for (int j = 0; j < obstaculos.getColumnas(); j++) {	

				if( obstaculos.get(i,j) )
					continue; 

				actual = this.getNodoVisitante(i, j);
				if(actual == null)
					actual = new Nodo(new Punto(i,j));

				obstaculos.obtenerVecinosNodo(i, j,actual,this);

				nodos.add(actual); 
			}	
		}
	
		
		nodosVistados = null; 
	}

	public Nodo getNodoVisitante(int i, int j) {
		return nodosVistados[i][j];
	}

	public Nodo getNodo(int i, int j) {
		for(Nodo nodo : nodos)
			if( nodo.getPunto().comparar(new Punto(i,j)))
				return nodo;
		return null;
	}

	public void setVisitados(Nodo aux, int fila, int columna) {
		nodosVistados[fila][columna] = aux;
	}

	public String toString() {
		String aux = "";
		for (Nodo n : nodos) {
			aux += n.toString()+"\n";
		}
		return aux;
	}


	public List<Nodo> getListaNodos() {
		return this.nodos;
	}




}

