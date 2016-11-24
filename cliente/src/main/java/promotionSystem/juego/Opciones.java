package promotionSystem.juego;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import promotionSystem.Cliente;
import promotionSystem.Personaje;

public class Opciones extends JFrame{
	private JPanel contentPane;
	private Personaje personajeClickeado;
	private Cliente cliente;

	public Opciones(Cliente cliente) {
		this.cliente=cliente;
		
		setResizable(false);
		setVisible(false);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(0, 0, 300, 150);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton alianza = new JButton("Solicitar Alianza");
		alianza.setBounds(24, 11, 234, 23);
		alianza.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					enviarAlianza();
					dispose();
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		});
		contentPane.add(alianza);
		
		
		JButton batallar = new JButton("Batallar");
		batallar.setBounds(24, 45, 234, 23);
		batallar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					enviarBatalla();
					dispose();
					
				} catch (IOException e1) {
					
					e1.printStackTrace();
				}
				
			}
			
		});
		contentPane.add(batallar);
		
		JButton cancelar = new JButton("Cancelar");
		cancelar.setBounds(24, 79, 234, 23);
		cancelar.addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent arg0) {
			
				dispose();	
			}
			
		});
		contentPane.add(cancelar);
		
		addWindowListener(new WindowAdapter(){

			@Override
			public void windowDeactivated(WindowEvent arg0) {
				
				dispose();
			}

		});
	}

	public Personaje getPersonajeClickeado() {
		return personajeClickeado;
	}

	public void setPersonajeClickeado(Personaje personajeClickeado) {
		this.personajeClickeado = personajeClickeado;
	}

	private void enviarAlianza() throws IOException {
		cliente.enviarInvitacionAAlianza(personajeClickeado);
	}

	private void enviarBatalla() throws IOException {
		cliente.enviarNotificacionDeBatalla(personajeClickeado);
	}


}
