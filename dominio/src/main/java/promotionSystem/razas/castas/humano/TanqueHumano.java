package promotionSystem.razas.castas.humano;

import promotionSystem.Constantes;
import promotionSystem.razas.Humano;

public class TanqueHumano extends Humano{
	
	public TanqueHumano(){

		energia=Constantes.ENERGIA_TANQUE_HUMANO;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_TANQUE_HUMANO;
		salud=Constantes.SALUD_TANQUE_HUMANO;
		saludMaxima=Constantes.SALUD_MAXIMA_TANQUE_HUMANO;
		ataque=Constantes.ATAQUE_TANQUE_HUMANO;
		defensa=Constantes.DEFENSA_TANQUE_HUMANO;
		magia=Constantes.MAGIA_TANQUE_HUMANO;
		velocidad=Constantes.VELOCIDAD_TANQUE_HUMANO;
		experiencia=0;
		nivel=1;
	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
		salud+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
		ataque+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		defensa+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		magia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
	}
}
