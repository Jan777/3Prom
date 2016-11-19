package promotionSystem.mapagrafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.IOException;

import promotionSystem.Cliente;
import promotionSystem.Personaje;
import promotionSystem.Punto;
import promotionSystem.juego.Camara;
import promotionSystem.juego.Mouse;
import promotionSystem.sprites.Animacion;
import promotionSystem.sprites.Sprite;


public class TilePersonaje {

	public final static int ANCHO = 64;
	public final static int ALTO = 32;
	private final int xCentro;
	private final int yCentro;
	private String nombre;
	private Mouse mouse;
	
	Personaje personajeJugable;
	private int xInicio;
	private int yInicio;
	private int xDestino;
	private int yDestino;
	
	private boolean nuevoRecorrido;
	private Camara camara;

	private int movimiento;
	private boolean enMovimiento;
	private boolean parado;
	private int movimientoAnterior;
	private Animacion[] animacionCaminado;
	public Image imagen;
	private Cliente cliente;



	public TilePersonaje(Punto punto,Cliente cliente,Mouse mouse,Camara camara) {
		this.cliente=cliente;
		this.xCentro = 320;
		this.yCentro = 320;
		this.camara = camara;
		this.movimiento = 0;
		this.personajeJugable = cliente.getPersonaje();
		this.nombre = cliente.getNombre();	
		this.xInicio = this.xDestino = -punto.getX();  
		this.yInicio = this.yDestino =  -punto.getY(); 
		this.mouse = mouse;
		
		inicializarAnimaciones("RecursosPersonaje/Razas/"+cliente.getCasta()+"/"+cliente.getCasta()+".png");
       
		this.nuevoRecorrido = false; 
		
	}

	public void dibujarCentro(Graphics g) {  
		g.drawImage( obtenerFrameActual() ,xCentro-25, yCentro-50, null);
		Font tipoDeLetra=new Font("Arial", Font.BOLD, 16);
		g.setColor(Color.BLUE);
		g.setFont(tipoDeLetra);
		g.drawString(nombre, xCentro, yCentro-48 /*- 25*/);

	}

	public void actualizar() throws IOException {
		int posMouse[] = mouse.getPos();

		actualizarAnimaciones();

		if (mouse.getRecorrido()) {
			setNuevoRecorrido(true);

			xDestino = xInicio - posMouse[0] + camara.getxOffCamara();
			yDestino = yInicio - posMouse[1] + camara.getyOffCamara();
			cliente.enviarPosicion(new Punto(xDestino*-1,yDestino*-1));
			mouse.setRecorrido(false); 
		}

	}


	public int getXDestino() {
		return xDestino;
	}

	public int getYDestino() {
		return yDestino;
	}

	public void mover(int xDestino2, int yDestino2) {
		xInicio = xDestino2;  
		yInicio = yDestino2;

	}

	public void inicializarAnimaciones(String pathPJ) {
		Sprite spriteCaminando =  new Sprite(pathPJ);
		animacionCaminado = new Animacion[8];
		for (int i = 0; i < animacionCaminado.length; i++) {
			animacionCaminado[i] = new Animacion(100, spriteCaminando.getVectorSprite(i));
		}

	}

	public void actualizarAnimaciones() {
		for (int i = 0; i < 8; i++) {
			animacionCaminado[i].actualizar();
		}

	}

	
	public void paraDondeVoy(int xDestino2, int yDestino2) {
		movimiento = 0;
		parado = false;

		if (xInicio == xDestino2 && yInicio == yDestino2) { 
			parado = true;
			return; 
		}
		if (xInicio > xDestino2 && yInicio > yDestino2) {
			movimiento = 6;
			return;
		}
		if (xInicio > xDestino2 && yInicio == yDestino2) {  
			movimiento = 5;
			return;
		}
		if (xInicio > xDestino2 && yInicio < yDestino2) {
			movimiento = 4;
			return;
		}
		if (xInicio == xDestino2 && yInicio < yDestino2) {
			movimiento = 3;
			return;
		}
		if (xInicio < xDestino2 && yInicio == yDestino2) {
			movimiento = 1;
			return;
		}
		if (xInicio < xDestino2 && yInicio > yDestino2) {
			movimiento = 0;
			return;
		}
		if (xInicio == xDestino2 && yInicio > yDestino2) {
			movimiento = 7;
			return;
		}
		if (xInicio < xDestino2 && yInicio < yDestino2) {
			movimiento = 2;
			return;
		}



	}

	public BufferedImage obtenerFrameActual() {
		if (!parado)
			return animacionCaminado[movimiento].getFrameActual();
		return animacionCaminado[movimientoAnterior].getFrame(8);
	}


	public void setNuevoRecorrido(boolean bs){
		this.nuevoRecorrido = bs;
	}

	public boolean getNuevoRecorrido() {
		return nuevoRecorrido;	
	}


	public boolean estaEnMovimiento() {
		return enMovimiento;
	}


	public void setEnMovimiento(boolean b) {
		this.enMovimiento = b;
	}

	public void parar() {
		movimientoAnterior = movimiento;
		parado = true;
	}



	public int getXCentro() {
		return xCentro;
	}
	public int getYCentro() {
		return yCentro;
	}


	public String getNombre() {
		return personajeJugable.getNombre();
	}



}
