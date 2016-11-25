package promotionSystem.razas;

import promotionSystem.Personaje;

public abstract class Orco extends Personaje {
	
	public Orco(){
		raza="Orco";
	}


	public void despuesDeAtacar(){
		ataque+=10;
	}

		
	
	
	
}
