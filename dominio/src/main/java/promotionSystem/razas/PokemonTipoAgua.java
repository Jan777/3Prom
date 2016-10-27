package promotionSystem.razas;

import java.util.HashMap;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Hidrobomba;
import promotionSystem.hechizo.Llamarada;

public class PokemonTipoAgua extends PersonajeDePokemon{
	
	public PokemonTipoAgua(){
		energia=Constantes.EnergiaPokemonDeAgua;
		energiaMaxima=Constantes.EnergiaMaximaPokemonDeAgua;
		salud=Constantes.SaludPokemonDeAgua; 
		saludMaxima=Constantes.SaludMaximaPokemonDeAgua;
		ataque=Constantes.AtaquePokemonDeAgua;
		defensa=Constantes.DefensaPokemonDeAgua;
		magia=Constantes.MagiaPokemonDeAgua;
		velocidad=Constantes.VelocidadPokemonDeAgua;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("Hidrobomba",new Hidrobomba());
	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		salud+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		ataque+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelEspecial;
		defensa+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelEspecial;
		magia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelPlebe;
	}
}


