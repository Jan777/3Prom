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
		LaminaPrincipal lamina=new LaminaPrincipal(cliente);
		add(lamina);
	}
}

class LaminaPrincipal extends JPanel{

	public LaminaPrincipal(Cliente cliente) throws IOException{

		setLayout(new BorderLayout());
		LaminaNorte laminaN=new LaminaNorte();
		LaminaOeste laminaE=new LaminaOeste(cliente);
		LaminaCentral laminaC=new LaminaCentral();

		LaminaSur laminaS = new LaminaSur();
		add(laminaN,BorderLayout.NORTH);
		add(laminaE,BorderLayout.WEST);
		add(laminaC,BorderLayout.CENTER);

		add(laminaS,BorderLayout.SOUTH);
	}
}

class LaminaSur extends JPanel{
	public LaminaSur(){
		setLayout(new GridLayout(2,1));
		LaminaAuxFlow lamina =new LaminaAuxFlow(FlowLayout.CENTER);
		LaminaAuxFlow informe =new LaminaAuxFlow(FlowLayout.CENTER);
		
		JButton seleccionar=new JButton("SELECCIONAR");
		JLabel error=new JLabel(" ");
		
		lamina.add(seleccionar);
		informe.add(error);
		add(lamina);
		add(informe);
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

class LaminaNorte extends JPanel{

	public LaminaNorte(){
		setLayout(new FlowLayout(FlowLayout.CENTER));
		JLabel titulo=new JLabel("Seleccione un personaje");
		titulo.setFont(new Font("titulo",Font.BOLD,33));
		add(titulo);

	}
}

class LaminaOeste extends JPanel{
	JComboBox castas,razas;
	private Cliente cliente;
	public LaminaOeste(Cliente cliente) throws IOException{
		setLayout(new GridLayout(8,1));
		this.cliente=cliente;
		enviarAccion();
		LaminaAuxFlow oesteRazas=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteCastas=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteSalud=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteAtaque=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteDefensa=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteMagia=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteEnergia=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteVelocidad=new LaminaAuxFlow(FlowLayout.LEFT);
		razas=new JComboBox();
		castas=new JComboBox();
		try {
			cargarRazas();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		/*
		razas.addItem("Seleccione una raza.." );
		razas.addItem("Humano");
		razas.addItem("Kingdom Hearts");
		razas.addItem("Orco");
		razas.addItem("Pokemon");
		razas.addItem("Star Wars");
		razas.addItem("Undertale");
*/
		razas.addActionListener(new AccionRazas());
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

	private void cargarRazas() throws IOException {
		
		ArrayList<String> razasRecibidas = (ArrayList<String>) cliente.recibirRazas();
		for(String raza : razasRecibidas) {
		    razas.addItem(raza);
		}
		
	}
	
	private void enviarAccion() throws IOException {		
		cliente.enviarAccion("Registro de Personaje");
	}

	private class AccionRazas implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent arg0) {
			castas.removeAllItems();
			String eleccion= (String) razas.getSelectedItem();
			
			try {
				cliente.enviarRazaSeleccionada(eleccion);
				cargarCastas();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
/*
			if(eleccion.equals("Humano")||eleccion.equals("Orco")){
				castas.addItem("Guerrero");
				castas.addItem("Mago");
				castas.addItem("Tanque");
			}else {
				if(eleccion.equals("Kingdom Hearts")){
					castas.addItem("Sora");
					castas.addItem("Roxas");
					castas.addItem("Riku");
				}else{
					if(eleccion.equals("Pokemon")){
						castas.addItem("Tipo Fuego");
						castas.addItem("Tipo Agua");
						castas.addItem("Tipo Planta");
					}else { if(eleccion.equals("Stars Wars")){
						castas.addItem("Jedi");
						castas.addItem("Droide");
						castas.addItem("Wookie");
					}else{if(eleccion.equals("Undertale"))
						castas.addItem("Chara");

					}

					}
				}
			}
*/
		}

		private void cargarCastas() throws IOException {
			ArrayList<String> castasRecibidas=(ArrayList<String>) cliente.recibirCasta();		
			for(String casta : castasRecibidas) {
			    castas.addItem(casta);
			}
			
		}

		private class AccionCastas implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {

				String eleccion=(String) castas.getSelectedItem();
				
			}

		}
	}
}

class LaminaAuxFlow extends JPanel{

	public LaminaAuxFlow(int f){
		setLayout(new FlowLayout(f));

	}
}