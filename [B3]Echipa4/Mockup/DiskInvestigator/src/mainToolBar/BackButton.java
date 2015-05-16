package mainToolBar;

import java.awt.Image;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BackButton extends JButton {
	
	private static final long serialVersionUID = 7412370022553305901L;

	public BackButton() {
		try {
		    Image img = ImageIO.read(getClass().getResource("back.png"));
		    this.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		this.setToolTipText("Back");
	}
}
