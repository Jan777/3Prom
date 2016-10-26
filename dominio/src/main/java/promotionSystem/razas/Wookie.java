package promotionSystem.razas;

import java.util.HashMap;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.IraWookeana;

public class Wookie extends PersonajeDeStarWars{
	
	public Wookie(){
		energia=Constantes.EnergiaWookie;
		energiaMaxima=Constantes.EnergiaMaximaWookie;
		salud=Constantes.SaludWookie; 
		saludMaxima=Constantes.SaludMaximaWookie;
		ataque=Constantes.AtaqueWookie;
		defensa=Constantes.DefensaWookie;
		magia=Constantes.MagiaWookie;
		velocidad=Constantes.VelocidadWookie;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("IraWookeana",new IraWookeana());
	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		salud+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		ataque+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelEspecial;
		defensa+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelEspecial;
		magia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelPlebe;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
	}


	@Override
	public void despuesDeAtacar() {
		ataque+=5;
		defensa-=2;
		
	}

}
