package promotionSystem.pantallaJuego.estados;

import promotionSystem.pantallaJuego.juego.*;
import promotionSystem.pantallaJuego.mapa.*;
import promotionSystem.pantallaJuego.resources.recursos.*;
import recursos.RecursoGrafico;

import java.awt.Color;
import java.awt.Graphics;

import entidades.Entidad;


public class EstadoJuego extends Estado {

	private Entidad personaje;
	private Mapa mundo;

	public EstadoJuego(Juego juego) {
		super(juego);
		mundo = new Mapa(juego, "recursos/mundo1.txt");
	    personaje = new Entidad(juego, mundo, 64, 64, 0, 0, RecursoGrafico.ogro, 150);
	}

	@Override
	public void actualizar() {
		mundo.actualizar();
		personaje.actualizar();
	}

	@Override
	public void graficar(Graphics g) {
		g.drawImage(RecursoGrafico.fondoDelJuego, 0, 0, juego.getAncho(), juego.getAlto(), null);
		mundo.graficar(g);
		personaje.graficar(g);
		}
	
	public Entidad getPersonaje() {
		return personaje;
	}
}
