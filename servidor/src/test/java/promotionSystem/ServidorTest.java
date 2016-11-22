package promotionSystem;

import javax.swing.*;

public class ServidorTest {

	public static void main(String[] args){

		try {
			Servidor server = new Servidor();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Error al Inicial el Servidor", "Error",JOptionPane.ERROR_MESSAGE);
		}

	}
}
