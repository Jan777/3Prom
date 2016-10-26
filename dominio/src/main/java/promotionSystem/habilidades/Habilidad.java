package promotionSystem.habilidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Habilidad {
    private String nombreHabilidad;
    private int ataqueAumentado;
    private int magiaAumentada;
    private int defensaAumentada;
    protected int nivel;

    public Habilidad(String nombreHabilidad, int ataqueAumentado, int magiaAumentada, int defensaAumentada, int nivel) {
        this.nombreHabilidad = nombreHabilidad;
        this.ataqueAumentado = ataqueAumentado;
        this.magiaAumentada = magiaAumentada;
        this.defensaAumentada = defensaAumentada;
        this.nivel = nivel;
    }

    public Boolean subirNivel(){
        if(puedeSubirNivel()){
            nivel++;
            return true;
        }
        return false;
    }

    public abstract boolean puedeSubirNivel();

    public List<Integer> statsASubir(){
        List<Integer> statsASubir = new ArrayList<>();
        statsASubir.add(ataqueAumentado);
        statsASubir.add(magiaAumentada);
        statsASubir.add(defensaAumentada);
        return statsASubir;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public int getNivel() {
        return nivel;
    }
}
