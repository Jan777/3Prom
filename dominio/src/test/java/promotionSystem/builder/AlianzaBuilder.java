package promotionSystem.builder;

import promotionSystem.Alianza;
import promotionSystem.alianzas.AlianzaDeHumanos;
import promotionSystem.Personaje;

import java.util.ArrayList;
import java.util.List;

public class AlianzaBuilder {

    public static Alianza crearAlianza(int cantidadDePersonajes){
        List<Personaje> personajes = new ArrayList<>();
        for(int i= 0; i < cantidadDePersonajes; i++){
            personajes.add(new Personaje());
        }
        return new Alianza(personajes);
    }

    public static AlianzaDeHumanos crearAlianzaDeHumanos(int cantidadDePersonajes){
        List<Personaje> personajes = new ArrayList<>();
        for(int i= 0; i < cantidadDePersonajes; i++){
            personajes.add(new Personaje());
        }
        return new AlianzaDeHumanos(personajes);
    }
}
