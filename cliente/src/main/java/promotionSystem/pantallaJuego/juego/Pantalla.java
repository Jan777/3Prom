package promotionSystem.pantallaJuego.juego;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Pantalla {

	private JFrame pantalla;
	private Canvas canvas; // Objeto donde se grafica el juego

	public Pantalla(final String tituloJuego, final int ancho, final int alto) {
		pantalla = new JFrame(tituloJuego);
		pantalla.setSize(ancho,alto);
		pantalla.setResizable(false);
		pantalla.setLocationRelativeTo(null);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(ancho,alto));
		canvas.setMinimumSize(new Dimension(ancho,alto));
		canvas.setFocusable(false);
		canvas.setMaximumSize(new Dimension(ancho,alto));
        
		pantalla.add(canvas);
		pantalla.pack();
	}

	public Canvas getCanvas() {
		return canvas;
	}
	
	public JFrame getFrame() {
		return pantalla;
	}

}
