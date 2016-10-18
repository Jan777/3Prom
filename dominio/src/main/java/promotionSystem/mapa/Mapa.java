package promotionSystem.mapa;

import java.util.ArrayList;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public class Mapa {

		private int largo;
		private int ancho;
		private ArrayList<Personaje>personajes;
		
		public Mapa(int largo, int ancho){
			this.largo=largo;
			this.ancho=ancho;
			personajes=new ArrayList<>();
		}
		public boolean posicionValida(Punto punto) {
				return punto.getX()>=0 && punto.getY()>=0 && punto.getX()<largo && punto.getY()<ancho;
		}
		
		
		
}
