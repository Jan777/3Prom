package promotionSystem.interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JComboBox;

import promotionSystem.razas.castas.kingdomHearts.Riku;
import promotionSystem.sprites.CargaImagen;
import promotionSystem.sprites.Sprite;
import promotionSystem.Alianza;
import promotionSystem.Personaje;
import promotionSystem.Punto;

import javax.swing.JLabel;
import javax.swing.JRadioButton;

import java.awt.Font;

public class Batalla extends JFrame {

	private JPanel contentPane;
	private BufferedImage fondo;
	private BufferedImage spriteUnitario;
	private List<Personaje> alianzaDesafiante;
	private List<Personaje> alianzaDesafiada;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Alianza a1=new Alianza();
					Alianza a2=new Alianza();
					
					a1.agregarPersonaje(new Riku());
					a1.agregarPersonaje(new Riku());
					a1.agregarPersonaje(new Riku());
					a1.agregarPersonaje(new Riku());
					a1.agregarPersonaje(new Riku());
					a1.agregarPersonaje(new Riku());
					a2.agregarPersonaje(new Riku());
					a2.agregarPersonaje(new Riku());
					a2.agregarPersonaje(new Riku());
					a2.agregarPersonaje(new Riku());
					a2.agregarPersonaje(new Riku());
					a2.agregarPersonaje(new Riku());
					
					Batalla frame = new Batalla(a1,a2);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Batalla(Alianza alianzaOrigen, Alianza alianzaDestino) {
		this.alianzaDesafiada=alianzaDestino.getPersonajes();
		this.alianzaDesafiante=alianzaOrigen.getPersonajes();
		
		setTitle("Batalla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(176, 469, 251, 48);
		contentPane.add(comboBox);
		
		JButton btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.setBounds(549, 488, 235, 48);
		contentPane.add(btnEjecutar);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(549, 444, 235, 41);
		contentPane.add(comboBox_1);
		
		JLabel lblSeleccionarEnemigo = new JLabel("Seleccionar Enemigo");
		lblSeleccionarEnemigo.setBounds(615, 420, 200, 14);
		contentPane.add(lblSeleccionarEnemigo);
		
		JLabel lblSeleccionarMagia = new JLabel("Seleccionar Magia");
		lblSeleccionarMagia.setBounds(269, 444, 200, 14);
		contentPane.add(lblSeleccionarMagia);
		
		JRadioButton rdbtnAtacar = new JRadioButton("Atacar");
		rdbtnAtacar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnAtacar.setBounds(37, 438, 109, 23);
		contentPane.add(rdbtnAtacar);
		
		JRadioButton rdbtnMagia = new JRadioButton("Hechizar");
		rdbtnMagia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMagia.setBounds(37, 480, 225, 23);
		contentPane.add(rdbtnMagia);
		
		JRadioButton rdbtnHuir = new JRadioButton("Huir");
		rdbtnHuir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnHuir.setBounds(37, 532, 109, 23);
		contentPane.add(rdbtnHuir);
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
			//g2d.drawString(personaje.getNombre(), punto.getX()+10,punto.getY()-5);
			g2d.drawString(personaje.getSalud()+ " / " +personaje.getSaludMaxima(),  punto.getX()+10,punto.getY()+5);
			
		}
		
		for(Personaje personaje: alianzaDesafiada){
			spriteUnitario= CargaImagen.cargarImagen("recursos/Batalla/"+ personaje.getCasta() +"BatallaInvertida.png");
			Punto punto=obtenerPosicionEnFrameBatallaDesafiados(alianzaDesafiada.indexOf(personaje));
			g2d.drawImage(spriteUnitario, punto.getX(),punto.getY(), null);
			
			Font tipoDeLetra=new Font("Arial", Font.BOLD, 16);
			g.setColor(Color.CYAN);
			g.setFont(tipoDeLetra);
			//g2d.drawString(personaje.getNombre(), punto.getX()+70,punto.getY()-5);
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
