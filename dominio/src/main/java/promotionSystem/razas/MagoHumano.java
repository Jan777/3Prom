package promotionSystem.razas;

import java.util.HashMap;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.Cura;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Hielo;

public class MagoHumano extends Humano {

	public MagoHumano(){
		energia=Constantes.EnergiaMagoHumano;
		energiaMaxima=Constantes.EnergiaMaximaMagoHumano;
		salud=Constantes.SaludMagoHumano; 
		saludMaxima=Constantes.SaludMaximaMagoHumano;
		ataque=Constantes.AtaqueMagoHumano;
		defensa=Constantes.DefensaMagoHumano;
		magia=Constantes.MagiaMagoHumano;
		velocidad=Constantes.VelocidadMagoHumano;
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
		ataque+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		defensa+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		magia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelEspecial;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
	}
}
