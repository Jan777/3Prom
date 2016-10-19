package promotionSystem;

import promotionSystem.administradores.AdministradorDeAlianzas;

import java.util.ArrayList;
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
	protected int velocidad;
	protected Punto posicion;
	
	
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
	
	public int obtenerPuntosDeVelocidad(){
		return calcularPuntosDeVelocidad();
	}
	
	private int calcularPuntosDeVelocidad() {
		return velocidad;
	}

	private int calcularPuntosDeMagia() {
		return magia;
	}

	public int getExperiencia() {
		return experiencia;
	}

	public final void  subirExperiencia(int experiencia) {
		this.experiencia+=experiencia;
		int nivelesSubidos = 0;
        while(this.experiencia > experienciaPorNivel()){
            this.experiencia -= experienciaPorNivel();
            subirNivel();
			nivelesSubidos++;
        }
        subirStats(nivelesSubidos);
    }

	public int getNivel() {
		return nivel;
	}

	public void subirNivel() {
        nivel++;
	}

	private int experienciaPorNivel() {
		return (int) Math.pow(nivel, 2);
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

	public void aceptarAlianza(Personaje invitador) {
		AdministradorDeAlianzas administrador = AdministradorDeAlianzas.getInstance();
		if(invitador.tieneAlianza()){
			if(tieneAlianza()){			
				administrador.juntarAlianzas(invitador.idAlianza,this.idAlianza);
			}
			else{
				administrador.agregarPersonajeAAlianza(invitador.idAlianza, this);
			}
		}
		else{
				List<Personaje> personajes=new ArrayList<Personaje>();
				personajes.add(invitador);
				personajes.add(this);
				Alianza alianzaNueva=new Alianza(personajes);
				administrador.agregarAlianza(alianzaNueva);
			}
	}
	

	private boolean tieneAlianza() {
		return idAlianza!=-1;
	}
	
	public void invitarAAlianza(Personaje invitado){
		invitado.tratarAlianza(this);
	}

	//FIXME arreglar segun decision del jugador
	private void tratarAlianza(Personaje invitador) {
		aceptarAlianza(invitador);
		//rechazarAlianza(invitador);
	}

	private void rechazarAlianza(Personaje invitador) {
		desafiar(invitador);
	}


	public void desafiar(Personaje desafiado) {
		AdministradorDeAlianzas administrador = AdministradorDeAlianzas.getInstance();
		administrador.informarBatalla(this,desafiado);
	}
	
	
	public abstract void subirStats(int nivel);
	
	public void mover(Punto posicionNueva){
		posicion=posicionNueva;
	}

	public Punto getPosicion() {
		return posicion;
	}
}
	
