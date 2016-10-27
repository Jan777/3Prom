package promotionSystem;

import promotionSystem.habilidades.AtaqueCertero;
import promotionSystem.habilidades.CuerpoFuerte;
import promotionSystem.habilidades.Habilidad;

import java.util.ArrayList;
import java.util.List;

public class ArbolDeHabilidadesBuilder {
    //TODO Podria cambiar String a Habilidad para mapear directamente la habilidad.
    public static List<Habilidad> crearHabilidades(){
        List<Habilidad> habilidades = new ArrayList<>();
        habilidades.add(new AtaqueCertero());
        habilidades.add(new CuerpoFuerte());
        return habilidades;
    }
}
