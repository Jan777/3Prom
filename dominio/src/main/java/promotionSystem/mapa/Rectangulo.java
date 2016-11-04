package promotionSystem.mapa;

import promotionSystem.Punto;

import java.util.ArrayList;
import java.util.List;

public class Rectangulo {

	private Punto puntoInferiorIzquierdo;
	private int largo;
	private int ancho;
	private List<Punto> puntos;
	
	public Rectangulo(Punto puntoInferiorIzquierdo, int largo, int ancho){
		this.puntoInferiorIzquierdo = puntoInferiorIzquierdo;
		this.largo = largo;
		this.ancho = ancho;
		this.puntos = new ArrayList<>();
		for(int i = 0; i < ancho ; i++){
			for(int j = 0; j < largo ; j++){
				puntos.add(new Punto(i+puntoInferiorIzquierdo.getX(), j+puntoInferiorIzquierdo.getX()));
			}
		}
	}
	
	public boolean hayColision(Punto puntoFinal){
		for(Punto punto : puntos){
		    if(punto.compareTo(puntoFinal) == 0){
		        return true;
            }
        }
        return false;
	}

	public List<Punto> getPuntos(){
		return puntos;
	}
}
