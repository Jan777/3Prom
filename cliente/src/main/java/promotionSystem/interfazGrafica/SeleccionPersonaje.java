package promotionSystem.interfazGrafica;

import javax.imageio.ImageIO;
import javax.swing.*;

import promotionSystem.Cliente;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class SeleccionPersonaje extends JFrame {


	public SeleccionPersonaje(Cliente cliente) throws IOException{
		
		setBounds(0,0,500,500);
		setResizable(false);
		setTitle("Seleccion de Personaje");
		LaminaPrincipal lamina=new LaminaPrincipal(cliente,this);
		add(lamina);
	}
}

class LaminaPrincipal extends JPanel{
	JComboBox<String> castas,razas;

	public LaminaPrincipal(Cliente cliente,JFrame marco) throws IOException{
		castas=new JComboBox<String>();
		razas=new JComboBox<String>();
		setLayout(new BorderLayout());
		LaminaNorte laminaN=new LaminaNorte();
		LaminaOeste laminaE=new LaminaOeste(cliente,castas,razas);
		LaminaCentral laminaC=new LaminaCentral();

		LaminaSur laminaS = new LaminaSur(cliente,castas,razas,marco);
		add(laminaN,BorderLayout.NORTH);
		add(laminaE,BorderLayout.WEST);
		add(laminaC,BorderLayout.CENTER);

		add(laminaS,BorderLayout.SOUTH);
	}
}

class LaminaSur extends JPanel{
	JComboBox<String> castas,razas;
	private Cliente cliente;
	
	public LaminaSur(Cliente cliente,JComboBox<String> castas, JComboBox<String> razas,JFrame marco){
		this.cliente=cliente;
		this.castas=castas;
		this.razas=razas;
		
		setLayout(new GridLayout(2,1));
		LaminaAuxFlow lamina =new LaminaAuxFlow(FlowLayout.CENTER);
		LaminaAuxFlow informe =new LaminaAuxFlow(FlowLayout.CENTER);
		
		JButton seleccionar=new JButton("SELECCIONAR");
		seleccionar.addActionListener (new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					enviarRazaYCasta();
					marco.dispose();
				
				} catch (Exception e) {
			
					e.printStackTrace();
				}
				
			}

		
			
		});
		
		JLabel error=new JLabel(" ");
		
		lamina.add(seleccionar);
		informe.add(error);
		add(lamina);
		add(informe);
	}
	
	private void enviarRazaYCasta() throws Exception {
		cliente.enviarAccion("seleccionarRazaYCasta");
		String raza=(String) razas.getSelectedItem();
		String casta=(String) castas.getSelectedItem();
		cliente.enviarRazaYCastaSeleccionada(raza,casta);
		
		
	}
}


class LaminaCentral extends JPanel{
	private Image imagen;

	public LaminaCentral (){
		setLayout(new FlowLayout(FlowLayout.CENTER));
	} //no funciona bien

	public void paintComponent(Graphics g){
		super.paintComponent(g);

		File miImagen=new File("recursos/Razas/Guerrero.jpg");
		try {
			imagen=ImageIO.read(miImagen);
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(imagen, 5, 5, null);

	}
}
/*
cliente.enviarAccion("enviarRaza");
cliente.enviarRazaSeleccionada(eleccion);
cargarCastas();*/

class LaminaNorte extends JPanel{

