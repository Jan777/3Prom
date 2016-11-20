package promotionSystem.mapagrafico;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import javax.swing.JOptionPane;

import promotionSystem.Cliente;
import promotionSystem.Personaje;
import promotionSystem.Punto;
import promotionSystem.juego.Camara;
import promotionSystem.juego.TileOtrosJugadores;
import promotionSystem.mapagrafico.dijkstra.MatrizBoolean;
import promotionSystem.mapagrafico.dijkstra.MetodoDijkstra;
import promotionSystem.mapagrafico.dijkstra.Nodo;
import promotionSystem.mapagrafico.dijkstra.Grafo;
import promotionSystem.sprites.Sprite;



public class Mapa {

	protected int id;
	protected int alto;
	protected int ancho;
	protected String nombre;


	
	protected int x;
	protected int y;

	protected boolean enMovimiento;
	protected String sprites;
	private static Image iluminacion;
	private static Image barraVida;
	private Tile[][] tiles;
	private TileObstaculo[][]  tilesObstaculo; 
	private boolean[][] obstaculos; 
	private TilePersonaje pj; 
	private ArrayList<Personaje> personajes; 
	private int xDestino;
	private int yDestino;
	private int xAnterior;
	private int yAnterior;
	public static int cantidadDeSprite;
	private Camara camara;
	private Grafo grafoDeMapa;
	MetodoDijkstra dijkstra;
	private List<Nodo> camino;
	private Nodo paso;
	private Nodo actual;
	private Nodo destino;
	private boolean noEnvieQueTermine;
	private Cliente cliente;
	ArrayList<TileOtrosJugadores> otrosJugadores = new ArrayList<>();
	


