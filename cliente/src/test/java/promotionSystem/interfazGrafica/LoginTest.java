package promotionSystem.interfazGrafica;

import javax.swing.JFrame;

import promotionSystem.interfazGrafica.Login;

public class LoginTest {

	public static void main(String[] args) throws Exception {
		Login login=new Login();	
		login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		login.setVisible(true);
	}

}
