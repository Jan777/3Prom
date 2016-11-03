package promotionSystem.razas.castas.kingdomHearts;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.Cura;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Piro;
import promotionSystem.razas.PersonajeDeKingdomHearts;

import java.util.HashMap;

public class Sora extends PersonajeDeKingdomHearts {
	
	public Sora(Punto posicion){
		super(posicion);
		energia=Constantes.ENERGIA_SORA;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_SORA;
		salud=Constantes.SALUD_SORA;
		saludMaxima=Constantes.SALUD_MAXIMA_SORA;
		ataque=Constantes.ATAQUE_SORA;
		defensa=Constantes.DEFENSA_SORA;
		magia=Constantes.MAGIA_SORA;
		velocidad=Constantes.VELOCIDAD_SORA;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
	    agregarHechizo("Piro",new Piro());
	    agregarHechizo("Cura",new Cura());
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
}
