package promotionSystem;

public class PersonajesDeUndertale extends Personaje{

	public PersonajesDeUndertale(String casta) {
		if(casta.equals("Sans")){
			energia=110;
			salud=1;
			ataque=8;
			defensa=1;
			magia=7;
			experiencia=0;
			nivel=1;
		}
		else if(casta.equals("Flowie")){
			energia=115;
			salud=130;
			ataque=11;
			defensa=6;
			magia=9;
			experiencia=0;
			nivel=1;
		}
		else if(casta.equals("Chara")){
			energia=110;
			salud=1;
			ataque=8;
			defensa=1;	
			magia=7;
			experiencia=0;
			nivel=1;
		}
//		else{
//			throws PersonajeInvalidoException();
//		}
	}
}
