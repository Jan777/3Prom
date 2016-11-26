package promotionSystem.juego;

import java.applet.Applet;
import java.applet.AudioClip;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;


public class Sonido extends Applet{


	
	public AudioClip audioClip;
	
	public Sonido(String nombre) throws MalformedURLException{
		File archivo=new File("Recursos/Musica/"+nombre+".wav");
		audioClip=Applet.newAudioClip(new URL("file:"+archivo.getAbsolutePath()));
		 
	}
	
	public void reproducir(){
		audioClip.loop();
	}
	
	public void cerrar(){
		audioClip.stop();
	}


	public void reproducirUnaVez() {
		audioClip.play();
		
	}

}
