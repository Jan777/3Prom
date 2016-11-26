package promotionSystem.interfazGrafica;


import javax.swing.*;

public class LoginTest {

	public static void main(String[] args) throws Exception {
		Login login = null;
		try {
			login = new Login();
			login.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			login.setVisible(true);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Error servidor no conectado!","Error al ejecutar el juego", JOptionPane.ERROR_MESSAGE);
		}
	}
}
