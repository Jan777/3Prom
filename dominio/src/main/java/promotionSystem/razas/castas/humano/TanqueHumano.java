package promotionSystem.razas.castas.humano;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.razas.Humano;

public class TanqueHumano extends Humano{
	
	public TanqueHumano(){
		energia=Constantes.EnergiaTanqueHumano;
		energiaMaxima=Constantes.EnergiaMaximaTanqueHumano;
		salud=Constantes.SaludTanqueHumano; 
		saludMaxima=Constantes.SaludMaximaTanqueHumano;
		ataque=Constantes.AtaqueTanqueHumano;
		defensa=Constantes.DefensaTanqueHumano;
		magia=Constantes.MagiaTanqueHumano;
		velocidad=Constantes.VelocidadTanqueHumano;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
	}

	@Override
	public void subirStats(int cantidadDeNivelesSubidos) {
		energia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		energiaMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		saludMaxima+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelEspecial;
		salud+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelEspecial;
		ataque+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		defensa+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		magia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
	}
}
