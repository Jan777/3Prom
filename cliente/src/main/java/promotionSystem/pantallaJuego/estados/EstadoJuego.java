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
	private Mapa mapa;

	public EstadoJuego(Juego juego) {
		super(juego);
		mapa = new Mapa(juego, "recursos/mundo1.txt");
	    personaje = new Entidad(juego, mapa, 64, 64, 0, 0, RecursoGrafico.pokemon, 150);
	}

	@Override
	public void actualizar() {
		mapa.actualizar();
		personaje.actualizar();
	}

	@Override
	public void graficar(Graphics g) {
		g.drawImage(RecursoGrafico.fondoDelJuego, 0, 0, juego.getAncho(), juego.getAlto(), null);
		mapa.graficar(g);
		personaje.graficar(g);
		}
	
	public Entidad getPersonaje() {
		return personaje;
	}
}
