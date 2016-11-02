package promotionSystem;

public abstract class Item {
    private String nombreItem;
    protected String tipoDeItem;
    protected double multiplicadorDeAtaque = 1;
    protected int sumadorDeAtaque = 0;
    protected double multiplicadorDeDefensa = 1;
    protected int sumadorDeDefensa = 0;
    protected double multiplicadorDeMagia = 1;
    protected int sumadorDeMagia = 0;
    protected double multiplicadorDeVelocidad = 1;
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

    public double getMultiplicadorDeAtaque() {
        return multiplicadorDeAtaque;
    }

    public int getSumadorDeAtaque() {
        return sumadorDeAtaque;
    }

    public double getMultiplicadorDeDefensa() {
        return multiplicadorDeDefensa;
    }

    public int getSumadorDeDefensa() {
        return sumadorDeDefensa;
    }

    public double getMultiplicadorDeMagia() {
        return multiplicadorDeMagia;
    }

    public int getSumadorDeMagia() {
        return sumadorDeMagia;
    }

    public double getMultiplicadorDeVelocidad() {
        return multiplicadorDeVelocidad;
    }

    public int getSumadorDeVelocidad() {
        return sumadorDeVelocidad;
    }

    public boolean equals(Item item) {
        return this.nombreItem.equals(item.nombreItem);
    }
}
