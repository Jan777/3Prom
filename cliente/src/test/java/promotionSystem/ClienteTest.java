package promotionSystem;

import org.junit.Test;

import promotionSystem.Cliente;

public class ClienteTest {
	@Test
	public void doStuff() throws Exception {
		Cliente cliente=new Cliente("pepe","humano","GuerreroHumano");
		Cliente cliente2=new Cliente("pepe","orco","GuerreroOrco");
		Cliente cliente3=new Cliente("pepe","starWars","Jedi");
	}
}
