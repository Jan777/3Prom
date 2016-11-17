package promotionSystem.mapagrafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;


import promotionSystem.juego.Camara;
import promotionSystem.juego.TilePlayer;
import promotionSystem.mapagrafico.dijkstra.AlgoritmoDelTacho;
import promotionSystem.mapagrafico.dijkstra.MatrizBoolean;
import promotionSystem.mapagrafico.dijkstra.Nodo;
import promotionSystem.mapagrafico.dijkstra.Grafo;
import promotionSystem.sprites.Sprite;



public class MapaGrafico {

	protected int id;
	protected int alto;
	protected int ancho;
	protected String nombre;


	// BUGERO
	protected int x;
	protected int y;

	protected boolean enMovimiento;
	protected String sprites;
	private static Image iluminacion;
	private static Image hud;
	private Tile[][] tiles;
	private TileObstaculo64x64[][]  tilesObstaculo; 
	private boolean[][] obstaculos; 
	private TilePersonaje pj; // cliente
	private HashMap<String, TilePlayer> personajes; // mensaje movimiento: 
	private int xDestino;
	private int yDestino;
	private int xAnterior;
	private int yAnterior;
	public static int cantidadDeSprite;
	private Camara camara;
	private Grafo grafoDeMapa;
	AlgoritmoDelTacho dijkstra;
	private List<Nodo> camino;
	private Nodo paso;
	private Nodo actual;
	private Nodo destino;
	private boolean noEnvieQueTermine;
	//private EnviadorPosicion env;


	public MapaGrafico(String nombre,TilePersonaje pj,Camara camara/*,EnviadorPosicion env*/, HashMap<String, TilePlayer> personajes) {
		File path = new File("recursos/"+nombre+".txt");
		this.pj = pj;
		//this.env = env;
		this.enMovimiento = false;
		this.xDestino = pj.getXDestino();
		this.yDestino = pj.getYDestino();
		this.xAnterior = -xDestino;
		this.yAnterior = -yDestino;
		this.dijkstra = new AlgoritmoDelTacho();
		this.nombre = nombre;
		this.camara = camara;
		this.personajes = personajes;

		Scanner sc = null;
		try {
			sc = new Scanner(path);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null, "No se encuentra el mapa "+nombre+".map\n Llamar al 0800-333-JUNIT\n"+e.toString());
			System.exit(0);
		}
		this.id = sc.nextInt();
		this.ancho=sc.nextInt();
		this.alto=sc.nextInt();
		cantidadDeSprite=sc.nextInt();
		this.sprites="/recursos/"+nombre;
		cargarSprite();

		this.tiles = new Tile[ancho][alto];
		this.tilesObstaculo  = new TileObstaculo64x64[ancho][alto];
		this.obstaculos = new boolean[ancho][alto];
		/**
		 * no hace falta pero para que se entienda
		 */
		int sprite;
		for (int i = 0; i < ancho ; i++) {
			for (int j = 0; j < alto; j++) {
				sprite = sc.nextInt();
				tiles[i][j] = new Tile(i,j,sprite);
			}
		}
		int obstaculo;
		for (int i = 0; i < ancho ; i++) {
			for (int j = 0; j < alto; j++) {
				obstaculo = sc.nextInt();
				obstaculos[i][j] = obstaculo>=1?true:false;
				tilesObstaculo[i][j] = new TileObstaculo64x64(i,j,obstaculo);
			}
		}

