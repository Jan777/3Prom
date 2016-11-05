package recursos;

import java.awt.image.BufferedImage;
import java.util.LinkedList;

import promotionSystem.pantallaJuego.resources.recursos.CargarDesdeArchivo;
import promotionSystem.pantallaJuego.resources.recursos.HojaDeSprite;

public class RecursoGrafico {

	private static int ancho; 
	private static int alto;
	
	public static BufferedImage piso;
	public static BufferedImage obstruccion;
	public static BufferedImage fondoDelJuego;
	
	
	public static LinkedList<BufferedImage[]> guerrero = new LinkedList<>();
	private static BufferedImage[] guerreroIzquierda;
	private static BufferedImage[] guerreroArribaIzquierda; 
	private static BufferedImage[] guerreroArriba;
	private static BufferedImage[] guerreroArribaDerecha;
	private static BufferedImage[] guerreroDerecha;
	private static BufferedImage[] guerreroAbajoDerecha;
	private static BufferedImage[] guerreroAbajo;
	private static BufferedImage[] guerreroAbajoIzquierda;
	 
	
	public static LinkedList<BufferedImage[]> ogro = new LinkedList<>();
	private static BufferedImage[] ogroIzquierda;
	private static BufferedImage[] ogroArribaIzquierda;
	private static BufferedImage[] ogroArriba;
	private static BufferedImage[] ogroArribaDerecha;
	private static BufferedImage[] ogroDerecha;
	private static BufferedImage[] ogroAbajoDerecha;
	private static BufferedImage[] ogroAbajo;
	private static BufferedImage[] ogroAbajoIzquierda; 
	
