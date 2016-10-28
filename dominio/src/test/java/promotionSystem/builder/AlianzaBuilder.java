package promotionSystem.builder;

import promotionSystem.Alianza;
import promotionSystem.alianzas.AlianzaDeHumanos;
import promotionSystem.alianzas.AlianzaDeOrcos;
import promotionSystem.razas.Humano;
import promotionSystem.razas.castas.humano.GuerreroHumano;
import promotionSystem.razas.castas.orco.GuerreroOrco;
import promotionSystem.razas.castas.pokemon.PokemonTipoFuego;
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
    
    public static AlianzaDeOrcos crearAlianzaDeOrcos(int cantidadDePersonajes){
        List<Personaje> personajes = new ArrayList<Personaje>();
        for(int i= 0; i < cantidadDePersonajes; i++){
            personajes.add(new GuerreroOrco());
        }
        return new AlianzaDeOrcos(personajes);
    }
}
