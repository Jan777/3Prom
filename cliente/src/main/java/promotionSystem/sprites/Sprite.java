package promotionSystem.sprites;

import java.awt.Image;
import java.awt.image.BufferedImage;

import javax.swing.ImageIcon;

import promotionSystem.mapagrafico.Mapa;

public class Sprite {
	public static BufferedImage[] piso;
	public static BufferedImage personaje, obstruccion;
	private static final int ancho = 64, alto = 32;
	private static final int altoObstruccion = 64;
	private static final int anchoPersonaje = 128, altoPersonaje = 128;
	private static final int framesPersonaje = 9;
	private static final int dirreciones = 8;
	private static final int cantidadSprite = 6;
	public static final BufferedImage click = CargaImagen.cargarImagen("recursos/click.png");
	
	private BufferedImage[][] sprite;
	

	public static BufferedImage[] estandar;


	public Sprite(String pathPJ) {
		HojaSprite hojaPJ = new HojaSprite(CargaImagen.cargarImagen(pathPJ));
		sprite = new BufferedImage[dirreciones][framesPersonaje];

		for (int i = 0; i < 8; i++) {
			recortarSprite(hojaPJ,i+1,framesPersonaje,i,sprite[i]);
		}	
	}

	public static void inicializar(String pathPiso){
		HojaSprite hoja = new HojaSprite(CargaImagen.cargarImagen(pathPiso));

       
		piso = new BufferedImage[cantidadSprite];

		int k = 0;

		for (int i = 0; i <  2 ;i++) {
			for (int j = 0; j < 3; j++) {
				if(j<2)
					piso[k] =  hoja.cortar(ancho*i, alto*j, ancho, alto);
				else
					piso[k] =  hoja.cortar(ancho*i, alto*j, ancho, altoObstruccion);
				k++;
			}
		}
	}


	public static void recortarSprite(HojaSprite hoja, int cantidadDeFilas,int cantidadDeElementosColumna,int inicionDeCorte, BufferedImage[] vectorDeImagenes){
		int x = 0;

		for (int i = inicionDeCorte; i < cantidadDeFilas; i++) {
			for (int j = 0; j < cantidadDeElementosColumna; j++) {
				vectorDeImagenes[x] = hoja.cortar(anchoPersonaje*j, altoPersonaje*i, anchoPersonaje, altoPersonaje);
				x++;
			}
		}
	}

	public BufferedImage[] getVectorSprite(int i ) {
		return sprite[i];
	}
	public static Image getImagePiso(int sprite) {
		return piso[sprite];
	}
	public static Image loadImage(String path) {
		return new ImageIcon(path).getImage();
	}



}