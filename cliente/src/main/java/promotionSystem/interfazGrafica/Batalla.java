package promotionSystem.interfazGrafica;

import promotionSystem.Cliente;
import promotionSystem.Personaje;
import promotionSystem.Punto;
import promotionSystem.juego.Sonido;
import promotionSystem.sprites.CargaImagen;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import org.junit.internal.builders.SuiteMethodBuilder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Enumeration;
import java.util.List;

public class Batalla extends JFrame implements Runnable{

	private JPanel contentPane;
	private BufferedImage fondo;
	private BufferedImage spriteUnitario;
	private List<Personaje> alianzaAmiga;
	private List<Personaje> alianzaEnemiga;
	private ButtonGroup buttonGroup;
	private Cliente cliente;
	private JLabel lblSeleccionarMagia;
	private JLabel lblSeleccionarEnemigo;
	private JComboBox<String> seleccionarEnemigo;
	private JComboBox<String> seleccionarAliado;
	private JComboBox<String> seleccionarMagia;
	private JButton btnEjecutar;
	private JRadioButton rdbtnAtacar;
	private JRadioButton rdbtnMagia;
	private JRadioButton rdbtnHuir;
	private boolean elegirAccion=false;
	private String movimiento;
	private String nombreObjetivo;
	private String hechizo;
	private int cantidadMuertesAlianzaAmiga;
	private int cantidadMuertesAlianzaEnemiga;
	private int experienciaSumada;
	
