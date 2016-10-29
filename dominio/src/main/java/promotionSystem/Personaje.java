package promotionSystem;

import promotionSystem.habilidades.Habilidad;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.mapa.Mapa;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static java.util.Collections.sort;

public abstract class Personaje implements Comparable<Personaje>{
	protected int salud;
	protected int energia;
	protected int ataque;
	protected int defensa;
	protected int magia;
	protected int experiencia;
	protected int nivel;
    protected static ArbolDeHabilidades arbolDeHabilidades = new ArbolDeHabilidades();
	protected int puntosDeHabilidad;
	protected Alianza alianza;
	protected int velocidad;
	protected Mapa mapa;
	protected Punto posicion;
	protected Circulo radioDeAcccion;
	private boolean enBatalla = false;
	protected int saludMaxima;
	protected int energiaMaxima;
	protected Map<String, Hechizo> hechizos;
	private String arma;
	private String botas;
	private String casco;
	private String chaleco;
	private String escudo;
	private Inventario inventario = new Inventario();

	public final void atacar(Personaje atacado) {
		if (puedeAtacar()) {
			int puntosARestar = calcularPuntosDeAtaque() - atacado.calcularPuntosDeDefensa();
			atacado.serAtacado(puntosARestar < 0 ? 0 : puntosARestar);
			energia -= calcularPuntosDeAtaque();
			despuesDeAtacar();
		}
	}

	public void atacarConMagia(Personaje atacado, String conjuro) {
		if (puedeAtacarConMagia()) {
			int puntosARestar = calcularPuntosDeMagia() - atacado.calcularPuntosDeDefensa();
			hechizar(conjuro, atacado, puntosARestar);
			energia -= calcularPuntosDeMagia();
			despuesDeAtacar();
		}
	}

    public final void usarMagiaSupport(Personaje atacado, String conjuro) {
        if (puedeAtacarConMagia()) {
            int puntosAUsar = calcularPuntosDeMagia();
            hechizar(conjuro, atacado, puntosAUsar);
            energia -= puntosAUsar;
            despuesDeAtacar();
        }
    }

    public final void usarMagiaDeAlteracion(String conjuro) {
        usarMagiaSupport(this,conjuro);
    }

	public abstract void despuesDeAtacar();

	public void serAtacado(int Ataque) {
		salud -= Ataque;
		if (salud < 0) {
			salud = 0;
		}
	}

	public void serAumentadoLaFuerza(int valor) {
		ataque += valor;
	}

	public void serRalentizado(double valor) {
		velocidad /= valor;
		if (velocidad < 0) {
			velocidad = 0;
		}
	}
	
	public void serReducidoLaDefensa(int puntos) {
		defensa -= puntos;
		if (defensa < 0) {
			defensa= 0;
		}
	}
	
	public void serAumentadoLaDefensa(int puntos) {
		defensa += puntos;
		
	}

	private boolean puedeAtacar() {
		return energia >= ataque;
	}

	private boolean puedeAtacarConMagia() {
		return energia >= magia;
	}

	public void elegirVictima(Alianza alianzaEnemiga, int numeroDePersonaje) {
		alianza.setObjetivo(alianzaEnemiga.darVictima(numeroDePersonaje));
	}

    public int getAtaque() {
        return ataque;
    }

    public int getSalud() {
		return salud;
	}

	public int getEnergia() {
		return energia;
	}

	public final boolean estaVivo() {
		return salud > 0;
	}

	public void serCurado() {
		salud = saludMaxima;
	}

	public void serCuradoConMagia(int efecto) {
		if (saludMaxima - salud > efecto){
			salud += efecto;			
		}
		else {
			salud = saludMaxima;			
		}
	}

	public void serEnergizado() {
		energia = energiaMaxima;

	}

	public void setSalud(int salud) {
		this.salud = salud;

	}

	public void setEnergia(int energia) {
		this.energia = energia;

	}

	protected int calcularPuntosDeAtaque() {
		return ataque;
	}

	protected int calcularPuntosDeDefensa() {
		return defensa;
	}

	public void setDefensa(int Defensa) {
		this.defensa = Defensa;
	}

	public int obtenerPuntosDeAtaque() {
		return calcularPuntosDeAtaque();
	}

	public int obtenerPuntosDeDefensa() {
		return calcularPuntosDeDefensa();
	}

	public int obtenerPuntosDeMagia() {
		return calcularPuntosDeMagia();
	}

