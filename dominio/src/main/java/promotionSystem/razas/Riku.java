package promotionSystem.razas;

import promotionSystem.Punto;

public class Riku extends PersonajesDeKingdomHearts {

    public Riku() {
        energia = 1000;
        salud = 200;
        ataque = 200;
        defensa = 50;
        magia = 75;
        velocidad = 150;
        experiencia = 0;
        nivel = 0;
        posicion = new Punto(0, 0);

    }

    @Override
    public void subirStats(int nivel) {
        energia += nivel*10;
        salud += nivel*10;
        ataque += nivel*10;
        defensa += nivel*5;
        magia += nivel*5;
        velocidad += nivel*5;
    }


}
