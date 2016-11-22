package promotionSystem.interfazGrafica;

import promotionSystem.Cliente;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

public class MenuPrincipal extends JFrame {

	private JPanel contentPane;
	private Cliente cliente;
	private JFrame marco;
	public MenuPrincipal(Cliente cliente) throws Exception {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		marco=this;
		setTitle("Menu Principal");
		this.cliente=cliente;
		
		
		
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
					dispose();
				}
				
			}

		});
		btnSeleccionarMapa.setBounds(163, 50, 115, 23);
		contentPane.add(btnSeleccionarMapa);
		
		JButton btnSalir = new JButton("Salir");
		btnSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
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
		
		
		addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent e) {
			
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				
				try {
					enviarAccionDeCerrar();
				} catch (IOException e1) {
					
					JOptionPane.showMessageDialog(null,"Error al cerrar","Error",JOptionPane.ERROR_MESSAGE);
				}
				dispose();
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				
				
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
			
				
			}

			@Override
			public void windowIconified(WindowEvent e) {
			
				
			}

			@Override
			public void windowOpened(WindowEvent e) {
			
				
			}
			
		});
	}
	
	

	private void enviarAccionDeCerrar() throws IOException {
		 cliente.enviarAccion("cerrar");
	 }

	private void abrirSeleccionDeMapa() throws IOException {
		SeleccionMapa mapa=new SeleccionMapa(cliente);
		mapa.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		mapa.setVisible(true);
		
		mapa.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
			
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
		
				marco.setEnabled(true);
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
			
				marco.setEnabled(true);
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
			
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {
	
				
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
		ver.addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent arg0) {
			
				
			}

			@Override
			public void windowClosed(WindowEvent arg0) {
		
				marco.setEnabled(true);
				
			}

			@Override
			public void windowClosing(WindowEvent arg0) {
			
				marco.setEnabled(true);
			}

			@Override
			public void windowDeactivated(WindowEvent arg0) {
			
				
			}

			@Override
			public void windowDeiconified(WindowEvent arg0) {
				
				
			}

			@Override
			public void windowIconified(WindowEvent arg0) {

				
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
			
				marco.setEnabled(false);
			}
			
		});
	}
}
