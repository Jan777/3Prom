package promotionSystem.interfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import promootionSystem.graficaNuestra.JuegoPanel;
import promotionSystem.Cliente;
import promotionSystem.pantallaJuego.juego.Juego;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class SeleccionMapa extends JFrame {

	private JPanel contentPane;
	private Cliente cliente;
	private JComboBox comboBox;
	public SeleccionMapa(Cliente cliente) throws IOException {
		this.cliente=cliente;
		cliente.enviarAccion("recibirMapas");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblSeleccioneUnMapa = new JLabel("Seleccione un Mapa:");
		lblSeleccioneUnMapa.setBounds(175, 11, 114, 14);
		contentPane.add(lblSeleccioneUnMapa);
		 
		comboBox = new JComboBox<String>();
		comboBox.setBounds(150, 51,200, 20);
		contentPane.add(comboBox);
		
		agregarMapas();
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnVolver.setBounds(175, 228, 89, 23);
		contentPane.add(btnVolver);
		btnVolver.setEnabled(false);
		JButton btnJugar = new JButton("JUGAR");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}

			
		});
	
		btnJugar.setBounds(175, 194, 89, 23);
		contentPane.add(btnJugar);
		
		JButton btnPrueba = new JButton("Prueba");
		btnPrueba.setBounds(175, 129, 89, 23);
		btnPrueba.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				JFrame juego=new JFrame("King of Multiverse V1.0");
				juego.setBounds(100, 100, 800, 600);
				JuegoPanel panel;
				try {
					panel = new JuegoPanel(juego);
					juego.add(panel);
				} catch (FileNotFoundException e) {
					
					e.printStackTrace();
				}
				
				juego.setResizable(false);
				juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				juego.setVisible(true);
				
			}
			
		});
		contentPane.add(btnPrueba);
	}
	private void agregarMapas() throws IOException {
		ArrayList<String> razasRecibidas = (ArrayList<String>) cliente.recibirMapas();
		for(String raza : razasRecibidas) {
		    comboBox.addItem(raza);
		}
		
	}
	private void enviarAccion() throws IOException {
		cliente.enviarAccion("seleccionarMapa");
	}
	
	 private void cargarRazas() throws IOException {
		
	
		
	}
}