package promotionSystem.personajeEquipado;

import promotionSystem.Personaje;
import promotionSystem.PersonajeEquipado;

public class ConEscudo extends PersonajeEquipado {
	
	public ConEscudo(Personaje personajeDecorado, double MultiplicadorDeAtaque, int sumadorDeAtaque, double MultiplicadorDeDefensa, int sumadorDeDefensa, double MultiplicadorDeMagia, int sumadorDeMagia, double MultiplicadorDeVelocidad, int sumadorDeVelocidad){
		super(personajeDecorado, MultiplicadorDeAtaque, sumadorDeAtaque, MultiplicadorDeDefensa, sumadorDeDefensa, MultiplicadorDeMagia, sumadorDeMagia, MultiplicadorDeVelocidad, sumadorDeVelocidad);
	}
	
	@Override
	public void setArma(String arma) {
		super.setArma(arma);
	}
	
	@Override
	public String getArma() {
		return super.getArma();
	}
	
	@Override
	public void setBotas(String botas) {
		super.setBotas(botas);
	}
	
	@Override
	public String getBotas() {
		return super.getBotas();
	}
	
	@Override
	public void setCasco(String casco) {
		super.setCasco(casco);
	}
	
	@Override
	public String getCasco() {
		return super.getCasco();
	}
	
	@Override
	public void setChaleco(String chaleco) {
		super.setChaleco(chaleco);
	}
	
	@Override
	public String getChaleco() {
		return super.getChaleco();
	}
	
	@Override
	public void setEscudo(String escudo) {
		super.setEscudo(escudo);
	}
	
	@Override
	public String getEscudo() {
		return super.getEscudo();
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
