package promotionSystem.razas.castas.humano;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.Cura;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Trueno;
import promotionSystem.razas.Humano;

import java.util.HashMap;

public class MagoHumano extends Humano {

	public MagoHumano(){
		energia=Constantes.ENERGIA_MAGO_HUMANO;
		energiaMaxima=Constantes.ENERGIA_MAXIMA_MAGO_HUMANO;
		salud=Constantes.SALUD_MAGO_HUMANO;
		saludMaxima=Constantes.SALUD_MAXIMA_MAGO_HUMANO;
		ataque=Constantes.ATAQUE_MAGO_HUMANO;
		defensa=Constantes.DEFENSA_MAGO_HUMANO;
		magia=Constantes.MAGIA_MAGO_HUMANO;
		velocidad=Constantes.VELOCIDAD_MAGO_HUMANO;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("Trueno",new Trueno());
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
