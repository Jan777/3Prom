package promotionSystem.pantallaJuego.resources.recursos;

import java.awt.image.BufferedImage;

public class HojaDeSprite {

	private BufferedImage sprite;
	
	public HojaDeSprite(BufferedImage sprite) {
		this.sprite = sprite;
	}
	
	public BufferedImage getTile(int x, int y, int ancho, int alto) {
		return sprite.getSubimage(x, y, ancho, alto);
	}
}