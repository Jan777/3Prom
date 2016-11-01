package promotionSystem.interfazGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame{
	
	public Login(){
		LaminaLogin lamina=new LaminaLogin();
		setTitle("LOGIN");
		setBounds(1500,1750,0,500);
		add(lamina);
		
	}
	
	

}

 class LaminaLogin extends JPanel{
	 
	 public LaminaLogin(){
		 
		 setLayout(new FlowLayout(FlowLayout.CENTER));
		 
		 nicklabel=new JLabel("NickName:");
		 
		nick=new JTextField(20);
		 
		 add(nicklabel);
		 add(nick);
		 
		 
	 }
	 
	 
	 JTextField nick,contraseña;
	 JLabel nicklabel,contraseñalabel,Titulo;
	JButton salir,registrarse,ingresar;
	
	
}