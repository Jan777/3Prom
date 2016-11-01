package promotionSystem.builder;

import promotionSystem.Item;
import promotionSystem.Personaje;
import promotionSystem.personajeEquipado.*;

import java.util.ArrayList;
import java.util.List;

public class ItemBuilder {

	public static List<Item> crearItems() throws ClassNotFoundException {
		List<Item> listaDeItems = new ArrayList<Item>();
		listaDeItems.add(new Item("ConEspadaGorgoroth"));
		listaDeItems.add(new Item("ConEspadaKokiri"));
		listaDeItems.add(new Item("ConBotasFlober"));
		listaDeItems.add(new Item("ConCascoAdamantium"));
		listaDeItems.add(new Item("ConChalecoKevlar"));
		listaDeItems.add(new Item("ConEscudoHyrule"));
		listaDeItems.add(new Item("ConVaritaMissingno"));
		return listaDeItems;
	}
}

