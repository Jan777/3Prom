package promotionSystem.razas.castas.starWars;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.*;
import promotionSystem.razas.PersonajeDeStarWars;

import java.util.HashMap;

public class Jedi extends PersonajeDeStarWars{
	
	public Jedi(Punto posicion){
		super(posicion);
		energia=Constantes.ENERGIA_JEDI;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_JEDI;
		salud=Constantes.SALUD_JEDI;
		saludMaxima=Constantes.SALUD_MAXIMA_JEDI;
		ataque=Constantes.ATAQUE_JEDI;
		defensa=Constantes.DEFENSA_JEDI;
		magia=Constantes.MAGIA_JEDI;
		velocidad=Constantes.VELOCIDAD_JEDI;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("EmpujonDeFuerza",new EmpujonDeFuerza());
        agregarHechizo("Telekinesis",new Telekinesis());
        agregarHechizo("Electrificar",new Electrificar());
        agregarHechizo("ControlMental",new ControlMental());
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
