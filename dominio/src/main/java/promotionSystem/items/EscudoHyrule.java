package promotionSystem.items;

import promotionSystem.Item;

public class EscudoHyrule extends Item{

    public EscudoHyrule() {
        super("EscudoHyrule", "escudo");
        multiplicadorDeDefensa = 2;
        sumadorDeDefensa = 10;
        multiplicadorDeVelocidad = 0.5;
    }
}
