package promotionSystem;

import promotionSystem.administradores.AdministradorDeAlianzas;
import promotionSystem.administradores.AdministradorDeExperiencia;
import java.util.List;


public abstract class Personaje {
	protected int salud;
	protected int energia;
	protected int ataque;
	protected int defensa;
	protected int magia;
	protected int experiencia;
	protected int nivel;
	protected List<Item> items;
	protected int idAlianza;
	
	
	public final void atacar(Personaje atacado) {
		if(puedeAtacar()){
			int puntosARestar=calcularPuntosDeAtaque()-atacado.calcularPuntosDeDefensa();
			atacado.serAtacado(puntosARestar<0?0:puntosARestar);
			energia-=calcularPuntosDeAtaque();
			despuesDeAtacar();
		}		
	}

	public abstract void despuesDeAtacar();

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

	public final boolean estaVivo() {
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
	/*Martin: velocidad es un stat?
	public int obtenerPuntosDeVelocidad(){
		return calcularPuntosDeVelocidad();
	}
	
	private int calcularPuntosDeVelocidad() {
		return velocidad;
	}
*/
	private int calcularPuntosDeMagia() {
		return magia;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public final void  subirExperiencia(int experiencia) {
		this.experiencia+=experiencia;
	}

	public int getNivel() {
		return nivel;
	}

	public void subirNivel() {
		nivel= AdministradorDeExperiencia.calcularNivel(this.experiencia);
		
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

	
	//FIXME cambiar esto cuando se defina el tema de como el personajeEquipado conoce la alianza.
	public void setAlianza(int alianza) {
		this.idAlianza=alianza;
	}

	public void abandonarAlianza() {
		AdministradorDeAlianzas administrador = AdministradorDeAlianzas.getInstance();
		administrador.sacarPersonajeDeAlianza(idAlianza, this);
		this.idAlianza=-1;		
	}

	public int getAlianza() {
		return idAlianza;
	}

	public void aceptarAlianza(int alianza) {
		AdministradorDeAlianzas administrador = AdministradorDeAlianzas.getInstance();
		if(tieneAlianza()){			
			administrador.juntarAlianzas(alianza,this.idAlianza);
		}
		else{
			administrador.agregarPersonajeAAlianza(alianza, this);
		}
		idAlianza=alianza;
	}

	private boolean tieneAlianza() {
		return idAlianza!=-1;
	}
}
	
