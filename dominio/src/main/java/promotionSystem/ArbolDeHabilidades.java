package promotionSystem;

import promotionSystem.habilidades.Habilidad;

import java.util.ArrayList;
import java.util.List;

import static promotionSystem.builder.ArbolDeHabilidadesBuilder.crearHabilidades;

public class ArbolDeHabilidades extends ArrayList{
     public static final int PUNTOS_DE_HABILIDAD_MAXIMOS = 100;
    private static List<Habilidad> habilidades = crearHabilidades();

    public Boolean subirHabilidad(Habilidad habilidad) {
        return habilidad.subirNivel();
    }

    public Habilidad buscarHabilidad(String habilidad){
        for(Habilidad habilidadBuscada : habilidades){
            if(habilidadBuscada.getNombreHabilidad().equals(habilidad)){
                return habilidadBuscada;
            }
        }
        return null;
    }

    public List<String> listaDeHabilidades(){
        List<String> listaDeHabilidades = new ArrayList<String>();
        for(Habilidad habilidad : habilidades){
            listaDeHabilidades.add(habilidad.getNombreHabilidad());
        }
        return listaDeHabilidades;
    }

}
