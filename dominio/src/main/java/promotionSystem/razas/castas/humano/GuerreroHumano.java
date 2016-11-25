package promotionSystem.razas.castas.humano;

import promotionSystem.Constantes;
import promotionSystem.razas.Humano;

public class GuerreroHumano extends Humano{
	
	public GuerreroHumano(){
		casta="GuerreroHumano";
		energia=Constantes.ENERGIA_GUERRERO_HUMANO;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_GUERRERO_HUMANO;
		salud=Constantes.SALUD_GUERRERO_HUMANO;
		saludMaxima=Constantes.SALUD_MAXIMA_GUERRERO_HUMANO;
		ataque=Constantes.ATAQUE_GUERRERO_HUMANO;
		defensa=Constantes.DEFENSA_GUERRERO_HUMANO;
		magia=Constantes.MAGIA_GUERRERO_HUMANO;
		velocidad=Constantes.VELOCIDAD_GUERRERO_HUMANO;
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
