package promotionSystem.mapa;

import promotionSystem.Punto;

public class Rectangulo {

	Punto puntoInferiorIzquierdo;
	int largo;
	int ancho;
	
	public Rectangulo(Punto puntoInferiorIzquierdo, int largo, int ancho){
		this.puntoInferiorIzquierdo = puntoInferiorIzquierdo;
		this.largo = largo;
		this.ancho = ancho;
	}
	
	public boolean hayColision(Punto puntoFinal){
		return (puntoFinal.getX() >= puntoInferiorIzquierdo.getX() && puntoFinal.getX() <= puntoInferiorIzquierdo.getX()+largo && puntoFinal.getY() >= puntoInferiorIzquierdo.getY() && puntoFinal.getY() <= puntoInferiorIzquierdo.getY()+ ancho);
	}
}
