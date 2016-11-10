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


	// BUGERO
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

	protected int xDestino;
	protected int yDestino;
	protected int xActual;
	protected int yActual;

	/*protected Grafo grafoDeObstaculo;
	protected List<Nodo> camino;
	private Nodo nodoActual;*/

	public Mapa(String nombre,TilePersonaje pj) throws FileNotFoundException {
		File path = new File("recursos/"+nombre+".txt");
		this.personajeJugable = pj;
		enMovimiento = false;
		xDestino = pj.getXDestino();
		yDestino = pj.getYDestino();

		xActual = -xDestino;
		yActual = -yDestino;

		this.nombre = nombre;
		//spriteDelMapa = new Image[7];

		
			Scanner sc = new Scanner(path);
		
		this.id = sc.nextInt();
		this.ancho=sc.nextInt();
		this.alto=sc.nextInt();
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

	/**
	 * Aca alex tiene que hacer la hoja de sprite y ir cortandola.
	 * lo que yo pense (que ya esta casi echo)
	 * es tener una carpeta (o unos sprites) con distintos nombres para 
	 * distintos mapas.
	 * por ejemplo:
	 * exterior va a hacer un a hoja de sprite con todo los sprite del exterior
	 * 
	 * pero si el mapa tiene la palabra castillo.
	 * va a cargar la hoja de sprite de castillo.
	 * 
	 * pero como dije necesitamos los sprite y a alex que haga el corte
	 * si no lo dejamos como esta :D
	 * @param nombre
	 */
	

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

	/**
	 * Segun la las coordenadas que recibe devuelve 
	 * verdadero si hay un obstaculo y falso si no.
	 * @param x
	 * @param y
	 * @return
	 */
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


	/**
	 * tengo que buscar la forma de dibujar solo la pantalla.
	 *
	 * 			      (0,0)
	 * 			 (0,1)(1,1)(1,0)
	 *		(0,2)(1,2)(2,2)(2,1)(2,0)
	 */
	public void dibujar(Graphics2D g2d) {
		g2d.setBackground(Color.BLACK);
//<<<<<<< Updated upstream
		g2d.clearRect(0, 0, 810, 610);		
		for (int i = 0; i <  alto; i++) { 
			for (int j = 0; j < ancho ; j++) { 
				tiles[i][j].dibujar(g2d,xDestino+JuegoPanel.xOffCamara,yDestino+JuegoPanel.yOffCamara);			
			}
		}
	}
	
	public void dibujarObstaculo(Graphics2D g2d) {
		
//<<<<<<< Updated upstream
		g2d.clearRect(0, 0, 810, 610);		
		for (int i = 0; i <  alto; i++) { 
			for (int j = 0; j < ancho ; j++) { 
				tiles[i][j].dibujar(g2d,xDestino+JuegoPanel.xOffCamara,yDestino+JuegoPanel.yOffCamara);			
			}
		}
	}
//=======
	
//>>>>>>> Stashed changes

	public void mover(Graphics2D g2d) {
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, 810, 610);		
		//Tiene que ser uno por uno entonces si cancelo termino el movimiento (sino se descuajaina todo).
		x = tiles[0][0].getXIso(); // puedo agarrar el centro. pero por ahora asi.
		y = tiles[0][0].getYIso();
		for (int i = 0; i <  alto; i++) { 
			for (int j = 0; j < ancho ; j++) { 
				tiles[i][j].mover(g2d,xDestino+ JuegoPanel.xOffCamara,yDestino+JuegoPanel.yOffCamara);
			}
		}
		g2d.drawImage( getImage(tipoDeSprite), 0, 0 , null);	
		termino();
	}

	private void termino() {
		if ( x == tiles[0][0].getXIso() && y == tiles[0][0].getYIso() )
			enMovimiento = false;
		else 
			enMovimiento = true;
	}



	
}
