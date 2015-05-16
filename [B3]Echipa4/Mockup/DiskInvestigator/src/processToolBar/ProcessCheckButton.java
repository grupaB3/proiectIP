package processToolBar;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ProcessCheckButton extends JButton {

	private static final long serialVersionUID = -604762861486061083L;

	protected ProcessCheckButton(){
		try {
		    Image img = ImageIO.read(getClass().getResource("ProcessCheck2.png"));
		    this.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		this.setToolTipText("Check Process");
	}
}
