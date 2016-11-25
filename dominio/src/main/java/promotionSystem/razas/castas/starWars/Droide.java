package promotionSystem.razas.castas.starWars;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.CampoDeFuerza;
import promotionSystem.hechizo.Cura;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.razas.PersonajeDeStarWars;

import java.util.HashMap;

public class Droide extends PersonajeDeStarWars{
	
	public Droide(){
		casta="Droide";
		energia=Constantes.ENERGIA_DROIDE;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_DROIDE;
		salud=Constantes.SALUD_DROIDE;
		saludMaxima=Constantes.SALUD_MAXIMA_DROIDE;
		ataque=Constantes.ATAQUE_DROIDE;
		defensa=Constantes.DEFENSA_DROIDE;
		magia=Constantes.MAGIA_DROIDE;
		velocidad=Constantes.VELOCIDAD_DROIDE;
		hechizos = new HashMap<String, Hechizo>();
//        agregarHechizo("Cura",new Cura());
//        agregarHechizo("CampoDeFuerza",new CampoDeFuerza());
	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		salud+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		ataque+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		defensa+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		magia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
	}

	@Override
	public void despuesDeAtacar() {
		velocidad+=2;
		
	}
}
