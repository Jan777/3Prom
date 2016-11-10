package promootionSystem.graficaNuestra;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class TilePersonaje {
	
	private int xCentro;
	private int yCentro;
	private int tipoDeSprite;
	private String nombre;
	private Mouse mouse ;
	
	private int xInicio;
	private int yInicio;
	private int xDestino;
	private int yDestino;
	// Movimiento Actual
	private boolean nuevoRecorrido;
	
	/*
	private boolean horizontal;
	private boolean vertical;
	private boolean diagonalInfIzq;
	private boolean diagonalInfDer;
	private boolean diagonalSupIzq;
	private boolean diagonalSupDer;
	*/

	
	public TilePersonaje(int x, int y, int sprite,String nombre,Mouse mouse) {
		this.xCentro = 320;
		this.yCentro = 320;
		this.tipoDeSprite = sprite;
		this.nombre = nombre;	
		this.mouse = mouse;
	}

	public void setxInicio(int xInicio) {
		this.xInicio = xInicio;
	}

	public void setyInicio(int yInicio) {
		this.yInicio = yInicio;
	}

	/**
	 * Ver si le mando las coordenadas donde  esto al personaje.
	 * @param g2d
	 * @param deltaX
	 * @param deltaY
	 */
	public void dibujarCentro(Graphics g) {
		g.drawImage( Mapa.getImage(tipoDeSprite), xCentro, yCentro, null);
		Font fuente=new Font("Arial", Font.BOLD, 16);
		g.setColor(Color.RED);
		g.setFont(fuente);
		g.drawString(nombre, xCentro+17, yCentro);

	}

	public void actualizar() {
		int posMouse[] = mouse.getPos();
		

		if (mouse.getRecorrido()) {
			
			setNuevoRecorrido(true);
			xDestino = xInicio - posMouse[0] + JuegoPanel.xOffCamara;
			yDestino = yInicio - posMouse[1] + JuegoPanel.yOffCamara;
			

			
			//esto es para animaciones no le des bola:
			/*
			diagonalInfIzq = false;
			diagonalInfDer = false;
			diagonalSupIzq = false;
			diagonalSupDer = false;
			vertical = false;
			horizontal = false;
			enMovimiento = false;
			if (difX < ancho && yInicio != yFinal) {
				vertical = true;
				horizontal = true;
			}
			if (difY < alto && xInicio != xFinal) {
				horizontal = true;
				vertical = true;
			}

			if (!vertical && !horizontal) {
				if (xFinal > xInicio && yFinal > yInicio) {
					diagonalInfDer = true;
				} else if (xFinal < xInicio && yFinal > yInicio) {
					diagonalInfIzq = true;
				} else if (xFinal > xInicio && yFinal < yInicio) {
					diagonalSupDer = true;
				} else if (xFinal < xInicio && yFinal < yInicio) {
					diagonalSupIzq = true;
				}
			}
			 */
			mouse.setRecorrido(false); 
		//	enMovimiento = true;// Cuando llego a destino tengo que poner esto en false
		}

	}


	/**
	 * Por un extraño motivo dan negativas :c
	 * @return
	 */
	public int getXDestino() {
		return xDestino;
	}

	public int getYDestino() {
		return yDestino;
	}
	
	public void mover() {
		//me muevo de inicio  a fin.
		xInicio = xDestino;  
		yInicio = yDestino;	
		setNuevoRecorrido(false); // cuando me muevo ya no es nuevo recorrido.
	}
		
	public void setNuevoRecorrido(boolean bs){
		this.nuevoRecorrido = bs;
	}
	
	public boolean getNuevoRecorrido() {
		return nuevoRecorrido;
		
	}




}
