package promotionSystem.razas;

import promotionSystem.Personaje;

public class PersonajesDeStarWars extends Personaje {

	public PersonajesDeStarWars(){
		//hecho para un jedi
		energia=120;
		salud=110;
		ataque=15;
		defensa=3;
		magia=12;
		experiencia=0;
		nivel=0;
	}
	
	public void despuesDeAtacar(){
		magia+=2;
	}

	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		// TODO Auto-generated method stub
		
	}
}

