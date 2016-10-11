package promotionSystem.razas;

import promotionSystem.Personaje;

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
	}

	public void despuesDeAtacar(){
		energia+=10;
	}

	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		energia+=10;
		salud+=+8;
		ataque+=7;
		defensa+=1;
		magia+=10;
		
		
	}
}
