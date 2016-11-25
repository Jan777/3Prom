package promotionSystem.razas.castas.starWars;

import promotionSystem.Constantes;
import promotionSystem.hechizo.*;
import promotionSystem.razas.PersonajeDeStarWars;

import java.util.HashMap;

public class Jedi extends PersonajeDeStarWars{
	
	public Jedi(){
		casta="Jedi";
		energia=Constantes.ENERGIA_JEDI;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_JEDI;
		salud=Constantes.SALUD_JEDI;
		saludMaxima=Constantes.SALUD_MAXIMA_JEDI;
		ataque=Constantes.ATAQUE_JEDI;
		defensa=Constantes.DEFENSA_JEDI;
		magia=Constantes.MAGIA_JEDI;
		velocidad=Constantes.VELOCIDAD_JEDI;
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("EmpujonDeFuerza",new EmpujonDeFuerza());
        agregarHechizo("Electrificar",new Electrificar());

	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		salud+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		ataque+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		defensa+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		magia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
	}

	@Override
	public void despuesDeAtacar() {
		magia+=2;
		
	}
}
