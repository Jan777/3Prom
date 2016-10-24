package promotionSystem.hechizo;

import promotionSystem.Personaje;

public class Cura extends Hechizo{

	@Override
	public void afectar(Personaje personaje) {
		if(personaje.getSalud()<=personaje.getSaludMaxima()-20)
		personaje.setSalud(personaje.getSalud()+20);
		else{
			personaje.setSalud(personaje.getSaludMaxima());
		}
		
	}

}
