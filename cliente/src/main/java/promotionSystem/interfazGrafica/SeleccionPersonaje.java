package promotionSystem.interfazGrafica;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.io.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class SeleccionPersonaje extends JFrame {
  
	public SeleccionPersonaje(){
		setBounds(0,0,500,500);
		setTitle("Seleccion de Personaje");
		LaminaPrincipal lamina=new LaminaPrincipal();
		add(lamina);
		
		
	}
	
}

class LaminaPrincipal extends JPanel{
	
	public LaminaPrincipal(){
		setLayout(new BorderLayout());
		LaminaNorte laminaN=new LaminaNorte();
		LaminaOeste laminaE=new LaminaOeste();
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
		LaminaAuxFlow lamina =new LaminaAuxFlow(FlowLayout.CENTER);
		JButton salir=new JButton("SALIR");
		JButton seleccionar=new JButton("SELECCIONAR");
		lamina.add(salir);
		lamina.add(seleccionar);
		add(lamina);
	}
}


class LaminaCentral extends JPanel{
	private Image imagen;
	
	public LaminaCentral (){
		setLayout(new FlowLayout(FlowLayout.CENTER));
	} //no funciona bien
	
	 public void paintComponent(Graphics g){
		 super.paintComponent(g);
		 
		 File miImagen=new File("C:/Users/Nahuel/Pictures/Para Juego Progra/Sora.png");
		 try {
			imagen=ImageIO.read(miImagen);
		} catch (IOException e) {
			// TODO Auto-generated catch block
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
	
	public LaminaOeste(){
		setLayout(new GridLayout(8,1));

		LaminaAuxFlow oesteRazas=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteCastas=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteSalud=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteAtaque=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteDefensa=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteMagia=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteEnergia=new LaminaAuxFlow(FlowLayout.LEFT);
		LaminaAuxFlow oesteVelocidad=new LaminaAuxFlow(FlowLayout.LEFT);
		JComboBox razas=new JComboBox();
		JComboBox castas=new JComboBox();
		razas.addItem("Seleccione una raza.." );
		castas.addItem("Seleccione una casta.." );
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
}

class LaminaAuxFlow extends JPanel{
	
	public LaminaAuxFlow(int f){
		setLayout(new FlowLayout(f));
		
	}
}
