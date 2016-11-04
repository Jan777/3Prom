package promotionSystem.pantallaJuego.juego;

import entidades.Entidad;



public class Camara {

	private Juego juego;
	private float margenY;
	private float margenX;

	public Camara(Juego juego, float margenX, float margenY) {
		this.juego = juego;
		this.margenX = margenX;
		this.margenY = margenY;
	}
	
	public void Centrar(Entidad e) {
		margenX = e.getX() - juego.getAncho() / 2 + e.getAncho() / 2;
		margenY = e.getY() - juego.getAlto() / 2 + e.getAlto() / 2;
	}
	
	public void mover(float dx, float dy) {
		margenX += dx;
		margenY += dy;
	}

	public float getyOffset() {
		return margenY;
	}

	public void setyOffset(float yOffset) {
		this.margenY = yOffset;
	}

	public float getxOffset() {
		return margenX;
	}

	public void setxOffset(float xOffset) {
		this.margenX = xOffset;
	}
}
