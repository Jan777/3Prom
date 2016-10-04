package promotionSystem;

public class Personaje {
	private int salud;
	private int energia;
	private int ataque;
	
	public Personaje(){
		energia=100;
		salud=100;
		ataque=10;
	}

	public void atacar(Personaje atacado) {
		if(puedeAtacar()){
			atacado.serAtacado(ataque);
			energia-=ataque;
		}
		
		
	}

	private void serAtacado(int ataque) {
		salud-=ataque;
		
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

	
}
