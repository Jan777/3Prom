package promotionSystem.razas;

import promotionSystem.Personaje;
import promotionSystem.Punto;

public class PersonajesDePokemon extends Personaje {
	
	public PersonajesDePokemon(){
		//hecho para pokemon tipo siniestro
		
		energia=120;
		salud=90;
		ataque=7;
		defensa=1;
		magia=11;
		experiencia=0;
		nivel=0;
		posicion=new Punto(0,0);
	}

	public void despuesDeAtacar(){
		energia+=10;
	}

	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		energia+=10;
		salud+=+5;
		ataque+=5;
		defensa+=1;
		magia+=10;
		
		
	}
}
