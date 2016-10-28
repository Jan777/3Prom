package promotionSystem.mapa;

import java.util.ArrayList;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public class Mapa {

		private int largo;
		private int ancho;
		private String nombre;
		private ArrayList<Personaje>personajes;
		private ArrayList<Obstaculo>obstaculos;
		
		public Mapa(int largo, int ancho){
			this.largo = largo;
			this.ancho = ancho;
			personajes = new ArrayList<Personaje>();
			obstaculos = new ArrayList<Obstaculo>();
		}
		public boolean posicionValida(Punto punto) {
				return punto.getX()>=0 && punto.getY()>=0 && punto.getX()<largo && punto.getY()<ancho && !hayObstaculo(punto);
		}
		
		private boolean hayObstaculo(Punto punto) {
			for(Obstaculo obstaculo : obstaculos){
				if(obstaculo.chocaConObstaculo(punto)){
					return true;
				}
			}
			return false;
		}
		
		public void agregarObstaculo(Obstaculo obstaculo) {
			obstaculos.add(obstaculo);
		}
}
