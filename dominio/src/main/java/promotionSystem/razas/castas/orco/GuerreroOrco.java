package promotionSystem.razas.castas.orco;

import promotionSystem.Constantes;
import promotionSystem.razas.Orco;

public class GuerreroOrco extends Orco{

	public GuerreroOrco(){
		casta="GuerreroOrco";
		energia=Constantes.ENERGIA_GUERRERO_ORCO;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_GUERRERO_ORCO;
		salud=Constantes.SALUD_GUERRERO_ORCO;
		saludMaxima=Constantes.SALUD_MAXIMA_GUERRERO_ORCO;
		ataque=Constantes.ATAQUE_GUERRERO_ORCO;
		defensa=Constantes.DEFENSA_GUERRERO_ORCO;
		magia=Constantes.MAGIA_GUERRERO_ORCO;
		velocidad=Constantes.VELOCIDAD_GUERRERO_ORCO;
	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
		salud+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		ataque+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL;
		defensa+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		magia+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL;
	}
}
