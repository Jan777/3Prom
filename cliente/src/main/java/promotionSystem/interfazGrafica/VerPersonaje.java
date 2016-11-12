package promotionSystem.interfazGrafica;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

import promotionSystem.Cliente;

public class VerPersonaje extends JFrame {

	private JPanel contentPane;

	
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VerPersonaje frame = new VerPersonaje();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	
	public VerPersonaje(Cliente cliente) {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblDetallesDelPersonaje = new JLabel("Detalles del Personaje");
		lblDetallesDelPersonaje.setBounds(171, 22, 106, 14);
		contentPane.add(lblDetallesDelPersonaje);
		
		JLabel lblNivel = new JLabel("Nivel");
		lblNivel.setBounds(39, 52, 46, 14);
		contentPane.add(lblNivel);
		
		JLabel lblSalud = new JLabel("Salud");
		lblSalud.setBounds(39, 77, 46, 14);
		contentPane.add(lblSalud);
		
		JLabel lblAtaque = new JLabel("Ataque");
		lblAtaque.setBounds(39, 102, 46, 14);
		contentPane.add(lblAtaque);
		
		JLabel lblDefensa = new JLabel("Defensa");
		lblDefensa.setBounds(39, 127, 46, 14);
		contentPane.add(lblDefensa);
		
		JLabel lblMagia = new JLabel("Magia");
		lblMagia.setBounds(39, 152, 46, 14);
		contentPane.add(lblMagia);
		
		JLabel lblVelocidad = new JLabel("Velocidad");
		lblVelocidad.setBounds(39, 177, 46, 14);
		contentPane.add(lblVelocidad);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(151, 228, 89, 23);
		contentPane.add(btnVolver);
		
		btnVolver. addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();
				
			}
			
		});
		
		JLabel label = new JLabel("");
		label.setBounds(171, 52, 46, 14);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(171, 77, 46, 14);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(171, 102, 46, 14);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(171, 127, 46, 14);
		contentPane.add(label_3);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(171, 152, 46, 14);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.setBounds(171, 177, 46, 14);
		contentPane.add(label_5);
		
		JLabel lblEnergia = new JLabel("Energia");
		lblEnergia.setBounds(39, 202, 46, 14);
		contentPane.add(lblEnergia);
		
		JLabel label_6 = new JLabel("");
		label_6.setBounds(171, 202, 46, 14);
		contentPane.add(label_6);
		
		addWindowListener(new WindowListener(){

			@Override
			public void windowActivated(WindowEvent e) {
			
				
			}

			@Override
			public void windowClosed(WindowEvent e) {
				
			}

			@Override
			public void windowClosing(WindowEvent e) {
				
				
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
			 label_1.setText(Integer.toString(cliente.getPersonaje().getNivel()));
			 label_2.setText(Integer.toString(cliente.getPersonaje().getSaludMaxima()));
			 label_3.setText(Integer.toString(cliente.getPersonaje().getAtaque()));
			 label_4.setText(Integer.toString(cliente.getPersonaje().getDefensa()));
			 label_5.setText(Integer.toString(cliente.getPersonaje().getMagia()));
			 label_6.setText(Integer.toString(cliente.getPersonaje().getEnergia()));
				
			}
			
		});
	}
}
