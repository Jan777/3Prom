package promotionSystem.razas.castas.kingdomHearts;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.Cura;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Hielo;
import promotionSystem.razas.PersonajeDeKingdomHearts;

import java.util.HashMap;

public class Roxas extends PersonajeDeKingdomHearts {

	public Roxas(){
		energia=Constantes.ENERGIA_ROXAS;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_ROXAS;
		salud=Constantes.SALUD_ROXAS;
		saludMaxima=Constantes.SALUD_MAXIMA_ROXAS;
		ataque=Constantes.ATAQUE_ROXAS;
		defensa=Constantes.DEFENSA_ROXAS;
		magia=Constantes.MAGIA_ROXAS;
		velocidad=Constantes.VELOCIDAD_ROXAS;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("Trueno",new Hielo());
        agregarHechizo("Cura",new Cura());
	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		salud+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		ataque+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
		defensa+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		magia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
	}
}
