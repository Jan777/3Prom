package promotionSystem.interfazGrafica;

import javax.swing.JFrame;

import promotionSystem.Cliente;
import promotionSystem.interfazGrafica.Registrarse;

public class RegistrarseTest {

	public static void main(String[] args) throws Exception {		
		Registrarse marco=new Registrarse(new Cliente());
		marco.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		marco.setVisible(true);

	}

}
