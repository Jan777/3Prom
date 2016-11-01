package promotionSystem.interfazGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Registrarse extends JFrame {

	public Registrarse(){
		LaminaRegistro lamina=new LaminaRegistro();
		setTitle("Registrarse");
		setBounds(0,0,600,600);
		add(lamina);
		
	}
	
	

}

 class LaminaRegistro extends JPanel{
	 
	 public LaminaRegistro(){
		 setLayout(new BorderLayout());
		 LaminaCentral laminaC =new LaminaCentral();
		 LaminaNorte laminaN=new LaminaNorte();
		 LaminaSur laminaS=new LaminaSur();
		 add(laminaC,BorderLayout.CENTER);
		 add(laminaN,BorderLayout.NORTH);
		 add(laminaS,BorderLayout.SOUTH);
		 
		 
		
	 }
 }
	 
	 class LaminaCentral extends JPanel{
		 
		 public LaminaCentral(){
			 
			 setLayout(new GridLayout(3,1));
			 JLabel nicklabel=new JLabel("NickName: ");
			 JTextField nick=new JTextField(100);
			 JLabel contraseñalabel=new JLabel("Contraseña: ");
			 JTextField contraseña=new JTextField(100);
			 JLabel contraseñalabelrepeticion=new JLabel("Repita Contraseña: ");
			 JTextField contraseñaRepeticion=new JTextField(100);
			 nicklabel.setBounds(0,10, 100, 20);
			 nick.setBounds(110, 10, 100, 20);
			 contraseñalabel.setBounds(0, 30, 100, 20);
			 contraseña.setBounds(110, 30,100,20);
			 contraseñalabelrepeticion.setBounds(0, 60, 100, 20);
			 contraseñaRepeticion.setBounds(0, 60, 100, 20);
			 
			 LaminaAuxiliarFlow nickname=new LaminaAuxiliarFlow(FlowLayout.LEFT);
			 LaminaAuxiliarFlow password=new LaminaAuxiliarFlow(FlowLayout.LEFT);
			 LaminaAuxiliarFlow passwordtry=new LaminaAuxiliarFlow(FlowLayout.LEFT);
			 
			 
			 nickname.add(nicklabel);
			 nickname.add(nick);
			 password.add(contraseñalabel);
			 password.add(contraseña);
			passwordtry.add(contraseñalabelrepeticion);
			passwordtry.add(contraseñaRepeticion);
			 
			 add(nickname);
			 add(password);
			 add(passwordtry);
			
		 }
	 }
	 
	 class LaminaNorte extends JPanel{
		 
		 public LaminaNorte(){
			 
			 JLabel Titulo=new JLabel("REGISTRARSE");
			 Titulo.setFont(new Font("titulo",Font.BOLD,33));
			 
			 add(Titulo);
			 
			 
		 }
	 }
	 
class LaminaSur extends JPanel{
		 
		 public LaminaSur(){
			 
			 JButton  aceptar=new JButton ("Aceptar");
			 JButton  cancelar=new JButton ("Cancelar");
			 
			 setLayout(new FlowLayout(FlowLayout.CENTER));
			 add(aceptar);
			 add(cancelar);
			 
		 }
	 }
	 
class LaminaAuxiliarFlow extends JPanel{
	
	public LaminaAuxiliarFlow(int f){
		setLayout(new FlowLayout(f));
		
	}
}
	 
	
