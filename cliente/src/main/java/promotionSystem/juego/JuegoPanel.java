package promotionSystem.juego;

import promotionSystem.Cliente;
import promotionSystem.Personaje;
import promotionSystem.mapagrafico.Mapa;
import promotionSystem.mapagrafico.TilePersonaje;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;



@SuppressWarnings("serial")
public class JuegoPanel extends Component implements Runnable{

	public static final int ANCHO = 1024;
	public static final int ALTO = 768;
	public static final int fps = 60;


	public static double timePerTick = 1000000000/fps;
	private Mapa mapa;
	private Thread thread;
	private Mouse mouse;
	private double delta = 0;
	private boolean ejecutando = true;
	private TilePersonaje personajeJugableDibujo;
	private Camara camara;
	JFrame padre;
	Cliente cliente;
	private ArrayList<Personaje> personajes; 
	

	private boolean jugar = true;

	public JuegoPanel(JFrame padre,String nombreMapa, Cliente cliente) throws IOException {
		this.padre = padre;
		this.cliente = cliente;
		cliente.crearHiloEscuchador();
		cliente.crearHiloEscuchadorBatalla();
		this.personajes = cliente.getJugadoresEnPartida();
		setPreferredSize(new Dimension(ANCHO, ALTO));
		setFocusable(true);
		requestFocus();
		mouse 	 = new Mouse();
		camara = new Camara(ANCHO, ALTO);
		addMouseListener(mouse);
		personajeJugableDibujo = new TilePersonaje(cliente,mouse,camara);  
		mapa 	 = new Mapa(nombreMapa,personajeJugableDibujo,camara, personajes,cliente);
		thread 	 = new Thread(this);
		Sonido.MAPAPOKEMON.loop();
		thread.start();
	}


	@Override
	public void run(){

		long now;
		long lastTime = System.nanoTime();


		while(ejecutando) {

			now = System.nanoTime();
			delta += (now - lastTime)/timePerTick;
			lastTime = now;
			if(delta >=1){  

				try {
					actualizar();
					repaint();
					delta--;
				} catch (Exception e) {
			
					e.printStackTrace();
				}
				
			}
		}
	}

	public void actualizar() throws Exception {
		mouse.actualizar();
		mouse.actualizarClickIzquierdo();
		personajeJugableDibujo.actualizar();
		mapa.actualizar();
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		if(jugar){
			mapa.dibujar(g2d);
			jugar = false;
		}
	
			mapa.mover(g2d);
	
	}

	/*public void nuevoMovimientoPersonajes(String pj, String sprite, Punto point){
		TileOtrosJugadores player = personajes.get(pj);
		if (player == null){
			player= new TileOtrosJugadores(pj,sprite,point);
			personajes.put(pj, player );
		}
		mapa.moverPlayer(player);

	}*/

	public void nuevaDetencionPersonaje(String pj){
		
	}

}
