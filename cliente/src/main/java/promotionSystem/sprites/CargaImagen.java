
package promotionSystem.sprites;

import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class CargaImagen {

	public static BufferedImage cargarImagen(String path) {
		try {
			return ImageIO.read(new FileImageInputStream(new File(path)));
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "No se encuentra la imagen","Error",JOptionPane.ERROR_MESSAGE);
			System.exit(1);
		}
		return null;
	}
}
