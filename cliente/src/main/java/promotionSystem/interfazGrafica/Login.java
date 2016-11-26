package promotionSystem.interfazGrafica;

import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import promotionSystem.Cliente;
import promotionSystem.juego.Sonido;
import promotionSystem.sprites.CargaImagen;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

public class Login extends JFrame {

	private Cliente cliente;
	private JPanel panelContenido;
	private JTextField nombre;
	private JButton registrarse;
	private JPasswordField contraseña;
	private JButton aceptar;
	private JLabel error;
	private JLabel contraseñaLabel;
	private JLabel nombreLabel;
	private JLabel label;
	private JButton salir;
	private JLabel aunNoRegistro;
	private Sonido sonido;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					JOptionPane.showMessageDialog(null,"Error en el menu","Error",JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws Exception 
	 */
	public Login() throws Exception {
		
		sonido = new Sonido("Menu Principal");
		sonido.reproducir();
		
		cliente = new Cliente();
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 430, 400);
		panelContenido = new JPanel();
		panelContenido.setBorder(new EmptyBorder(5, 5, 5, 5));
		panelContenido.setLayout(null);
		setResizable(false);
		repaint();
		
		nombreLabel = new JLabel("Nombre de Usuario");
		panelContenido.add(nombreLabel);
		
		contraseñaLabel = new JLabel("Contraseña");
		panelContenido.add(contraseñaLabel);
		
		nombre = new JTextField();
		panelContenido.add(nombre);
		nombre.setColumns(10);
		
		contraseña = new JPasswordField();
		panelContenido.add(contraseña);
		
		aceptar = new JButton("Aceptar");
		panelContenido.add(aceptar);
		
		aunNoRegistro = new JLabel("Aún no te has registrado?");
		panelContenido.add(aunNoRegistro);
		
		registrarse = new JButton("Registrarse");
		panelContenido.add(registrarse);
		
		error = new JLabel("");
		panelContenido.add(error);
		
		salir = new JButton("Salir");
		panelContenido.add(salir);
		
		contraseña.addKeyListener(new KeyAdapter() {

			@Override				
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					aceptar();
				}
			}
		});

		aceptar.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				aceptar();
			}
		});

		registrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrirRegistrar();
			}

		});

		nombreLabel.setBounds(10, 82, 128, 20);
		nombre.setBounds(166, 82, 186, 20);
		contraseñaLabel.setBounds(10, 113, 118, 20);
		contraseña.setBounds(166, 113, 186, 20);
		aceptar.setBounds(178, 157, 100, 30);
		aunNoRegistro.setBounds(10, 209, 156, 20);
		registrarse.setBounds(195, 209, 120, 20);
		salir.setBounds(319, 312, 75, 30);
		error.setBounds(22, 257, 367, 30);
		
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				try {
					enviarAccionDeCerrar();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null,"Error al cerrar el login" ,"ERROR!",JOptionPane.ERROR_MESSAGE);
				}

			}

		});

		salir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					enviarAccionDeCerrar();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null,"Error al iniciar sesion","Error",JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				pararSonido();
				cerrarFrame();
			}

		});

		getContentPane().add(panelContenido);
	}
	
	public void paint(Graphics graphics){
		super.paint(graphics);
		Graphics2D logo = (Graphics2D) graphics;
		BufferedImage image = CargaImagen.cargarImagen("Recursos/kingsOfTheMultiverseLogoMenu.png");
		logo.drawImage(image, 0, 20, null);
	}
	
	private void enviarAccionDeCerrar() throws IOException {
		cliente.enviarAccion("cerrar");
	}

	private void cerrarFrame() {
		dispose();
	}

	private void aceptar() {
		try {
			if (camposNoVacios()) {
				registrarse.setEnabled(false);
				enviarAccion();
				iniciarSesion();
				if (resultado()) {
					cargarNombre();
					cargarPersonaje();
					conectarASocketBatalla();
					menuPrincipal();
				} else{
					error.setText("Usuario y/o Contraseña incorrecta o usuario ya logueado");
					vaciarCampos();
				}
			} else {
				error.setText("Los Campos no deben estar vacios");
			}
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error al iniciar sesion","Error",JOptionPane.ERROR_MESSAGE);
			System.exit(0);
		}
	}

	private void conectarASocketBatalla() throws UnknownHostException, IOException {
		cliente.conectarASocketBatalla();
		cliente.enviarNombreASocketBatalla();
		
	}

	private void cargarPersonaje() throws Exception {
		if (!cliente.tienePersonaje()) {
			cliente.enviarAccion("cargarPersonaje");
			cliente.recibirPersonaje();
		}
	}

	private void abrirRegistrar() {
		Registrarse marco = new Registrarse(cliente, sonido);
		marco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		marco.setVisible(true);

		marco.addWindowListener(new WindowAdapter() {

			
			@Override
			public void windowClosed(WindowEvent arg0) {
				setEnabled(true);
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				setEnabled(false);
			}

		});
	}

	private void vaciarCampos() {
		nombre.setText("");
		contraseña.setText("");
	}

	private void cargarNombre() {
		cliente.setNombre(nombre.getText());

	}

	private boolean camposNoVacios() {
		return !nombre.getText().equals("") && !contraseña.getText().equals("");
	}

	private void iniciarSesion() throws IOException {

		cliente.enviarUsuarioYContraseña(nombre.getText(), contraseña.getText());
	}

	private void enviarAccion() throws IOException {
		cliente.enviarAccion("login");
	}

	private boolean resultado() throws IOException {
		return cliente.resultado().equals("true");
	}
	
	private void pararSonido() {
		sonido.cerrar();
	}

	private void menuPrincipal() throws Exception {

		MenuPrincipal ventana = new MenuPrincipal(cliente, sonido);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		ventana.addWindowListener(new WindowAdapter() {

		

			@Override
			public void windowOpened(WindowEvent arg0) {

				dispose();
			}

		});

	}
}


