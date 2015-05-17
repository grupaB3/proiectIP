package processToolBar;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class ProcessScanButton extends JButton{

	private static final long serialVersionUID = 1378373445586830621L;

	protected ProcessScanButton(){
		try {
		    Image img = ImageIO.read(getClass().getResource("ProcessScan.png"));
		    this.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		this.setToolTipText("Scan Processes");
	}
}
