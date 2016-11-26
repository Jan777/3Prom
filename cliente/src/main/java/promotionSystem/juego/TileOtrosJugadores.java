package promotionSystem.juego;

import promotionSystem.Personaje;
import promotionSystem.Punto;
import promotionSystem.mapagrafico.dijkstra.Grafo;
import promotionSystem.mapagrafico.dijkstra.MetodoDijkstra;
import promotionSystem.mapagrafico.dijkstra.Nodo;
import promotionSystem.sprites.Animacion;
import promotionSystem.sprites.Sprite;

import java.awt.*;
import java.util.List;



public class TileOtrosJugadores {
	protected int anchoImagen = 128;
	protected int altoImagen = 128;
	public final static int ANCHO = 64;
	public final static int ALTO = 32;
	private Animacion[] animacionCaminado;
	private int xActual;
	private int yActual;
	private int xDestino;
	private int yDestino;
	protected int xIsometrica; 
	protected int yIsometrica;
	private List<Nodo> camino;
	private int xAnterior;
	private int yAnterior;
	private Nodo paso;
	private String nombre;
	MetodoDijkstra moverPersonaje;
	private Personaje personaje;
	private int movimiento;
	private boolean parado;
	
	public TileOtrosJugadores (Personaje personaje, int deltaX, int deltaY){
		
		xActual= personaje.getPosicion().getX();
		yActual= personaje.getPosicion().getY();
		this.personaje=personaje;
		
		setPosicionesIsometricas(deltaX, deltaY);
	
		inicializarAnimaciones("Recursos/Recursos Personaje/Razas/"+personaje.getCasta()+"/"+personaje.getCasta()+".png");
	}
	
	public TileOtrosJugadores(Personaje personaje) {
		xActual= personaje.getPosicion().getX();
		yActual= personaje.getPosicion().getY();
		this.personaje=personaje;
		inicializarAnimaciones("Recursos/Recursos Personaje/Razas/"+personaje.getCasta()+"/"+personaje.getCasta()+".png");
	}

	public void dibujar(Graphics2D g2d, int deltaX, int deltaY) {
		setPosicionesIsometricas(deltaX, deltaY);
		
		g2d.drawImage( animacionCaminado[movimiento].getFrame(8) ,xIsometrica-32,yIsometrica-48-5, null);
		Font tipoDeLetra=new Font("Arial", Font.BOLD, 16);
		g2d.setColor(Color.BLUE);
		g2d.setFont(tipoDeLetra);
		
		g2d.drawString("Nv. " +String.valueOf(personaje.getNivel()), xIsometrica-32, yIsometrica-32-48-50);
		g2d.drawString(String.valueOf(personaje.getSalud())+ " / " + String.valueOf(personaje.getSaludMaxima()),xIsometrica-32, yIsometrica-32-48-80);
		g2d.drawString(personaje.getNombre(), xIsometrica-32,yIsometrica-32-48-2 );
	}
	
	
	public void inicializarAnimaciones(String pathPJ) {
		Sprite spriteCaminando =  new Sprite(pathPJ);
		animacionCaminado = new Animacion[8];
		for (int i = 0; i < animacionCaminado.length; i++) {
			animacionCaminado[i] = new Animacion(100, spriteCaminando.getVectorSprite(i));
		}
	}
	public void mover(Graphics2D g2d, int x2, int y2) {


		x2+=xActual;
		y2+=yActual;	

		int nx = (x2 - y2) * ( ANCHO / 2);
		int ny = (x2 + y2) * ( ALTO / 2);

		if(xIsometrica < nx){
			xIsometrica+=2;
		}
		if(xIsometrica > nx){
			xIsometrica-=2;
		}

		if(yIsometrica < ny){
			yIsometrica++;
		}
		if(yIsometrica > ny){
			yIsometrica--;
		}
		

		if(!parado){
			g2d.drawImage( animacionCaminado[movimiento].getFrameActual(), xIsometrica-32, yIsometrica-32-48 , null);	
			
			Font tipoDeLetra=new Font("Arial", Font.BOLD, 16);
			g2d.setColor(Color.BLUE);
			g2d.setFont(tipoDeLetra);
			g2d.drawString(personaje.getNombre(), xIsometrica-32,yIsometrica-32-48-20);
			g2d.drawString("Nv. " +String.valueOf(personaje.getNivel()), xIsometrica-32, yIsometrica-32-48-38);
			g2d.drawString(String.valueOf(personaje.getSalud())+ " / " + String.valueOf(personaje.getSaludMaxima()),xIsometrica-32, yIsometrica-32-48-2);
		}
		
	
	}

	public void actualizarAnimaciones() {
		if(!parado){
			for (int i = 0; i < 8; i++) {
				animacionCaminado[i].actualizar();
			}		
		}
	}
	public int getxDestino() {
		return xDestino;
	}
	public int getyDestino() {
		return yDestino;
	}
	public void calcularDijkstra(Grafo grafoDeMapa, Nodo actual, Nodo destino) {
		moverPersonaje 	= 	new MetodoDijkstra();
		camino 		=	moverPersonaje.obtenerCamino(destino);
		
	}

	private void moverUnPaso() { 
		if(camino == null || camino.isEmpty() )
			return;
		paso = camino.get(0);
		xAnterior = xDestino;
		yAnterior = yDestino;
		xDestino = paso.getPunto().getX();
		yDestino = paso.getPunto().getY();
		camino.remove(0);
		
	}

	public void actualizar() {
		if(xActual==xDestino &&	yActual==yDestino ){
			moverUnPaso();
		}		
	}

	public int getyAnterior() {
		return yAnterior;
	}
	public int getxAnterior() {
		return xAnterior;
	}

	@Override
	public String toString() {
		return this.nombre +" "+xDestino+" : "+yDestino;
	}

	public void setPuntoDestino(Punto puntoNuevo) {
		paraDondeVoy(puntoNuevo.getX(), puntoNuevo.getY());
		xActual= puntoNuevo.getX();
        yActual=puntoNuevo.getY();
        actualizarAnimaciones();
	}

	public Personaje getPersonaje() {
		return personaje;
	}
	
	public void paraDondeVoy(int xDestino2, int yDestino2) {
		movimiento = 0;
		parado = false;

		if (xActual == xDestino2 && yActual == yDestino2) { 
			parado = true;
			return; 
		}
		if (xActual > xDestino2 && yActual > yDestino2) {
			movimiento = 2;
			return;
		}
		if (xActual > xDestino2 && yActual == yDestino2) {  
			movimiento = 1;
			return;
		}
		if (xActual > xDestino2 && yActual < yDestino2) {
			movimiento = 0;
			return;
		}
		if (xActual == xDestino2 && yActual < yDestino2) {
			movimiento = 7;
			return;
		}
		if (xActual < xDestino2 && yActual == yDestino2) {
			movimiento = 5;
			return;
		}
		if (xActual < xDestino2 && yActual > yDestino2) {
			movimiento = 4;
			return;
		}
		if (xActual == xDestino2 && yActual > yDestino2) {
			movimiento = 3;
			return;
		}
		if (xActual < xDestino2 && yActual < yDestino2) {
			movimiento = 6;
			return;
		}



	}

	public void setPosicionesIsometricas(int deltaX, int deltaY) {
		deltaX+=xActual;
		deltaY+=yActual;		
		xIsometrica = (deltaX - deltaY) * ( ANCHO / 2) + anchoImagen%64;
		yIsometrica = (deltaX + deltaY) * ( ALTO / 2) + altoImagen%32;
		
	}


	

}

