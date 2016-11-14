package promootionSystem.graficaNuestra;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.io.FileNotFoundException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;

import promotionSystem.Cliente;
import promotionSystem.Punto;

public class JuegoPanel extends JPanel implements Runnable{
	
	private Cliente cliente;
	private Thread thread;
	private JFrame juego;
	private Mouse mouse;
	private Mapa mapa;
	private boolean enEjecucion=true;
	private boolean jugar=true;
	private double delta = 0;
	private static final int fps=60;
	private TilePersonaje personajeJugable;
	public static double timePerTick = 1000000000/fps;
	public static final int ANCHO=800;
	public static final int ALTO=600;
	//public static final int xOffCamara = 16;
	//public static final int yOffCamara = 6;
	
	public JuegoPanel(JFrame juego,Cliente cliente) throws FileNotFoundException{
		setPreferredSize(new Dimension(ALTO,ANCHO));
		mouse=new Mouse();
		this.cliente=cliente;
		addMouseListener(mouse);
	cliente.getPersonaje().setPosicion(new Punto(25,25));
		ImageIcon imagen=new ImageIcon("RecursosPersonaje/Razas/"+ cliente.getCasta()+"/"+cliente.getCasta()+".png");
	
		personajeJugable=new TilePersonaje(1,1,3,"pablo94",mouse,imagen.getImage());
		mapa=new Mapa("Mapa Prueba",personajeJugable);
//		
		this.juego=juego;
		thread=new Thread(this);
		thread.start();
	}

	@Override
	public void run() {

		long now;
		long lastTime = System.nanoTime();

		while(enEjecucion) {
			
			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			lastTime = now;
			
			if(delta >=1){   
				actualizar();
				repaint();
				delta--;
			}
		}
	}

	public void actualizar() {
		//mouse.actualizar(); 
		//personajeJugable.actualizar();
	 	//mapa.actualizar();
	}

	
	public void paint(Graphics g) {

		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		/*if(jugar){
			mapa.dibujar(g2d);
			
			jugar = false;
		
		}*/
		 
		mapa.dibujar(g2d,cliente.getPersonaje().getPosicion());
		personajeJugable.dibujarCentro(g2d);
		mapa.dibujarObstaculo(g2d,cliente.getPersonaje().getPosicion());
		//mapa.mover(g2d);
	    
	}


}
