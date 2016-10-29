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
	
	public void setArmaDelInventario(String arma) {
		personajeDecorado.setArmaDelInventario(arma);
	}
	
	public String getArmaDelInventario() {
		return personajeDecorado.getArmaDelInventario();
	}
	
	public String getArma(){
		return personajeDecorado.getArma();
	}
	
	public void setBotas(String botas) {
		personajeDecorado.setBotas(botas);
	}
	
	public void setBotasDelInventario(String botas) {
		personajeDecorado.setBotasDelInventario(botas);
	}
	
	public String getBotasDelInventario() {
		return personajeDecorado.getBotasDelInventario();
	}
	
	public String getBotas(){
		return personajeDecorado.getBotas();
	}
	
	public void setCasco(String casco) {
		personajeDecorado.setCasco(casco);
	}
	
	public void setCascoDelInventario(String casco) {
		personajeDecorado.setCascoDelInventario(casco);
	}
	
	public String getCascoDelInventario() {
		return personajeDecorado.getCascoDelInventario();
	}
	
	public String getCasco(){
		return personajeDecorado.getCasco();
	}
	
	public void setChaleco(String chaleco) {
		personajeDecorado.setChaleco(chaleco);
	}
	
	public void setChalecoDelInventario(String chaleco) {
		personajeDecorado.setChalecoDelInventario(chaleco);
	}
	
	public String getChalecoDelInventario() {
		return personajeDecorado.getChalecoDelInventario();
	}
	
	public String getChaleco(){
		return personajeDecorado.getChaleco();
	}
	
	public void setEscudo(String escudo) {
		personajeDecorado.setEscudo(escudo);
	}
	
	public void setEscudoDelInventario(String escudo) {
		personajeDecorado.setEscudoDelInventario(escudo);
	}
	
	public String getEscudoDelInventario() {
		return personajeDecorado.getEscudoDelInventario();
	}
	
	public String getEscudo(){
		return personajeDecorado.getEscudo();
	}
	
	@Override
	public boolean puedeEquiparArma(){
		return personajeDecorado.puedeEquiparArma();
	}
	@Override
	public boolean puedeEquiparArmaInventario(){
		return personajeDecorado.puedeEquiparArmaInventario();
	}
	@Override
	public boolean puedeEquiparBotas(){
		return personajeDecorado.puedeEquiparBotas();
	}
	@Override
	public boolean puedeEquiparBotasInventario(){
		return personajeDecorado.puedeEquiparBotasInventario();
	}
	@Override
	public boolean puedeEquiparCasco(){
		return personajeDecorado.puedeEquiparCasco();
	}
	@Override
	public boolean puedeEquiparCascoInventario(){
		return personajeDecorado.puedeEquiparCascoInventario();
	}
	@Override
	public boolean puedeEquiparChaleco(){
		return personajeDecorado.puedeEquiparChaleco();
	}
	@Override
	public boolean puedeEquiparChalecoInventario(){
		return personajeDecorado.puedeEquiparChalecoInventario();
	}
	@Override
	public boolean puedeEquiparEscudo(){
		return personajeDecorado.puedeEquiparEscudo();
	}
	@Override
	public boolean puedeEquiparEscudoInventario(){
		return personajeDecorado.puedeEquiparEscudoInventario();
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
