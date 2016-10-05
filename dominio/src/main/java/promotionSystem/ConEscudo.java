package promotionSystem;

public class ConEscudo extends PersonajeEquipado{
	private Item arma;
	
	public ConEscudo(Personaje personajeDecorado){
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa() + 2;
	}
}
