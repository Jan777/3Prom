package promotionSystem.interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame{
	
	public Login(){
		
		LaminaLogin lamina=new LaminaLogin();
		setTitle("LOGIN");
		setBounds(0,0,450,400);
		add(lamina);
		
		 /*this.addComponentListener(new ComponentAdapter(){
			 public void componentResized(ComponentEvent e){
				 remove(lamina);
				 Dimension ventana= getSize();
				 int x=ventana.width;
				 int y=ventana.height;
				 LaminaLogin lamina=new LaminaLogin(x,y);
				 add(lamina);
			 }
		 });*/
		
		
	}
	
	

}

 class LaminaLogin extends JPanel{
	 
	 public LaminaLogin(){
		 setLayout(new BorderLayout());
		 LaminaLoginCentral lamina =new LaminaLoginCentral();
		 LaminaLoginNorte laminaN=new LaminaLoginNorte();
		 LaminaLoginSur laminaS=new LaminaLoginSur();
		 add(lamina,BorderLayout.CENTER);
		 add(laminaN,BorderLayout.NORTH);
		 add(laminaS,BorderLayout.SOUTH);
		 
		 
		
	 }
 }
	 
	 class LaminaLoginCentral extends JPanel{
		 
		 public LaminaLoginCentral(){
			 
			 setLayout(new GridLayout(5,1));
			 JLabel nicklabel=new JLabel("NickName:");
			 JTextField nick=new JTextField(20);
			 JLabel contraseñalabel=new JLabel("Contraseña: ");
			 JTextField contraseña=new JTextField(20);
			 JButton ingresar=new JButton("Ingresar");
			 JLabel label=new JLabel("Aun no te has registrado?");
			 JButton  registrarse =new JButton("REGISTRATE");
			 JLabel error=new JLabel(" ");
			 
			 nicklabel.setBounds(0,10, 100, 20);
			 nick.setBounds(110, 10, 100, 20);
			 contraseñalabel.setBounds(0, 30, 100, 20);
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
	 
	
	
