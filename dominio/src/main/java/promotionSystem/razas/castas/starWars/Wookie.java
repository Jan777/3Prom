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
		energia=Constantes.ENERGIA_WOOKIE;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_WOOKIE;
		salud=Constantes.SALUD_WOOKIE;
		saludMaxima=Constantes.SALUD_MAXIMA_WOOKIE;
		ataque=Constantes.ATAQUE_WOOKIE;
		defensa=Constantes.DEFENSA_WOOKIE;
		magia=Constantes.MAGIA_WOOKIE;
		velocidad=Constantes.VELOCIDAD_WOOKIE;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
//        agregarHechizo("IraWookeana",new IraWookeana());
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
