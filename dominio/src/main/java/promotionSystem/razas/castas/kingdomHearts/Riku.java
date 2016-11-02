package promotionSystem.razas.castas.kingdomHearts;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.Cura;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Hielo;
import promotionSystem.razas.PersonajeDeKingdomHearts;

import java.util.HashMap;

public class Riku extends PersonajeDeKingdomHearts {

	public Riku(){
		energia=Constantes.ENERGIA_RIKU;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_RIKU;
		salud=Constantes.SALUD_RIKU;
		saludMaxima=Constantes.SALUD_MAXIMA_RIKU;
		ataque=Constantes.ATAQUE_RIKU;
		defensa=Constantes.DEFENSA_RIKU;
		magia=Constantes.MAGIA_RIKU;
		velocidad=Constantes.VELOCIDAD_RIKU;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("Hielo",new Hielo());
        agregarHechizo("Cura",new Cura());

	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		salud+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		ataque+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		defensa+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_PLEBE;
		magia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
	}
}
