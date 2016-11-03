package promotionSystem.builder;

import promotionSystem.Alianza;
import promotionSystem.Personaje;
import promotionSystem.alianzas.AlianzaDeHumanos;
import promotionSystem.alianzas.AlianzaDeOrcos;
import promotionSystem.razas.castas.humano.GuerreroHumano;
import promotionSystem.razas.castas.orco.GuerreroOrco;

import java.util.ArrayList;
import java.util.List;

import static promotionSystem.Constantes.INICIO_MAPA;

public class AlianzaBuilder {

    public static Alianza crearAlianza(int cantidadDePersonajes){
        List<Personaje> personajes = new ArrayList<>();
        for(int i= 0; i < cantidadDePersonajes; i++){
            personajes.add(new GuerreroHumano(INICIO_MAPA));
        }
        return new Alianza(personajes);
    }

    public static Alianza crearAlianzaCon(Personaje personaje) {
        List<Personaje> personajes = new ArrayList<>();
        personajes.add(personaje);
        personaje.setAlianza(new Alianza(personajes));
        return personaje.getAlianza();
    }

    public static AlianzaDeHumanos crearAlianzaDeHumanos(int cantidadDePersonajes){
        List<Personaje> personajes = new ArrayList<>();
        for(int i= 0; i < cantidadDePersonajes; i++){
            personajes.add(new GuerreroHumano(INICIO_MAPA));
        }
        return new AlianzaDeHumanos(personajes);
    }
    
    public static AlianzaDeOrcos crearAlianzaDeOrcos(int cantidadDePersonajes){
        List<Personaje> personajes = new ArrayList<>();
        for(int i= 0; i < cantidadDePersonajes; i++){
            personajes.add(new GuerreroOrco(INICIO_MAPA));
        }
        return new AlianzaDeOrcos(personajes);
    }

    public static AlianzaDeHumanos crearAlianzaDeHumanosConEnemigos(int cantidadDePersonajes, Alianza alianzaEnemiga){
        List<Personaje> personajes = new ArrayList<>();
        for(int i= 0; i < cantidadDePersonajes; i++){
            personajes.add(new GuerreroHumano(INICIO_MAPA));
        }
        return new AlianzaDeHumanos(personajes, alianzaEnemiga);
    }

    public static AlianzaDeOrcos crearAlianzaDeOrcosConEnemigos(int cantidadDePersonajes, Alianza alianzaEnemiga){
        List<Personaje> personajes = new ArrayList<>();
        for(int i= 0; i < cantidadDePersonajes; i++){
            personajes.add(new GuerreroOrco(INICIO_MAPA));
        }
        return new AlianzaDeOrcos(personajes, alianzaEnemiga);
    }
}
