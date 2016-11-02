package promotionSystem.items;

import promotionSystem.Item;

public class BotasFlober extends Item{

    public BotasFlober() {
        super("Botas Flober", "botas");
        sumadorDeDefensa = -10;
        sumadorDeMagia = 5;
        sumadorDeVelocidad = 15;
    }
}
