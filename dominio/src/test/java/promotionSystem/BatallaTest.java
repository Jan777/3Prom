package promotionSystem;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static promotionSystem.builder.AlianzaBuilder.crearAlianza;

public class BatallaTest {
    private Alianza alianza1;
    private Alianza alianza2;
    private Item item;
//FIXME ARREGLAR TEST COMENTADOS
    @Before
    public void setUp(){
        alianza1 = crearAlianza(2);
        alianza2 = crearAlianza(1);
//        item = new Item("ConEspadaGorgoroth", alianza1.getPersonajes().get(0));
    }

    @Test
    public void debeDefinirElGanadorEntreDosBatallones(){
        Batalla batalla = crearBatalla();
        Assert.assertEquals(alianza1, batalla.definirGanador());
    }

    @Test
    public void debeDefinirElPerdedorEntreDosBatallones(){
        Batalla batalla = crearBatalla();
        Assert.assertEquals(alianza2, batalla.definirPerdedor());
    }

    @Test
    public void siLaAlianzaPerdedoraTieneDosItemsYDosPersonajesDebeEntregarLosDosItems(){
        alianza1 = crearAlianza(3);
        alianza2 = crearAlianza(2);
        Batalla batalla = crearBatalla();
        //hacer comprobacion de que si tiene un arma ya equipada la guarde en el lugar del inventario
        //y si no hay lugar en el inventario que se joda.
        alianza2.getPersonajes().get(0).recibirItem(item);
        alianza2.getPersonajes().get(1).recibirItem(item);
        Assert.assertEquals(batalla.entregarPremio(), alianza1.getItems());
        Assert.assertEquals(2, alianza1.getItems().size());
    }

   @Test
    public void siLaAlianzaPerdedoraTiene2ItemsY1PersonajeDebeEntregarUnSoloItem(){
        Batalla batalla = crearBatalla();
        alianza2.getPersonajes().get(0).recibirItem(item);
        alianza2.getPersonajes().get(0).recibirItem(item);
        Assert.assertEquals(batalla.entregarPremio(), alianza1.getItems());
        Assert.assertEquals(1, alianza1.getItems().size());
    }

   @Test
   public void siLaAlianzaPerdedoraTieneUnPersonajeQueNoTieneItemsNoDebeEntregarItems(){
	   Batalla batalla = crearBatalla();
	   Assert.assertEquals(batalla.entregarPremio(),alianza1.getItems());
	   Assert.assertEquals(0,alianza1.getItems().size());
	   
   }

    private Batalla crearBatalla(){
        return new Batalla(alianza1, alianza2);
    }

    @Ignore
    @Test
    public void batalla(){
        Batalla batalla = crearBatalla();
        alianza1.entrarEnBatalla();
        alianza2.entrarEnBatalla();
        batalla.darTurno(alianza1);
        Personaje atacante =  alianza1.getPersonajeActivo();
        atacante.elegirVictima(alianza2, 0);
        atacante.atacar(alianza1.objetivo);
        if(alianza1.objetivo.estaVivo()){

        }
        Assert.assertEquals(alianza2, batalla.definirGanador());
    }

    //FIXME Codigo para ejecutar una batalla, se tiene que mover a los distintos elementos de JForm.
    public void asd(){

    }
}