	public LaminaNorte(){
		setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel titulo=new JLabel("Seleccione un personaje");
		titulo.setFont(new Font("titulo",Font.BOLD,33));
		add(titulo);

	}
}

class LaminaOeste extends JPanel{
	JComboBox<String> castas,razas;
	private Cliente cliente;
	private ArrayList<String> listaDeCastas;
	private String razaElegida;
	private String castaElegida;
	public LaminaOeste(Cliente cliente,JComboBox<String> castas, JComboBox<String> razas) throws IOException{
		this.castas=castas;
		this.razas=razas;
		setLayout(new GridLayout(8,1));
		this.cliente=cliente;
		LaminaAuxFlow oesteRazas=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteCastas=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteSalud=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteAtaque=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteDefensa=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteMagia=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteEnergia=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteVelocidad=new LaminaAuxFlow(FlowLayout.LEFT);
		
		cargarRazas();
		listaDeCastas=recibirListaDeCastas();
		
		castas.setEnabled(false);
	    
	    castas.addActionListener(new AccionCastas(castas));
	    
		razas.addActionListener(new AccionRazas(razas));
	
		JLabel ataque=new JLabel("ATAQUE: ");
		JLabel puntosAtaque=new JLabel();
		JLabel defensa=new JLabel("DEFENSA: ");
		JLabel puntosDefensa=new JLabel();
		JLabel magia=new JLabel("MAGIA: ");
		JLabel puntosMagia=new JLabel();
		JLabel velocidad=new JLabel("VELOCIDAD: ");
		JLabel puntosVelocidad=new JLabel();
		JLabel energia=new JLabel("ENERGIA: ");
		JLabel puntosEnergia=new JLabel();
		JLabel salud=new JLabel("SALUD: ");
		JLabel puntosSalud=new JLabel();

		oesteRazas.add(razas);
		oesteCastas.add(castas);
		oesteSalud.add(salud);
		oesteSalud.add(puntosSalud);
		oesteAtaque.add(ataque);
		oesteAtaque.add(puntosAtaque);
		oesteDefensa.add(defensa);
		oesteDefensa.add(puntosDefensa);
		oesteMagia.add(magia);
		oesteMagia.add(puntosMagia);
		oesteEnergia.add(energia);
		oesteEnergia.add(puntosEnergia);
		oesteVelocidad.add(velocidad);
		oesteVelocidad.add(puntosVelocidad);


		this.add(oesteRazas);
		this.add(oesteCastas);
		this.add(oesteSalud);
		this.add(oesteAtaque);
		this.add(oesteDefensa);
		this.add(oesteMagia);
		this.add(oesteEnergia);
		this.add(oesteVelocidad);


	}

	private ArrayList<String> recibirListaDeCastas() throws IOException {
		return (ArrayList<String>) cliente.recibirListaDeCastas();
	}

	private void cargarRazas() throws IOException {
		
		ArrayList<String> razasRecibidas = (ArrayList<String>) cliente.recibirRazas();
		for(String raza : razasRecibidas) {
		    razas.addItem(raza);
		}
		
	}
	

	private class AccionCastas implements ActionListener{
		JComboBox castas;

		public AccionCastas(JComboBox castas){
			this.castas=castas;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
		  String castaElegida=(String) this.castas.getSelectedItem();	
		}

	}
	private class AccionRazas implements ActionListener{
		JComboBox razas;

		public AccionRazas(JComboBox razas){
			this.razas=razas;
		}
		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			castas.removeAllItems();
			String razaElegida= (String) this.razas.getSelectedItem();
			cargarCastas(razaElegida);
		    castas.setEnabled(true);
				
		

		}
		
		private void cargarCastas(String raza) {
			if (raza.equals("Humano")){
				castas.addItem(listaDeCastas.get(0));
				castas.addItem(listaDeCastas.get(1));
				castas.addItem(listaDeCastas.get(2));
				
			} else {
				if (raza.equals("Kingdom Hearts")) {
					castas.addItem(listaDeCastas.get(3));
					castas.addItem(listaDeCastas.get(4));
					castas.addItem(listaDeCastas.get(5));
				} else {
					if (raza.equals("Pokemon")) {
						castas.addItem(listaDeCastas.get(6));
						castas.addItem(listaDeCastas.get(7));
						castas.addItem(listaDeCastas.get(8));
					} else {
						if (raza.equals("Star Wars")) {
							castas.addItem(listaDeCastas.get(9));
							castas.addItem(listaDeCastas.get(10));
							castas.addItem(listaDeCastas.get(11));
						} else {
							if (raza.equals("Undertale")){
								castas.addItem(listaDeCastas.get(12));		
							}else if(raza.equals("Orco")){
								castas.addItem(listaDeCastas.get(13));
								castas.addItem(listaDeCastas.get(14));
								castas.addItem(listaDeCastas.get(15));
							}
						}
					}
				}
			}
			
		}

		
	}
}

class LaminaAuxFlow extends JPanel{

	public LaminaAuxFlow(int f){
		setLayout(new FlowLayout(f));

	}
}