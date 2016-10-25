package promotionSystem.builder;

import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.ConArma;
import promotionSystem.personajeEquipado.ConBotas;
import promotionSystem.personajeEquipado.ConCasco;
import promotionSystem.personajeEquipado.ConChaleco;
import promotionSystem.personajeEquipado.ConEscudo;

public class ItemBuilder {
	
	public static Personaje ConEspadaGorgoroth(Personaje braixen){
		final double MultiplicadorDeAtaque = 2;
		final int SumadorDeAtaque = 0;
		final double MultiplicadorDeDefensa = 1;
		final int SumadorDeDefensa = 0;
		final double MultiplicadorDeMagia = 1;
		final int SumadorDeMagia = 10;
		final double MultiplicadorDeVelocidad = 1;
		final int SumadorDeVelocidad = 1;
		if(braixen.puedeEquiparArma()){
			braixen.setArma();
			return new ConArma(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
		}
		else{
			if(braixen.puedeEquiparArmaInventario()){
				braixen.setArmaInventario("ConEspadaGorgoroth");
			}
		}
		return braixen;
	}
	
	public static Personaje ConEspadaKokiri(Personaje braixen){
		final double MultiplicadorDeAtaque = 2;
		final int SumadorDeAtaque = 0;
		final double MultiplicadorDeDefensa = 1;
		final int SumadorDeDefensa = 0;
		final double MultiplicadorDeMagia = 1;
		final int SumadorDeMagia = 10;
		final double MultiplicadorDeVelocidad = 1;
		final int SumadorDeVelocidad = 1;
		if(braixen.puedeEquiparArma()){
			braixen.setArma();
			return new ConArma(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
		}
		else{
			if(braixen.puedeEquiparArmaInventario()){
				braixen.setArmaInventario("ConEspadaKokiri");
			}
		}
		return braixen;
	}
	
	public static Personaje ConBotasFlober(Personaje braixen){
		final double MultiplicadorDeAtaque = 2;
		final int SumadorDeAtaque = 0;
		final double MultiplicadorDeDefensa = 1;
		final int SumadorDeDefensa = -10;
		final double MultiplicadorDeMagia = 1;
		final int SumadorDeMagia = 3;
		final double MultiplicadorDeVelocidad = 2;
		final int SumadorDeVelocidad = 1;
		if(braixen.puedeEquiparBotas()){
			braixen.setBotas();
			return new ConBotas(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
		}
		else{
			if(braixen.puedeEquiparBotasInventario()){
				braixen.setBotasInventario("ConBotasFlober");
			}
		}
		return braixen;
	}
	
	public static Personaje ConCascoAdamantium(Personaje braixen){
		final double MultiplicadorDeAtaque = 1;
		final int SumadorDeAtaque = 10;
		final double MultiplicadorDeDefensa = 3;
		final int SumadorDeDefensa = 0;
		final double MultiplicadorDeMagia = 1;
		final int SumadorDeMagia = 0;
		final double MultiplicadorDeVelocidad = 1;
		final int SumadorDeVelocidad = 0;
		if(braixen.puedeEquiparCasco()){
			braixen.setCasco();
			return new ConCasco(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
		}
		else{
			if(braixen.puedeEquiparCascoInventario()){
				braixen.setCascoInventario("ConCascoAdamantium");
			}
		}
		return braixen;
	}
	
	public static Personaje ConChalecoKevlar(Personaje braixen){
		final double MultiplicadorDeAtaque = 1;
		final int SumadorDeAtaque = 10;
		final double MultiplicadorDeDefensa = 3;
		final int SumadorDeDefensa = 0;
		final double MultiplicadorDeMagia = 1;
		final int SumadorDeMagia = 0;
		final double MultiplicadorDeVelocidad = 1;
		final int SumadorDeVelocidad = -15;
		if(braixen.puedeEquiparChaleco()){
			braixen.setChaleco();
			return new ConChaleco(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
		}
		else{
			if(braixen.puedeEquiparChalecoInventario()){
				braixen.setChalecoInventario("ConChalecoKevlar");
			}
		}
		return braixen;
	}
	
	public static Personaje ConEscudoHyrule(Personaje braixen){
		final double MultiplicadorDeAtaque = 1;
		final int SumadorDeAtaque = 0;
		final double MultiplicadorDeDefensa = 2;
		final int SumadorDeDefensa = 10;
		final double MultiplicadorDeMagia = 1;
		final int SumadorDeMagia = 0;
		final double MultiplicadorDeVelocidad = 0.5;
		final int SumadorDeVelocidad = 0;
		if(braixen.puedeEquiparEscudo()){
			braixen.setEscudo();
			return new ConEscudo(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
		}
		else{
			if(braixen.puedeEquiparEscudoInventario()){
				braixen.setEscudoInventario("ConEscudoHyrule");
			}
		}
		return braixen;
	}
	
	
	public static Personaje ConVaritaMissigno(Personaje braixen){
		final double MultiplicadorDeAtaque = 1;
		final int SumadorDeAtaque = 0;
		final double MultiplicadorDeDefensa = 1;
		final int SumadorDeDefensa = 0;
		final double MultiplicadorDeMagia = 2;
		final int SumadorDeMagia = 5;
		final double MultiplicadorDeVelocidad = 1;
		final int SumadorDeVelocidad = -10;
		if(braixen.puedeEquiparArma()){
			braixen.setArma();
			return new ConArma(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
		}
		else{
			if(braixen.puedeEquiparArmaInventario()){
				braixen.setArmaInventario("ConVaritaMissigno");
			}
		}
		return braixen;
	}
}

