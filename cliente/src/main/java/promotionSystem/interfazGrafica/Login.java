package promotionSystem.interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import promotionSystem.Cliente;

public class Login extends JFrame{
	Cliente cliente;
	public Login() throws Exception{
		
		cliente=new Cliente();
		LaminaLogin lamina=new LaminaLogin(cliente,this);
		setTitle("LOGIN");
		setResizable(false);
		setBounds(0,0,450,400);
		add(lamina);
		
		
		
		 
		
		
	}
	
	

}

 class LaminaLogin extends JPanel{
	 
	 public LaminaLogin(Cliente cliente,JFrame marco){
		 setLayout(new BorderLayout());
		 LaminaLoginCentral lamina =new LaminaLoginCentral(cliente,marco);
		 LaminaLoginNorte laminaN=new LaminaLoginNorte();
		 LaminaLoginSur laminaS=new LaminaLoginSur();
		 add(lamina,BorderLayout.CENTER);
		 add(laminaN,BorderLayout.NORTH);
		 add(laminaS,BorderLayout.SOUTH);
		 
		 
		
	 }
 }
	 
	 class LaminaLoginCentral extends JPanel{
		 
		 private Cliente cliente;
		private  JTextField contrasenia ;
		private JTextField nick;
		private JLabel error;

		public LaminaLoginCentral(Cliente cliente,JFrame frame){
			 this.cliente=cliente;
			 setLayout(new GridLayout(5,1));
			 JLabel nicklabel=new JLabel("NickName:");
			 nick=new JTextField(20);
			 JButton  registrarse ;
			 registrarse =new JButton("REGISTRATE");
			 JLabel contrasenialabel=new JLabel("contraseña: ");
			 JPasswordField contraseña = new JPasswordField(20); 
			 
			 JButton ingresar=new JButton("Ingresar");
			 ingresar.addActionListener (new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						try {
							registrarse.setEnabled(false);
							enviarAccion();
							iniciarSesion(contraseña);
							if(resultado()){		
								menuPrincipal(frame);
							}
							else{								
								error.setText("Usuario y/o Contraseña incorrecta");
							}
						} catch (IOException e) {
							e.printStackTrace();
						}
					}

					

					

					
				}					
				);
			 
			 JLabel label=new JLabel("Aun no te has registrado?");
			 
			 registrarse.addActionListener (new ActionListener(){

					@Override
					public void actionPerformed(ActionEvent arg0) {
						Registrarse marco=new Registrarse(cliente);
						marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
						marco.setVisible(true);
						
						marco.addWindowListener(new WindowListener(){

							@Override
							public void windowActivated(WindowEvent arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void windowClosed(WindowEvent arg0) {
								// TODO Auto-generated method stub
								frame.setEnabled(true);
							}

							@Override
							public void windowClosing(WindowEvent arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void windowDeactivated(WindowEvent arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void windowDeiconified(WindowEvent arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void windowIconified(WindowEvent arg0) {
								// TODO Auto-generated method stub
								
							}

							@Override
							public void windowOpened(WindowEvent arg0) {
								// TODO Auto-generated method stub
								frame.setEnabled(false);
							}
							
						});
						
					}
	
				}					
				);
			 
			 
			 
			

			 error=new JLabel(" ");
			 
			 nicklabel.setBounds(0,10, 100, 20);
			 nick.setBounds(110, 10, 100, 20);
			 contrasenialabel.setBounds(0, 30, 100, 20);
			 contraseña.setBounds(110, 30,100,20);
			 ingresar.setBounds(220,20,100,30);
			 label.setBounds(0,60,200, 20);
			 registrarse.setBounds(0, 90, 120, 20);
			 
			 LaminaAuxiliarFlowLog nickName =new LaminaAuxiliarFlowLog(FlowLayout.LEFT);
			 LaminaAuxiliarFlowLog password =new LaminaAuxiliarFlowLog(FlowLayout.LEFT);
			 LaminaAuxiliarFlowLog registro =new LaminaAuxiliarFlowLog(FlowLayout.LEFT);
			 LaminaAuxiliarFlowLog ingresarBoton =new LaminaAuxiliarFlowLog(FlowLayout.CENTER);
			 LaminaAuxiliarFlowLog informe =new LaminaAuxiliarFlowLog(FlowLayout.LEFT);
			 
			 
			 nickName.add(nicklabel);
			 nickName.add(nick);
			 password.add(contrasenialabel);
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
		 
		 private void iniciarSesion(JPasswordField contraseña) throws IOException {
			
				cliente.enviarUsuarioYContraseña(nick.getText(), contraseña.getText());
			}
			private void verResultado() throws IOException {
				error.setText(cliente.resultado());
			}
			private void enviarAccion() throws IOException {		
				cliente.enviarAccion("Login");
			}
			private boolean resultado() throws IOException {
				return cliente.resultado().equals("true");
			}
			
			private void menuPrincipal(JFrame marco) throws IOException {
				
				MenuPrincipal ventana=new MenuPrincipal(cliente);
				ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				ventana.setVisible(true);
				ventana.addWindowListener(new WindowListener(){

					@Override
					public void windowActivated(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosed(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowClosing(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeactivated(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowDeiconified(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowIconified(WindowEvent arg0) {
						// TODO Auto-generated method stub
						
					}

					@Override
					public void windowOpened(WindowEvent arg0) {
						// TODO Auto-generated method stub
						//marco.setEnabled(false);
						marco.dispose();
					}
					
				});
				
				
				
				
			}
		
	 }
	 
	 class LaminaLoginNorte extends JPanel{
		 
		 public LaminaLoginNorte(){
			 
			 JLabel Titulo=new JLabel("KING OF MULTIVERSE");
			 
			 Titulo.setFont(new Font("titulo",Font.BOLD,33));
			 
		
			 add(Titulo);
			 
			 
		 }
	 }
	 
class LaminaLoginSur extends JPanel{
		 
		 public LaminaLoginSur(){
			 
			
			 
			 JButton  salir=new JButton ("SALIR");
			 
			 
			 salir.setSize(50, 50);
			 
			 setLayout(new FlowLayout(FlowLayout.RIGHT));
			 add(salir);
			 
			 
		 }
	 }
	 
class LaminaAuxiliarFlowLog extends JPanel{
	
	public LaminaAuxiliarFlowLog(int f){
		setLayout(new FlowLayout(f));
		
	}
}
	 
	
	
