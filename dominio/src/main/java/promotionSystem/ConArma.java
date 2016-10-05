package promotionSystem;

public class ConArma extends PersonajeEquipado{
	private Item arma;
	
	public ConArma(Personaje personajeDecorado){
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() * 2;
	}
}
