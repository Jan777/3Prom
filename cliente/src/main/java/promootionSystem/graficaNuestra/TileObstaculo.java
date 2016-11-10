package promootionSystem.graficaNuestra;

import java.awt.Graphics2D;

public class TileObstaculo extends Tile{
	protected int anchoImagen;
	protected int altoImagen;


	public TileObstaculo(int x, int y, int sprite,int anchoImagen,int altoImagen) {
		super(x, y, sprite);
		this.anchoImagen = anchoImagen;
		this.altoImagen = altoImagen;
	}

	public void dibujar(Graphics2D g2d, int deltaX, int deltaY) {
		deltaX+=posicionX;
		deltaY+=posicionY;		
		posicionXConvertida = (deltaX - deltaY) * ( ANCHO / 2)- anchoImagen%64;
		posicionYConvertida = (deltaX + deltaY) * ( ALTO / 2) - altoImagen%32;
		g2d.drawImage( Mapa.getImage(tipoDeSprite),posicionXConvertida, posicionYConvertida-64 , null);			
	}

	public void mover(Graphics2D g2d, int x2, int y2) {


		x2+=posicionX;
		y2+=posicionY;	

		int nx = (x2 - y2) * ( ANCHO / 2);
		int ny = (x2 + y2) * ( ALTO / 2);

		
		
	
		if(posicionXConvertida < nx){
			posicionXConvertida+=2;
		}
		if(posicionXConvertida > nx){
			posicionXConvertida-=2;
		}

		if(posicionYConvertida < ny){
			posicionYConvertida++;
		}
		if(posicionYConvertida > ny){
			posicionYConvertida--;
		}

		g2d.drawImage( Mapa.getImage(tipoDeSprite), posicionXConvertida, posicionYConvertida-32 , null);	
	}

}
