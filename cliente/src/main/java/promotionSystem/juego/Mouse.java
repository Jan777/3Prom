package promotionSystem.juego;

import promotionSystem.mapagrafico.Tile;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;


public class Mouse implements MouseListener{

	private int x;
	private int y;
	private int[] pos;
	private int[] posicionClickIzquierdo;
	private int xClickIzquierdo;
	private int yClickIzquierdo;
	private boolean recorrido;
	private boolean clickIzquierdo;
	public Mouse() {
		pos = new int[2];
		posicionClickIzquierdo= new int[2];
		xClickIzquierdo=0;
		yClickIzquierdo=0;
		x=0;
		y=0;
	}
	@Override
	public void mouseClicked(MouseEvent evento) {
		if(evento.getButton()==MouseEvent.BUTTON3){
			x = evento.getX();
			y = evento.getY();
			recorrido = true;			
		}
		else if(evento.getButton()==MouseEvent.BUTTON1){
			xClickIzquierdo = evento.getX();
			yClickIzquierdo = evento.getY();
			clickIzquierdo=true;
		}
			
	}
	
	
	public boolean getRecorrido(){
		return recorrido;
	}
	public void setRecorrido(boolean b) {
		recorrido = b;
	}
	public void actualizar() {
		
		actualizarSegunClick(x,y,pos);

	}
	public void actualizarClickIzquierdo() {
		
		actualizarSegunClick(xClickIzquierdo,yClickIzquierdo,posicionClickIzquierdo);

	}
	private void actualizarSegunClick(int x,int y,int[]posicion) {
		int x0 = x - ( Tile.ANCHO / 2 );
		int y0 = y;

		int auxX = y0 + (x0 / 2);
		int auxY = y0 - (x0 / 2);

		if(auxX < 0)
			auxX -= 31;
		if(auxY < 0)
			auxY -= 31;


		auxX /= 32;
		auxY /= 32;

		posicion[0] = auxX;
		posicion[1] = auxY;
	}
	
	
	public int[] getPos() {
		return pos;
	}
	@Override
	public String toString() {
		return pos[0]+" : "+pos[1];
	}
	
	@Override
	public void mouseEntered(MouseEvent evento) {}

	@Override
	public void mouseExited(MouseEvent evento) {}

	@Override
	public void mousePressed(MouseEvent evento) {}

	@Override
	public void mouseReleased(MouseEvent evento) {}
	
	public int[] getPosicionClickIzquierdo() {
		return posicionClickIzquierdo;
	}
	public boolean getClickIzquierdo() {
		return clickIzquierdo;
	}
	public void setClickIzquierdo(boolean valor) {
		clickIzquierdo=valor;
		
	}

}
