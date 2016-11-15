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
    protected Mouse mouse;
	
	protected int xDestino;
	protected int yDestino;
	protected int xActual;
	protected int yActual;
	int xCentro ;
	int yCentro; 

	

	public Mapa(String nombre,TilePersonaje pj,Camara camara) throws FileNotFoundException {
		File path = new File("recursos/"+nombre+".txt");
		this.personajeJugable = pj;
		enMovimiento = false;
		Punto punto=new Punto(2,2);
		
		
		xDestino = pj.getxDestino();
		yDestino = pj.getxDestino();
		 
		xCentro = pj.getxCentro();
		yCentro = pj.getyCentro();
		
		;
		

		xActual = -xDestino;
		yActual = -yDestino;

		this.camara=camara;
		this.nombre = nombre;
		
		
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

		



		sc.close();

	}


private void cargarSprites(String nombre) {
		
		for(int i=0;i<cantidadDeSprites;i++){
			spritesDelMapa[i]= loadImage("recursos/"+nombre+"/sprite"+ i + ".png" );
		}
		
		
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

	

	
	

	



	

	

	


	
	public void dibujar(Graphics2D g2d,Punto puntoADibujar, int[] ks) {
		g2d.setBackground(Color.BLACK);
		g2d.clearRect(0, 0, 810, 610);		
		
	   
		
		for (int i = 0; i <  alto; i++) { 
			for (int j = 0; j < ancho ; j++) { 
				tiles[i][j].dibujar(g2d,this.DESPLAZAMIENTO_EN_X_PARA_PASAR_DE_2D_A_ISOMETRICO-(puntoADibujar.getX()),this.DESPLAZAMIENTO_EN_Y_PARA_PASAR_DE_2D_A_ISOMETRICO-(puntoADibujar.getY()));	
				
				
			} 
		}
		
		
	}
	
	public void dibujarObstaculo(Graphics2D g2d,Punto puntoADibujar, int[] ks) {
		

				
		for (int i = 0; i <  alto; i++) { 
			for (int j = 0; j < ancho ; j++) { 
				
				if(obstaculos[i][j])
					tilesObstaculo[i][j].dibujar(g2d,this.DESPLAZAMIENTO_EN_X_PARA_PASAR_DE_2D_A_ISOMETRICO-(puntoADibujar.getX()),this.DESPLAZAMIENTO_EN_Y_PARA_PASAR_DE_2D_A_ISOMETRICO-(puntoADibujar.getY()));	
							
			} 
		}
		
	}
	
	


	

	
}
