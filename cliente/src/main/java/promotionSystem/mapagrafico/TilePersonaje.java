package promotionSystem.mapagrafico;

import promotionSystem.Cliente;
import promotionSystem.Personaje;
import promotionSystem.Punto;
import promotionSystem.interfazGrafica.Batalla;
import promotionSystem.juego.Camara;
import promotionSystem.juego.Mouse;
import promotionSystem.juego.TileOtrosJugadores;
import promotionSystem.sprites.Animacion;
import promotionSystem.sprites.Sprite;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class TilePersonaje {

	public final static int ANCHO = 64;
	public final static int ALTO = 32;
	private final int xCentro;
	private final int yCentro;
	private String nombre;
	private Mouse mouse;

	private Personaje personajeJugable;
	private int xInicio;
	private int yInicio;
	private int xDestino;
	private int yDestino;

	private boolean nuevoRecorrido;
	private Camara camara;

	private int movimiento;
	private boolean enMovimiento;
	private boolean parado;
	private int movimientoAnterior;
	private Animacion[] animacionCaminado;
	public Image imagen;
	private Cliente cliente;
	private JPopupMenu popup;
	private Personaje personajeClickeado;


	public TilePersonaje(Cliente cliente,Mouse mouse,Camara camara) {
		this.cliente=cliente;
		this.xCentro = 320;
		this.yCentro = 320;

		incializarPopup();
		this.camara = camara;
		this.movimiento = 0;
		this.personajeJugable = cliente.getPersonaje();
		this.nombre = cliente.getNombre();	
		this.xInicio = this.xDestino = -cliente.getPersonaje().getPosicion().getX();  
		this.yInicio = this.yDestino =  -cliente.getPersonaje().getPosicion().getY(); 
		this.mouse = mouse;

		inicializarAnimaciones("RecursosPersonaje/Razas/" + cliente.getCasta() + "/" + cliente.getCasta() + ".png");

		this.nuevoRecorrido = false;

	}

	private void incializarPopup() {
		popup = new JPopupMenu();
		JMenuItem seleccionarBatalla = new JMenuItem("Seleccionar Batalla");
		popup.add(seleccionarBatalla);	
		
		seleccionarBatalla.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cliente.enviarNotificacionDeBatalla(personajeClickeado);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				popup.transferFocus();
				popup.setVisible(false);
			}
		});
	
		
		JMenuItem solicitarAlianza = new JMenuItem("Solicitar Alianza");
		popup.add(solicitarAlianza);

		solicitarAlianza.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					cliente.enviarInvitacionAAlianza(personajeClickeado);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				popup.setVisible(false);

			}
		});
		
		JMenuItem cancelar = new JMenuItem("Cancelar");
		popup.add(cancelar);
		
		cancelar.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {			
				popup.transferFocus();
				popup.setVisible(false);

			}
		});
			
	
	}

	public void dibujarCentro(Graphics g) {
		g.drawImage(obtenerFrameActual(), xCentro - 25, yCentro - 50, null);
		Font tipoDeLetra = new Font("Arial", Font.BOLD, 16);
		g.setColor(Color.BLUE);
		g.setFont(tipoDeLetra);
		g.drawString(nombre, xCentro, yCentro - 48 /*- 25*/);

	}

	public void actualizar() throws Exception {
		int posMouse[] = mouse.getPos();

		if (mouse.getClickIzquierdo()) {
			personajeClickeado = CoincideConOtroJugador();
			if (personajeClickeado != null && alianzaEsValida()) {
				abrirPopup();
			}
			mouse.setClickIzquierdo(false);
		}
		if (cliente.getInvitacionAAlianza()) {
			abrirPanelDeRespuesta();
			cliente.setInvitacionAAlianza(false);
		}
		if(cliente.getDesafioABatalla()){
			abrirPanelDeBatalla();
			cliente.setDesafioABatalla(false);
		}

		actualizarAnimaciones();

		if (mouse.getRecorrido()) {
			setNuevoRecorrido(true);

			xDestino = xInicio - posMouse[0] + camara.getxOffCamara();
			yDestino = yInicio - posMouse[1] + camara.getyOffCamara();
			mouse.setRecorrido(false);
		}

	}

	private void abrirPanelDeBatalla() {
		new Batalla(cliente);
	}

	private boolean alianzaEsValida() {
		return ((personajeJugable.getAlianza()!=null && personajeClickeado.getAlianza()!=null) && (personajeJugable.getAlianza()!=personajeClickeado.getAlianza())
			|| (personajeJugable.getAlianza()==null && personajeClickeado.getAlianza()!=null) || (personajeJugable.getAlianza()!=null && personajeClickeado.getAlianza()==null)
			|| (personajeJugable.getAlianza()==null && personajeClickeado.getAlianza()==null));
	}

	private void abrirPanelDeRespuesta() throws Exception {
		int respuesta = JOptionPane.showConfirmDialog(null, "Aceptar o Rechazar invitacion a Alianza", "Invitacion",
				JOptionPane.YES_NO_OPTION);
		if (respuesta == JOptionPane.YES_OPTION) {
			cliente.enviarRespuestaAInvitacionDeAlianza(true, cliente.getInvitador());
		} 
		else {
			cliente.enviarRespuestaAInvitacionDeAlianza(false, cliente.getInvitador());
		}
	}

	private void abrirPopup() {

		popup.setLocation(xCentro, yCentro);
		popup.setVisible(true);
	}

	private Personaje CoincideConOtroJugador() {
		Punto puntoClickeado = new Punto((xInicio - mouse.getPosicionClickIzquierdo()[0] + camara.getxOffCamara()) * -1,
				(yInicio - mouse.getPosicionClickIzquierdo()[1] + camara.getyOffCamara()) * -1);

		for (TileOtrosJugadores otroJugador : cliente.getTiles()) {

			if (otroJugador.getPersonaje().getPosicion().comparar(puntoClickeado)) {
				return otroJugador.getPersonaje();
			}
		}
		return null;
	}

	public int getXDestino() {
		return xDestino;
	}

	public int getYDestino() {
		return yDestino;
	}

	public void mover(int xDestino2, int yDestino2) {
		xInicio = xDestino2;
		yInicio = yDestino2;

	}

	public void inicializarAnimaciones(String pathPJ) {
		Sprite spriteCaminando = new Sprite(pathPJ);
		animacionCaminado = new Animacion[8];
		for (int i = 0; i < animacionCaminado.length; i++) {
			animacionCaminado[i] = new Animacion(100, spriteCaminando.getVectorSprite(i));
		}

	}

	public void actualizarAnimaciones() {
		for (int i = 0; i < 8; i++) {
			animacionCaminado[i].actualizar();
		}

	}

	public void paraDondeVoy(int xDestino2, int yDestino2) {
		movimiento = 0;
		parado = false;

		if (xInicio == xDestino2 && yInicio == yDestino2) {
			parado = true;
			return;
		}
		if (xInicio > xDestino2 && yInicio > yDestino2) {
			movimiento = 6;
			return;
		}
		if (xInicio > xDestino2 && yInicio == yDestino2) {
			movimiento = 5;
			return;
		}
		if (xInicio > xDestino2 && yInicio < yDestino2) {
			movimiento = 4;
			return;
		}
		if (xInicio == xDestino2 && yInicio < yDestino2) {
			movimiento = 3;
			return;
		}
		if (xInicio < xDestino2 && yInicio == yDestino2) {
			movimiento = 1;
			return;
		}
		if (xInicio < xDestino2 && yInicio > yDestino2) {
			movimiento = 0;
			return;
		}
		if (xInicio == xDestino2 && yInicio > yDestino2) {
			movimiento = 7;
			return;
		}
		if (xInicio < xDestino2 && yInicio < yDestino2) {
			movimiento = 2;
			return;
		}

	}

	public BufferedImage obtenerFrameActual() {
		if (!parado)
			return animacionCaminado[movimiento].getFrameActual();
		return animacionCaminado[movimientoAnterior].getFrame(8);
	}

	public void setNuevoRecorrido(boolean bs) {
		this.nuevoRecorrido = bs;
	}

	public boolean getNuevoRecorrido() {
		return nuevoRecorrido;
	}

	public boolean estaEnMovimiento() {
		return enMovimiento;
	}

	public void setEnMovimiento(boolean b) {
		this.enMovimiento = b;
	}

	public void parar() {
		movimientoAnterior = movimiento;
		parado = true;
	}

	public int getXCentro() {
		return xCentro;
	}

	public int getYCentro() {
		return yCentro;
	}

	public String getNombre() {
		return personajeJugable.getNombre();
	}

}
