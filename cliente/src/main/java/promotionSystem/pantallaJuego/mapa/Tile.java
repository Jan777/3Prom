package promotionSystem.pantallaJuego.mapa;

import java.awt.Graphics;
import java.awt.image.BufferedImage;

public class Tile {
	protected BufferedImage textura;
	protected final int id;
	
	public static Tile[] tiles = new Tile[256];
	public static Tile piso = new Suelo(0);
	public static Tile obstruccion = new Obstruccion(1);
	
	public static final int ANCHO = 64;
	public static final int ALTO = 32;
	
	
	
	public Tile(BufferedImage textura, int id) {
		this.textura = textura;
		this.id = id;
		
		tiles[id] = this;
	}
	
	public void actualizar() {
	    // nos falto implementar
	}
	
	public boolean esSolido() {
		return false;
	}
	
	public void graficar(Graphics g, int x, int y) {
		g.drawImage(textura, x, y, ANCHO, ALTO, null);
	}
	
	public int getId() {
		return id;
	}
}
