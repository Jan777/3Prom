package promotionSystem.pantallaJuegoTest;

import promotionSystem.pantallaJuego.juego.Juego;

public class Ejecutor {

	public static void main(String[] args) {
		System.out.println("entra");	
		Juego Kom = new Juego("King of Multiverse", 800, 600);
			
		Kom.start();
	}
}