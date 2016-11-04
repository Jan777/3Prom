package promotionSystem.pantallaJuego.entidades;

import java.awt.image.BufferedImage;

public class Animacion {
	
	private int velocidad;
	private int indice;
	private long ultimoTiempo, temporizador;
	private BufferedImage[] cuadros;
	
	public Animacion(int velocidad, BufferedImage[] cuadros) {
		this.velocidad = velocidad;
		this.cuadros = cuadros;
		indice = 0;
		temporizador = 0;
		ultimoTiempo = System.currentTimeMillis();
	}
	
	public void actualizar() {
		temporizador += System.currentTimeMillis() - ultimoTiempo;
		ultimoTiempo = System.currentTimeMillis();
		
		if(temporizador > velocidad) {
			indice++;
			temporizador = 0;
			if(indice >= cuadros.length) {
				indice = 0;
			}
		}
	}
	
	public BufferedImage getFrameActual() {
		return cuadros[indice];
	}
	
}
