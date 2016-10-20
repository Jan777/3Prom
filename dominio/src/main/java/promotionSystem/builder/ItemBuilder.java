package promotionSystem.builder;

import promotionSystem.Personaje;
import promotionSystem.PersonajeEquipado;
import promotionSystem.personajeEquipado.ConArma;
import promotionSystem.personajeEquipado.ConBotas;
import promotionSystem.personajeEquipado.ConCasco;

public class ItemBuilder {
	
	public static Personaje ConEspadaGorgoroth(Personaje Braixen){
		return new ConArma(Braixen,2,0,1,0,1,10,1,1);
	}//ataque*2 - magia+10 - velocidad+1
	
	public static Personaje ConBotasFlober(Personaje Braixen){
		return new ConBotas(Braixen,1,0,1,-10,1,3,2,0);
	}//defensa-10 - magia+3 - velocidad*2
	
	public static Personaje ConCascoAdamantium(Personaje Braixen){
		return new ConCasco(Braixen,1,10,3,0,1,0,1,0);
	}//defensa*3 - ataque+10
	
	public static Personaje ConChalecoKevlar(Personaje Braixen){
		return new ConCasco(Braixen,1,10,3,0,1,0,1,-15);
	}//ataque+10 - defensa*3 - velocidad-15
	
	public static Personaje ConEscudoHyrule(Personaje Braixen){
		return new ConCasco(Braixen,1,0,2,10,1,0,0.5,0);
	}//defensa*2 + 10 - velocidad/2
}

