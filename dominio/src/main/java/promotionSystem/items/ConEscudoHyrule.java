package promotionSystem.items;

import promotionSystem.Item;
import promotionSystem.Personaje;
import promotionSystem.PersonajeEquipado;
import promotionSystem.personajeEquipado.ConEscudo;

public class ConEscudoHyrule extends PersonajeEquipado{

    @Override
    public Personaje equipar(Personaje braixen) throws ClassNotFoundException {
        final double MultiplicadorDeAtaque = 1;
        final int SumadorDeAtaque = 0;
        final double MultiplicadorDeDefensa = 2;
        final int SumadorDeDefensa = 10;
        final double MultiplicadorDeMagia = 1;
        final int SumadorDeMagia = 0;
        final double MultiplicadorDeVelocidad = 0.5;
        final int SumadorDeVelocidad = 0;
        if(braixen.puedeEquiparEscudo()){
            braixen = new ConEscudo(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
            braixen.setEscudo("ConEscudoHyrule");
            return braixen;
        }
        else{
            braixen.agregarAInventario(new Item("ConEscudoHyrule"));
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
