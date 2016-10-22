package promotionSystem.personajeEquipado;

import promotionSystem.Item;
import promotionSystem.Personaje;
import promotionSystem.PersonajeEquipado;

public class ConArma extends PersonajeEquipado {
	//private Item arma;
	
	public ConArma(Personaje personajeDecorado, double multiplicadorDeAtaque, int sumadorDeAtaque, double multiplicadorDeDefensa, int sumadorDeDefensa, double multiplicadorDeMagia, int sumadorDeMagia, double multiplicadorDeVelocidad, int sumadorDeVelocidad){
		super(personajeDecorado, multiplicadorDeAtaque, sumadorDeAtaque, multiplicadorDeDefensa, sumadorDeDefensa, multiplicadorDeMagia, sumadorDeMagia, multiplicadorDeVelocidad, sumadorDeVelocidad);
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
