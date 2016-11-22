package promotionSystem.interfazGrafica;

import promotionSystem.Cliente;
import promotionSystem.juego.JuegoPanel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

public class SeleccionMapa extends JFrame {

	private JPanel contentPane;
	private Cliente cliente;
	private JComboBox comboBox;

	public SeleccionMapa(Cliente cliente) throws IOException {
		this.cliente = cliente;
		cliente.enviarAccion("recibirMapas");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
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
		comboBox.setBounds(150, 51, 200, 20);
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

		JButton btnJugar = new JButton("JUGAR");
		btnJugar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					enviarAccion();
					enviarMapaElegido();
					recibirPosicionInicial();
					abrirMapa();

				} catch (IOException e1) {

					JOptionPane.showMessageDialog(null,"Error al abrir la partida","Error",JOptionPane.ERROR_MESSAGE);
					dispose();
				}
			}

		});

		btnJugar.setBounds(175, 194, 89, 23);
		contentPane.add(btnJugar);

	}

	protected void recibirPosicionInicial() throws IOException {
		cliente.recibirPosicionInicial();

	}

	private void enviarAccionDeCerrar() throws IOException {
		cliente.enviarAccion("cerrar");
	}

	private void agregarMapas() throws IOException {
		ArrayList<String> mapasRecibidos = (ArrayList<String>) cliente.recibirMapas();
		for (String mapa : mapasRecibidos) {
			comboBox.addItem(mapa);
		}

	}

	private void enviarAccion() throws IOException {
		cliente.enviarAccion("seleccionarMapa");
	}

	private void enviarMapaElegido() throws IOException {
		String mapa = (String) comboBox.getSelectedItem();
		cliente.enviarMapaSeleccionado(mapa);
	}

	private void abrirMapa() throws IOException {
		JFrame juego = new JFrame("Kings of the Multiverse V1.0");
		juego.setBounds(100, 100, 800, 600);
		JuegoPanel panel;
		panel = new JuegoPanel(juego, "Mapa Prueba", cliente);
		juego.add(panel);

		juego.setResizable(false);
		juego.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		juego.setVisible(true);

		juego.addWindowListener(new WindowAdapter() {

		
			@Override
			public void windowClosing(WindowEvent e) {

				try {
					enviarAccionDeCerrar();
				} catch (IOException e1) {

					JOptionPane.showMessageDialog(null,"Error al cerrar","Error",JOptionPane.ERROR_MESSAGE);
				}

			}


		});
	}

}
