package promotionSystem.interfazGrafica;

import promotionSystem.Cliente;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class VerPersonaje extends JFrame {

	private JPanel contentPane;
	private JLabel lblNivel;
	private JLabel lblSalud;
	private JLabel lblAtaque;
	private JLabel lblDefensa;
	private JLabel lblMagia;
	private JLabel lblVelocidad;
	private JLabel lblRaza;
	private JLabel lblCasta;

	public VerPersonaje(Cliente cliente) {

		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblDetallesDelPersonaje = new JLabel("Detalles del Personaje");
		lblDetallesDelPersonaje.setBounds(171, 22, 250, 14);
		contentPane.add(lblDetallesDelPersonaje);

		lblRaza = new JLabel("Raza: " + cliente.getRaza());
		lblRaza.setBounds(39, 52, 200, 14);
		contentPane.add(lblRaza);

		lblCasta = new JLabel("Casta: " + cliente.getCasta());
		lblCasta.setBounds(39, 77, 200, 14);
		contentPane.add(lblCasta);

		lblNivel = new JLabel("Nivel: " + Integer.toString(cliente.getPersonaje().getNivel()));
		lblNivel.setBounds(39, 102, 80, 14);
		contentPane.add(lblNivel);

		lblSalud = new JLabel("Salud: " + Integer.toString(cliente.getPersonaje().getSaludMaxima()));
		lblSalud.setBounds(39, 127, 80, 14);
		contentPane.add(lblSalud);

		lblAtaque = new JLabel("Ataque: " + Integer.toString(cliente.getPersonaje().getAtaque()));
		lblAtaque.setBounds(39, 152, 80, 14);
		contentPane.add(lblAtaque);

		lblDefensa = new JLabel("Defensa: " + Integer.toString(cliente.getPersonaje().getDefensa()));
		lblDefensa.setBounds(39, 177, 80, 14);
		contentPane.add(lblDefensa);

		lblMagia = new JLabel("Magia: " + Integer.toString(cliente.getPersonaje().getMagia()));
		lblMagia.setBounds(39, 202, 80, 14);
		contentPane.add(lblMagia);

		lblVelocidad = new JLabel("Velocidad: " + Integer.toString(cliente.getPersonaje().getEnergia()));
		lblVelocidad.setBounds(39, 227, 100, 14);
		contentPane.add(lblVelocidad);

		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(151, 228, 89, 23);
		contentPane.add(btnVolver);

		btnVolver.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				dispose();

			}

		});

		addWindowListener(new WindowListener() {

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

			}

		});
	}

}
