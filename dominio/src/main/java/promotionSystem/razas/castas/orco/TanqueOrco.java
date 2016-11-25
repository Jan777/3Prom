package promotionSystem.razas.castas.orco;

import promotionSystem.Constantes;
import promotionSystem.razas.Orco;

public class TanqueOrco extends Orco{

	public TanqueOrco(){
		casta="TanqueOrco";
		energia=Constantes.ENERGIA_TANQUE_ORCO;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_TANQUE_ORCO;
		salud=Constantes.SALUD_TANQUE_ORCO;
		saludMaxima=Constantes.SALUD_MAXIMA_TANQUE_ORCO;
		ataque=Constantes.ATAQUE_TANQUE_ORCO;
		defensa=Constantes.DEFENSA_TANQUE_ORCO;
		magia=Constantes.MAGIA_TANQUE_ORCO;
		velocidad=Constantes.VELOCIDAD_TANQUE_ORCO;
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
