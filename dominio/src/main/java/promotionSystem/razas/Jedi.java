package promotionSystem.razas;

import java.util.HashMap;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.ControlMental;
import promotionSystem.hechizo.Electrificar;
import promotionSystem.hechizo.EmpujonDeFuerza;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Telekinesis;

public class Jedi extends PersonajeDeStarWars{
	
	public Jedi(){
		energia=Constantes.EnergiaJedi;
		energiaMaxima=Constantes.EnergiaMaximaJedi;
		salud=Constantes.SaludJedi; 
		saludMaxima=Constantes.SaludMaximaJedi;
		ataque=Constantes.AtaqueJedi;
		defensa=Constantes.DefensaJedi;
		magia=Constantes.MagiaJedi;
		velocidad=Constantes.VelocidadJedi;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("EmpujonDeFuerza",new EmpujonDeFuerza());
        agregarHechizo("Telekinesis",new Telekinesis());
        agregarHechizo("Electrificar",new Electrificar());
        agregarHechizo("ControlMental",new ControlMental());
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

	@Override
	public void despuesDeAtacar() {
		magia+=2;
		
	}
}
