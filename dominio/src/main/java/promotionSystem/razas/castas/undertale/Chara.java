package promotionSystem.razas.castas.undertale;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.razas.PersonajeDeUndertale;

public class Chara extends PersonajeDeUndertale{
	public Chara(){
		energia=Constantes.ENERGIA_CHARA;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_CHARA;
		salud=Constantes.SALUD_CHARA;
		saludMaxima=Constantes.SALUD_MAXIMA_CHARA;
		ataque=Constantes.ATAQUE_CHARA;
		defensa=Constantes.DEFENSA_CHARA;
		magia=Constantes.MAGIA_CHARA;
		velocidad=Constantes.VELOCIDAD_CHARA;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
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
