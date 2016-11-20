package promotionSystem.juego;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.util.List;

import promotionSystem.Personaje;
import promotionSystem.Punto;
import promotionSystem.mapagrafico.dijkstra.Grafo;
import promotionSystem.mapagrafico.dijkstra.MetodoDijkstra;
import promotionSystem.mapagrafico.dijkstra.Nodo;
import promotionSystem.sprites.Animacion;
import promotionSystem.sprites.Sprite;



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
	
	public TileOtrosJugadores (Personaje personaje){
		
		xActual= personaje.getPosicion().getX();
		yActual= personaje.getPosicion().getY();
		this.personaje=personaje;
		inicializarAnimaciones("RecursosPersonaje/Razas/"+personaje.getCasta()+"/"+personaje.getCasta()+".png");
	}
	
	public void dibujar(Graphics2D g2d, int deltaX, int deltaY) {
		deltaX+=xActual;
		deltaY+=yActual;		
		xIsometrica = (deltaX - deltaY) * ( ANCHO / 2) + anchoImagen%64;
		yIsometrica = (deltaX + deltaY) * ( ALTO / 2) + altoImagen%32;
		g2d.drawImage( animacionCaminado[0].getFrame(8), xIsometrica-32,  yIsometrica-48, null);	
		
		g2d.drawImage( animacionCaminado[0].getFrame(8) ,xIsometrica-32,yIsometrica-48-5, null);
		Font tipoDeLetra=new Font("Arial", Font.BOLD, 16);
		g2d.setColor(Color.BLUE);
		g2d.setFont(tipoDeLetra);
		g2d.drawString(personaje.getNombre(), xIsometrica-32,yIsometrica-32-48-2 /*- 25*/);
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

		g2d.drawImage( animacionCaminado[0].getFrameActual(), xIsometrica-32, yIsometrica-32-48 , null);	
		
		Font tipoDeLetra=new Font("Arial", Font.BOLD, 16);
		g2d.setColor(Color.BLUE);
		g2d.setFont(tipoDeLetra);
		g2d.drawString(personaje.getNombre(), xIsometrica-32,yIsometrica-32-48-2 /*- 25*/);
	
	}


	/*public TileOtrosJugadores(String nombre,String sprite, Punto point) {
		xDestino = xActual = xAnterior = point.getX();
		yDestino = yActual = yAnterior = point.getY();
		this.nombre = nombre;
		inicializarAnimaciones("src\\main\\resources\\personajes\\"+sprite+".png");
	}
	public TileOtrosJugadores(Personaje personaje) {
		
		xDestino = xActual = xAnterior = personaje.getPosicion().getX();
		yDestino = yActual = yAnterior = personaje.getPosicion().getY();
		this.nombre =personaje.getNombre();
		inicializarAnimaciones("RecursosPersonaje/Razas/"+personaje.getCasta()+"/"+personaje.getCasta()+".png");
	}
	
	
	public void inicializarAnimaciones(String pathPJ) {
		Sprite spriteCaminando =  new Sprite(pathPJ);
		animacionCaminado = new Animacion[8];
		for (int i = 0; i < animacionCaminado.length; i++) {
			animacionCaminado[i] = new Animacion(100, spriteCaminando.getVectorSprite(i));
		}
	}*/

	public void actualizarAnimaciones() {
		for (int i = 0; i < 8; i++) {
			animacionCaminado[i].actualizar();
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

	/*public void mover(Graphics2D g2d) {
		
		xActual+=xDestino;
		yActual+=yDestino;	

		int nx = (xActual - yActual) * ( 128 / 2);
		int ny = (xActual + yActual) * ( 128 / 2);

		if(xIsometrica < nx)
			xIsometrica+=2;

		if(xIsometrica > nx)
			xIsometrica-=2;

		if(yIsometrica < ny)
			yIsometrica++;

		if(yIsometrica > ny)
			yIsometrica--;

		g2d.drawImage( animacionCaminado[0].getFrameActual(), xIsometrica, yIsometrica-32 , null);	
		Font fuente=new Font("Arial", Font.BOLD, 16);
		g2d.setColor(Color.BLUE);
		g2d.setFont(fuente);
		g2d.drawString(nombre, xIsometrica, yIsometrica - 5);
	}*/
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
		xActual= puntoNuevo.getX();
        yActual=puntoNuevo.getY();
        actualizar();
        actualizarAnimaciones();
	}

	public Personaje getPersonaje() {
		return personaje;
	}
	

}

