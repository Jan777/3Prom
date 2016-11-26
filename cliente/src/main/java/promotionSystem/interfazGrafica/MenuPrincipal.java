package promotionSystem.interfazGrafica;

import promotionSystem.Cliente;
import promotionSystem.juego.Sonido;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private Cliente cliente;
	private JFrame marco;
	private Sonido sonido;
	public MenuPrincipal(Cliente cliente, Sonido sonido) throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco=this;
		setTitle("Menu Principal");
		this.cliente=cliente;
		this.sonido=sonido;		
		setBounds(100, 100, 450, 300);
		setResizable(false);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblMenu = new JLabel("MENU PRINCIPAL");
		lblMenu.setBounds(181, 11, 126, 14);
		contentPane.add(lblMenu);
		
		
		
		JButton btnSeleccionarMapa = new JButton("Seleccionar Mapa");
		btnSeleccionarMapa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					abrirSeleccionDeMapa();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null,"Error al abrir el menu","Error",JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				
			}

		});
		btnSeleccionarMapa.setBounds(163, 50, 115, 23);
		contentPane.add(btnSeleccionarMapa);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					pararMusica();
					enviarAccionDeCerrar();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null,"Error al salir","Error",JOptionPane.ERROR_MESSAGE);
				}
				dispose();
			}

					
		});
		btnSalir.setBounds(170, 228, 89, 23);
		contentPane.add(btnSalir);
		
		
		
		JButton btnVerDetallesDel = new JButton("Ver Detalles del Personaje");
		
		btnVerDetallesDel.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrirVerPersonaje();
				
			}
			
		});
		btnVerDetallesDel.setBounds(134, 84, 185, 23);
		contentPane.add(btnVerDetallesDel);
		
		
		addWindowListener(new WindowAdapter(){
			
			@Override
			public void windowClosing(WindowEvent e) {
				
				try {
					enviarAccionDeCerrar();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null,"Error al cerrar","Error",JOptionPane.ERROR_MESSAGE);
				}
				dispose();
			}
		});
	}
	
	private void pararMusica() {
		sonido.cerrar();
		
	}
	

	private void enviarAccionDeCerrar() throws IOException {
		 cliente.enviarAccion("cerrar");
	 }

	private void abrirSeleccionDeMapa() throws IOException {
		SeleccionMapa mapa=new SeleccionMapa(cliente,marco,sonido);
		mapa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mapa.setVisible(true);
		
		mapa.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosed(WindowEvent arg0) {
		
				marco.setEnabled(true);
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
			
				marco.setEnabled(true);
			}

			
			@Override
			public void windowOpened(WindowEvent arg0) {
			
				marco.setEnabled(false);
			}
			
		});
	}



	private void abrirVerPersonaje() {
		VerPersonaje ver=new VerPersonaje(cliente);
		ver.setBounds(100, 100, 500, 400);
		ver.setVisible(true);
		ver.addWindowListener(new WindowAdapter(){

			@Override
			public void windowClosed(WindowEvent arg0) {
		
				marco.setEnabled(true);
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
			
				marco.setEnabled(true);
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
			
				marco.setEnabled(false);
			}
			
		});
	}
}
