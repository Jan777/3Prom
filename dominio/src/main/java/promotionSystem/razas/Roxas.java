package promotionSystem.razas;

import java.util.HashMap;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.Cura;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Hielo;

public class Roxas extends PersonajeDeKingdomHearts {

	public Roxas(){
		energia=Constantes.EnergiaRoxas;
		energiaMaxima=Constantes.EnergiaMaximaRoxas;
		salud=Constantes.SaludRoxas; 
		saludMaxima=Constantes.SaludMaximaRoxas;
		ataque=Constantes.AtaqueRoxas;
		defensa=Constantes.DefensaRoxas;
		magia=Constantes.MagiaRoxas;
		velocidad=Constantes.VelocidadRoxas;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("Trueno",new Hielo());
        agregarHechizo("Cura",new Cura());
	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		salud+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		ataque+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelEspecial;
		defensa+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		magia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
	}
}
