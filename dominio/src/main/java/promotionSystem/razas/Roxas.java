package promotionSystem.razas;

import java.util.HashMap;

import promotionSystem.Circulo;
import promotionSystem.Punto;
import promotionSystem.hechizo.Cura;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.hechizo.Trueno;

public class Roxas extends PersonajeDeKingdomHearts {

    public Roxas() {
        energia = 1000;
        energiaMaxima=1000;
		saludMaxima=100;
        salud = 100;
        ataque = 55;
        defensa = 200;
        magia = 200;
        velocidad = 150;
        experiencia = 0;
        nivel = 0;
        posicion = new Punto(0, 0);
        radioDeAcccion=new Circulo(posicion,20);
        hechizos = new HashMap<String, Hechizo>();
        agregarHechizo("Trueno",new Trueno());
        agregarHechizo("Cura",new Cura());
    }

    @Override
    public void subirStats(int nivel) {
        energia += nivel * 10;
        energiaMaxima+=nivel*10;
		saludMaxima+=nivel*5;
        salud += nivel * 5;
        ataque += nivel * 5;
        defensa += nivel * 10;
        magia += nivel * 10;
        velocidad += nivel * 10;
    }
}
