package promotionSystem.mapagrafico.dijkstra;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import promotionSystem.Punto;



public class Grafo {

	private ArrayList<Nodo> nodos;
	private Nodo[][] nodosVistados;
	//	private AlgoritmoDelTacho d;

	/*
	 *  00 	01	02	03	04
	 *  10 	x 	12	13	14  // EJ: 00 -> 01, 10
	 *	20	21	22	23	24
	 *	30	31	x	33	34
	 *	40	41	42	43	44
	 */

	public Grafo(MatrizBoolean obstaculos) {
		this.nodos  = new ArrayList<Nodo>();
		nodosVistados = new Nodo[obstaculos.getFilas()][obstaculos.getColumnas()];
		Nodo actual;
		for (int i = 0; i < obstaculos.getFilas(); i++) {    	// Recorro la matriz (filas)
			for (int j = 0; j < obstaculos.getColumnas(); j++) {	// Recorro la matriz (columna)

				if( obstaculos.get(i,j) )
					continue; // es un goto :v 

				actual = this.getNodoVisitante(i, j);
				if(actual == null)
					actual = new Nodo(new Punto(i,j));

				obstaculos.obtenerVecinosNodo(i, j,actual,this);

				nodos.add(actual); 
			}	
		}
	
		/*for (int i = 0; i < obstaculos.getFilas(); i++) {
			for (int j = 0; j < obstaculos.getColumnas(); j++) {
				System.out.print("("+i+" " +j+")"+obstaculos.get(i, j)+"\t");
			}
			System.out.println("\n");
		}*/
		nodosVistados = null; // libero memoria :D 
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



	/**	
	 * 	c = comienzo.
	 *  x = destino.
	 * 
	 *		0 - 0 - 0 - 0 
	 * 		| X | X | X |
	 * 		0 - 0 - 0 - 0 
	 * 		| X | X | X |
	 *		0 - 0 - 0 - 0 
	 * 		| X | X | X |
	 * 		0 - 0 - 0 - 0 
	 */

	/*public static void main(String[] args) {
		int n = 5;
		boolean[][] m = new boolean[n][n];
		m[2][2]= true; //hay ostaculo
		m[1][1]= true;
		m[1][2]= true;
		m[1][3]= true;

		m[3][1]= true;
		m[3][2]= true;
		m[3][3]= true;
		m[3][4]= true;
		MatrizBoolean obstaculos = new MatrizBoolean(m, n, n);

		Grafo g = new Grafo(obstaculos);

		System.out.println(g);
	}*/



	public List<Nodo> getListaNodos() {
		return this.nodos;
	}




}