	public Batalla(Cliente cliente) {
		Sonido.BATALLAPOKEMON.loop();
		this.alianzaEnemiga=cliente.getAlianzaEnemiga().getPersonajes();
		this.alianzaAmiga=cliente.getAlianzaAmiga().getPersonajes();
		this.cliente = cliente;
		setVisible(true);
		setTitle("Batalla");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		buttonGroup = new ButtonGroup();
		
		seleccionarMagia = new JComboBox<>();
		seleccionarMagia.setBounds(176, 469, 251, 48);
		contentPane.add(seleccionarMagia);
		
		btnEjecutar = new JButton("Ejecutar");
		btnEjecutar.setBounds(549, 488, 235, 48);
		contentPane.add(btnEjecutar);
		btnEjecutar.setEnabled(false);
		
		seleccionarEnemigo = new JComboBox<>();
		seleccionarEnemigo.setBounds(549, 444, 235, 41);
		contentPane.add(seleccionarEnemigo);
		cargarEnemigos();
		seleccionarEnemigo.setEnabled(false);
		
	
		seleccionarAliado = new JComboBox<>();
		seleccionarAliado.setBounds(549, 444, 235, 41);
		contentPane.add(seleccionarAliado);
		cargarAliados();
		seleccionarAliado.setVisible(false);
		lblSeleccionarEnemigo = new JLabel("Seleccionar Enemigo");
		lblSeleccionarEnemigo.setBounds(615, 420, 200, 14);
		contentPane.add(lblSeleccionarEnemigo);
		
		lblSeleccionarMagia = new JLabel("Seleccionar Magia");
		lblSeleccionarMagia.setBounds(269, 444, 200, 14);
		contentPane.add(lblSeleccionarMagia);
		
		rdbtnAtacar = new JRadioButton("Atacar");
		rdbtnAtacar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnAtacar.setBounds(37, 438, 109, 23);
		contentPane.add(rdbtnAtacar);
		
		rdbtnMagia = new JRadioButton("Hechizar");
		rdbtnMagia.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnMagia.setBounds(37, 480, 200, 23);
		contentPane.add(rdbtnMagia);
		
		rdbtnHuir = new JRadioButton("Huir");
		rdbtnHuir.setFont(new Font("Tahoma", Font.PLAIN, 15));
		rdbtnHuir.setBounds(37, 532, 109, 23);
		contentPane.add(rdbtnHuir);
		
		buttonGroup.add(rdbtnAtacar);
		buttonGroup.add(rdbtnMagia);
		buttonGroup.add(rdbtnHuir);
		seleccionarMagia.setEnabled(false);
		cargarHechizos();
		deshabilitarRadioButtons();
		

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				try {
					enviarAccionDeCerrar();
				} catch (IOException e1) {
					JOptionPane.showMessageDialog(null, "ERROR!");
				}

			}



		});

	}

	private void enviarAccionDeCerrar() throws IOException {
		cliente.enviarAccion("cerrar");
		

	}

	private void cargarAliados() {
		for(Personaje personajeAliado:alianzaAmiga){
			seleccionarAliado.addItem(personajeAliado.getNombre());
		}

	}

	private void cargarEnemigos() {
		for(Personaje personajeEnemigo:alianzaEnemiga){
			seleccionarEnemigo.addItem(personajeEnemigo.getNombre());
		}

	}

	private void cargarHechizos() {
		for(String key : cliente.getPersonaje().getHechizos()) {
			seleccionarMagia.addItem(key);
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		Graphics2D g2d = (Graphics2D) g;
		fondo= CargaImagen.cargarImagen("recursos/Batalla/BatallaFondo.gif");
		g2d.drawImage(fondo, 0, 0, null);
		for(Personaje personaje: alianzaAmiga){
			spriteUnitario= CargaImagen.cargarImagen("recursos/Batalla/"+ personaje.getCasta() +"Batalla.png");
			Punto punto=obtenerPosicionEnFrameBatallaDesafiantes(alianzaAmiga.indexOf(personaje));
			g2d.drawImage(spriteUnitario, punto.getX(),punto.getY(), null);
			
			Font tipoDeLetra=new Font("Arial", Font.BOLD, 16);
			g.setColor(Color.WHITE);
			g.setFont(tipoDeLetra);
			g2d.drawString(personaje.getNombre(), punto.getX()+10,punto.getY()-7);
			g2d.drawString(personaje.getSalud()+ " / " +personaje.getSaludMaxima(),  punto.getX()+10,punto.getY()+5);
			
		}
		
		for(Personaje personaje: alianzaEnemiga){
			spriteUnitario= CargaImagen.cargarImagen("recursos/Batalla/"+ personaje.getCasta() +"BatallaInvertida.png");
			Punto punto=obtenerPosicionEnFrameBatallaDesafiados(alianzaEnemiga.indexOf(personaje));
			g2d.drawImage(spriteUnitario, punto.getX(),punto.getY(), null);
			
			Font tipoDeLetra=new Font("Arial", Font.BOLD, 16);
			g.setColor(Color.CYAN);
			g.setFont(tipoDeLetra);
			g2d.drawString(personaje.getNombre(), punto.getX()+70,punto.getY()-7);
			g2d.drawString(personaje.getSalud()+ " / " +personaje.getSaludMaxima(),  punto.getX()+70,punto.getY()+5);
		}
		
		
	}
	
	public Punto obtenerPosicionEnFrameBatallaDesafiantes(int posicionDeLlegada){
	   int x=0, y=0;
		
		if(posicionDeLlegada==0 || posicionDeLlegada==1 || posicionDeLlegada==2){
			x=128;
		}
		
		if(posicionDeLlegada==0 || posicionDeLlegada==3){
			y=225;
		}
		if(posicionDeLlegada==1 || posicionDeLlegada==4){
			y=273;
		}
		if(posicionDeLlegada==5 || posicionDeLlegada==2){
			y=322;
		}
		
		
		return new Punto(x,y);
	}
	
	public Punto obtenerPosicionEnFrameBatallaDesafiados(int posicionDeLlegada){
		   int x=672, y=0;
			
			if(posicionDeLlegada==0 || posicionDeLlegada==1 || posicionDeLlegada==2){
				x=544;
			}
			
			if(posicionDeLlegada==0 || posicionDeLlegada==3){
				y=225;
			}
			if(posicionDeLlegada==1 || posicionDeLlegada==4){
				y=273;
			}
			if(posicionDeLlegada==5 || posicionDeLlegada==2){
				y=322;
			}
			
			
			return new Punto(x,y);
		}

	@Override
	public void run() {
		setearListeners();

		
		try {
		
			while (cantidadMuertesAlianzaAmiga < cliente.getAlianzaAmiga().getPersonajes().size() && cantidadMuertesAlianzaEnemiga <  cliente.getAlianzaEnemiga().getPersonajes().size() ) {
				Thread.sleep(10);
				if(cliente.getTurno()){	
					otorgarTurno();
					repaint();
					cliente.setTurno(false);
					elegirAccion=false;
					deshabilitarRadioButtons();
				}
				Thread.sleep(10);
				 if(cliente.getAtaque()){
					realizarAtaque();
					repaint();		
					cliente.setAtaque(false);
				}					
				 
				 if(cliente.getAtaqueConMagia()){
					 realizarAtaqueConMagia();
					 repaint();
					 cliente.setAtaqueConMagia(false);
				 }
			}
			if(cantidadMuertesAlianzaAmiga == cliente.getAlianzaAmiga().getPersonajes().size()){
				JOptionPane.showMessageDialog(null,"Has perdido!","Fin de batalla",JOptionPane.INFORMATION_MESSAGE);
			}else{
				cliente.getPersonaje().subirExperiencia(experienciaSumada);
				JOptionPane.showMessageDialog(null,"Has Ganado!","Fin de batalla",JOptionPane.INFORMATION_MESSAGE);
			}
			Sonido.BATALLAPOKEMON.stop();
			Sonido.MAPAPOKEMON.loop();
			dispose();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	
	private void realizarAtaqueConMagia() {
		Personaje atacante = obtenerPersonajeAPartirDelNombreEnAlgunaAlianza(cliente.getAtacante());
		Personaje atacado = obtenerPersonajeAPartirDelNombreEnAlgunaAlianza(cliente.getAtacado());
		atacante.atacarConMagia(atacado,cliente.getHechizo());
		determinarMuerte(atacado);
		
	}

	private void deshabilitarRadioButtons() {
			rdbtnAtacar.setEnabled(false);
			rdbtnHuir.setEnabled(false);
			rdbtnMagia.setEnabled(false);
			rdbtnAtacar.setSelected(false);
			rdbtnHuir.setSelected(false);
			rdbtnMagia.setSelected(false);
	}

	private void realizarAtaque() {
	
		Personaje atacante = obtenerPersonajeAPartirDelNombreEnAlgunaAlianza(cliente.getAtacante());
		Personaje atacado = obtenerPersonajeAPartirDelNombreEnAlgunaAlianza(cliente.getAtacado());
		atacante.atacar(atacado);
		determinarMuerte(atacado);
	}
	


	private void determinarMuerte(Personaje atacado) {
		if(!atacado.estaVivo()){
			if(alianzaAmiga.contains(atacado)){
				cantidadMuertesAlianzaAmiga++;
			}
			else{
				 cantidadMuertesAlianzaEnemiga++;
				 seleccionarEnemigo.removeItem(atacado.getNombre());
				 experienciaSumada+=atacado.getSaludMaxima();
			}
		}
		
	}

	private Personaje obtenerPersonajeAPartirDelNombreEnAlgunaAlianza(String atacado) {
		
			for(Personaje personajeAtacado : alianzaEnemiga){
				if(personajeAtacado.getNombre().equals(atacado)){
					return personajeAtacado;
				}
			}
			
			for(Personaje personajeAtacado : alianzaAmiga){
				if(personajeAtacado.getNombre().equals(atacado)){
					return personajeAtacado;
				}
			}
			return null;
	}

	private void otorgarTurno() throws IOException {	
		habilitarRadioButtons();
		
		while(!elegirAccion)
		{
			System.out.println(elegirAccion);
		}
		
		enviarMovimiento();				
		
	}

	private void habilitarRadioButtons() {
		rdbtnAtacar.setEnabled(true);
		rdbtnHuir.setEnabled(true);
		rdbtnMagia.setEnabled(true);
	}
	
	

	private void enviarMovimiento() throws IOException {
		if(movimiento.equals("Atacar")){
			enviarAtacar();
		}
		else if(movimiento.equals("Hechizar")){
			enviarHechizo();
		}

	}

	private void enviarHechizo() throws IOException {
		Personaje personajeAtacado = obtenerPersonajeAPartirDelNombre(nombreObjetivo);
		cliente.getPersonaje().atacarConMagia(personajeAtacado,hechizo);
		enviarAccionDeBatalla(movimiento.toLowerCase());
		enviarObjetivo();
		determinarMuerte(personajeAtacado);
	}

	private void enviarAtacar() throws IOException {
		Personaje personajeAtacado = obtenerPersonajeAPartirDelNombre(nombreObjetivo);
		cliente.getPersonaje().atacar(personajeAtacado);
		enviarAccionDeBatalla(movimiento.toLowerCase());
		enviarObjetivo();
		
		determinarMuerte(personajeAtacado);
			
	}

	private void enviarObjetivo() throws IOException {
		cliente.enviarPersonajeHechizado(nombreObjetivo,hechizo);
	}

	private Personaje obtenerPersonajeAPartirDelNombre(String nombreObjetivo) {
		for(Personaje personajeAtacado : alianzaEnemiga){
			if(personajeAtacado.getNombre().equals(nombreObjetivo)){
				return personajeAtacado;
			}
		}
		return null;
	}

	private void enviarAccionDeBatalla(String accion) throws IOException {
		cliente.enviarAccionDeBatalla(accion);

	}

	private void setearListeners() {
		btnEjecutar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				elegirAccion=true;
				btnEjecutar.setEnabled(false);	
				seleccionarEnemigo.setEnabled(false);
				seleccionarMagia.setEnabled(false);
			}
		});

		seleccionarEnemigo.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent arg0) {
				movimiento=obtenerRadioButtonSeleccionado();
				nombreObjetivo=(String)seleccionarEnemigo.getSelectedItem();
				btnEjecutar.setEnabled(true);

			}	
		});

		rdbtnAtacar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnAtacar.isSelected()){
					seleccionarMagia.setEnabled(false);
					seleccionarEnemigo.setEnabled(true);
				}
			}
		});

		rdbtnMagia.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if(rdbtnMagia.isSelected()){
					seleccionarMagia.setEnabled(true);
					seleccionarEnemigo.setEnabled(false);
				}
			}
		});
		
		seleccionarMagia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				hechizo=(String)seleccionarMagia.getSelectedItem();
				seleccionarEnemigo.setEnabled(true);
				
			}
		});

		rdbtnHuir.addActionListener(new ActionListener() {


			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(rdbtnHuir.isSelected()){
					seleccionarMagia.setEnabled(false);
					seleccionarEnemigo.setEnabled(false);
					JOptionPane.showMessageDialog(null, "¿A donde queres ir? No seas cagon","No puedes huir",JOptionPane.INFORMATION_MESSAGE);
				}
			}
		});

	}
	
	private String obtenerRadioButtonSeleccionado() {

		for (Enumeration<AbstractButton> enumeracion=buttonGroup.getElements(); enumeracion.hasMoreElements(); ) 
		{
			JRadioButton boton = (JRadioButton)enumeracion.nextElement();
			if (boton.getModel() == buttonGroup.getSelection()) 
			{
				return boton.getText();
			}
		}

		return null;
	}
}
