package promotionSystem.personajeEquipado;

import promotionSystem.Item;
import promotionSystem.Personaje;
import promotionSystem.PersonajeEquipado;

public class ConBotas extends PersonajeEquipado{

private Item arma;
	
	public ConBotas(Personaje personajeDecorado){
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeVelocidad() {
		return super.obtenerPuntosDeVelocidad() * 2;
	}
}
