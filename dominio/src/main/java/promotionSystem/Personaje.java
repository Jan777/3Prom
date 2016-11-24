package promotionSystem;

import promotionSystem.habilidades.Habilidad;
import promotionSystem.hechizo.Hechizo;
import promotionSystem.mapa.Mapa;
import promotionSystem.mapa.Rectangulo;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import static java.util.Collections.sort;
import static promotionSystem.Constantes.RADIO_DE_ACCION;

public abstract class Personaje implements Comparable<Personaje> {
	protected String nombre;
	protected String raza;
	protected String casta;
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
	protected Rectangulo rectanguloDeVision;
	private boolean enBatalla = false;
	protected int saludMaxima;
	protected int energiaMaxima;
	protected Map<String, Hechizo> hechizos;
	private Item arma;
	private Item botas;
	private Item casco;
	private Item chaleco;
	private Item escudo;
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
		usarMagiaSupport(this, conjuro);
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
			defensa = 0;
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

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public String getCasta() {
		return casta;
	}

	public void setCasta(String casta) {
		this.casta = casta;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;

	}

	public String getNombre() {
		return nombre;
	}

	public int getAtaque() {
		return ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public int getMagia() {
		return magia;
	}

	public int getVelocidad() {
		return velocidad;
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
		if (saludMaxima - salud > efecto) {
			salud += efecto;
		} else {
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

	public List<String> habilidades() {
		return arbolDeHabilidades.listaDeHabilidades();
	}

	public final void subirExperiencia(int experiencia) {
		this.experiencia += experiencia;
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

	public void subirHabilidad(String habilidad) {
		Habilidad habilidadASubir = arbolDeHabilidades.buscarHabilidad(habilidad);
		if (arbolDeHabilidades.subirHabilidad(habilidadASubir)) {
			activarHabilidad(habilidadASubir);
		}
	}

	public void activarHabilidad(Habilidad habilidad) {
		List<Integer> statsASubir = habilidad.statsASubir();
		ataque += statsASubir.get(0);
		magia += statsASubir.get(1);
		defensa += statsASubir.get(2);
	}

	private int experienciaPorNivel() {
		return (int) Math.pow(nivel, 2);
	}

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

		} 
		else if (invitador.tieneAlianza()) {
			invitador.alianza.agregarPersonaje(this);
		} 
		else if (tieneAlianza()) {
			alianza.agregarPersonaje(invitador);
		} 
		else {
			List<Personaje> personajes = new ArrayList<Personaje>();
			personajes.add(invitador);
			personajes.add(this);
			this.alianza = new Alianza(personajes);
			invitador.alianza = alianza;
		}

	}

	private boolean tieneAlianza() {
		return alianza != null;
	}

	private void rechazarAlianza(Personaje invitador) {
		desafiar(invitador);
	}

	public void desafiar(Personaje desafiado) {
		alianza.atacar(desafiado.alianza);
	}

	public void aceptarDesafio(Personaje enemigo) {
		sort(this.alianza.personajes);
		sort(enemigo.alianza.personajes);
		Batalla batalla = new Batalla((this.invocarAliados()), enemigo.invocarAliados());
	}

	public abstract void subirStats(int nivel);

	public void mover(Punto posicionNueva) {
		if (mapa.posicionValida(posicionNueva)) {
			posicion = posicionNueva;
			radioDeAcccion.setCentro(posicion);
		}
	}

	public Camino buscarCamino(Punto destino) {
		return new Camino(posicion, destino);
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

	public Item getArma() {
		return arma;
	}

	public Item getBotas() {
		return botas;
	}

	public Item getCasco() {
		return casco;
	}

	public Item getChaleco() {
		return chaleco;
	}

	public Item getEscudo() {
		return escudo;
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

	public List<Item> getItems() {
		return inventario.getListaDeItems();
	}

	public void equiparItem(Item item) throws Exception {
		Item itemEquipado = (Item) this.getClass().getSuperclass().getSuperclass()
				.getDeclaredField(item.getTipoDeItem()).get(this);
		if (itemEquipado == null) {
			Item itemEnInventario = inventario.buscarItem(item);
			equipar(itemEnInventario);
		} else {
			desequiparItem(itemEquipado);
			equiparItem(item);
		}
	}

	private void equipar(Item item) throws Exception {
		inventario.remove(item);
		this.getClass().getSuperclass().getSuperclass().getDeclaredField(item.getTipoDeItem()).set(this, item);
		activarItem(item);
	}

	public void desequiparItem(Item item) throws Exception {
		desactivarItem(item);
		this.getClass().getSuperclass().getSuperclass().getDeclaredField(item.getTipoDeItem()).set(this, null);
		inventario.add(item);
	}

	private void activarItem(Item item) {
		ataque += item.getSumadorDeAtaque();
		magia += item.getSumadorDeMagia();
		defensa += item.getSumadorDeDefensa();
		velocidad += item.getSumadorDeVelocidad();
	}

	private void desactivarItem(Item item) {
		ataque -= item.getSumadorDeAtaque();
		magia -= item.getSumadorDeMagia();
		defensa -= item.getSumadorDeDefensa();
		velocidad -= item.getSumadorDeVelocidad();
	}

	public void agregarAInventario(Item item) {
		inventario.add(item);
	}

	public Inventario getInventario() {
		return inventario;
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
		radioDeAcccion = new Circulo(punto, RADIO_DE_ACCION);
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

	public boolean equals(Personaje personaje) {
		return this.nombre == personaje.nombre;
	}

	public void ponerEnModoBatalla() {
		enBatalla = true;
	}
	
	public void sacarDeModoBatalla() {
		enBatalla = false;
	}
	
	public boolean isEnBatalla() {
		return enBatalla;
	}

	public Set<String> getHechizos() {
		return hechizos.keySet();
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
