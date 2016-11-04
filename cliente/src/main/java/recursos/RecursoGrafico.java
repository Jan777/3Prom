package recursos;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import promotionSystem.pantallaJuego.resources.recursos.CargadorImagen;
import promotionSystem.pantallaJuego.resources.recursos.HojaDeSprite;

public class RecursoGrafico {

	private static int ancho; 
	private static int alto;
	
	public static BufferedImage piso;
	public static BufferedImage obstruccion;
	public static BufferedImage fondoDelJuego;
	
	
	public static LinkedList<BufferedImage[]> guerrero = new LinkedList<>();
	private static BufferedImage[] guerreroIzq;
	private static BufferedImage[] guerreroArribaIzq; 
	private static BufferedImage[] guerreroArriba;
	private static BufferedImage[] guerreroArribaDer;
	private static BufferedImage[] guerreroDer;
	private static BufferedImage[] guerreroAbajoDer;
	private static BufferedImage[] guerreroAbajo;
	private static BufferedImage[] guerreroAbajoIzq;
	 
	
	public static LinkedList<BufferedImage[]> ogro = new LinkedList<>();
	private static BufferedImage[] ogroIzq;
	private static BufferedImage[] ogroArribaIzq;
	private static BufferedImage[] ogroArriba;
	private static BufferedImage[] ogroArribaDer;
	private static BufferedImage[] ogroDer;
	private static BufferedImage[] ogroAbajoDer;
	private static BufferedImage[] ogroAbajo;
	private static BufferedImage[] ogroAbajoIzq; 
	
	
	public static void cargar() {
		
		ancho = 256;
		alto = 256;
		
		HojaDeSprite spriteGuerrero = new HojaDeSprite(CargadorImagen.cargarImagen("C:/Users/Nahuel/Documents/Juego Prog avanzada/jrpg/cliente/recursos/Guerrero.png"));
		
		guerreroIzq = new BufferedImage[4];
		guerreroArribaIzq = new BufferedImage[4];
		guerreroArriba = new BufferedImage[4];
		guerreroArribaDer = new BufferedImage[4];
		guerreroDer = new BufferedImage[4];
		guerreroAbajoDer = new BufferedImage[4];
		guerreroAbajo = new BufferedImage[4];
		guerreroAbajoIzq = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			guerreroIzq[i] = spriteGuerrero.getTile(ancho*i, 0, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroArribaIzq[i] = spriteGuerrero.getTile(ancho*i, alto, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroArriba[i] = spriteGuerrero.getTile(ancho*i, alto*2, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroArribaDer[i] = spriteGuerrero.getTile(ancho*i, alto*3, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroDer[i] = spriteGuerrero.getTile(ancho*i, alto*4, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroAbajoDer[i] = spriteGuerrero.getTile(ancho*i, alto*5, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroAbajo[i] = spriteGuerrero.getTile(ancho*i, alto*6, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroAbajoIzq[i] = spriteGuerrero.getTile(ancho*i, alto*7, ancho, alto);
		}
		
		 guerrero.add(guerreroIzq);
		 guerrero.add(guerreroArribaIzq);
		 guerrero.add(guerreroArriba);
		 guerrero.add(guerreroArribaDer);
		 guerrero.add(guerreroDer);
		 guerrero.add(guerreroAbajoDer);
		 guerrero.add(guerreroAbajo);
		 guerrero.add(guerreroAbajoIzq);
		 
		HojaDeSprite spriteOgro = new HojaDeSprite(CargadorImagen.cargarImagen("C:/Users/Nahuel/Documents/Juego Prog avanzada/jrpg/cliente/recursos/Ogro.png"));
		
		ogroIzq = new BufferedImage[4];
		ogroArribaIzq = new BufferedImage[4];
		ogroArriba = new BufferedImage[4];
		ogroArribaDer = new BufferedImage[4];
		ogroDer = new BufferedImage[4];
		ogroAbajoDer = new BufferedImage[4];
		ogroAbajo = new BufferedImage[4];
		ogroAbajoIzq = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			ogroIzq[i] = spriteOgro.getTile(ancho*i, 0, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroArribaIzq[i] = spriteOgro.getTile(ancho*i, alto, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroArriba[i] = spriteOgro.getTile(ancho*i, alto*2, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroArribaDer[i] = spriteOgro.getTile(ancho*i, alto*3, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroDer[i] = spriteOgro.getTile(ancho*i, alto*4, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroAbajoDer[i] = spriteOgro.getTile(ancho*i, alto*5, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroAbajo[i] = spriteOgro.getTile(ancho*i, alto*6, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroAbajoIzq[i] = spriteOgro.getTile(ancho*i, alto*7, ancho, alto);
		}
		
		ogro.add(ogroIzq);
		ogro.add(ogroArribaIzq);
		ogro.add(ogroArriba);
		ogro.add(ogroArribaDer);
		ogro.add(ogroDer);
		ogro.add(ogroAbajoDer);
		ogro.add(ogroAbajo);
		ogro.add(ogroAbajoIzq);
		
		
		piso = CargadorImagen.cargarImagen("C:/Users/Nahuel/Documents/Juego Prog avanzada/jrpg/cliente/recursos/Verde.png");
		obstruccion = CargadorImagen.cargarImagen("C:/Users/Nahuel/Documents/Juego Prog avanzada/jrpg/cliente/recursos/arbol.png");
		fondoDelJuego = CargadorImagen.cargarImagen("C:/Users/Nahuel/Documents/Juego Prog avanzada/jrpg/cliente/recursos/fondo verde.jpg");
		
	}
}
