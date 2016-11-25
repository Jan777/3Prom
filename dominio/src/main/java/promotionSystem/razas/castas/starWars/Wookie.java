package promotionSystem.razas.castas.starWars;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.IraWookeana;
import promotionSystem.razas.PersonajeDeStarWars;

import java.util.HashMap;

public class Wookie extends PersonajeDeStarWars{
	
	public Wookie(){
		casta="Wookie";
		energia=Constantes.ENERGIA_WOOKIE;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_WOOKIE;
		salud=Constantes.SALUD_WOOKIE;
		saludMaxima=Constantes.SALUD_MAXIMA_WOOKIE;
		ataque=Constantes.ATAQUE_WOOKIE;
		defensa=Constantes.DEFENSA_WOOKIE;
		magia=Constantes.MAGIA_WOOKIE;
		velocidad=Constantes.VELOCIDAD_WOOKIE;	
		hechizos = new HashMap<String, Hechizo>();

	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		salud+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		ataque+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
		defensa+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
		magia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_PLEBE;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
	}


	@Override
	public void despuesDeAtacar() {
		ataque+=5;
		defensa-=2;
		
	}

}
