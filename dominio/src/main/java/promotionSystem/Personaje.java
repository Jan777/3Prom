package promotionSystem;

public class Personaje {
	protected int salud;
	protected int energia;
	protected int ataque;
	protected int defensa;
	
	public Personaje(){
		energia=100;
		salud=100;
		ataque=10;
		defensa=2;
	}
	
	public final void atacar(Personaje atacado) {
		if(puedeAtacar()){
			int puntosARestar=calcularPuntosDeAtaque()-atacado.calcularPuntosDeDefensa();
			atacado.serAtacado(puntosARestar<0?0:puntosARestar);
			energia-=calcularPuntosDeAtaque();
			despuesDeAtacar();
		}		
	}

	private void despuesDeAtacar(){
		
	}
		
		

	private void serAtacado(int ataque) {
		salud-=ataque;
		if(salud<0){
			salud=0;
		}		
	}

	private boolean puedeAtacar() {
		return energia>=ataque;
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

	private int calcularPuntosDeAtaque(){
		return ataque;		
	}
	
	private int calcularPuntosDeDefensa(){
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa=defensa;
		
	}
	
	
}
