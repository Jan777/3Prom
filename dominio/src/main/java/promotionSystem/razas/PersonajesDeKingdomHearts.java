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
		defensa+=(int)defensa*(1/8);
	}

	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		energia+=10;
		salud+=1;
		ataque+=5;
		defensa+=10;
		magia+=5;
		
		
	}
}
