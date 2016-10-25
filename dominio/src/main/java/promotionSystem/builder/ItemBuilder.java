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
		final int SumadorDeVelocidad = 10;
		if(braixen.puedeEquiparArma()){
			braixen = new ConArma(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
			braixen.setArma("ConEspadaGorgoroth");
			return braixen;
		}
		else{
			if(braixen.puedeEquiparArmaInventario()){
				braixen.setArmaDelInventario("ConEspadaGorgoroth");
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
		final int SumadorDeVelocidad = 10;
		if(braixen.puedeEquiparArma()){
			braixen = new ConArma(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
			braixen.setArma("ConEspadaKokiri");
			return braixen;
		}
		else{
			if(braixen.puedeEquiparArmaInventario()){
				braixen.setArmaDelInventario("ConEspadaKokiri");
			}
		}
		return braixen;
	}
	
	public static Personaje ConBotasFlober(Personaje braixen){
		final double MultiplicadorDeAtaque = 1;
		final int SumadorDeAtaque = 0;
		final double MultiplicadorDeDefensa = 1;
		final int SumadorDeDefensa = -10;
		final double MultiplicadorDeMagia = 1;
		final int SumadorDeMagia = 5;
		final double MultiplicadorDeVelocidad = 2;
		final int SumadorDeVelocidad = 15;
		if(braixen.puedeEquiparBotas()){
			braixen = new ConBotas(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
			braixen.setBotas("ConBotasFlober");
			return braixen;
		}
		else{
			if(braixen.puedeEquiparBotasInventario()){
				braixen.setBotasDelInventario("ConBotasFlober");
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
			braixen = new ConCasco(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
			braixen.setCasco("ConCascoAdamantium");
			return braixen;
		}
		else{
			if(braixen.puedeEquiparCascoInventario()){
				braixen.setCascoDelInventario("ConCascoAdamantium");
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
		final int SumadorDeVelocidad = -10;
		if(braixen.puedeEquiparChaleco()){
			braixen = new ConChaleco(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
			braixen.setChaleco("ConChalecoKevlar");
			return braixen;
		}
		else{
			if(braixen.puedeEquiparChalecoInventario()){
				braixen.setChalecoDelInventario("ConChalecoKevlar");
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
			braixen = new ConEscudo(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
			braixen.setEscudo("ConEscudoHyrule");
			return braixen;
		}
		else{
			if(braixen.puedeEquiparEscudoInventario()){
				braixen.setEscudoDelInventario("ConEscudoHyrule");
			}
		}
		return braixen;
	}
	
	
	public static Personaje ConVaritaMissingno(Personaje braixen){
		final double MultiplicadorDeAtaque = 1;
		final int SumadorDeAtaque = 0;
		final double MultiplicadorDeDefensa = 1;
		final int SumadorDeDefensa = 0;
		final double MultiplicadorDeMagia = 2;
		final int SumadorDeMagia = 5;
		final double MultiplicadorDeVelocidad = 1;
		final int SumadorDeVelocidad = -10;
		if(braixen.puedeEquiparArma()){
			braixen = new ConArma(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
			braixen.setArma("ConVaritaMissigno");
			return braixen;
		}
		else{
			if(braixen.puedeEquiparArmaInventario()){
				braixen.setArmaDelInventario("ConVaritaMissigno");
			}
		}
		return braixen;
	}
}

