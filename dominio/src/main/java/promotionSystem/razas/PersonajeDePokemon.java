package promotionSystem.razas;

import promotionSystem.Personaje;

public abstract class PersonajeDePokemon extends Personaje {

	public PersonajeDePokemon(){
		raza="PersonajeDePokemon";
	}

	public void despuesDeAtacar(){
		magia+=10;
	}

}