	public int obtenerPuntosDeVelocidad() {
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

    public int getNivel() {
        return nivel;
    }

	public int getPuntosDeHabilidad() {
		return puntosDeHabilidad;
	}

    public List<String> habilidades(){
        return arbolDeHabilidades.listaDeHabilidades();
    }

    public final void  subirExperiencia(int experiencia) {
		this.experiencia+=experiencia;
		int nivelesSubidos = 0;
		while (this.experiencia > experienciaPorNivel()) {
			this.experiencia -= experienciaPorNivel();
			subirNivel();
			nivelesSubidos++;
		}
		subirStats(nivelesSubidos);
	}

	public void subirNivel() {
        nivel++;
        puntosDeHabilidad++;
	}

	public void subirHabilidad(String habilidad){
        Habilidad habilidadASubir = arbolDeHabilidades.buscarHabilidad(habilidad);
        if(arbolDeHabilidades.subirHabilidad(habilidadASubir)){
            activarHabilidad(habilidadASubir);
        }
    }

    public void activarHabilidad(Habilidad habilidad){
        List<Integer> statsASubir = habilidad.statsASubir();
        ataque += statsASubir.get(0);
        magia += statsASubir.get(1);
        defensa += statsASubir.get(2);
	}

	private int experienciaPorNivel() {
		return (int) Math.pow(nivel, 2);
	}

	/*
	 * public Item entregarItem() { return items.remove(0); }
	 *
	 * public boolean puedeDarItem() { return items.size()!=0; }
	 *
	 * public void recibirItem(Item item) { items.add(item); }
	 */
	// FIXME cambiar esto cuando se defina el tema de como el personajeEquipado
	// conoce la alianza.
	public void setAlianza(Alianza alianza) {
		this.alianza = alianza;
	}

	public void abandonarAlianza() {
		alianza.sacarPersonaje(this);
		alianza = null;
	}

	public Alianza getAlianza() {
		return alianza;
	}

	public void aceptarAlianza(Personaje invitador) {

		if (invitador.tieneAlianza() && this.tieneAlianza()) {
			invitador.alianza.agregarPersonaje(this.alianza.getPersonajes());

		} else if (invitador.tieneAlianza()) {
			invitador.alianza.agregarPersonaje(this);
		} else if (tieneAlianza()) {
			alianza.agregarPersonaje(invitador);
		}
		else{
			List<Personaje> personajes= new ArrayList<Personaje>();
			personajes.add(invitador);
			personajes.add(this);
			this.alianza = new Alianza(personajes);
			invitador.alianza = alianza;

		}

	}

	private boolean tieneAlianza() {
		return alianza != null;
	}

	public void invitarAAlianza(Personaje invitado) {
		invitado.tratarAlianza(this);
	}

	// FIXME arreglar segun decision del jugador
	private void tratarAlianza(Personaje invitador) {
		aceptarAlianza(invitador);
		// rechazarAlianza(invitador);
	}

	private void rechazarAlianza(Personaje invitador) {
		desafiar(invitador);
	}

	public void desafiar(Personaje desafiado) {
		alianza.atacar(desafiado.alianza);
	}

	public void aceptarDesafio(Personaje enemigo){
        sort(this.alianza.personajes);
        sort(enemigo.alianza.personajes);
        Batalla batalla = new Batalla((this.invocarAliados()), enemigo.invocarAliados());
    }

	public abstract void subirStats(int nivel);

	public void mover(Punto posicionNueva) {
		if(mapa.posicionValida(posicionNueva)){
			posicion = posicionNueva;
			radioDeAcccion.setCentro(posicion);
		}
	}

	public Punto getPosicion() {
		return posicion;
	}

	public final Alianza invocarAliados() {
		int i = 0;
		List<Personaje> aliadosEnBatalla = new ArrayList<Personaje>();
		aliadosEnBatalla.add(this);
		if (tieneAlianza()) {
			List<Personaje> aliadosTotales = this.alianza.getPersonajes();
			while (aliadosEnBatalla.size() < 5 && i < aliadosTotales.size()) {
				Personaje personaje = aliadosTotales.get(i);
				if (personaje.estaEnElRadio(this.radioDeAcccion) && !personaje.enBatalla && personaje != this) {
					aliadosEnBatalla.add(personaje);
				}
				i++;
			}
		}
		return new Alianza(aliadosEnBatalla);
	}

	private boolean estaEnElRadio(Circulo radioDeAcccion) {
		return radioDeAcccion.incluye(this.posicion);
	}

	public String getArma() {

		return arma;
	}

	public void setArma(String arma) {
		this.arma = arma;
	}

	public String getBotas() {
		return botas;
	}

	public void setBotas(String botas) {
		this.botas = botas;
	}

	public String getCasco() {
		return casco;
	}

	public void setCasco(String casco) {
		this.casco = casco;
	}

	public String getChaleco() {
		return chaleco;
	}

	public void setChaleco(String chaleco) {
		this.chaleco = chaleco;
	}

	public String getEscudo() {
		return escudo;
	}

	public void setEscudo(String escudo) {
		this.escudo = escudo;
	}

	public void recibirItem(Item item) {
		inventario.add(item);
	}

	public boolean puedeDarItem() {
		return inventario.size() != 0;
	}

	public Item entregarItem() {
		return inventario.remove();
	}

	public List<Item> getItems(){
        return inventario.getListaDeItems();
    }

	protected Personaje equiparItem(String nombreItem){
		return inventario.buscarItem(this, nombreItem).equiparPersonaje(this);
	}

	public void agregarAInventario(Item item){
        inventario.add(item);
    }

	public boolean puedeEquiparArma() {
		return arma == null;
	}

	public boolean puedeEquiparBotas() {
		return botas == null;
	}

	public boolean puedeEquiparCasco() {

		return casco == null;

	}

	public boolean puedeEquiparChaleco() {

		return chaleco == null;

	}

	public boolean puedeEquiparEscudo() {

		return escudo == null;

	}

	public void setVelocidad(int Velocidad) {
		this.velocidad = Velocidad;
	}

	public int getSaludMaxima() {
		return saludMaxima;
	}

	public void agregarHechizo(String conjuro, Hechizo hechizo) {
		this.hechizos.put(conjuro, hechizo);
	}
	
	public int getCantidadDeHechizos() {
		return this.hechizos.size();
	}

	public void hechizar(String conjuro, Personaje personaje, int efecto) {
		this.hechizos.get(conjuro).afectar(personaje, efecto);
	}

	public Mapa getMapa() {
		return mapa;
	}

	public void setMapa(Mapa mapa) {
		this.mapa = mapa;
	}

	public void setPosicion(Punto punto) {
		posicion = punto;
		radioDeAcccion.setCentro(punto);
	}

    @Override
    public int compareTo(Personaje personaje) {
        if (velocidad < personaje.velocidad) {
            return -1;
        }
        if (velocidad > personaje.velocidad) {
            return 1;
        }
        return 0;
    }
}
	

