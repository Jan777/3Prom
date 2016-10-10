package promotionSystem.razas;

import promotionSystem.Personaje;

public class PersonajesDeUndertale extends Personaje{
	
	public PersonajesDeUndertale(){
		energia=10;
		salud=1; //esta hecho para sans
		ataque=8;
		defensa=1;
		magia=7;
		experiencia=0;
		nivel=0;
	}
	
	public void despuesDeAtacar(){
		magia+=1;
		energia+=1;
	}

}
