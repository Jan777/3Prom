package promotionSystem.razas.castas.kingdomHearts;

import java.util.HashMap;



import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.Cura;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Piro;
import promotionSystem.razas.PersonajeDeKingdomHearts;

public class Sora extends PersonajeDeKingdomHearts {
	
	public Sora(){
		energia=Constantes.EnergiaSora;
		energiaMaxima=Constantes.EnergiaMaximaSora;
		salud=Constantes.SaludSora; 
		saludMaxima=Constantes.SaludMaximaSora;
		ataque=Constantes.AtaqueSora;
		defensa=Constantes.DefensaSora;
		magia=Constantes.MagiaSora;
		velocidad=Constantes.VelocidadSora;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
	    agregarHechizo("Piro",new Piro());
	    agregarHechizo("Cura",new Cura());
	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		salud+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		ataque+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		defensa+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		magia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelEspecial;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
	}
}
