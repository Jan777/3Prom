package promotionSystem.razas.castas.starWars;

import java.util.HashMap;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.CampoDeFuerza;
import promotionSystem.hechizo.Cura;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.razas.PersonajeDeStarWars;

public class Droide extends PersonajeDeStarWars{
	
	public Droide(){
		energia=Constantes.EnergiaDroide;
		energiaMaxima=Constantes.EnergiaMaximaDroide;
		salud=Constantes.SaludDroide; 
		saludMaxima=Constantes.SaludMaximaDroide;
		ataque=Constantes.AtaqueDroide;
		defensa=Constantes.DefensaDroide;
		magia=Constantes.MagiaDroide;
		velocidad=Constantes.VelocidadDroide;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("Cura",new Cura());
        agregarHechizo("CampoDeFuerza",new CampoDeFuerza());
	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		salud+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		ataque+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		defensa+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		magia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelEspecial;
	}

	@Override
	public void despuesDeAtacar() {
		velocidad+=2;
		
	}
}
