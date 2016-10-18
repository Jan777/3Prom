package promotionSystem.builder;

public class ItemBuilder {
	private float multiplicadorDeAtaque;
	private int sumadorDeAtaque;
	private float multiplicadorDeDefensa;
	private int sumadorDeDefensa;
	private float multiplicadorDeMagia;
	private int sumadorDeMagia;
	
	public void ConItemGenerico(){
		multiplicadorDeAtaque = 1;
		sumadorDeAtaque = 0;
		multiplicadorDeDefensa = 1;
		sumadorDeDefensa = 0;
		multiplicadorDeMagia = 1;
		sumadorDeMagia = 0;
	}
	
	public void ConEspadaGorgoroth(){
		multiplicadorDeAtaque = (float) 0.4;
		sumadorDeMagia = 20;
	}
}
