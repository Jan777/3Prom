package promotionSystem.builder;

import promotionSystem.habilidades.AtaqueCertero;
import promotionSystem.habilidades.CuerpoFuerte;
import promotionSystem.habilidades.Habilidad;

import java.util.ArrayList;
import java.util.List;

public class ArbolDeHabilidadesBuilder {
    public static List<Habilidad> crearHabilidades(){
        List<Habilidad> habilidades = new ArrayList<>();
        habilidades.add(new AtaqueCertero());
        habilidades.add(new CuerpoFuerte());
        return habilidades;
    }
}
