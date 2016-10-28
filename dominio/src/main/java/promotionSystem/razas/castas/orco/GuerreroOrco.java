package promotionSystem.razas.castas.orco;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.razas.Orco;

public class GuerreroOrco extends Orco{

	public GuerreroOrco(){
		energia=Constantes.EnergiaGuerreroOrco;
		energiaMaxima=Constantes.EnergiaMaximaGuerreroOrco;
		salud=Constantes.SaludGuerreroOrco; 
		saludMaxima=Constantes.SaludMaximaGuerreroOrco;
		ataque=Constantes.AtaqueGuerreroOrco;
		defensa=Constantes.DefensaGuerreroOrco;
		magia=Constantes.MagiaGuerreroOrco;
		velocidad=Constantes.VelocidadGuerreroOrco;
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
		salud+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		ataque+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelEspecial;
		defensa+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		magia+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
		velocidad+=cantidadDeNivelesSubidos*Constantes.MultiplicadorDeNivelNormal;
	}
}
