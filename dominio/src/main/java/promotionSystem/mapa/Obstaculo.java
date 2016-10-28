package promotionSystem.mapa;

import promotionSystem.Punto;

public class Obstaculo {

	Rectangulo obstaculo;
	
	public Obstaculo(Punto puntoInferiorIzquierdo, int largo, int ancho){
		obstaculo = new Rectangulo(puntoInferiorIzquierdo, largo, ancho);
	}
	
	public boolean chocaConObstaculo(Punto puntoFinal){
		return obstaculo.hayColision(puntoFinal);
	}

}
