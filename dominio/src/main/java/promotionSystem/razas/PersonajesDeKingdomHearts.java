package promotionSystem.razas;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public class PersonajesDeKingdomHearts extends Personaje{
	
	public PersonajesDeKingdomHearts(){
		//hecho para heartless
		energia=10;
		salud=60;
		ataque=9;
		defensa=4;
		magia=2;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
	}

	public void despuesDeAtacar(){
		defensa+=defensa*(1/4);
	}

	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		energia+=2;
		salud+=5;
		ataque+=3;
		defensa+=10;
		magia+=8;
		
		
	}
}
