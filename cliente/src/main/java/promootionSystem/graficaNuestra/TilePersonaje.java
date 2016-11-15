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
	private Camara camara;


	
	public TilePersonaje(int x, int y, int sprite,String nombre,Mouse mouse,Image imagen,Camara camara) {
		this.xCentro =386; //320
		this.yCentro = 280; //320
		this.tipoDeSprite = sprite;
		this.nuevoRecorrido = false; // revisar
		this.camara=camara;
		this.nombre = nombre;	
		this.mouse = mouse;
		this.imagenInicial=imagen;
		xInicio=-x;
		yInicio=-y;
		xDestino=-x;
		yDestino=-y;
	}

	public Mouse getMouse() {
		return mouse;
	}

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
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

	
	

	public int getxCentro() {
		return xCentro;
	}

	
	public int getyCentro() {
		return yCentro;
	}

	
	public Image getImagenInicial() {
		return imagenInicial;
	}

	public void resetear() {
		xDestino=0;
		yDestino=0;
		
	}

	public void actualizar() {
		int posMouse[] = mouse.getPos();

		

		if (mouse.getRecorrido()) {
			setNuevoRecorrido(true);

			xDestino = xInicio - posMouse[0] + camara.getxOffCamara();
			yDestino = yInicio - posMouse[1] + camara.getyOffCamara();
			mouse.setRecorrido(false); 
		}

	}

	public int getxDestino() {
		return xDestino;
	}

	public void setxDestino(int xDestino) {
		this.xDestino = xDestino;
	}

	public int getyDestino() {
		return yDestino;
	}

	public void setyDestino(int yDestino) {
		this.yDestino = yDestino;
	}

	public boolean isNuevoRecorrido() {
		return nuevoRecorrido;
	}

	public void setNuevoRecorrido(boolean nuevoRecorrido) {
		this.nuevoRecorrido = nuevoRecorrido;
	}

	




}
