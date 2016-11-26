package promotionSystem.hilos;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import promotionSystem.Cliente;
import promotionSystem.Personaje;

import javax.swing.*;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;

public class EscuchadorBatalla extends Thread {
	private boolean continuar=true;
	private Cliente cliente;
	private  DataOutputStream salidaBatalla;
	private  DataInputStream entradaBatalla;
	
	public EscuchadorBatalla(Cliente cliente, ArrayList<Personaje> jugadoresEnPartida) throws IOException {
		this.cliente=cliente;
		this.cliente.getPersonaje().ponerEnModoBatalla();
		this.entradaBatalla=new DataInputStream(cliente.getSocketBatalla().getInputStream());
		this.salidaBatalla=new DataOutputStream(cliente.getSocketBatalla().getOutputStream());
	}

	
	public void run(){

		try {

			while (continuar) {
				Method miMetodo = EscuchadorBatalla.class.getMethod(recibirAccion());
				miMetodo.invoke(this);
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null,"Hubo un problema en la comunicacion con el Servidor","Error",JOptionPane.ERROR_MESSAGE);			
			System.exit(MAX_PRIORITY);
		}
	}

		public void cerrar(){
			continuar=false;
		}
	
		public String recibirAccion() throws IOException {
			JsonElement elemento = recibirObjetoJson();
			return elemento.getAsJsonObject().get("Accion").getAsString();
		}
	
		public JsonElement recibirObjetoJson() throws IOException {
			JsonParser parser = new JsonParser();
			return parser.parse(entradaBatalla.readUTF());
		}
		
		public void turnoOtorgado() throws IOException{
			JsonElement turno = recibirObjetoJson();
			cliente.setTurno(true);
			
		}
		
		public void ataqueRealizado() throws IOException{
			JsonElement ataque = recibirObjetoJson();
			cliente.setAtacante(ataque.getAsJsonObject().get("atacante").getAsString());
			cliente.setAtacado(ataque.getAsJsonObject().get("atacado").getAsString());
			cliente.setAtaque(true);
		

		}
		
		public void ataqueConMagiaRealizado() throws IOException{
			JsonElement ataque = recibirObjetoJson();
			cliente.setAtacante(ataque.getAsJsonObject().get("atacante").getAsString());
			cliente.setAtacado(ataque.getAsJsonObject().get("atacado").getAsString());
			cliente.setHechizo(ataque.getAsJsonObject().get("hechizo").getAsString());
			cliente.setAtaqueConMagia(true);
		}
}