	public Mapa(String nombre,TilePersonaje pj,Camara camara ,ArrayList<Personaje> personajes,Cliente cliente) {
		File path = new File("recursos/"+nombre+".txt");
		this.pj = pj;
		this.enMovimiento = false;
		this.xDestino = pj.getXDestino();
		this.yDestino = pj.getYDestino();
		this.xAnterior = -xDestino;
		this.yAnterior = -yDestino;
		this.dijkstra = new MetodoDijkstra();
		this.nombre = nombre;
		this.camara = camara;
		this.personajes = personajes;
		this.cliente=cliente;
		otrosJugadores = cliente.getTiles();
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
		this.tilesObstaculo  = new TileObstaculo[ancho][alto];
		this.obstaculos = new boolean[ancho][alto];
		
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
				tilesObstaculo[i][j] = new TileObstaculo(i,j,obstaculo);
			}
		}

		sc.close();
		this.grafoDeMapa = new Grafo(new MatrizBoolean(obstaculos, ancho, alto));
		this.camino = new LinkedList<Nodo>();
	}


	private void cargarSprite() {
		load(sprites);
		iluminacion = Sprite.loadImage("recursos/iluminacion.png").getScaledInstance(camara.getAncho() + 10,camara.getAlto() + 10,Image.SCALE_SMOOTH);
		barraVida = 	Sprite.loadImage("recursos/vida.png");

	}

	public boolean EnMovimiento() {
		return enMovimiento;
	}

	
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
	
	public void actualizar() throws IOException {
		if( pj.getNuevoRecorrido() && posicionValida(-pj.getXDestino(),-pj.getYDestino()) )	{
			dijkstra	= 	new MetodoDijkstra();
			actual 		= 	grafoDeMapa.getNodo(-xDestino, -yDestino);
			destino 	=	grafoDeMapa.getNodo(-pj.getXDestino(), -pj.getYDestino());			
			dijkstra.calcularDijkstra(grafoDeMapa, actual,destino);
			camino 		=	dijkstra.obtenerCamino(destino);
			pj.setNuevoRecorrido(false);
		
			noEnvieQueTermine = true;
		}

		if( ! pj.estaEnMovimiento() && hayCamino() ){
			moverUnPaso();	
			pj.paraDondeVoy(xDestino, yDestino);
			pj.mover(xDestino,yDestino);	
		}
		if( noEnvieQueTermine && !pj.estaEnMovimiento() && ! hayCamino()){
			
			
			noEnvieQueTermine = false;
		}
		//actualizarRestoPersonajes();
	}

	/*private void actualizarRestoPersonajes() {
		for (TileOtrosJugadores pj : personajes.values()) {
			pj.actualizar();
		}		
	}*/


	private boolean hayCamino() {
		return camino != null && ! camino.isEmpty();
	}


	private void moverUnPaso() { 
		paso = camino.get(0);
		xAnterior = -xDestino;
		yAnterior = -yDestino;
		xDestino = -paso.getPunto().getX();
		yDestino = -paso.getPunto().getY();
		camino.remove(0);
	}


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
		dibujarRestoPersonajes(g2d);

		g2d.drawImage( iluminacion, 0, 0 , null);
	}


	public void mover(Graphics2D g2d) {
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, camara.getAncho() + 10, camara.getAlto() + 10);		
		
		x = tiles[0][0].getPosicionIsometricaX(); 
		y = tiles[0][0].getPosicionIsometricaY();
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
		moverRestoPersonajes(g2d);
		g2d.drawImage( iluminacion, 0, 0 , null);
		hud(g2d);
		termino();
	}


	private void hud(Graphics2D g2d) {
		g2d.drawImage( barraVida, 50, 62, null);
		g2d.setFont(new Font("Verdana", Font.BOLD, 18));
		g2d.setColor(Color.black);
		g2d.drawString(pj.getNombre(), 52, 62);
		g2d.setColor(Color.white);
		g2d.drawString(pj.getNombre(), 50, 60);
	}


	private boolean puedoDibujarObstaculo(int i, int j) {
		return tilesObstaculo[i][j].tipoDeSprite > 1; 
	}

	private boolean puedoDibujarPJ(int i, int j) {
		return  i == -xDestino && j == -yDestino ||
				i == xAnterior && j == yAnterior ||
				i == -xDestino && j == yAnterior ||
				i == xAnterior && j == -yDestino ; 
	}  
	
	private void termino() {
		if ( x == tiles[0][0].getPosicionIsometricaX() && y == tiles[0][0].getPosicionIsometricaY() ){
			pj.setEnMovimiento(false);
			pj.parar();
		}
		else 
			pj.setEnMovimiento(true);

	}


	/*public void moverPlayer(TileOtrosJugadores player) {
		actual 		= 	grafoDeMapa.getNodo(player.getxAnterior(),player.getyAnterior());
		destino 	=	grafoDeMapa.getNodo( player.getxDestino(), player.getyDestino());			
		player.calcularDijkstra(grafoDeMapa,actual,destino);
	}

	private void dibujarRestoPersonajes(Graphics2D g2d) {
		for (TileOtrosJugadores pj : personajes.values()) {
			pj.mover(g2d);
		}
	}*/

	private void dibujarRestoPersonajes(Graphics2D g2d) {
		if(!personajes.isEmpty()){
			for (Personaje personaje: personajes) {
				TileOtrosJugadores otrosPersonajes=new TileOtrosJugadores(personaje);
				otrosJugadores.add(otrosPersonajes);
				otrosPersonajes.dibujar(g2d,xDestino + camara.getxOffCamara(),yDestino + camara.getyOffCamara());
//				otrosPersonajes.actualizarAnimaciones();
			}
		}
	}
	
	private void moverRestoPersonajes(Graphics2D g2d) {
		for (TileOtrosJugadores jugador: otrosJugadores){
			jugador.mover(g2d,xDestino + camara.getxOffCamara(),yDestino + camara.getyOffCamara());
//			jugador.actualizarAnimaciones();
			jugador.actualizar();
		}
	}

}
