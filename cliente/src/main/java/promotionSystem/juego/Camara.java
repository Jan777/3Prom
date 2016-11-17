package promotionSystem.juego;

public class Camara {
	private final int xOffCamara;
	private final int yOffCamara; 
	private final int alto;
	private final int ancho;

	public Camara(int ancho, int alto) {
	
		int xInicial = 320;
		int yInicial = 320;
		this.alto = alto;
		this.ancho = ancho;
		int auxiliarX = yInicial + (xInicial / 2);
		int auxiliarY = yInicial - (xInicial / 2);
		if(auxiliarX < 0)
			auxiliarX -= 31; 
		if(auxiliarY < 0)
			auxiliarY -= 31;
		auxiliarX /= 32;
		auxiliarY /= 32;
		xOffCamara = auxiliarX+1; 
		yOffCamara = auxiliarY+1;
	}
	
	public int getxOffCamara() {
		return xOffCamara;
	}

	public int getyOffCamara() {
		return yOffCamara;
	}

	public int getAncho() {
		return ancho;
	}
	public int getAlto() {
		return alto;
	}


}
