package promotionSystem.interfazGrafica;

import javax.swing.JFrame;

import promotionSystem.Cliente;
import promotionSystem.interfazGrafica.SeleccionPersonaje;

public class SeleccionPersonajeTest {

	public static void main(String[] args) throws Exception {
		SeleccionPersonaje ventana=new SeleccionPersonaje(new Cliente());
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setVisible(true);

	}

}
