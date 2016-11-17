package promotionSystem.mapagrafico.dijkstra;

import promotionSystem.Punto;



public class MatrizBoolean {

	private boolean[][]matrizBooleana;
	private int filas;
	private int columnas;


	public MatrizBoolean(boolean[][] matrizBooleana, int filas, int columnas) {
		this.matrizBooleana = matrizBooleana;
		this.filas = filas;
		this.columnas = columnas;

	}
	
	public void obtenerVecinosNodo(int xNodo, int yNodo,Nodo actual, Grafo g) {
		int i, j,xArista,yArista;
		Nodo aux;

		for (i = -1; i < 2; i++) {
			xArista = xNodo +i;
			for (j = -1; j < 2; j++) {
				yArista = yNodo + j;
				if ( esPosicionValida(xArista, yArista)) 
				{
					if ((xArista != xNodo || yArista != yNodo)) 

					{	

						if( !matrizBooleana[xArista][yArista] && !hayObstaculoCerca(xNodo,yNodo,xArista,yArista) ){ 

							aux = g.getNodoVisitante(xArista,yArista);
							if(aux==null){	
								aux = new Nodo(new Punto(xArista,yArista));
								actual.agregarConexion( aux ) ;
								g.setVisitados(aux, xArista, yArista);
							}
							else{
								actual.agregarConexion(aux);
							}

						}

					}
				}
			}
		}
	}

	
	private boolean hayObstaculoCerca(int xNodo,int yNodo, int xArista, int yArista) {

		boolean aux = false;
		if( xArista+1==xNodo && yArista+1==yNodo && xNodo>=0 && yNodo>=0)
			aux = matrizBooleana[xNodo-1][yNodo]	|| 	matrizBooleana[xNodo][yNodo-1];

		if( xArista+1==xNodo && yArista-1==yNodo && xNodo>=0 && yNodo<columnas)
			aux = matrizBooleana[xNodo-1][yNodo] ||matrizBooleana[xNodo][yNodo+1]	;

		if( xArista-1==xNodo && yArista+1==yNodo && xNodo<filas && yNodo>=0)
			aux =  matrizBooleana[xNodo+1][yNodo] 	|| 	matrizBooleana[xNodo][yNodo-1];

		if( xArista-1==xNodo && yArista-1==yNodo && xNodo<filas && yNodo<columnas)
			aux =  matrizBooleana[xNodo+1][yNodo] 	||	matrizBooleana[xNodo][yNodo+1];
		return aux;
	}
	public boolean esPosicionValida(int posicionFila, int posicionColumna) {
		return (posicionFila >= 0 && posicionFila < filas && posicionColumna >= 0 && posicionColumna < columnas);
	}
	public boolean get(int i,int j){
		return matrizBooleana[i][j];
	}
	public int getFilas() {
		return filas;
	}

	public int getColumnas() {
		return columnas;
	}
	@Override
	public String toString() {
		String aux = "";
		for (int i = 0; i < filas; i++) {
			for (int j = 0; j < columnas; j++) {
				aux += this.get(i, j)+" ";
			}	
			aux+= "\n";
		}
		return aux;
	}

}
