package promotionSystem.razas;

import java.util.HashMap;

import promotionSystem.Circulo;
import promotionSystem.Punto;
import promotionSystem.hechizo.Cura;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Hielo;
import promotionSystem.hechizo.Piro;
import promotionSystem.hechizo.Trueno;

public class Riku extends PersonajeDeKingdomHearts {

    public Riku() {
        energia = 1000;
        energiaMaxima=1000;
		saludMaxima=200;
        salud = 200;
        ataque = 200;
        defensa = 50;
        magia = 75;
        velocidad = 150;
        experiencia = 0;
        nivel = 0;
        posicion = new Punto(0, 0);
        radioDeAcccion=new Circulo(posicion,20);
        hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("Hielo",new Hielo());
        agregarHechizo("Cura",new Cura());

    }

    @Override
    public void subirStats(int nivel) {
        energia += nivel*10;
        energiaMaxima+=nivel*10;
		saludMaxima+=nivel*10;
        salud += nivel*10;
        ataque += nivel*10;
        defensa += nivel*5;
        magia += nivel*5;
        velocidad += nivel*5;
    }


}
