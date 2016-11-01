package promotionSystem.razas.castas.pokemon;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Llamarada;
import promotionSystem.razas.PersonajeDePokemon;

import java.util.HashMap;

public class PokemonTipoFuego extends PersonajeDePokemon {
	public PokemonTipoFuego(){
		energia=Constantes.EnergiaPokemonDeFuego;
		energiaMaxima=Constantes.EnergiaMaximaPokemonDeFuego;
		salud=Constantes.SaludPokemonDeFuego; 
		saludMaxima=Constantes.SaludMaximaPokemonDeFuego;
		ataque=Constantes.AtaquePokemonDeFuego;
		defensa=Constantes.DefensaPokemonDeFuego;
		magia=Constantes.MagiaPokemonDeFuego;
		velocidad=Constantes.VelocidadPokemonDeFuego;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("Llamarada",new Llamarada());
        
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
