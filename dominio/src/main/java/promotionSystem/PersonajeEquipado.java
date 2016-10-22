package promotionSystem;

import promotionSystem.personajeEquipado.ConArma;
import promotionSystem.personajeEquipado.ConBotas;
import promotionSystem.personajeEquipado.ConCasco;
import promotionSystem.personajeEquipado.ConChaleco;
import promotionSystem.personajeEquipado.ConEscudo;

public abstract class PersonajeEquipado extends Personaje {
	//personaje
	private Personaje personajeDecorado;
	//modificadoresDeStatsDeItems
	private double multiplicadorDeAtaque;
	private int sumadorDeAtaque;
	private double multiplicadorDeDefensa;
	private int sumadorDeDefensa;
	private double multiplicadorDeMagia;
	private int sumadorDeMagia;
	private double multiplicadorDeVelocidad;
	private int sumadorDeVelocidad;
	
	public PersonajeEquipado(Personaje personajeDecorado, double multiplicadorDeAtaque, int sumadorDeAtaque, double multiplicadorDeDefensa, int sumadorDeDefensa, double multiplicadorDeMagia, int sumadorDeMagia, double multiplicadorDeVelocidad, int sumadorDeVelocidad) {
		this.personajeDecorado = personajeDecorado;
		this.multiplicadorDeAtaque = multiplicadorDeAtaque;
		this.multiplicadorDeDefensa = multiplicadorDeDefensa;
		this.multiplicadorDeMagia = multiplicadorDeMagia;
		this.multiplicadorDeVelocidad = multiplicadorDeVelocidad;
		this.sumadorDeAtaque = sumadorDeAtaque;
		this.sumadorDeDefensa = sumadorDeDefensa;
		this.sumadorDeMagia = sumadorDeMagia;
		this.sumadorDeVelocidad = sumadorDeVelocidad;
	}

	@Override
	public int obtenerPuntosDeAtaque() {
		return this.personajeDecorado.obtenerPuntosDeAtaque();
	}
	
	@Override
	protected int calcularPuntosDeAtaque() {
		return this.personajeDecorado.calcularPuntosDeAtaque();
	}

	@Override
	public int obtenerPuntosDeDefensa() {
		return this.personajeDecorado.obtenerPuntosDeDefensa();
	}
	
	@Override
	public int obtenerPuntosDeVelocidad() {
		return this.personajeDecorado.obtenerPuntosDeVelocidad();
	}
	
	@Override
	public int obtenerPuntosDeMagia() {
		return this.personajeDecorado.obtenerPuntosDeMagia();
	}

	public Personaje getPersonajeDecorado() {
		return personajeDecorado;
	}

	public void setPersonajeDecorado(Personaje personajeDecorado) {
		this.personajeDecorado = personajeDecorado;
	}

	public double getMultiplicadorDeAtaque() {
		return multiplicadorDeAtaque;
	}

	public void setMultiplicadorDeAtaque(double multiplicadorDeAtaque) {
		this.multiplicadorDeAtaque = multiplicadorDeAtaque;
	}

	public int getSumadorDeAtaque() {
		return sumadorDeAtaque;
	}

	public void setSumadorDeAtaque(int sumadorDeAtaque) {
		this.sumadorDeAtaque = sumadorDeAtaque;
	}

	public double getMultiplicadorDeDefensa() {
		return multiplicadorDeDefensa;
	}

	public void setMultiplicadorDeDefensa(double multiplicadorDeDefensa) {
		this.multiplicadorDeDefensa = multiplicadorDeDefensa;
	}

	public int getSumadorDeDefensa() {
		return sumadorDeDefensa;
	}

	public void setSumadorDeDefensa(int sumadorDeDefensa) {
		this.sumadorDeDefensa = sumadorDeDefensa;
	}

	public double getMultiplicadorDeMagia() {
		return multiplicadorDeMagia;
	}

	public void setMultiplicadorDeMagia(double multiplicadorDeMagia) {
		this.multiplicadorDeMagia = multiplicadorDeMagia;
	}

	public int getSumadorDeMagia() {
		return sumadorDeMagia;
	}

	public void setSumadorDeMagia(int sumadorDeMagia) {
		this.sumadorDeMagia = sumadorDeMagia;
	}

	public double getMultiplicadorDeVelocidad() {
		return multiplicadorDeVelocidad;
	}

	public void setMultiplicadorDeVelocidad(double multiplicadorDeVelocidad) {
		this.multiplicadorDeVelocidad = multiplicadorDeVelocidad;
	}

	public int getSumadorDeVelocidad() {
		return sumadorDeVelocidad;
	}

	public void setSumadorDeVelocidad(int sumadorDeVelocidad) {
		this.sumadorDeVelocidad = sumadorDeVelocidad;
	}
}
