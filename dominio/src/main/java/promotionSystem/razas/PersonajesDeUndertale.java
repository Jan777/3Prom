package promotionSystem.razas;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public class PersonajesDeUndertale extends Personaje{
	
	public PersonajesDeUndertale(){
		energia=10;
		salud=1; //esta hecho para sans
		ataque=8;
		defensa=1;
		magia=7;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
	}
	
	public void despuesDeAtacar(){
		magia+=1;
		energia+=1;
	}

	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		energia+=10;
		ataque+=10;
		defensa+=1;
		magia+=8;
		
		
	}

}
