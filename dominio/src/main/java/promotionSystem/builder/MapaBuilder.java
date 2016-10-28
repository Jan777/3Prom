package promotionSystem.builder;

import promotionSystem.Punto;
import promotionSystem.mapa.Mapa;
import promotionSystem.mapa.Obstaculo;

public class MapaBuilder {

	public static Mapa Kanto(){
		Mapa kanto = new Mapa(1000,1000);
		kanto.agregarObstaculo(new Obstaculo(new Punto(1,1), 10, 20));
		return kanto;
	}
}
