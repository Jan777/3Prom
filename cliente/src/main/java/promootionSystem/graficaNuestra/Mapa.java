package promootionSystem.graficaNuestra;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import javax.swing.ImageIcon;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public class Mapa {
	protected int id;
	protected int alto;
	protected int ancho;
	protected String nombre;
	public static final int DESPLAZAMIENTO_EN_X_PARA_PASAR_DE_2D_A_ISOMETRICO=16;
	public static final int DESPLAZAMIENTO_EN_Y_PARA_PASAR_DE_2D_A_ISOMETRICO=4;


	protected int x;
	protected int y;

	protected boolean enMovimiento;

    private int tipoDeSprite;
    private int cantidadDeSprites; 
	private static Image[] spritesDelMapa;	
	protected Tile[][] tiles;
	protected TileObstaculo[][]  tilesObstaculo; 
	protected boolean[][] obstaculos; 
	protected TilePersonaje personajeJugable; // cliente
	protected Map<String,Personaje> personajes; // esto server
	protected Camara camara;
	protected int posicionX;
	protected int posicionY;

	protected int xDestino;
	protected int yDestino;
	protected int xActual;
	protected int yActual;
	int xCentro ;
	int yCentro; 

	/*protected Grafo grafoDeObstaculo;
	protected List<Nodo> camino;
	private Nodo nodoActual;*/

	public Mapa(String nombre,TilePersonaje pj) throws FileNotFoundException {
		File path = new File("recursos/"+nombre+".txt");
		this.personajeJugable = pj;
		enMovimiento = false;
		Punto punto=new Punto(2,2);
		Punto isometrico=new Punto(punto.getX()*32,punto.getY()*32);
		
		//xDestino = pj.getXDestino();
		//yDestino = pj.getYDestino();
		 //xCentro = pj.getxCentro()-posicionX;
		 //yCentro = pj.getyCentro()-posicionY;
		 
		// xCentro = pj.getxCentro();
		 //yCentro = pj.getyCentro();
		
		xDestino=-punto.getX();
		yDestino=-punto.getY();
		

		xActual = -xDestino;
		yActual = -yDestino;

		this.nombre = nombre;
		//spriteDelMapa = new Image[7];

		
			Scanner sc = new Scanner(path);
		
		this.id = sc.nextInt();
		this.ancho=sc.nextInt();
		this.alto=sc.nextInt();
		camara=new Camara(alto,ancho,382-0*32,281-0*32);
		cantidadDeSprites=sc.nextInt();
		spritesDelMapa=new Image[cantidadDeSprites];
		cargarSprites(nombre);

		this.tiles = new Tile[ancho][alto];
		this.tilesObstaculo  = new TileObstaculo[ancho][alto];
		this.obstaculos = new boolean[ancho][alto];
		/**
		 * no hace falta pero para que se entienda
		 */
		
		for (int i = 0; i < ancho ; i++) {
			for (int j = 0; j < alto; j++) {
				tipoDeSprite = sc.nextInt();
				
				tiles[i][j] = new Tile(i,j,tipoDeSprite);
				
			}
		}
		int obstaculo;
		for (int i = 0; i < ancho ; i++) {
			for (int j = 0; j < alto; j++) {
				obstaculo = sc.nextInt();
				obstaculos[i][j] = obstaculo>=1?true:false;
				if(obstaculos[i][j]){
				tilesObstaculo[i][j]=new TileObstaculo(i,j,2,64,64);
				}
			}
		}

		/*grafoDeObstaculo = new Grafo(new MatrizBoolean(obstaculos, ancho, alto));
		camino = new ArrayList<Nodo>();*/



		sc.close();
		this.personajes=new HashMap<String,Personaje>();
	}


private void cargarSprites(String nombre) {
		
		for(int i=0;i<cantidadDeSprites;i++){
			spritesDelMapa[i]= loadImage("recursos/"+nombre+"/sprite"+ i + ".png" );
		}
		
		
	}


	public boolean EnMovimiento() {
		return enMovimiento;
	}

	
	

	public static Image loadImage(String path) {
		ImageIcon i = new ImageIcon(path);
		return i.getImage();
	}
	public static Image getImage(int sprite) {
		return spritesDelMapa[sprite];
	}

	public int getId() {
		return this.id;
	}

	public boolean posicionValida(int x, int y){
		return dentroDelMapa(-personajeJugable.getXDestino(),-personajeJugable.getYDestino()) && ! hayObstaculo(-personajeJugable.getXDestino(),-personajeJugable.getYDestino());


	}

	
	public boolean hayObstaculo(int x,int y){
		return obstaculos[x][y];
	}

	private boolean dentroDelMapa(int x, int y) {
		return x>=0 && y>=0 && x<alto && y<ancho;
	}


	public void agregarPersonaje(Personaje pj){
		personajes.put(pj.getNombre(), pj);
	}

	/*public boolean recibirMensajeMovmiento(MensajeMovimiento men){
		Personaje aMover = personajes.get(men.getEmisor());

		if(aMover.isPuedoMoverme()){
			aMover.setUbicacion(men.getPos());
			return true;
		}
		return false;
	}*/

	public Personaje getPersonaje(String per) {
		return personajes.get(per);
	}

	/*public void actualizar() {

		if( personajeJugable.getNuevoRecorrido() && posicionValida(-personajeJugable.getXDestino(),-personajeJugable.getYDestino()) )	{

			personajeJugable.mover();
			camino = grafoDeObstaculo.getCamino(xActual,yActual,-pj.getXDestino(),-pj.getYDestino());

			nodoActual = camino.get(0);
			xDestino = -nodoActual.getPunto().getX();
			yDestino = -nodoActual.getPunto().getY();
			camino.remove(0);
			xActual = -xDestino;
			yActual = -yDestino;


		}
		if(!enMovimiento && ! camino.isEmpty()){
			nodoActual = camino.get(0);
			xDestino = -nodoActual.getPunto().getX();
			yDestino = -nodoActual.getPunto().getY();
			camino.remove(0);
			xActual = -xDestino;
			yActual = -yDestino;

		}


	}*/


	
	public void dibujar(Graphics2D g2d,Punto puntoADibujar) {
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, 810, 610);		
		
	   int x=xDestino+camara.xOffCamara;
	   int y=yDestino+camara.yOffCamara;
		
		for (int i = 0; i <  alto; i++) { // sin estos hace efecto de movimiento de piso 
			for (int j = 0; j < ancho ; j++) { 
				tiles[i][j].dibujar(g2d,this.DESPLAZAMIENTO_EN_X_PARA_PASAR_DE_2D_A_ISOMETRICO-puntoADibujar.getX(),this.DESPLAZAMIENTO_EN_Y_PARA_PASAR_DE_2D_A_ISOMETRICO-puntoADibujar.getY());	
				 
				//tiles[i][j].dibujar(g2d,x,y);	
			} 
		}
		
		
	}
	
	public void dibujarObstaculo(Graphics2D g2d,Punto puntoADibujar) {
		

				
		for (int i = 0; i <  alto; i++) { 
			for (int j = 0; j < ancho ; j++) { 
				
				if(obstaculos[i][j])
					tilesObstaculo[i][j].dibujar(g2d,this.DESPLAZAMIENTO_EN_X_PARA_PASAR_DE_2D_A_ISOMETRICO-puntoADibujar.getX(),this.DESPLAZAMIENTO_EN_Y_PARA_PASAR_DE_2D_A_ISOMETRICO-puntoADibujar.getY());	
							
			} 
		}
		
	}



	/*public void mover(Graphics2D g2d) {
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, 810, 610);		
		
		x = tiles[0][0].getXIso(); 
		y = tiles[0][0].getYIso();
		for (int i = 0; i <  alto; i++) {   ///sin estos for no dibuja el piso
			for (int j = 0; j < ancho ; j++) { 
				tiles[i][j].mover(g2d,xDestino+ JuegoPanel.xOffCamara,yDestino+JuegoPanel.yOffCamara);
			}
		}
		
		for (int i = 0; i <  alto; i++) { // sin estos no dibuja los obstaculos
			for (int j = 0; j < ancho ; j++) { 
				
				if(obstaculos[i][j])
				tilesObstaculo[i][j].dibujar(g2d,xDestino+JuegoPanel.xOffCamara,yDestino+JuegoPanel.yOffCamara);			
			} 
		}
		//g2d.drawImage( getImage(tipoDeSprite), 0, 0 , null);	
		termino();
	}*/
	
	/*public void mover(Graphics2D g2d) {
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, 810, 610);	
		
		
		x = tiles[0][0].getXIso(); 
		y = tiles[0][0].getYIso();
		for (int i = 0; i <  alto; i++) { 
			for (int j = 0; j < ancho ; j++) { 
				tiles[i][j].mover(g2d,xCentro+ JuegoPanel.xOffCamara,yCentro+JuegoPanel.yOffCamara);
			}
		}
		//g2d.drawImage( getImage(tipoDeSprite), 0, 0 , null);	
		termino();
	}*/

	private void termino() {
		if ( x == tiles[0][0].getXIso() && y == tiles[0][0].getYIso() )
			enMovimiento = false;
		else 
			enMovimiento = true;
	}



	
}
