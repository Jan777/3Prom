package promotionSystem.personajeEquipado;

import promotionSystem.Personaje;
import promotionSystem.PersonajeEquipado;

public class ConEscudo extends PersonajeEquipado {
	
	public ConEscudo(Personaje personajeDecorado, double MultiplicadorDeAtaque, int sumadorDeAtaque, double MultiplicadorDeDefensa, int sumadorDeDefensa, double MultiplicadorDeMagia, int sumadorDeMagia, double MultiplicadorDeVelocidad, int sumadorDeVelocidad){
		super(personajeDecorado, MultiplicadorDeAtaque, sumadorDeAtaque, MultiplicadorDeDefensa, sumadorDeDefensa, MultiplicadorDeMagia, sumadorDeMagia, MultiplicadorDeVelocidad, sumadorDeVelocidad);
	}
	
	@Override
	public void atacarConMagia(Personaje atacado, String conjuro){
		super.atacarConMagia(atacado, conjuro);
	}
	

	@Override
	public int obtenerPuntosDeAtaque() {
		return (int) ((super.obtenerPuntosDeAtaque()+getSumadorDeAtaque())*getMultiplicadorDeAtaque());
	}
	
	@Override
	public int obtenerPuntosDeDefensa() {
		return (int) ((super.obtenerPuntosDeDefensa()+getSumadorDeDefensa())*getMultiplicadorDeDefensa());
	}
	
	@Override
	public int obtenerPuntosDeMagia() {
		return (int) ((super.obtenerPuntosDeMagia()+getSumadorDeMagia())*getMultiplicadorDeMagia());
	}
	
	@Override
	public int obtenerPuntosDeVelocidad() {
		return (int) ((super.obtenerPuntosDeVelocidad()+getSumadorDeVelocidad())*getMultiplicadorDeVelocidad());
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
