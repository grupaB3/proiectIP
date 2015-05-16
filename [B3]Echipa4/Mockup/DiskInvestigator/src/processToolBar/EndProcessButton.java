package processToolBar;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;


public class EndProcessButton extends JButton {

	private static final long serialVersionUID = -604762861486061083L;

	protected EndProcessButton(){
		try {
		    Image img = ImageIO.read(getClass().getResource("StopProcess.png"));
		    this.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		this.setToolTipText("End Process");
	}
}