	public static LinkedList<BufferedImage[]> pokemon = new LinkedList<>();
	private static BufferedImage[] pokemonIzquierda;
	private static BufferedImage[] pokemonArribaIzquierda;
	private static BufferedImage[] pokemonArriba;
	private static BufferedImage[] pokemonArribaDerecha;
	private static BufferedImage[] pokemonDerecha;
	private static BufferedImage[] pokemonAbajoDerecha;
	private static BufferedImage[] pokemonAbajo;
	private static BufferedImage[] pokemonAbajoIzquierda;
	
	
	public static void cargar() {
		
		ancho =256;
		alto = 256;		
		HojaDeSprite spriteGuerrero = new HojaDeSprite(CargarDesdeArchivo.cargarImagen("C:/Users/Nahuel/Documents/Juego Prog avanzada/jrpg/cliente/recursos/Guerrero.png"));
		
		guerreroIzquierda = new BufferedImage[4];
		guerreroArribaIzquierda = new BufferedImage[4];
		guerreroArriba = new BufferedImage[4];
		guerreroArribaDerecha = new BufferedImage[4];
		guerreroDerecha = new BufferedImage[4];
		guerreroAbajoDerecha = new BufferedImage[4];
		guerreroAbajo = new BufferedImage[4];
		guerreroAbajoIzquierda = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			guerreroIzquierda[i] = spriteGuerrero.getTile(ancho*i, 0, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroArribaIzquierda[i] = spriteGuerrero.getTile(ancho*i, alto, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroArriba[i] = spriteGuerrero.getTile(ancho*i, alto*2, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroArribaDerecha[i] = spriteGuerrero.getTile(ancho*i, alto*3, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroDerecha[i] = spriteGuerrero.getTile(ancho*i, alto*4, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroAbajoDerecha[i] = spriteGuerrero.getTile(ancho*i, alto*5, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroAbajo[i] = spriteGuerrero.getTile(ancho*i, alto*6, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			guerreroAbajoIzquierda[i] = spriteGuerrero.getTile(ancho*i, alto*7, ancho, alto);
		}
		
		 guerrero.add(guerreroIzquierda);
		 guerrero.add(guerreroArribaIzquierda);
		 guerrero.add(guerreroArriba);
		 guerrero.add(guerreroArribaDerecha);
		 guerrero.add(guerreroDerecha);
		 guerrero.add(guerreroAbajoDerecha);
		 guerrero.add(guerreroAbajo);
		 guerrero.add(guerreroAbajoIzquierda);
		 
		 HojaDeSprite spritepokemon = new HojaDeSprite(CargarDesdeArchivo.cargarImagen("C:/Users/Nahuel/Documents/Juego Prog avanzada/jrpg/cliente/recursos/pokemon.png"));
			
			pokemonIzquierda = new BufferedImage[2];
			pokemonArribaIzquierda = new BufferedImage[2];
			pokemonArriba = new BufferedImage[2];
			pokemonArribaDerecha = new BufferedImage[2];
			pokemonDerecha = new BufferedImage[2];
			pokemonAbajoDerecha = new BufferedImage[2];
			pokemonAbajo = new BufferedImage[2];
			pokemonAbajoIzquierda = new BufferedImage[2];
			
			for(int i = 0; i < 2; i++) {
				pokemonAbajo[i] = spritepokemon.getTile(ancho*i, 0, ancho, alto);
			}
			
			for(int i = 0; i < 2; i++) {
				pokemonArriba[i] = spritepokemon.getTile(ancho*i, alto, ancho, alto);
			}
			
			for(int i = 0; i < 2; i++) {
				pokemonIzquierda[i] = spritepokemon.getTile(ancho*i, alto*2, ancho, alto);
			}
			
			for(int i = 0; i < 2; i++) {
				pokemonDerecha[i] = spritepokemon.getTile(ancho*i, alto*3, ancho, alto);
			}
			
			for(int i = 0; i < 2; i++) {
				pokemonAbajoIzquierda[i] = spritepokemon.getTile(ancho*i, alto*4, ancho, alto);
			}
			
			for(int i = 0; i < 2; i++) {
				pokemonAbajoDerecha[i] = spritepokemon.getTile(ancho*i, alto*5, ancho, alto);
			}
			
			for(int i = 0; i < 2; i++) {
				pokemonArribaIzquierda[i] = spritepokemon.getTile(ancho*i, alto*6, ancho, alto);
			}
			
			for(int i = 0; i < 2; i++) {
				pokemonArribaDerecha[i] = spritepokemon.getTile(ancho*i, alto*7, ancho, alto);
			}
			
			pokemon.add(pokemonIzquierda);
			pokemon.add(pokemonArribaIzquierda);
			pokemon.add(pokemonArriba);
			pokemon.add(pokemonArribaDerecha);
			pokemon.add(pokemonDerecha);
			pokemon.add(pokemonAbajoDerecha);
			pokemon.add(pokemonAbajo);
			pokemon.add(pokemonAbajoIzquierda);
		 
		HojaDeSprite spriteOgro = new HojaDeSprite(CargarDesdeArchivo.cargarImagen("C:/Users/Nahuel/Documents/Juego Prog avanzada/jrpg/cliente/recursos/Ogro.png"));
		
		ogroIzquierda = new BufferedImage[4];
		ogroArribaIzquierda = new BufferedImage[4];
		ogroArriba = new BufferedImage[4];
		ogroArribaDerecha = new BufferedImage[4];
		ogroDerecha = new BufferedImage[4];
		ogroAbajoDerecha = new BufferedImage[4];
		ogroAbajo = new BufferedImage[4];
		ogroAbajoIzquierda = new BufferedImage[4];
		
		for(int i = 0; i < 4; i++) {
			ogroIzquierda[i] = spriteOgro.getTile(ancho*i, 0, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroArribaIzquierda[i] = spriteOgro.getTile(ancho*i, alto, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroArriba[i] = spriteOgro.getTile(ancho*i, alto*2, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroArribaDerecha[i] = spriteOgro.getTile(ancho*i, alto*3, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroDerecha[i] = spriteOgro.getTile(ancho*i, alto*4, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroAbajoDerecha[i] = spriteOgro.getTile(ancho*i, alto*5, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroAbajo[i] = spriteOgro.getTile(ancho*i, alto*6, ancho, alto);
		}
		
		for(int i = 0; i < 4; i++) {
			ogroAbajoIzquierda[i] = spriteOgro.getTile(ancho*i, alto*7, ancho, alto);
		}
		
		ogro.add(ogroIzquierda);
		ogro.add(ogroArribaIzquierda);
		ogro.add(ogroArriba);
		ogro.add(ogroArribaDerecha);
		ogro.add(ogroDerecha);
		ogro.add(ogroAbajoDerecha);
		ogro.add(ogroAbajo);
		ogro.add(ogroAbajoIzquierda);
		
		
		piso = CargarDesdeArchivo.cargarImagen("C:/Users/Nahuel/Documents/Juego Prog avanzada/jrpg/cliente/recursos/Verde.png");
		obstruccion = CargarDesdeArchivo.cargarImagen("C:/Users/Nahuel/Documents/Juego Prog avanzada/jrpg/cliente/recursos/rock.png");
		fondoDelJuego = CargarDesdeArchivo.cargarImagen("C:/Users/Nahuel/Documents/Juego Prog avanzada/jrpg/cliente/recursos/fondo verde.jpg");
		
	}
}
