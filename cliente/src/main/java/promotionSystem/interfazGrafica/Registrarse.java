package promotionSystem.interfazGrafica;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

public class Registrarse extends JFrame {

	public Registrarse(Cliente cliente){
		LaminaRegistro laminaRegistro=new LaminaRegistro(cliente,this);
		setTitle("Registrarse");
		setResizable(false);
		setBounds(100,100,600,400);
		add(laminaRegistro);
		
		
	
	
		
	}
	
	

}

 class LaminaRegistro extends JPanel{
	 
	 public LaminaRegistro(Cliente cliente,JFrame marco){
		 setLayout(new BorderLayout());
		 LaminaCentralR laminaC =new LaminaCentralR(cliente,marco);
		 LaminaNorteR laminaN=new LaminaNorteR();
		 LaminaSurR laminaS=new LaminaSurR(marco);
		 add(laminaC,BorderLayout.CENTER);
		 add(laminaN,BorderLayout.NORTH);
		 add(laminaS,BorderLayout.SOUTH);
		 
		 
		
	 }
 }
	 
	 class LaminaCentralR extends JPanel{
		 
		 private JPasswordField contraseña ;
		 
		 JPasswordField contraseniaRepeticion;
		 private JLabel error;
		 private JTextField nick;
		 private Cliente cliente;
		 public LaminaCentralR(Cliente cliente,JFrame marco){
			 this.cliente=cliente;
			 setLayout(new GridLayout(4,1));
			 JLabel nicklabel=new JLabel("NickName: ");
			 nick=new JTextField(10);
			 JLabel contrasenialabel=new JLabel("contraseña: ");
			  contraseña= new JPasswordField(20);
			 JLabel contrasenialabelrepeticion=new JLabel("Repita contraseña: ");
			  contraseniaRepeticion= new JPasswordField(20);
			 error=new JLabel(" ");
			 error.setBounds(0, 90, 50, 20);
			 nicklabel.setBounds(0,10, 100, 20);
			 nick.setBounds(110, 10, 50, 20);
			 contrasenialabel.setBounds(0, 30, 100, 20);
			 contraseña.setBounds(110, 30,50,20);
			 contrasenialabelrepeticion.setBounds(0, 60, 100, 20);
			 contraseniaRepeticion.setBounds(0, 60, 50, 20);
			 JButton  aceptar=new JButton ("Aceptar");
				aceptar.setBounds(0, 80, 10, 10);
				 aceptar.addActionListener (new ActionListener(){

						@Override
						public void actionPerformed(ActionEvent arg0) {
							try {
								if(comprobarContraseñas()){
									enviarAccion();
									if(comprobarUsuario()){
										enviarUsuarioYContraseña();
										elegirPersonaje(marco);
									}
									else{
										informarErrorUsuario();
									}
								}
								else{
									informarErrorContraseña();
								}
							} catch (Exception e) {
								e.printStackTrace();
							} 	
						}

					

						

						

					

						

						

						
				
				 });
			 LaminaAuxiliarFlow nickname=new LaminaAuxiliarFlow(FlowLayout.LEFT);
			 LaminaAuxiliarFlow password=new LaminaAuxiliarFlow(FlowLayout.LEFT);
			 LaminaAuxiliarFlow passwordtry=new LaminaAuxiliarFlow(FlowLayout.LEFT);
			 LaminaAuxiliarFlow informe=new LaminaAuxiliarFlow(FlowLayout.LEFT);
			 
			informe.add(error); 
			 nickname.add(nicklabel);
			 nickname.add(nick);
			 password.add(contrasenialabel);
			 password.add(contraseña);
			passwordtry.add(contrasenialabelrepeticion);
			passwordtry.add(contraseniaRepeticion);
			 
			 add(nickname);
			 add(password);
			 add(passwordtry);
			add(informe);
			 add(aceptar);
			 
		 }
		 
		 private boolean comprobarContraseñas() {
				return contraseña.getText().equals(contraseniaRepeticion.getText());
			}
		 
		 private void informarErrorContraseña() {
				error.setText("Las contraseñas no coinciden");
			}
		 
		 private void informarErrorUsuario() {
			 
			 error.setText("Las el nombre de usuario no esta disponible, ya esta usado");
			
		 }

		 private boolean comprobarUsuario() throws Exception {
			 cliente.enviarUsuario(nick.getText());
			 return cliente.recibirComprobacion();
		 }

		 private void enviarUsuarioYContraseña() throws IOException {
			 cliente.enviarUsuarioYContraseña(nick.getText(), contraseña.getText());
		 }
		 private void enviarAccion() throws IOException {
			 cliente.enviarAccion("registrar");
		 }
		 
		 private void enviarAccionDeCerrar() throws IOException {
			 cliente.enviarAccion("cerrar");
		 }

		 private void elegirPersonaje(JFrame marco) throws IOException {
			 SeleccionPersonaje ventana=new SeleccionPersonaje(cliente);
			 ventana.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
			 ventana.setVisible(true);
			 marco.dispose();

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
		 
		 public LaminaSurR(JFrame marco){
			 
			
			 JButton  cancelar=new JButton ("Cancelar");
			 
			 setLayout(new FlowLayout(FlowLayout.CENTER));
			 
			 cancelar.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent arg0) {
					
					marco.dispose();
				}
				 
			 });
			
			 add(cancelar);
			 
		 }
	 }
	 
class LaminaAuxiliarFlow extends JPanel{
	
	public LaminaAuxiliarFlow(int f){
		setLayout(new FlowLayout(f));
		
	}
}
	 
	
