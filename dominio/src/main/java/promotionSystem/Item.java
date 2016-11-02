package promotionSystem;

public abstract class Item {
    private String nombreItem;
    protected String tipoDeItem;
    protected int sumadorDeAtaque = 0;
    protected int sumadorDeDefensa = 0;
    protected int sumadorDeMagia = 0;
    protected int sumadorDeVelocidad = 0;

    public Item(String nombreItem, String tipoDeItem){
        this.nombreItem = nombreItem;
        this.tipoDeItem = tipoDeItem;
    }

    public String getNombreItem() {
        return nombreItem;
    }

    public String getTipoDeItem() {
        return tipoDeItem;
    }

    public int getSumadorDeAtaque() {
        return sumadorDeAtaque;
    }

    public int getSumadorDeDefensa() {
        return sumadorDeDefensa;
    }


    public int getSumadorDeMagia() {
        return sumadorDeMagia;
    }


    public int getSumadorDeVelocidad() {
        return sumadorDeVelocidad;
    }

    public boolean equals(Item item) {
        return this.nombreItem.equals(item.nombreItem);
    }
}