		sc.close();
		this.grafoDeMapa = new Grafo(new MatrizBoolean(obstaculos, ancho, alto));
		this.camino = new LinkedList<Nodo>();
	}


	private void cargarSprite() {
		load(sprites);
		iluminacion = Sprite.loadImage("src\\main\\resources\\mapas\\99.png").getScaledInstance(camara.getAncho() + 10,camara.getAlto() + 10,Image.SCALE_SMOOTH);
		hud = 	Sprite.loadImage("src\\main\\resources\\vida.png");

	}

	public boolean EnMovimiento() {
		return enMovimiento;
	}

	/**
	 * cambiar por hoja:
	 * @param nombre
	 */
	private void load(String nombre) {
		
		String recursos = nombre;
		Sprite.inicializar("recursos/Mapa Prueba/piso.png");
		
	}

	public boolean posicionValida(int x, int y){
		return dentroDelMapa(-pj.getXDestino(),-pj.getYDestino()) && ! hayObstaculo(-pj.getXDestino(),-pj.getYDestino());
	}

	public boolean hayObstaculo(int x,int y){
		return obstaculos[x][y];
	}

	private boolean dentroDelMapa(int x, int y) {
		return x>=0 && y>=0 && x<alto && y<ancho;
	}
	/*
	public boolean recibirMensajeMovmiento(MensajeMovimiento men){
		Personaje aMover = personajes.get(men.getEmisor());

		if(aMover.isPuedoMoverme()){
			aMover.setUbicacion(men.getPos());
			return true;
		}
		return false;
	}

	public Personaje getPersonaje(String per) {
		return personajes.get(per);
	}
	 */
	public void actualizar() {
		if( pj.getNuevoRecorrido() && posicionValida(-pj.getXDestino(),-pj.getYDestino()) )	{
			dijkstra	= 	new AlgoritmoDelTacho();
			actual 		= 	grafoDeMapa.getNodo(-xDestino, -yDestino);
			destino 	=	grafoDeMapa.getNodo(-pj.getXDestino(), -pj.getYDestino());			
			dijkstra.calcularDijkstra(grafoDeMapa, actual,destino);
			camino 		=	dijkstra.obtenerCamino(destino);
			pj.setNuevoRecorrido(false);
			// ACA SE ENVIA POR EL CLIENTE LA POSICION NUEVA DEL PERSONAJE
		//	env.enviarPosicion(destino.getPunto());
			//
			noEnvieQueTermine = true;
		}

		if( ! pj.estaEnMovimiento() && hayCamino() ){
			moverUnPaso();	
			pj.paraDondeVoy(xDestino, yDestino);
			pj.mover(xDestino,yDestino);	
		}
		if( noEnvieQueTermine && !pj.estaEnMovimiento() && ! hayCamino()){
			// ACA SE ENVIA POR EL CLIENTE LA POSICION FINAL DEL PERSONAJE
			//env.enviarDetencion();
			//
			noEnvieQueTermine = false;
		}
		//actualizarRestoPersonajes();
	}

	private void actualizarRestoPersonajes() {
		for (TilePlayer pj : personajes.values()) {
			pj.actualizar();
		}		
	}


	private boolean hayCamino() {
		return camino != null && ! camino.isEmpty();
	}


	private void moverUnPaso() { // Esto tengo que ver, pero lo que hace es mover paso a paso por el camino del DI kjsoihyoas TRAMMMMMMMMMMM
		paso = camino.get(0);
		xAnterior = -xDestino;
		yAnterior = -yDestino;
		xDestino = -paso.getPunto().getX();
		yDestino = -paso.getPunto().getY();
		camino.remove(0);
	}


	/**
	 * tengo que buscar la forma de dibujar solo la pantalla.
	 *
	 * 			      (0,0)
	 * 			 (0,1)(1,1)(1,0)
	 *		(0,2)(1,2)(2,2)(2,1)(2,0)
	 */
	public void dibujar(Graphics2D g2d) {
		g2d.setBackground(Color.BLACK);
		for (int i = 0; i <  alto; i++) { 
			for (int j = 0; j < ancho ; j++) { 
				tiles[i][j].dibujar(g2d,xDestino + camara.getxOffCamara(),yDestino + camara.getyOffCamara());
				if( puedoDibujarPJ(i, j))
					pj.dibujarCentro(g2d);
				
				if( puedoDibujarObstaculo(i, j)  )
					tilesObstaculo[i][j].dibujar(g2d,xDestino + camara.getxOffCamara(),yDestino + camara.getyOffCamara());	
			}
		}
		//dibujarRestoPersonajes(g2d);

		g2d.drawImage( iluminacion, 0, 0 , null);
	}


	public void mover(Graphics2D g2d) {
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, camara.getAncho() + 10, camara.getAlto() + 10);		
		//Tiene que ser uno por uno entonces si cancelo termino el movimiento (sino se descuajaina todo).
		x = tiles[0][0].getXIso(); // puedo agarrar el centro. pero por ahora asi.
		y = tiles[0][0].getYIso();
		for (int i = 0; i <  alto; i++) { 
			for (int j = 0; j < ancho ; j++) { 
				tiles[i][j].mover(g2d,xDestino + camara.getxOffCamara(),yDestino+camara.getyOffCamara());

				if( puedoDibujarPJ(i, j) ){
					pj.dibujarCentro(g2d);
					//dibujarRestoPersonajes(g2d);
				}
				
				if( puedoDibujarObstaculo(i, j) )
					tilesObstaculo[i][j].mover(g2d,xDestino + camara.getxOffCamara(),yDestino + camara.getyOffCamara());
			}
		}
		g2d.drawImage( iluminacion, 0, 0 , null);
		hud(g2d);
		termino();
	}


	private void hud(Graphics2D g2d) {
		g2d.drawImage( hud, 50, 62, null);
		g2d.setFont(new Font("Verdana", Font.BOLD, 18));
		g2d.setColor(Color.black);
		g2d.drawString(pj.getNombre(), 52, 62);
		g2d.setColor(Color.white);
		g2d.drawString(pj.getNombre(), 50, 60);
	}


	private boolean puedoDibujarObstaculo(int i, int j) {
		return tilesObstaculo[i][j].sprite > 1; // Si es 0 no dibujo y si es 1 TAMPOCO, porque seria un obstaculo trasparente.
	}

	private boolean puedoDibujarPJ(int i, int j) {
		return  i == -xDestino && j == -yDestino ||
				i == xAnterior && j == yAnterior ||
				i == -xDestino && j == yAnterior ||
				i == xAnterior && j == -yDestino ; 
	}  
	/**
	 * Estrambolico, avisa cuando termino de moverse el personaje. deberia camiarlo ya que utiliza los tiles Graficos.
	 */
	private void termino() {
		if ( x == tiles[0][0].getXIso() && y == tiles[0][0].getYIso() ){
			pj.setEnMovimiento(false);
			pj.parar();
		}
		else 
			pj.setEnMovimiento(true);

	}


	public void moverPlayer(TilePlayer player) {
		actual 		= 	grafoDeMapa.getNodo(player.getxAnterior(),player.getyAnterior());
		destino 	=	grafoDeMapa.getNodo( player.getxDestino(), player.getyDestino());			
		player.calcularDijkstra(grafoDeMapa,actual,destino);
	}

	private void dibujarRestoPersonajes(Graphics2D g2d) {
		for (TilePlayer pj : personajes.values()) {
			pj.mover(g2d);
		}
	}


}
