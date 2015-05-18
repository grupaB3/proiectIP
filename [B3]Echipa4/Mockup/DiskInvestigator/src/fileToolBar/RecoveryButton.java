package fileToolBar;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Image;
import java.io.IOException;

public class RecoveryButton extends JButton {
	
	private static final long serialVersionUID = 4049711543317874759L;

		public RecoveryButton() {
			try {
			    Image img = ImageIO.read(getClass().getResource("Recover.png"));
			    this.setIcon(new ImageIcon(img));
			  } catch (IOException ex) {
			  }
			setEnabled(false);
			this.setToolTipText("Recover File");
		}
	
}
