package processToolBar;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class StartProcessButton extends JButton {
	
	protected StartProcessButton(){
		try {
		    Image img = ImageIO.read(getClass().getResource("StartProcess.png"));
		    this.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		this.setToolTipText("Start Process");
	}
}
