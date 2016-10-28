package promotionSystem.razas.castas.undertale;

import promotionSystem.Circulo;
import promotionSystem.Punto;
import promotionSystem.Constantes;
import promotionSystem.razas.PersonajeDeUndertale;

public class Chara extends PersonajeDeUndertale{
	public Chara(){
		energia=Constantes.EnergiaChara;
		energiaMaxima=Constantes.EnergiaMaximaChara;
		salud=Constantes.SaludChara; 
		saludMaxima=Constantes.SaludMaximaChara;
		ataque=Constantes.AtaqueChara;
		defensa=Constantes.DefensaChara;
		magia=Constantes.MagiaChara;
		velocidad=Constantes.VelocidadChara;
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
