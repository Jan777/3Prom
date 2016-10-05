package promotionSystem.personajeEquipado;

import promotionSystem.Item;
import promotionSystem.Personaje;
import promotionSystem.PersonajeEquipado;

public class ConCasco extends PersonajeEquipado {
	
	private Item arma;
	
	public ConCasco(Personaje personajeDecorado){
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return super.obtenerPuntosDeDefensa() * 2;
	}
}
