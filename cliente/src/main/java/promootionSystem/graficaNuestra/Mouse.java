package promootionSystem.graficaNuestra;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Mouse implements MouseListener{
	private int x;
	private int y;
	private int[] pos;
	private boolean recorrido;
	
	public Mouse() {
		pos = new int[2];
		x=0;
		y=0;
		

	}

	@Override
	public void mouseClicked(MouseEvent evento) {
		if(evento.getButton()==MouseEvent.BUTTON3){
		x = evento.getX();
		y = evento.getY();
		
		
		}
		

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		
		
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	@Override
	public void mouseExited(MouseEvent e) {
	
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	
		
	}
	
public void actualizar() {
		
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

		pos[0] = auxX;
		pos[1] = auxY;

	}

public int[] getPos() {
	return pos;
}

public void setPos(int[] pos) {
	this.pos = pos;
}

public boolean isRecorrido() {
	return recorrido;
}

public void setRecorrido(boolean recorrido) {
	this.recorrido = recorrido;
}

public boolean getRecorrido(){
	return recorrido;
}
	
}

	
	
	
