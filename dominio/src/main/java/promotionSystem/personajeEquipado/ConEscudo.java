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
	public void setArma(String arma) {
		super.setArma(arma);
	}
	
	@Override
	public void setArmaDelInventario(String arma) {
		super.setArmaDelInventario(arma);
	}
	
	@Override
	public String getArma() {
		return super.getArma();
	}
	
	@Override
	public String getArmaDelInventario() {
		return super.getArmaDelInventario();
	}
	
	@Override
	public void setBotas(String botas) {
		super.setBotas(botas);
	}
	
	@Override
	public void setBotasDelInventario(String botas) {
		super.setBotasDelInventario(botas);
	}
	
	@Override
	public String getBotas() {
		return super.getBotas();
	}
	
	@Override
	public String getBotasDelInventario() {
		return super.getBotasDelInventario();
	}
	
	@Override
	public void setCasco(String casco) {
		super.setCasco(casco);
	}
	
	@Override
	public void setCascoDelInventario(String casco) {
		super.setCascoDelInventario(casco);
	}
	
	@Override
	public String getCasco() {
		return super.getCasco();
	}
	
	@Override
	public String getCascoDelInventario() {
		return super.getCascoDelInventario();
	}
	
	@Override
	public void setChaleco(String chaleco) {
		super.setChaleco(chaleco);
	}
	
	@Override
	public void setChalecoDelInventario(String chaleco) {
		super.setChalecoDelInventario(chaleco);
	}
	
	@Override
	public String getChaleco() {
		return super.getChaleco();
	}
	
	@Override
	public String getChalecoDelInventario() {
		return super.getChalecoDelInventario();
	}
	
	@Override
	public void setEscudo(String escudo) {
		super.setEscudo(escudo);
	}
	
	@Override
	public void setEscudoDelInventario(String escudo) {
		super.setEscudoDelInventario(escudo);
	}
	
	@Override
	public String getEscudo() {
		return super.getEscudo();
	}
	
	@Override
	public String getEscudoDelInventario() {
		return super.getEscudoDelInventario();
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
