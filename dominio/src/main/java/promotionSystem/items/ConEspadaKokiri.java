package promotionSystem.items;

import promotionSystem.Item;
import promotionSystem.Personaje;
import promotionSystem.PersonajeEquipado;
import promotionSystem.personajeEquipado.ConArma;

public class ConEspadaKokiri extends PersonajeEquipado{
    @Override
    public Personaje equipar(Personaje braixen) throws ClassNotFoundException {
        final double MultiplicadorDeAtaque = 2;
        final int SumadorDeAtaque = 0;
        final double MultiplicadorDeDefensa = 1;
        final int SumadorDeDefensa = 0;
        final double MultiplicadorDeMagia = 1;
        final int SumadorDeMagia = 10;
        final double MultiplicadorDeVelocidad = 1;
        final int SumadorDeVelocidad = 10;
        if(braixen.puedeEquiparArma()){
            braixen = new ConArma(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
            braixen.setArma("ConEspadaKokiri");
            return braixen;
        }
        else{
            braixen.agregarAInventario(new Item("ConEspadaKokiri"));
        }
        return braixen;
    }

    @Override
    public void despuesDeAtacar() {

    }

    @Override
    public void subirStats(int nivel) {

    }
}
