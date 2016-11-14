package promootionSystem.graficaNuestra;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;

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
	private Image imagenInicial;
	
	private boolean nuevoRecorrido;
	


	
	public TilePersonaje(int x, int y, int sprite,String nombre,Mouse mouse,Image imagen) {
		this.xCentro =386;
		this.yCentro = 280;
		this.tipoDeSprite = sprite;
		this.nombre = nombre;	
		this.mouse = mouse;
		this.imagenInicial=imagen;
		xInicio=x+400;
		yInicio=y+300;
	}

	public void setxInicio(int xInicio) {
		this.xInicio = xInicio;
	}

	public void setyInicio(int yInicio) {
		this.yInicio = yInicio;
	}

	
	public void dibujarCentro(Graphics g) {
		
		
		g.drawImage( imagenInicial, xCentro, yCentro, null);
		Font fuente=new Font("Arial", Font.BOLD, 16);
		g.setColor(Color.BLUE);
		g.setFont(fuente);
		g.drawString(nombre, xInicio+12, yInicio-17);

	}

	public void actualizar() {
		int posMouse[] = mouse.getPos();
		

		if (mouse.getRecorrido()) {
			
			setNuevoRecorrido(true);
			xDestino = xInicio - posMouse[0] + Mapa.DESPLAZAMIENTO_EN_X_PARA_PASAR_DE_2D_A_ISOMETRICO;
			yDestino = yInicio - posMouse[1] + Mapa.DESPLAZAMIENTO_EN_Y_PARA_PASAR_DE_2D_A_ISOMETRICO;
			
			
			
			
			boolean diagonalInfIzq = false;
			boolean diagonalInfDer = false;
			boolean diagonalSupIzq = false;
			boolean diagonalSupDer = false;
			boolean vertical = false;
			boolean horizontal = false;
			boolean enMovimiento = false;
			int yFinal = 0;
			int difX = 0;
			int ancho = 0;
			if (difX < ancho && yInicio != yFinal) {
				vertical = true;
				horizontal = true;
			}
			int xFinal = 0;
			int difY = 0;
			int alto = 0;
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
			 
			mouse.setRecorrido(false); 
			enMovimiento = true;// Cuando llego a destino tengo que poner esto en false
		}

	}


	
	public int getXDestino() {
		return xDestino;
	}

	public int getYDestino() {
		return yDestino;
	}
	
	public void mover() {
		
		xInicio = xDestino;  
		yInicio = yDestino;	
		setNuevoRecorrido(false); 
	}
		
	public void setNuevoRecorrido(boolean bs){
		this.nuevoRecorrido = bs;
	}
	
	public boolean getNuevoRecorrido() {
		return nuevoRecorrido;
		
	}

	public int getxCentro() {
		return xCentro;
	}

	public void setxCentro(int xCentro) {
		this.xCentro = xCentro;
	}

	public int getyCentro() {
		return yCentro;
	}

	public void setyCentro(int yCentro) {
		this.yCentro = yCentro;
	}

	public Image getImagenInicial() {
		return imagenInicial;
	}

	




}
