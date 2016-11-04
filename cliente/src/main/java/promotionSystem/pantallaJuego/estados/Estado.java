package promotionSystem.pantallaJuego.estados;

import promotionSystem.pantallaJuego.juego.*;

import java.awt.Graphics;



public abstract class Estado {

	private static Estado estadoActual = null; 
 
	protected Juego juego;
	
	public Estado(Juego juego) {
		this.juego = juego;
	}
	
	public abstract void actualizar();
	
	public abstract void graficar(Graphics g);
	
	public static void setEstado(Estado estado) {
		estadoActual = estado;
	}
	
	public static Estado getEstado() {
		return estadoActual;
	}
}
