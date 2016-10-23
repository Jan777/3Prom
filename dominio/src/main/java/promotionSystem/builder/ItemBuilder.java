package promotionSystem.builder;

import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.ConArma;
import promotionSystem.personajeEquipado.ConBotas;
import promotionSystem.personajeEquipado.ConCasco;
import promotionSystem.personajeEquipado.ConChaleco;
import promotionSystem.personajeEquipado.ConEscudo;

public class ItemBuilder {
	
	public static Personaje ConEspadaGorgoroth(Personaje braixen){
		final double multiplicadorDeAtaque = 2;
		final int sumadorDeAtaque = 0;
		final double multiplicadorDeDefensa = 1;
		final int sumadorDeDefensa = 0;
		final double multiplicadorDeMagia = 1;
		final int sumadorDeMagia = 10;
		final double multiplicadorDeVelocidad = 1;
		final int sumadorDeVelocidad = 1;
		if(braixen.puedeEquiparArma()){
			braixen.setArma();
			return new ConArma(braixen,multiplicadorDeAtaque,sumadorDeAtaque,multiplicadorDeDefensa,sumadorDeDefensa,multiplicadorDeMagia,sumadorDeMagia,multiplicadorDeVelocidad,sumadorDeVelocidad);
		}
		else{
			if(braixen.puedeEquiparArmaInventario()){
				braixen.setArmaInventario("ConEspadaGorgoroth");
			}
		}
		return braixen;
	}
	
	public static Personaje ConEspadaKokiri(Personaje braixen){
		final double multiplicadorDeAtaque = 2;
		final int sumadorDeAtaque = 0;
		final double multiplicadorDeDefensa = 1;
		final int sumadorDeDefensa = 0;
		final double multiplicadorDeMagia = 1;
		final int sumadorDeMagia = 10;
		final double multiplicadorDeVelocidad = 1;
		final int sumadorDeVelocidad = 1;
		if(braixen.puedeEquiparArma()){
			braixen.setArma();
			return new ConArma(braixen,multiplicadorDeAtaque,sumadorDeAtaque,multiplicadorDeDefensa,sumadorDeDefensa,multiplicadorDeMagia,sumadorDeMagia,multiplicadorDeVelocidad,sumadorDeVelocidad);
		}
		else{
			if(braixen.puedeEquiparArmaInventario()){
				braixen.setArmaInventario("ConEspadaKokiri");
			}
		}
		return braixen;
	}
	
	public static Personaje ConBotasFlober(Personaje braixen){
		final double multiplicadorDeAtaque = 2;
		final int sumadorDeAtaque = 0;
		final double multiplicadorDeDefensa = 1;
		final int sumadorDeDefensa = -10;
		final double multiplicadorDeMagia = 1;
		final int sumadorDeMagia = 3;
		final double multiplicadorDeVelocidad = 2;
		final int sumadorDeVelocidad = 1;
		if(braixen.puedeEquiparBotas()){
			braixen.setBotas();
			return new ConBotas(braixen,multiplicadorDeAtaque,sumadorDeAtaque,multiplicadorDeDefensa,sumadorDeDefensa,multiplicadorDeMagia,sumadorDeMagia,multiplicadorDeVelocidad,sumadorDeVelocidad);
		}
		else{
			if(braixen.puedeEquiparBotasInventario()){
				braixen.setBotasInventario("ConBotasFlober");
			}
		}
		return braixen;
	}
	
	public static Personaje ConCascoAdamantium(Personaje braixen){
		final double multiplicadorDeAtaque = 1;
		final int sumadorDeAtaque = 10;
		final double multiplicadorDeDefensa = 3;
		final int sumadorDeDefensa = 0;
		final double multiplicadorDeMagia = 1;
		final int sumadorDeMagia = 0;
		final double multiplicadorDeVelocidad = 1;
		final int sumadorDeVelocidad = 0;
		if(braixen.puedeEquiparCasco()){
			braixen.setCasco();
			return new ConCasco(braixen,multiplicadorDeAtaque,sumadorDeAtaque,multiplicadorDeDefensa,sumadorDeDefensa,multiplicadorDeMagia,sumadorDeMagia,multiplicadorDeVelocidad,sumadorDeVelocidad);
		}
		else{
			if(braixen.puedeEquiparCascoInventario()){
				braixen.setCascoInventario("ConCascoAdamantium");
			}
		}
		return braixen;
	}
	
	public static Personaje ConChalecoKevlar(Personaje braixen){
		final double multiplicadorDeAtaque = 1;
		final int sumadorDeAtaque = 10;
		final double multiplicadorDeDefensa = 3;
		final int sumadorDeDefensa = 0;
		final double multiplicadorDeMagia = 1;
		final int sumadorDeMagia = 0;
		final double multiplicadorDeVelocidad = 1;
		final int sumadorDeVelocidad = -15;
		if(braixen.puedeEquiparChaleco()){
			braixen.setChaleco();
			return new ConChaleco(braixen,multiplicadorDeAtaque,sumadorDeAtaque,multiplicadorDeDefensa,sumadorDeDefensa,multiplicadorDeMagia,sumadorDeMagia,multiplicadorDeVelocidad,sumadorDeVelocidad);
		}
		else{
			if(braixen.puedeEquiparChalecoInventario()){
				braixen.setChalecoInventario("ConChalecoKevlar");
			}
		}
		return braixen;
	}
	
	public static Personaje ConEscudoHyrule(Personaje braixen){
		final double multiplicadorDeAtaque = 1;
		final int sumadorDeAtaque = 0;
		final double multiplicadorDeDefensa = 2;
		final int sumadorDeDefensa = 10;
		final double multiplicadorDeMagia = 1;
		final int sumadorDeMagia = 0;
		final double multiplicadorDeVelocidad = 0.5;
		final int sumadorDeVelocidad = 0;
		if(braixen.puedeEquiparEscudo()){
			braixen.setEscudo();
			return new ConEscudo(braixen,multiplicadorDeAtaque,sumadorDeAtaque,multiplicadorDeDefensa,sumadorDeDefensa,multiplicadorDeMagia,sumadorDeMagia,multiplicadorDeVelocidad,sumadorDeVelocidad);
		}
		else{
			if(braixen.puedeEquiparEscudoInventario()){
				braixen.setEscudoInventario("ConEscudoHyrule");
			}
		}
		return braixen;
	}
}

