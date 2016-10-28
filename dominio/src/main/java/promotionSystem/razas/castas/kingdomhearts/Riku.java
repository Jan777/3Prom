package promotionSystem.razas.castas.kingdomhearts;

import java.util.HashMap;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.Cura;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Hielo;
import promotionSystem.razas.PersonajeDeKingdomHearts;

public class Riku extends PersonajeDeKingdomHearts {

	public Riku(){
		energia=Constantes.EnergiaRiku;
		energiaMaxima=Constantes.EnergiaMaximaRiku;
		salud=Constantes.SaludRiku; 
		saludMaxima=Constantes.SaludMaximaRiku;
		ataque=Constantes.AtaqueRiku;
		defensa=Constantes.DefensaRiku;
		magia=Constantes.MagiaRiku;
		velocidad=Constantes.VelocidadRiku;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("Hielo",new Hielo());
        agregarHechizo("Cura",new Cura());

	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		salud+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		ataque+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		defensa+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelPlebe;
		magia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelEspecial;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelEspecial;
	}
}
