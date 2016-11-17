package promotionSystem.mapagrafico;
import java.awt.Graphics2D;

import promotionSystem.sprites.Sprite;



public class Tile {

	public final static int ANCHO = 64;
	public final static int ALTO = 32;

	protected int realX;		
	protected int realY;
	protected int xIsometrica; 	
	protected int yIsometrica;	
	protected int tipoDeSprite;



	public Tile(int posicionX, int posicionY, int sprite) {
		this.realX = posicionX;
		this.realY = posicionY;
		this.tipoDeSprite = sprite;
	}


	public void dibujar(Graphics2D g2d, int deltaX, int deltaY) {
		deltaX+=realX;
		deltaY+=realY;		
		xIsometrica = (deltaX - deltaY) * ( ANCHO / 2);
		yIsometrica = (deltaX + deltaY) * ( ALTO / 2) ;
		g2d.drawImage( Sprite.getImagePiso(tipoDeSprite), 0, 0 , null);			
	}

	public void mover(Graphics2D g2d, int x2, int y2) {


		x2+=realX;
		y2+=realY;	

		int nx = (x2 - y2) * ( ANCHO / 2);
		int ny = (x2 + y2) * ( ALTO / 2);

		if(xIsometrica < nx){
			xIsometrica+=2;
		}
		if(xIsometrica > nx){
			xIsometrica-=2;
		}

		if(yIsometrica < ny){
			yIsometrica+=1;
		}
		if(yIsometrica > ny){
			yIsometrica-=1;
		}
		g2d.drawImage( Sprite.getImagePiso(tipoDeSprite), xIsometrica, yIsometrica , null);	
	}

	public int getPosicionIsometricaX() {
		return xIsometrica;
	}
	public int getPosicionIsometricaY() {
		return yIsometrica;
	}
}
