package promotionSystem.razas.castas.orco;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.razas.Orco;

public class TanqueOrco extends Orco{

	public TanqueOrco(){
		energia=Constantes.EnergiaTanqueOrco;
		energiaMaxima=Constantes.EnergiaMaximaTanqueOrco;
		salud=Constantes.SaludTanqueOrco; 
		saludMaxima=Constantes.SaludMaximaTanqueOrco;
		ataque=Constantes.AtaqueTanqueOrco;
		defensa=Constantes.DefensaTanqueOrco;
		magia=Constantes.MagiaTanqueOrco;
		velocidad=Constantes.VelocidadTanqueOrco;
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
