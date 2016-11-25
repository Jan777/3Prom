package promotionSystem.razas.castas.undertale;

import org.junit.Assert;
import org.junit.Test;
import promotionSystem.Constantes;
import promotionSystem.razas.PersonajeDeStarWars;
import promotionSystem.razas.PersonajeDeUndertale;
import promotionSystem.razas.castas.starWars.Droide;

public class CharaTest {
	
		@Test
		public void siAumentaDeNivelAumentaLosStats(){
			Chara personaje=new Chara();
			Assert.assertEquals(1, personaje.getNivel());
			personaje.subirExperiencia(10);
			Assert.assertEquals(3, personaje.getNivel());

			Assert.assertEquals(Constantes.SALUD_CHARA +Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL *2, personaje.getSalud());
			Assert.assertEquals(Constantes.ENERGIA_MAXIMA_CHARA+Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL *2, personaje.getEnergia());
			Assert.assertEquals(Constantes.ATAQUE_CHARA +Constantes.MULTIPLICADOR_DE_NIVEL_ESPECIAL *2, personaje.obtenerPuntosDeAtaque());
			Assert.assertEquals(Constantes.DEFENSA_CHARA +Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL *2, personaje.obtenerPuntosDeDefensa());
			Assert.assertEquals(Constantes.MAGIA_CHARA +Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL *2, personaje.obtenerPuntosDeMagia());
			Assert.assertEquals(Constantes.VELOCIDAD_CHARA +Constantes.MULTIPLICADOR_DE_NIVEL_NORMAL *2, personaje.obtenerPuntosDeVelocidad());
		}
		
		@Test
		public void siAtacaAumentaElAtaqueYEnergia(){
			PersonajeDeUndertale personajeAtacante=new Chara();
			PersonajeDeStarWars personajeAtacado=new Droide();
			
			Assert.assertEquals(Constantes.ATAQUE_CHARA,personajeAtacante.obtenerPuntosDeAtaque());
			Assert.assertEquals(Constantes.ENERGIA_MAXIMA_CHARA,personajeAtacante.getEnergia());
			personajeAtacante.atacar(personajeAtacado);
			Assert.assertEquals(Constantes.ATAQUE_CHARA +1,personajeAtacante.obtenerPuntosDeAtaque());
			Assert.assertEquals(Constantes.ENERGIA_MAXIMA_CHARA-Constantes.ATAQUE_CHARA +1,personajeAtacante.getEnergia());
			
		}

}
