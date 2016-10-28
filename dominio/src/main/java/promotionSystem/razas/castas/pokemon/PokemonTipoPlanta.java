package promotionSystem.razas.castas.pokemon;

import java.util.HashMap;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.Gigadrenado;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Hidrobomba;
import promotionSystem.razas.PersonajeDePokemon;

public class PokemonTipoPlanta extends PersonajeDePokemon {

	public PokemonTipoPlanta(){
		energia=Constantes.EnergiaPokemonDePlanta;
		energiaMaxima=Constantes.EnergiaMaximaPokemonDePlanta;
		salud=Constantes.SaludPokemonDePlanta; 
		saludMaxima=Constantes.SaludMaximaPokemonDePlanta;
		ataque=Constantes.AtaquePokemonDePlanta;
		defensa=Constantes.DefensaPokemonDePlanta;
		magia=Constantes.MagiaPokemonDePlanta;
		velocidad=Constantes.VelocidadPokemonDePlanta;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("Gigadrenado",new Gigadrenado());
	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		salud+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		ataque+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		defensa+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelEspecial;
		magia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelEspecial;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelPlebe;
	}
}
