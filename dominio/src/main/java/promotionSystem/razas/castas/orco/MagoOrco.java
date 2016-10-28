package promotionSystem.razas.castas.orco;

import java.util.HashMap;

import promotionSystem.Circulo;
import promotionSystem.Constantes;
import promotionSystem.Punto;
import promotionSystem.hechizo.Cura;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Hielo;
import promotionSystem.hechizo.Piro;
import promotionSystem.razas.Orco;

public class MagoOrco extends Orco{
	
	public MagoOrco(){
		energia=Constantes.EnergiaMagoOrco;
		energiaMaxima=Constantes.EnergiaMaximaMagoOrco;
		salud=Constantes.SaludMagoOrco; 
		saludMaxima=Constantes.SaludMaximaMagoOrco;
		ataque=Constantes.AtaqueMagoOrco;
		defensa=Constantes.DefensaMagoOrco;
		magia=Constantes.MagiaMagoOrco;
		velocidad=Constantes.VelocidadMagoOrco;
		experiencia=0;
		nivel=1;
		posicion=new Punto(0,0);
		radioDeAcccion=new Circulo(posicion,20);
		hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("Piro",new Piro());
        agregarHechizo("Hielo",new Hielo());
		
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
