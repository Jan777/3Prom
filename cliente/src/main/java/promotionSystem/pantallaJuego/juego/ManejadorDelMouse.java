package promotionSystem.pantallaJuego.juego;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ManejadorDelMouse implements MouseListener {
	
	private int x;
	private int y;
	private int posicionClick[];
	private boolean recorrido;
	
	
	public ManejadorDelMouse() {
		posicionClick = new int[2];
	}
	
	public void actualizar() {
		posicionClick[0] = x;
		posicionClick[1] = y;
	}
	
	

	@Override
	public void mouseEntered(MouseEvent arg0) {
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		
	}
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getButton()==MouseEvent.BUTTON3){
			x = e.getX();
			y = e.getY();
			recorrido = true;			
		}
	}
	
	public int[] obtenerPosicionClick() {
		return posicionClick;
	}

	public boolean getNuevoRecorrido() {
		return recorrido;
	}
	
	public void setNuevoRecorrido(boolean b) {
		recorrido = b;
	}

}
