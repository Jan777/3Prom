package promotionSystem.items;

import promotionSystem.Item;
import promotionSystem.Personaje;
import promotionSystem.PersonajeEquipado;
import promotionSystem.personajeEquipado.ConCasco;

public class ConCascoAdamantium extends PersonajeEquipado{

    @Override
    public Personaje equipar(Personaje braixen) throws ClassNotFoundException {
        final double MultiplicadorDeAtaque = 1;
        final int SumadorDeAtaque = 10;
        final double MultiplicadorDeDefensa = 3;
        final int SumadorDeDefensa = 0;
        final double MultiplicadorDeMagia = 1;
        final int SumadorDeMagia = 0;
        final double MultiplicadorDeVelocidad = 1;
        final int SumadorDeVelocidad = 0;
        if(braixen.puedeEquiparCasco()){
            braixen = new ConCasco(braixen,MultiplicadorDeAtaque,SumadorDeAtaque,MultiplicadorDeDefensa,SumadorDeDefensa,MultiplicadorDeMagia,SumadorDeMagia,MultiplicadorDeVelocidad,SumadorDeVelocidad);
            braixen.setCasco("ConCascoAdamantium");
            return braixen;
        }
        else{
            braixen.agregarAInventario(new Item("ConCascoAdamantium"));
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
