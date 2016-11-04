package promotionSystem.pantallaJuego.juego;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import entidades.Entidad;
import promotionSystem.pantallaJuego.estados.*;
import promotionSystem.pantallaJuego.resources.recursos.*;
import promotionSystem.pantallaJuego.*;
import recursos.RecursoGrafico;


public class Juego implements Runnable {
	private BufferStrategy strategy;
	private Pantalla pantalla;
	private final String tituloJuego;
	private final int ancho;
	private final int alto;
	private Thread hilo;
	private boolean estaEnEjecucion;

	 
	private Graphics g;


	private Estado estadoJuego;


	private ManejadorDelMouse manejador;
	

	private Camara camara;

	public Juego(final String tituloJuego, final int ancho, final int alto) {
		
		manejador = new ManejadorDelMouse();
		this.tituloJuego = tituloJuego;
		this.alto = alto;
		this.ancho = ancho;
		
		
	}

	public void iniciar() { 
		pantalla = new Pantalla(tituloJuego, ancho, alto);

		pantalla.getCanvas().addMouseListener(manejador);

		RecursoGrafico.cargar();
		
		estadoJuego = new EstadoJuego(this);
		Estado.setEstado(estadoJuego);
		
		camara = new Camara(this, 0, 0);
	}

	private void actualizar() { 
		manejador.actualizar();

		if (Estado.getEstado() != null) {
			Estado.getEstado().actualizar();
		}
	}

	private void graficar() { 
		strategy = pantalla.getCanvas().getBufferStrategy();
		if (strategy == null) { 
			pantalla.getCanvas().createBufferStrategy(3);
			return;
		}

		g = strategy.getDrawGraphics(); 

		g.clearRect(0, 0, ancho, alto); 

		
		
		if (Estado.getEstado() != null) {
			estadoJuego.graficar(g);
		}

		

		strategy.show(); 
		g.dispose();
	}

	@Override
	public void run() { 
			
		iniciar();
		
		int fps = 60; 
		double tiempoPorActualizacion = 1000000000 / fps; 
		double delta = 0;
		long ahora;
		long ultimoTiempo = System.nanoTime();
		long timer = 0; 
		int actualizaciones = 0; 

		while (estaEnEjecucion) {
			ahora = System.nanoTime();
			delta += (ahora - ultimoTiempo) / tiempoPorActualizacion; 
			timer += ahora - ultimoTiempo; 
			ultimoTiempo = ahora; 

			if (delta >= 1) {
				actualizar();
				graficar();
				actualizaciones++;
				delta--;
			}

			if (timer >= 1000000000) {
				pantalla.getFrame().setTitle(tituloJuego + " | " + "FPS: " + fps);
				actualizaciones = 0;
				timer = 0;
			}
		}

		stop();
	}

	public synchronized void start() { 
		if (estaEnEjecucion)
			return;
		estaEnEjecucion = true;
		hilo = new Thread(this);
		hilo.start();
	}

	public synchronized void stop() { 
		if (!estaEnEjecucion)
			return;
		try {
			estaEnEjecucion = false;
			hilo.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}

	public ManejadorDelMouse getManejadorDeMouse() {
		return manejador;
	}
	
	public Camara getCamara() {
		return camara;
	}
	
	public EstadoJuego getEstadoJuego() {
		return (EstadoJuego) estadoJuego;
	}
}
