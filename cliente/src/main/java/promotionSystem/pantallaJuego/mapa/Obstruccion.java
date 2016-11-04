package promotionSystem.pantallaJuego.mapa;

import promotionSystem.pantallaJuego.resources.recursos.*;
import recursos.RecursoGrafico;

public class Obstruccion extends Tile {
	
	public Obstruccion(int id) {
		super(RecursoGrafico.obstruccion, id);
	}
	
	@Override
	public boolean esSolido() {
		return true;
	}
}
