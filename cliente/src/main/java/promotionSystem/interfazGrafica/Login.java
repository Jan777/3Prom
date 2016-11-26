package promotionSystem.interfazGrafica;

import promotionSystem.Cliente;
import promotionSystem.juego.Sonido;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.UnknownHostException;

public class Login extends JFrame {
	Cliente cliente;
	Sonido sonido;
	public Login() throws Exception {

			sonido = new Sonido("Menu Principal");
			sonido.reproducir();
			cliente = new Cliente();

			crearInterfaz();

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
		


	}

	private void crearInterfaz() {
		LaminaLogin lamina = new LaminaLogin(cliente, this,sonido);
		setTitle("LOGIN");
		setResizable(false);
		setBounds(0, 0, 450, 400);
		add(lamina);
	}

	public Login(Cliente cliente) {
		this.cliente = cliente;
		crearInterfaz();
	}

	private void enviarAccionDeCerrar() throws IOException {
		cliente.enviarAccion("cerrar");
	}

}

class LaminaLogin extends JPanel {

	public LaminaLogin(Cliente cliente, JFrame marco,Sonido sonido) {
		setLayout(new BorderLayout());
		LaminaLoginCentral lamina = new LaminaLoginCentral(cliente, marco,sonido);
		LaminaLoginNorte laminaN = new LaminaLoginNorte();
		LaminaLoginSur laminaS = new LaminaLoginSur(cliente, marco,sonido);
		add(lamina, BorderLayout.CENTER);
		add(laminaN, BorderLayout.NORTH);
		add(laminaS, BorderLayout.SOUTH);

	}
}

class LaminaLoginCentral extends JPanel implements KeyListener {

	private Cliente cliente;
	private JPasswordField contraseña;
	private JTextField nick;
	private JLabel error;
	private JFrame frame;
	private JButton registrarse;
	private Sonido sonido;

	public LaminaLoginCentral(Cliente cliente, JFrame frame,Sonido sonido) {
		this.sonido=sonido;
		this.cliente = cliente;
		setLayout(new GridLayout(5, 1));
		JLabel nicklabel = new JLabel("NickName:");
		nick = new JTextField(20);
		this.frame = frame;
		registrarse = new JButton("REGISTRATE");
		JLabel contraseñalabel = new JLabel("contraseña: ");
		contraseña = new JPasswordField(20);
		contraseña.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent arg0) {
				if (arg0.getKeyCode() == KeyEvent.VK_ENTER) {
					aceptar();
				}
			}
		});

		JButton ingresar = new JButton("Ingresar");
		ingresar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				aceptar();
			}
		});

		JLabel label = new JLabel("Aun no te has registrado?");

		registrarse.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				abrirRegistrar();
			}

		});

		error = new JLabel(" ");

		nicklabel.setBounds(0, 10, 100, 20);
		nick.setBounds(110, 10, 100, 20);
		contraseñalabel.setBounds(0, 30, 100, 20);
		contraseña.setBounds(110, 30, 100, 20);
		ingresar.setBounds(220, 20, 100, 30);
		label.setBounds(0, 60, 200, 20);
		registrarse.setBounds(0, 90, 120, 20);

		LaminaAuxiliarFlowLog nickName = new LaminaAuxiliarFlowLog(FlowLayout.LEFT);
		LaminaAuxiliarFlowLog password = new LaminaAuxiliarFlowLog(FlowLayout.LEFT);
		LaminaAuxiliarFlowLog registro = new LaminaAuxiliarFlowLog(FlowLayout.LEFT);
		LaminaAuxiliarFlowLog ingresarBoton = new LaminaAuxiliarFlowLog(FlowLayout.CENTER);
		LaminaAuxiliarFlowLog informe = new LaminaAuxiliarFlowLog(FlowLayout.LEFT);

		nickName.add(nicklabel);
		nickName.add(nick);
		password.add(contraseñalabel);
		password.add(contraseña);
		ingresarBoton.add(ingresar);
		registro.add(label);
		registro.add(registrarse);
		informe.add(error);

		add(nickName);
		add(password);
		add(ingresarBoton);
		add(registro);
		add(informe);
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
		Registrarse marco = new Registrarse(cliente,sonido);
		marco.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		marco.setVisible(true);

		marco.addWindowListener(new WindowAdapter() {

			
			@Override
			public void windowClosed(WindowEvent arg0) {
				frame.setEnabled(true);
			}

			@Override
			public void windowOpened(WindowEvent arg0) {
				frame.setEnabled(false);
			}

		});
	}

	private void vaciarCampos() {
		nick.setText("");
		contraseña.setText("");
	}

	private void cargarNombre() {
		cliente.setNombre(nick.getText());

	}

	private boolean camposNoVacios() {
		return !nick.getText().equals("") && !contraseña.getText().equals("");
	}

	private void iniciarSesion() throws IOException {

		cliente.enviarUsuarioYContraseña(nick.getText(), contraseña.getText());
	}

	private void enviarAccion() throws IOException {
		cliente.enviarAccion("login");
	}

	private boolean resultado() throws IOException {
		return cliente.resultado().equals("true");
	}

	private void menuPrincipal() throws Exception {

		MenuPrincipal ventana = new MenuPrincipal(cliente,sonido);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);
		ventana.addWindowListener(new WindowAdapter() {

		

			@Override
			public void windowOpened(WindowEvent arg0) {

				frame.dispose();
			}

		});

	}

	@Override
	public void keyPressed(KeyEvent arg0) {
		

	}

	@Override
	public void keyReleased(KeyEvent arg0) {
		

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		

	}

}

class LaminaLoginNorte extends JPanel {

	public LaminaLoginNorte() {

		JLabel Titulo = new JLabel("KINGS OF THE MULTIVERSE");

		Titulo.setFont(new Font("titulo", Font.BOLD, 33));

		add(Titulo);

	}
}

class LaminaLoginSur extends JPanel {
	private Cliente cliente;
	private JFrame marco;
	private Sonido sonido;
	
	public LaminaLoginSur(Cliente cliente, JFrame marco,Sonido sonido) {
		this.cliente=cliente;
		this.marco=marco;
		this.sonido=sonido;
		
		JButton salir = new JButton("SALIR");

		salir.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					pararSonido();
					enviarAccionDeCerrar();
				} catch (IOException e) {
					JOptionPane.showMessageDialog(null,"Error al iniciar sesion","Error",JOptionPane.ERROR_MESSAGE);
					System.exit(0);
				}
				cerrarFrame();
			}

		

		});

		salir.setSize(50, 50);

		setLayout(new FlowLayout(FlowLayout.RIGHT));
		add(salir);

	}
	
	private void pararSonido() {
		sonido.cerrar();
	}

	private void enviarAccionDeCerrar() throws IOException {
		cliente.enviarAccion("cerrar");
	}

	private void cerrarFrame() {
		marco.dispose();
	}
}

class LaminaAuxiliarFlowLog extends JPanel {

	public LaminaAuxiliarFlowLog(int f) {
		setLayout(new FlowLayout(f));

	}
}
