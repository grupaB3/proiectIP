package processToolBar;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StopServiceButton extends JButton {

	private static final long serialVersionUID = 3259570067502408586L;

	protected StopServiceButton(){
		try {
		    Image img = ImageIO.read(getClass().getResource("StopService.png"));
		    this.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		this.setToolTipText("Stop Service");
	}
}