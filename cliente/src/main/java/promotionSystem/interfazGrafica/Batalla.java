package promotionSystem.interfazGrafica;

import promotionSystem.Cliente;
import promotionSystem.Personaje;
import promotionSystem.Punto;
import promotionSystem.juego.Sonido;
import promotionSystem.sprites.CargaImagen;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

public class Batalla extends JFrame {

	private JPanel contentPane;
	private BufferedImage fondo;
	private BufferedImage spriteUnitario;
	private List<Personaje> alianzaDesafiante;
	private List<Personaje> alianzaDesafiada;
	private ButtonGroup buttonGroup;
	private Cliente cliente;
	private JLabel lblSeleccionarMagia;
	private JLabel lblSeleccionarEnemigo;
	private JComboBox<String> seleccionarEnemigo;
	private JComboBox<String> seleccionarAliado;
	private JComboBox<String> seleccionarMagia;
	private JButton btnEjecutar;
	private JRadioButton rdbtnAtacar;
	private JRadioButton rdbtnMagia;
	private JRadioButton rdbtnHuir;
	
	public Batalla(Cliente cliente) {
		Sonido.BATALLAPOKEMON.loop();
		this.alianzaDesafiada=cliente.getAlianzaEnemiga().getPersonajes();
		this.alianzaDesafiante=cliente.getAlianzaAmiga().getPersonajes();
		this.cliente = cliente;
		setVisible(true);
		setTitle("Batalla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		buttonGroup = new ButtonGroup();
		
		seleccionarMagia = new JComboBox<>();
		seleccionarMagia.setBounds(176, 469, 251, 48);
		contentPane.add(seleccionarMagia);
		
		btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.setBounds(549, 488, 235, 48);
		contentPane.add(btnEjecutar);
		
		seleccionarEnemigo = new JComboBox<>();
		seleccionarEnemigo.setBounds(549, 444, 235, 41);
		contentPane.add(seleccionarEnemigo);
		cargarEnemigos();
		
		seleccionarAliado = new JComboBox<>();
		seleccionarAliado.setBounds(549, 444, 235, 41);
		contentPane.add(seleccionarAliado);
		cargarAliados();
		seleccionarAliado.setVisible(false);
		lblSeleccionarEnemigo = new JLabel("Seleccionar Enemigo");
		lblSeleccionarEnemigo.setBounds(615, 420, 200, 14);
		contentPane.add(lblSeleccionarEnemigo);
		
		lblSeleccionarMagia = new JLabel("Seleccionar Magia");
		lblSeleccionarMagia.setBounds(269, 444, 200, 14);
		contentPane.add(lblSeleccionarMagia);
		
		rdbtnAtacar = new JRadioButton("Atacar");
		rdbtnAtacar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnAtacar.setBounds(37, 438, 109, 23);
		contentPane.add(rdbtnAtacar);
		
		rdbtnMagia = new JRadioButton("Hechizar");
		rdbtnMagia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMagia.setBounds(37, 480, 200, 23);
		contentPane.add(rdbtnMagia);
		
		rdbtnHuir = new JRadioButton("Huir");
		rdbtnHuir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnHuir.setBounds(37, 532, 109, 23);
		contentPane.add(rdbtnHuir);
		
		buttonGroup.add(rdbtnAtacar);
		buttonGroup.add(rdbtnMagia);
		buttonGroup.add(rdbtnHuir);
		seleccionarMagia.setEnabled(false);
		cargarHechizos();
		
		rdbtnAtacar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnAtacar.isSelected()){
					seleccionarMagia.setEnabled(false);
				}
			}
		});

		rdbtnMagia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMagia.isSelected()){
					seleccionarMagia.setEnabled(true);
				}
			}
		});
		
		rdbtnHuir.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnHuir.isSelected()){
					seleccionarMagia.setEnabled(false);
				}
			}
		});
		

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				try {
					enviarAccionDeCerrar();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "ERROR!");
				}

			}



		});

	}

	private void enviarAccionDeCerrar() throws IOException {
		cliente.enviarAccion("cerrar");

	}

	private void cargarAliados() {
		for(Personaje personajeAliado:alianzaDesafiante){
			seleccionarAliado.addItem(personajeAliado.getNombre());
		}

	}

	private void cargarEnemigos() {
		for(Personaje personajeEnemigo:alianzaDesafiada){
			seleccionarEnemigo.addItem(personajeEnemigo.getNombre());
		}

	}

	private void cargarHechizos() {
		for(String key : cliente.getPersonaje().getHechizos()) {
			seleccionarMagia.addItem(key);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		fondo= CargaImagen.cargarImagen("recursos/Batalla/BatallaFondo.gif");
		g2d.drawImage(fondo, 0, 0, null);
		for(Personaje personaje: alianzaDesafiante){
			spriteUnitario= CargaImagen.cargarImagen("recursos/Batalla/"+ personaje.getCasta() +"Batalla.png");
			Punto punto=obtenerPosicionEnFrameBatallaDesafiantes(alianzaDesafiante.indexOf(personaje));
			g2d.drawImage(spriteUnitario, punto.getX(),punto.getY(), null);
			
			Font tipoDeLetra=new Font("Arial", Font.BOLD, 16);
			g.setColor(Color.WHITE);
			g.setFont(tipoDeLetra);
			g2d.drawString(personaje.getNombre(), punto.getX()+10,punto.getY()-7);
			g2d.drawString(personaje.getSalud()+ " / " +personaje.getSaludMaxima(),  punto.getX()+10,punto.getY()+5);
			
		}
		
		for(Personaje personaje: alianzaDesafiada){
			spriteUnitario= CargaImagen.cargarImagen("recursos/Batalla/"+ personaje.getCasta() +"BatallaInvertida.png");
			Punto punto=obtenerPosicionEnFrameBatallaDesafiados(alianzaDesafiada.indexOf(personaje));
			g2d.drawImage(spriteUnitario, punto.getX(),punto.getY(), null);
			
			Font tipoDeLetra=new Font("Arial", Font.BOLD, 16);
			g.setColor(Color.CYAN);
			g.setFont(tipoDeLetra);
			g2d.drawString(personaje.getNombre(), punto.getX()+70,punto.getY()-7);
			g2d.drawString(personaje.getSalud()+ " / " +personaje.getSaludMaxima(),  punto.getX()+70,punto.getY()+5);
		}
		
		
	}
	
	public Punto obtenerPosicionEnFrameBatallaDesafiantes(int posicionDeLlegada){
	   int x=0, y=0;
		
		if(posicionDeLlegada==0 || posicionDeLlegada==1 || posicionDeLlegada==2){
			x=128;
		}
		
		if(posicionDeLlegada==0 || posicionDeLlegada==3){
			y=225;
		}
		if(posicionDeLlegada==1 || posicionDeLlegada==4){
			y=273;
		}
		if(posicionDeLlegada==5 || posicionDeLlegada==2){
			y=322;
		}
		
		
		return new Punto(x,y);
	}
	
	public Punto obtenerPosicionEnFrameBatallaDesafiados(int posicionDeLlegada){
		   int x=672, y=0;
			
			if(posicionDeLlegada==0 || posicionDeLlegada==1 || posicionDeLlegada==2){
				x=544;
			}
			
			if(posicionDeLlegada==0 || posicionDeLlegada==3){
				y=225;
			}
			if(posicionDeLlegada==1 || posicionDeLlegada==4){
				y=273;
			}
			if(posicionDeLlegada==5 || posicionDeLlegada==2){
				y=322;
			}
			
			
			return new Punto(x,y);
		}
}
