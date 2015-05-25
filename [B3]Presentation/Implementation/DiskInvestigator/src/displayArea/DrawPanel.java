package displayArea;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

@SuppressWarnings("serial")
class DrawPanel extends JPanel {
	
	public void paint(Graphics g) {
		Graphics2D g2d = (Graphics2D)g;
		try {
			
			BufferedImage bi = ImageIO.read(new File(getClass().getResource("/displayArea/background.png").toURI()));
			g2d.drawImage(bi, 0, 0, 900, 440, null);
		} catch (IOException | URISyntaxException e) {
		}
	}
}