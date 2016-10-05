package promotionSystem;

import java.util.ArrayList;
import java.util.List;

public class Personaje {
	protected int salud;
	protected int energia;
	protected int ataque;
	protected int defensa;
	protected int magia;
	protected int experiencia;
	protected int nivel;
	protected List<Item> items;
	
	public Personaje(){
		energia=100;
		salud=100;
		ataque=10;
		defensa=2;
		magia=5;
		experiencia=0;
		nivel = 0;
		items = new ArrayList<>();
	}
	
	public final void atacar(Personaje atacado) {
		if(puedeAtacar()){
			int puntosARestar=calcularPuntosDeAtaque()-atacado.calcularPuntosDeDefensa();
			atacado.serAtacado(puntosARestar<0?0:puntosARestar);
			energia-=calcularPuntosDeAtaque();
			despuesDeAtacar();
		}		
	}

	public void despuesDeAtacar(){}

	private void serAtacado(int ataque) {
		salud-=ataque;
		if(salud<0){
			salud=0;
		}		
	}

	private boolean puedeAtacar() {
		return energia>=ataque;
	}

	public Personaje elegirVictima(Alianza alianzaEnemiga, int numeroDePersonaje) {
		return alianzaEnemiga.darVictima(numeroDePersonaje);
	}

	public int getSalud() {
		return salud;
	}

	public int getEnergia() {
		return energia;
	}

	public boolean estaVivo() {
		return salud>0;
	}

	public void serCurado() {
		salud=100;
		
	}

	public void serEnergizado() {
		energia=100;
		
	}

	public void setSalud(int salud) {
		this.salud=salud;
		
	}

	public void setEnergia(int energia) {
		this.energia=energia;
		
	}

	protected int calcularPuntosDeAtaque(){
		return ataque;		
	}
	
	protected int calcularPuntosDeDefensa(){
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa=defensa;
		
	}
	
	public int obtenerPuntosDeAtaque(){
		return calcularPuntosDeAtaque();
	}
	
	public int obtenerPuntosDeDefensa(){
		return calcularPuntosDeDefensa();
	}
	
	public int obtenerPuntosDeMagia(){
		return calcularPuntosDeMagia();
	}

	private int calcularPuntosDeMagia() {
		return magia;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public void subirExperiencia(int experiencia) {
		this.experiencia+=experiencia;
	}

	public int getNivel() {
		return nivel;
	}

	public void subirNivel() {
		nivel=RepartidorDeExperiencia.calcularNivel(this.experiencia);
		
	}

	public Item entregarItem() {
			return items.remove(0);			
	}

	public boolean puedeDarItem() {
		return items.size()!=0;
	}

	public void recibirItem(Item item) {
		items.add(item);
	}
}
	
