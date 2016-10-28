 package promotionSystem.habilidades;

import java.util.ArrayList;
import java.util.List;

public abstract class Habilidad {
    private String nombreHabilidad;
    private int AtaqueAumentado;
    private int MagiaAumentada;
    private int DefensaAumentada;
    protected int nivel;

    public Habilidad(String nombreHabilidad, int AtaqueAumentado, int MagiaAumentada, int DefensaAumentada, int nivel) {
        this.nombreHabilidad = nombreHabilidad;
        this.AtaqueAumentado = AtaqueAumentado;
        this.MagiaAumentada = MagiaAumentada;
        this.DefensaAumentada = DefensaAumentada;
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
        List<Integer> statsASubir = new ArrayList<Integer>();
        statsASubir.add(AtaqueAumentado);
        statsASubir.add(MagiaAumentada);
        statsASubir.add(DefensaAumentada);
        return statsASubir;
    }

    public String getNombreHabilidad() {
        return nombreHabilidad;
    }

    public int getNivel() {
        return nivel;
    }
}
