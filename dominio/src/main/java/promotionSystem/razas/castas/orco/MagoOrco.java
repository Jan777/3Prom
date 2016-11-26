package promotionSystem.razas.castas.orco;

import promotionSystem.Constantes;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Hielo;
import promotionSystem.hechizo.Piro;
import promotionSystem.razas.Orco;

import java.util.HashMap;

public class MagoOrco extends Orco{
	
	public MagoOrco(){
		casta="MagoOrco";
		energia=Constantes.ENERGIA_MAGO_ORCO;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_MAGO_ORCO;
		salud=Constantes.SALUD_MAGO_ORCO;
		saludMaxima=Constantes.SALUD_MAXIMA_MAGO_ORCO;
		ataque=Constantes.ATAQUE_MAGO_ORCO;
		defensa=Constantes.DEFENSA_MAGO_ORCO;
		magia=Constantes.MAGIA_MAGO_ORCO;
		velocidad=Constantes.VELOCIDAD_MAGO_ORCO;
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("Piro",new Piro());
        agregarHechizo("Hielo",new Hielo());
		
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
