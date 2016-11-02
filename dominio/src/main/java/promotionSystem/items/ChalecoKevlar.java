package promotionSystem.items;

import promotionSystem.Item;

public class ChalecoKevlar extends Item{

    public ChalecoKevlar() {
        super("Chaleco Kevlar", "chaleco");
        sumadorDeAtaque = 10;
        sumadorDeDefensa = 10;
        sumadorDeVelocidad = -10;
    }
}
