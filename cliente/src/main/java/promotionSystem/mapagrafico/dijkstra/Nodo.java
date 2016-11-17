package promotionSystem.mapagrafico.dijkstra;

import java.util.ArrayList;
import java.util.List;

import promotionSystem.Punto;

;


public class Nodo {
	private Punto punto;
	List<Nodo> nodosAdyacentes;

	
	public Nodo(final Punto punto) {
		this.punto = punto;
		nodosAdyacentes = new ArrayList<>();
	}


	public Punto getPunto() {
		return punto;
	}

	public void setPos(Punto punto) {
		this.punto = punto;
	}

	public void agregarConexion(Nodo nodo) {
		nodosAdyacentes.add(nodo);
	}

	public void agregarConexionPunto(Punto nodo) {
		nodosAdyacentes.add(new Nodo(nodo));
	}

	public double calcularDistanciaNodos(Nodo nodo) {
		return this.getPunto().distanciaCon(nodo.getPunto());
	}

	@Override
	public String toString() {
		String aux = punto+": ";
		for (Nodo nodo : nodosAdyacentes)
			aux += nodo.punto.toString() + " ";
		return aux;
	}

	public Nodo clone() {
		Nodo nodoAClonar = new Nodo(this.getPunto());
		nodoAClonar.nodosAdyacentes = new ArrayList<>();

		for (Nodo nodo : this.nodosAdyacentes) {
			nodoAClonar.agregarConexion(nodo);
		}
		return nodoAClonar;
	}



	public boolean equals(Nodo nodo) {

		if (this.getPunto().equals(nodo.getPunto()))
			return true;

		return false;
	}


	
	public boolean esAdyacente(Nodo nodo){
		
		if(this.nodosAdyacentes.contains(nodo))
			return true;
		
		if(nodo.nodosAdyacentes.contains(this))
			return true;
		
		return false;
	}

	public int getPeso(Nodo vecino) {
		if( noEsDiagonal(vecino) )
			return 2;
		return 3;
	}

	private boolean noEsDiagonal(Nodo vecino) {
		return this.getPunto().getX() == vecino.getPunto().getX() || this.getPunto().getY() == vecino.getPunto().getY() ;
	}
	


}
