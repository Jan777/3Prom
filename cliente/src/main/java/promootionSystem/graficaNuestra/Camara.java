package promootionSystem.graficaNuestra;
// por ahora sin implementacion
public class Camara {
	public static final int ANCHO = 800;
	public static final int ALTO = 600;
	public int ancho;
	public int alto;
	
	public int xOffCamara; 
	public int yOffCamara; 
	
	
	
	public int getxOffCamara() {
		return xOffCamara;
	}



	public void setxOffCamara(int xOffCamara) {
		this.xOffCamara = xOffCamara;
	}



	public int getyOffCamara() {
		return yOffCamara;
	}



	public void setyOffCamara(int yOffCamara) {
		this.yOffCamara = yOffCamara;
	}



	public Camara(int ancho, int alto) {
		//	int xCamara= ancho/2 - (ancho/2)%32;
		//	int yCamara = alto/2 - (alto/2)%32;
			int x0 = 320; //ancho/2
			int y0 = 320;
			this.alto = alto;
			this.ancho = ancho;
			int auxX = y0 + (x0 / 2);
			int auxY = y0 - (x0 / 2);
			if(auxX < 0)
				auxX -= 31; // 32X64
			if(auxY < 0)
				auxY -= 31;
			auxX /= 32;
			auxY /= 32;
			xOffCamara = auxX+1; 
			yOffCamara = auxY+1;
		}


}
