package promotionSystem;

public class AdministradorDeExperiencia {

	public static int calcularNivel(int experiencia) {
		return (int) Math.sqrt(experiencia/10);
	}

}
