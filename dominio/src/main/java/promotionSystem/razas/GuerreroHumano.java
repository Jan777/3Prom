package promotionSystem.razas;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;

public class GuerreroHumano extends Humano{
	
	public GuerreroHumano(){
		energia=Constantes.EnergiaGuerreroHumano;
		energiaMaxima=Constantes.EnergiaMaximaGuerreroHumano;
		salud=Constantes.SaludGuerreroHumano; 
		saludMaxima=Constantes.SaludMaximaGuerreroHumano;
		ataque=Constantes.AtaqueGuerreroHumano;
		defensa=Constantes.DefensaGuerreroHumano;
		magia=Constantes.MagiaGuerreroHumano;
		velocidad=Constantes.VelocidadGuerreroHumano;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
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
