package promotionSystem.items;

import promotionSystem.Item;
import promotionSystem.Personaje;
import promotionSystem.PersonajeEquipado;
import promotionSystem.personajeEquipado.ConChaleco;

public class ConChalecoKevlar extends PersonajeEquipado{

    @Override
    public Personaje equipar(Personaje braixen) throws ClassNotFoundException {
        final double MultiplicadorDeAtaque = 1;
        final int SumadorDeAtaque = 10;
        final double MultiplicadorDeDefensa = 3;
        final int SumadorDeDefensa = 0;
        final double MultiplicadorDeMagia = 1;
        final int SumadorDeMagia = 0;
        final double MultiplicadorDeVelocidad = 1;
        final int SumadorDeVelocidad = -10;
        if(braixen.puedeEquiparChaleco()){
            braixen = new ConChaleco(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
            braixen.setChaleco("ConChalecoKevlar");
            return braixen;
        }
        else{
            braixen.agregarAInventario(new Item("ConChalecoKevlar"));
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
