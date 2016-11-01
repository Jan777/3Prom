package promotionSystem.items;

import promotionSystem.Item;
import promotionSystem.Personaje;
import promotionSystem.PersonajeEquipado;
import promotionSystem.personajeEquipado.ConBotas;

public class ConBotasFlober extends PersonajeEquipado{

    @Override
    public Personaje equipar(Personaje braixen) throws ClassNotFoundException {
        final double MultiplicadorDeAtaque = 1;
        final int SumadorDeAtaque = 0;
        final double MultiplicadorDeDefensa = 1;
        final int SumadorDeDefensa = -10;
        final double MultiplicadorDeMagia = 1;
        final int SumadorDeMagia = 5;
        final double MultiplicadorDeVelocidad = 2;
        final int SumadorDeVelocidad = 15;
        if(braixen.puedeEquiparBotas()){
            braixen = new ConBotas(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
            braixen.setBotas("ConBotasFlober");
            return braixen;
        }
        else{
            braixen.agregarAInventario(new Item("ConBotasFlober"));
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
