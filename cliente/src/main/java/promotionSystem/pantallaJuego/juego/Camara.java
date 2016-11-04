package promotionSystem.pantallaJuego.juego;

import entidades.Entidad;



public class Camara {

	private Juego juego;
	private float posicionY;
	private float pocisionX;

	public Camara(Juego juego, float margenX, float margenY) {
		this.juego = juego;
		this.pocisionX = margenX;
		this.posicionY = margenY;
	}
	
	public void Centrar(Entidad e) {
		pocisionX = e.getX() - juego.getAncho() / 2 + e.getAncho() / 2;
		posicionY = e.getY() - juego.getAlto() / 2 + e.getAlto() / 2;
	}
	
	public void mover(float dx, float dy) {
		pocisionX += dx;
		posicionY += dy;
	}

	public float getyOffset() {
		return posicionY;
	}

	public void setyOffset(float yOffset) {
		this.posicionY = yOffset;
	}

	public float getxOffset() {
		return pocisionX;
	}

	public void setxOffset(float xOffset) {
		this.pocisionX = xOffset;
	}
}
