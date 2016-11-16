package promotionSystem.juego;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import javax.swing.JFrame;


public class JuegoTest_SinServidor {

	public static void main(String[] args) {
		JFrame ventana=new JFrame("El se�or de los aniloros"); //Ventana comun
		Personaje pj_test = new PersonajePrueba("El Dani");
		String nombreMapa = "map_test";
		ventana.add(new JuegoPanel(ventana, pj_test.getUbicacion(),pj_test,nombreMapa, null)); //Dentro de la ventana pongo el juego.
		ventana.setCursor(cursor("cursor") );
		ventana.pack(); //hace que el tama�o se ajuste al tama�o preferido y dise�os de sus subcomponentes.
		ventana.setLocationRelativeTo(null); //centro
		ventana.setResizable(false);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // :c adios amor.
		ventana.setVisible(true); // uno se mata haciendo los graficos para que ponga false ��
	}

	public final static Cursor cursor(String c) {
		Image im = Toolkit.getDefaultToolkit().createImage("src\\main\\resources\\"+c+".png");
		Cursor cur = Toolkit.getDefaultToolkit().createCustomCursor(im, new Point(10,10),"WILL");
		return cur;
	}



}
