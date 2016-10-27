package promotionSystem.hechizo;

import promotionSystem.Personaje;

public class Llamarada extends Hechizo {

	@Override
	public void afectar(Personaje personaje, int efecto) {
		double probabilidad=Math.random();
		
		if(probabilidad>0.5){
			personaje.serAtacado(efecto*2);
		}else{
			personaje.serAtacado(efecto);
		}
				
		
	}
	

}
