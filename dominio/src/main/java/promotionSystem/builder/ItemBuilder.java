package promotionSystem.builder;

import promotionSystem.Item;
import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.ConArma;
import promotionSystem.personajeEquipado.ConBotas;
import promotionSystem.personajeEquipado.ConCasco;
import promotionSystem.personajeEquipado.ConChaleco;
import promotionSystem.personajeEquipado.ConEscudo;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

	public static List<Item> crearItems() throws ClassNotFoundException {
		List<Item> listaDeItems = new ArrayList<Item>();
		listaDeItems.add(new Item("ConEspadaGorgoroth"));
		listaDeItems.add(new Item("ConEspadaKokiri"));
//		listaDeItems.add(new Item("ConBotasFlober"));
//		listaDeItems.add(new Item("ConCascoAdamantium"));
//		listaDeItems.add(new Item("ConChalecoKevlar"));
//		listaDeItems.add(new Item("ConEscudoHyrule"));
//		listaDeItems.add(new Item("ConVaritaMissingno"));
		return listaDeItems;
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
//            braixen.agregarAInventario(new Item("ConBotasFlober", braixen));
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
//            braixen.agregarAInventario(new Item("ConCascoAdamantium", braixen));
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
//            braixen.agregarAInventario(new Item("ConChalecoKevlar", braixen));
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
//            braixen.agregarAInventario(new Item("ConEscudoHyrule", braixen));
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
//            braixen.agregarAInventario(new Item("ConVaritaMissigno", braixen));
		}
		return braixen;
	}
}

