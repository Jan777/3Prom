package promotionSystem;



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
	protected Alianza alianza;
	protected int velocidad;
	protected Punto posicion;
	protected Circulo radioDeAcccion;
	private boolean enBatalla=false;
	protected int saludMaxima;
	protected int energiaMaxima;
	
	
	public final void atacar(Personaje atacado) {
		if(puedeAtacar()){
			int puntosARestar=calcularPuntosDeAtaque()-atacado.calcularPuntosDeDefensa();
			atacado.serAtacado(puntosARestar<0?0:puntosARestar);
			energia-=calcularPuntosDeAtaque();
			despuesDeAtacar();
		}		
	}
	
	public final void atacarConMagia(Personaje atacado) {
		if(puedeAtacarConMagia()){
			int puntosARestar=calcularPuntosDeMagia()-atacado.calcularPuntosDeDefensa();
			atacado.serAtacado(puntosARestar<0?0:puntosARestar);
			energia-=calcularPuntosDeMagia();
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
	
	private boolean puedeAtacarConMagia() {
		return energia>=magia;
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
		salud=saludMaxima;
		
	}

	public void serEnergizado() {
		energia=energiaMaxima;
		
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
	public void setAlianza(Alianza alianza) {
		this.alianza=alianza;
	}

	public void abandonarAlianza() {
		alianza.sacarPersonaje(this);
		alianza=null;		
	}

	public Alianza getAlianza() {
		return alianza;
	}

	public void aceptarAlianza(Personaje invitador) {
			
		if(invitador.tieneAlianza() && this.tieneAlianza()){
			invitador.alianza.agregarPersonajes(this.alianza.getPersonajes());	
			
		}
		else if(invitador.tieneAlianza()){
			invitador.alianza.agregarPersonajes(this);
		}
		else if(tieneAlianza()){
			alianza.agregarPersonajes(invitador);
		}
		else{
			List<Personaje> personajes=new ArrayList<Personaje>();
			personajes.add(invitador);
			personajes.add(this);
			this.alianza=new Alianza(personajes);
			invitador.alianza=alianza;
			
		}
		
	}
	

	private boolean tieneAlianza() {
		return alianza!=null;
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
		alianza.atacar(desafiado.alianza);
	}
	
	
	public abstract void subirStats(int nivel);
	
	public void mover(Punto posicionNueva){
		posicion=posicionNueva;
		radioDeAcccion.setCentro(posicion);
	}

	public Punto getPosicion() {
		return posicion;
	}
	
	public final List<Personaje> invocarAliados(){
		int i=0;
		List<Personaje> aliadosEnBatalla = new ArrayList<>();
		aliadosEnBatalla.add(this);
		if(tieneAlianza()){
			List<Personaje> aliadosTotales=this.alianza.getPersonajes();
			while(aliadosEnBatalla.size()<5 && i<aliadosTotales.size()){
				Personaje personaje = aliadosTotales.get(i);
				if(personaje.estaEnElRadio(this.radioDeAcccion)&&!personaje.enBatalla&&personaje!=this){
					aliadosEnBatalla.add(personaje);
				}
				i++;
			}
		}
		return aliadosEnBatalla;
	}

	private boolean estaEnElRadio(Circulo radioDeAcccion) {
			return radioDeAcccion.incluye(this.posicion);
	}
}
	
