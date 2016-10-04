package promotionSystem;

public class RepartidorDeExperiencia {

	public static int calcularNivel(int experiencia) {
		return (int) Math.sqrt(experiencia/10);
	}

}
