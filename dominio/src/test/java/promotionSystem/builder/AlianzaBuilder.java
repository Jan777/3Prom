package promotionSystem.builder;

import promotionSystem.Alianza;
import promotionSystem.alianzas.AlianzaDeHumanos;
import promotionSystem.razas.GuerreroHumano;
import promotionSystem.razas.Humano;
import promotionSystem.Personaje;

import java.util.ArrayList;
import java.util.List;

public class AlianzaBuilder {

    public static Alianza crearAlianza(int cantidadDePersonajes){
        List<Personaje> personajes = new ArrayList<Personaje>();
        for(int i= 0; i < cantidadDePersonajes; i++){
            personajes.add(new GuerreroHumano());
        }
        return new Alianza(personajes);
    }

    public static AlianzaDeHumanos crearAlianzaDeHumanos(int cantidadDePersonajes){
        List<Personaje> personajes = new ArrayList<Personaje>();
        for(int i= 0; i < cantidadDePersonajes; i++){
            personajes.add(new GuerreroHumano());
        }
        return new AlianzaDeHumanos(personajes);
    }
}
