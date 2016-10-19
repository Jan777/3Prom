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

	@Override
	public void despuesDeAtacar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subirStats(int nivel) {
		// TODO Auto-generated method stub
		
	}
}
