package promotionSystem.pantallaJuego.juego;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Pantalla {

	private JFrame pantalla;
	private Canvas canvas; 

	public Pantalla(final String tituloJuego, final int ancho, final int alto) {
		pantalla = new JFrame(tituloJuego);
		pantalla.setResizable(false);
		pantalla.setSize(ancho,alto);
		pantalla.setLocationRelativeTo(null);
		pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		pantalla.setVisible(true);
		
		canvas = new Canvas();
		canvas.setPreferredSize(new Dimension(ancho,alto));
		canvas.setFocusable(false);
		canvas.setMinimumSize(new Dimension(ancho,alto));
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
