package promotionSystem.personajeEquipado;

import promotionSystem.Item;
import promotionSystem.Personaje;
import promotionSystem.PersonajeEquipado;

public class ConArma extends PersonajeEquipado {
	private Item arma;
	
	public ConArma(Personaje personajeDecorado){
		super(personajeDecorado);
	}
	
	@Override
	public int obtenerPuntosDeAtaque() {
		return super.obtenerPuntosDeAtaque() * 2;
	}

	@Override
	public void despuesDeAtacar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void subirStatsCadaVezQueSeSubeNivel() {
		// TODO Auto-generated method stub
		
	}
}
