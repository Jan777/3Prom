package promotionSystem.items;

import promotionSystem.Item;

public class BotasFlober extends Item{

    public BotasFlober() {
        super("BotasFlober", "botas");
        sumadorDeDefensa = -10;
        sumadorDeMagia = 5;
        multiplicadorDeVelocidad = 2;
        sumadorDeVelocidad = 15;
    }
}
