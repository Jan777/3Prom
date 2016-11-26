package promotionSystem.mapagrafico;

import promotionSystem.Cliente;
import promotionSystem.Personaje;
import promotionSystem.juego.Camara;
import promotionSystem.juego.TileOtrosJugadores;
import promotionSystem.mapagrafico.dijkstra.Grafo;
import promotionSystem.mapagrafico.dijkstra.MatrizBoolean;
import promotionSystem.mapagrafico.dijkstra.MetodoDijkstra;
import promotionSystem.mapagrafico.dijkstra.Nodo;
import promotionSystem.sprites.Sprite;

import javax.swing.*;

import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;



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
		File path = new File("Recursos/Recursos Mapa/"+nombre+".map");
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
		this.pj.setMapa(this);
		otrosJugadores = cliente.getTiles();
		Scanner sc = null;
		try {
			sc = new Scanner(path);
		} catch (FileNotFoundException e) {
			JOptionPane.showMessageDialog(null,"Error al configurar el mapa","Error",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
		this.id = sc.nextInt();
		this.ancho=sc.nextInt();
		this.alto=sc.nextInt();
		cantidadDeSprite=sc.nextInt();
		this.sprites="/Recursos/"+nombre;
		cargarSprite(nombre);

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


	private void cargarSprite(String nombre) {
		load(nombre);
		iluminacion = Sprite.loadImage("Recursos/Recursos Mapa/iluminacion.png").getScaledInstance(camara.getAncho() + 10,camara.getAlto() + 10,Image.SCALE_SMOOTH);
		

	}

	public boolean EnMovimiento() {
		return enMovimiento;
	}

	
	private void load(String nombre) {
		
		Sprite.inicializar("Recursos/Recursos Mapa/"+nombre+"/piso.png");
		
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
			cliente.enviarPosicion(destino.getPunto());
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
	}

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
	
		int pos=0;
		x = tiles[0][0].getPosicionIsometricaX(); 
		y = tiles[0][0].getPosicionIsometricaY();
		for (int i = 0; i <  alto; i++) { 
			for (int j = 0; j < ancho ; j++) { 
				tiles[i][j].mover(g2d,xDestino + camara.getxOffCamara(),yDestino+camara.getyOffCamara());

				if( puedoDibujarPJ(i, j) ){
					pj.dibujarCentro(g2d);

				}
				
				
				
				if( puedoDibujarObstaculo(i, j) )
					tilesObstaculo[i][j].mover(g2d,xDestino + camara.getxOffCamara(),yDestino + camara.getyOffCamara());
			}
		}
		moverRestoPersonajes(g2d);
		g2d.drawImage( iluminacion, 0, 0 , null);
		
		termino();
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
     			otrosPersonajes.actualizarAnimaciones();
			}
		}
	}
	
	private void moverRestoPersonajes(Graphics2D g2d) {
		for (TileOtrosJugadores jugador: otrosJugadores){
			
			jugador.mover(g2d,xDestino + camara.getxOffCamara(),yDestino + camara.getyOffCamara());
			jugador.actualizarAnimaciones();
		}
	}


	public String getNombre() {
		return nombre;
	}
	
	

}
