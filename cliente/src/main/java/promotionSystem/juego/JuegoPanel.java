package promotionSystem.juego;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.HashMap;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import promotionSystem.Cliente;
import promotionSystem.Personaje;
import promotionSystem.Punto;
import promotionSystem.mapagrafico.MapaGrafico;
import promotionSystem.mapagrafico.TilePersonaje;



@SuppressWarnings("serial")
public class JuegoPanel extends Component implements Runnable{

	public static final int ANCHO = 1024;
	public static final int ALTO = 768;
	public static final int fps = 60;


	public static double timePerTick = 1000000000/fps;
	private MapaGrafico mapa;
	private Thread thread;
	private Mouse mouse;
	private double delta = 0;
	private boolean ejecutando = true;
	private TilePersonaje pjDibujo;
	private Camara camara;
	JFrame padre;
	Cliente cliente;
	private HashMap<String, TilePlayer> personajes;
	//EnviadorPosicion env;

	private boolean jugar = true;

	public JuegoPanel(JFrame padre,String nombreMapa, Cliente cliente) {
		this.padre = padre;
		this.cliente = cliente;
		this.personajes = new HashMap<String, TilePlayer>();
		//ImageIcon imagen=new ImageIcon("RecursosPersonaje/Razas/"+ cliente.getCasta()+"/"+cliente.getCasta()+".png");
		//env = new EnviadorPosicion(cliente, pj.getNombre(),nombreMapa, pj.getSprite());
		setPreferredSize(new Dimension(ANCHO, ALTO));
		setFocusable(true);
		requestFocus();
		mouse 	 = new Mouse();
		camara = new Camara(ANCHO, ALTO);
		addMouseListener(mouse);
		pjDibujo = new TilePersonaje(cliente.getPersonaje().getPosicion(),cliente,mouse,camara);  
		mapa 	 = new MapaGrafico(nombreMapa,pjDibujo,camara, null/*env,personajes*/);
		thread 	 = new Thread(this);
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

				actualizar();
				repaint();
				delta--;
			}
		}
	}

	public void actualizar() {
		mouse.actualizar();  // Preguntar porque aveces no me lo agarra :c estupido mouse listener de java ?
		pjDibujo.actualizar();
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

	public void nuevoMovimientoPersonajes(String pj, String sprite, Punto point){
		TilePlayer player = personajes.get(pj);
		if (player == null){
			player= new TilePlayer(pj,sprite,point);
			personajes.put(pj, player );
		}
		mapa.moverPlayer(player);

	}

	public void nuevaDetencionPersonaje(String pj){
		// aca te envio que el personaje llego a su destino, 
		// si por las dudas no llego todavia moverlo magicamente.
	}

}
