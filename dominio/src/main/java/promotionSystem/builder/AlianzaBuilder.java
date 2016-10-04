package promotionSystem.builder;

import promotionSystem.Alianza;
import promotionSystem.Personaje;

import java.util.ArrayList;
import java.util.List;

public class AlianzaBuilder {

    public static Alianza crearAlianza(int cantidadDePersonajes){
        List<Personaje> personajes = new ArrayList<Personaje>();
        for(int i= 0; i < cantidadDePersonajes; i++){
            personajes.add(new Personaje());
        }
        return new Alianza(personajes);
    }
}
