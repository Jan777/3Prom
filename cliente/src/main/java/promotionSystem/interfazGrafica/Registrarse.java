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
		LaminaRegistro laminaRegistro=new LaminaRegistro();
		setTitle("Registrarse");
		setBounds(0,0,600,300);
		add(laminaRegistro);
		
	}
	
	

}

 class LaminaRegistro extends JPanel{
	 
	 public LaminaRegistro(){
		 System.out.println("entra");
		 setLayout(new BorderLayout());
		 LaminaCentralR laminaC =new LaminaCentralR();
		 LaminaNorteR laminaN=new LaminaNorteR();
		 LaminaSurR laminaS=new LaminaSurR();
		 add(laminaC,BorderLayout.CENTER);
		 add(laminaN,BorderLayout.NORTH);
		 add(laminaS,BorderLayout.SOUTH);
		 
		 
		
	 }
 }
	 
	 class LaminaCentralR extends JPanel{
		 
		 public LaminaCentralR(){
			 
			 setLayout(new GridLayout(4,1));
			 JLabel nicklabel=new JLabel("NickName: ");
			 JTextField nick=new JTextField(10);
			 JLabel contraseñalabel=new JLabel("Contraseña: ");
			 JTextField contraseña=new JTextField(10);
			 JLabel contraseñalabelrepeticion=new JLabel("Repita Contraseña: ");
			 JTextField contraseñaRepeticion=new JTextField(10);
			 JLabel error=new JLabel(" ");
			 error.setBounds(0, 90, 50, 20);
			 nicklabel.setBounds(0,10, 100, 20);
			 nick.setBounds(110, 10, 50, 20);
			 contraseñalabel.setBounds(0, 30, 100, 20);
			 contraseña.setBounds(110, 30,50,20);
			 contraseñalabelrepeticion.setBounds(0, 60, 100, 20);
			 contraseñaRepeticion.setBounds(0, 60, 50, 20);
			 
			 LaminaAuxiliarFlow nickname=new LaminaAuxiliarFlow(FlowLayout.LEFT);
			 LaminaAuxiliarFlow password=new LaminaAuxiliarFlow(FlowLayout.LEFT);
			 LaminaAuxiliarFlow passwordtry=new LaminaAuxiliarFlow(FlowLayout.LEFT);
			 LaminaAuxiliarFlow informe=new LaminaAuxiliarFlow(FlowLayout.LEFT);
			 
			informe.add(error); 
			 nickname.add(nicklabel);
			 nickname.add(nick);
			 password.add(contraseñalabel);
			 password.add(contraseña);
			passwordtry.add(contraseñalabelrepeticion);
			passwordtry.add(contraseñaRepeticion);
			 
			 add(nickname);
			 add(password);
			 add(passwordtry);
			add(informe);
		 }
	 }
	 
	 class LaminaNorteR extends JPanel{
		 
		 public LaminaNorteR(){
			 
			 JLabel Titulo=new JLabel("REGISTRARSE");
			 Titulo.setFont(new Font("titulo",Font.BOLD,33));
			 
			 add(Titulo);
			 
			 
		 }
	 }
	 
class LaminaSurR extends JPanel{
		 
		 public LaminaSurR(){
			 
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
	 
	
