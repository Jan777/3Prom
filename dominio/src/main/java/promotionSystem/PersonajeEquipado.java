package promotionSystem;

public abstract class PersonajeEquipado extends Personaje {
	
	private Personaje personajeDecorado;
	
	private double MultiplicadorDeAtaque;
	private int sumadorDeAtaque;
	private double MultiplicadorDeDefensa;
	private int sumadorDeDefensa;
	private double MultiplicadorDeMagia;
	private int sumadorDeMagia;
	private double MultiplicadorDeVelocidad;
	private int sumadorDeVelocidad;
	
	public PersonajeEquipado(Personaje personajeDecorado, double MultiplicadorDeAtaque, int sumadorDeAtaque, double MultiplicadorDeDefensa, int sumadorDeDefensa, double MultiplicadorDeMagia, int sumadorDeMagia, double MultiplicadorDeVelocidad, int sumadorDeVelocidad) {
		this.personajeDecorado = personajeDecorado;
		this.MultiplicadorDeAtaque = MultiplicadorDeAtaque;
		this.MultiplicadorDeDefensa = MultiplicadorDeDefensa;
		this.MultiplicadorDeMagia = MultiplicadorDeMagia;
		this.MultiplicadorDeVelocidad = MultiplicadorDeVelocidad;
		this.sumadorDeAtaque = sumadorDeAtaque;
		this.sumadorDeDefensa = sumadorDeDefensa;
		this.sumadorDeMagia = sumadorDeMagia;
		this.sumadorDeVelocidad = sumadorDeVelocidad;
	}
	
	public void atacarConMagia(Personaje atacado, String conjuro){
		personajeDecorado.atacarConMagia(atacado, conjuro);
	}
	
	public void setArma(String arma) {
		personajeDecorado.setArma(arma);
	}
	
	public String getArma(){
		return personajeDecorado.getArma();
	}

	public void setBotas(String botas) {
		personajeDecorado.setBotas(botas);
	}
	
	public String getBotas(){
		return personajeDecorado.getBotas();
	}
	
	public void setCasco(String casco) {
		personajeDecorado.setCasco(casco);
	}
	
	public String getCasco(){
		return personajeDecorado.getCasco();
	}
	
	public void setChaleco(String chaleco) {
		personajeDecorado.setChaleco(chaleco);
	}
	
	public String getChaleco(){
		return personajeDecorado.getChaleco();
	}
	
	public void setEscudo(String escudo) {
		personajeDecorado.setEscudo(escudo);
	}
	
	public String getEscudo(){
		return personajeDecorado.getEscudo();
	}
	
	@Override
	public boolean puedeEquiparArma(){
		return personajeDecorado.puedeEquiparArma();
	}
	@Override
	public boolean puedeEquiparBotas(){
		return personajeDecorado.puedeEquiparBotas();
	}
	@Override
	public boolean puedeEquiparCasco(){
		return personajeDecorado.puedeEquiparCasco();
	}
	@Override
	public boolean puedeEquiparChaleco(){
		return personajeDecorado.puedeEquiparChaleco();
	}
	@Override
	public boolean puedeEquiparEscudo(){
		return personajeDecorado.puedeEquiparEscudo();
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
		return MultiplicadorDeAtaque;
	}

	public void setMultiplicadorDeAtaque(double MultiplicadorDeAtaque) {
		this.MultiplicadorDeAtaque = MultiplicadorDeAtaque;
	}

	public int getSumadorDeAtaque() {
		return sumadorDeAtaque;
	}

	public void setSumadorDeAtaque(int sumadorDeAtaque) {
		this.sumadorDeAtaque = sumadorDeAtaque;
	}

	public double getMultiplicadorDeDefensa() {
		return MultiplicadorDeDefensa;
	}

	public void setMultiplicadorDeDefensa(double MultiplicadorDeDefensa) {
		this.MultiplicadorDeDefensa = MultiplicadorDeDefensa;
	}

	public int getSumadorDeDefensa() {
		return sumadorDeDefensa;
	}

	public void setSumadorDeDefensa(int sumadorDeDefensa) {
		this.sumadorDeDefensa = sumadorDeDefensa;
	}

	public double getMultiplicadorDeMagia() {
		return MultiplicadorDeMagia;
	}

	public void setMultiplicadorDeMagia(double MultiplicadorDeMagia) {
		this.MultiplicadorDeMagia = MultiplicadorDeMagia;
	}

	public int getSumadorDeMagia() {
		return sumadorDeMagia;
	}

	public void setSumadorDeMagia(int sumadorDeMagia) {
		this.sumadorDeMagia = sumadorDeMagia;
	}

	public double getMultiplicadorDeVelocidad() {
		return MultiplicadorDeVelocidad;
	}

	public void setMultiplicadorDeVelocidad(double MultiplicadorDeVelocidad) {
		this.MultiplicadorDeVelocidad = MultiplicadorDeVelocidad;
	}

	public int getSumadorDeVelocidad() {
		return sumadorDeVelocidad;
	}

	public void setSumadorDeVelocidad(int sumadorDeVelocidad) {
		this.sumadorDeVelocidad = sumadorDeVelocidad;
	}
}
