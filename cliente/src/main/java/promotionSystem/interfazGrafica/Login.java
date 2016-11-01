package promotionSystem.interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Login extends JFrame{
	
	public Login(){
		int x=400;
		int y=240;
		LaminaLogin lamina=new LaminaLogin(x,y);
		setTitle("LOGIN");
		setBounds(0,0,x,y);
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
	 
	 public LaminaLogin(int x,int y){
		 setLayout(new BorderLayout());
		 LaminaLoginCentral lamina =new LaminaLoginCentral(x,y);
		 LaminaLoginNorte laminaN=new LaminaLoginNorte();
		 LaminaLoginSur laminaS=new LaminaLoginSur();
		 add(lamina,BorderLayout.CENTER);
		 add(laminaN,BorderLayout.NORTH);
		 add(laminaS,BorderLayout.SOUTH);
		 
		 
		
	 }
 }
	 
	 class LaminaLoginCentral extends JPanel{
		 
		 public LaminaLoginCentral(int x,int y){
			 
			 setLayout(null);
			 JLabel nicklabel=new JLabel("NickName:");
			 JTextField nick=new JTextField(100);
			 JLabel contraseñalabel=new JLabel("Contraseña: ");
			 JTextField contraseña=new JTextField(100);
			 JButton ingresar=new JButton("Ingresar");
			 JLabel label=new JLabel("Aun no te has registrado?");
			 JButton  registrarse =new JButton("REGISTRATE");
			 
			 nicklabel.setBounds(0,10, 100, 20);
			 nick.setBounds(110, 10, 100, 20);
			 contraseñalabel.setBounds(0, 30, 100, 20);
			 contraseña.setBounds(110, 30,100,20);
			 ingresar.setBounds(220,20,100,30);
			 label.setBounds(0,60,200, 20);
			 registrarse.setBounds(0, 90, 120, 20);
			 
			 //ingresar.setBounds(220+(x-400),20+(y-400),100+(x-400),30+(y-400));
			 
			 add(nicklabel);
			 add(nick);
			 add(contraseñalabel);
			 add(contraseña);
			 add(ingresar);
			 add(label);
			 add(registrarse);
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
			 
			 
			 salir.setSize(1150, 30);
			 
			 setLayout(new FlowLayout(FlowLayout.RIGHT));
			 add(salir);
			 
			 
		 }
	 }
	 
	 
	
	
