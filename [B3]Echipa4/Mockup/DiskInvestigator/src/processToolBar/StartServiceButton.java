package processToolBar;

import java.awt.Image;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class StartServiceButton extends JButton {

	private static final long serialVersionUID = 3259570067502408586L;

	protected StartServiceButton(){
		try {
		    Image img = ImageIO.read(getClass().getResource("StartService.png"));
		    setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		setToolTipText("Start Service");
		/*addActionListener(new ActionListener() {
		     public void actionPerformed(ActionEvent ae) {
		         setEnabled(false);
		      }
		    }
		  );*/
	}
}
