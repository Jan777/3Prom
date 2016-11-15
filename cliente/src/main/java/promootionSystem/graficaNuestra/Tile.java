package promootionSystem.graficaNuestra;

import java.awt.Graphics2D;

public class Tile {
	public final static int ANCHO = 64;
	public final static int ALTO = 32;

	protected int tipoDeSprite;
	protected int posicionX;
	protected int posicionY;
	private boolean obstaculo;
	protected int posicionXConvertida; 
	protected int posicionYConvertida;
	protected int altoImagen;

	
	public Tile(int x, int y, int sprite) {
		this.posicionX = x;
		this.posicionY = y;
		this.tipoDeSprite = sprite;
		this.altoImagen = Tile.ALTO;
	}
	public Tile(int x, int y, int sprite,int altoImagen) {
		this.posicionX = x;
		this.posicionY = y;
		this.tipoDeSprite = sprite;
		this.altoImagen = altoImagen;
	}

	public void dibujar(Graphics2D g2d, int deltaX, int deltaY) {
		deltaX+=posicionX;
		deltaY+=posicionY;		
		posicionXConvertida = (deltaX - deltaY) * ( ANCHO / 2);
		posicionYConvertida = (deltaX + deltaY) * ( ALTO / 2);
		g2d.drawImage( Mapa.getImage(tipoDeSprite),posicionXConvertida,posicionYConvertida , null);		
			
	}

	
}
