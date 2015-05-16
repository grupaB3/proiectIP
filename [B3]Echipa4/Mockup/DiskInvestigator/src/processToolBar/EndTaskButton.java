package processToolBar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import dialogs.WarningDialog;

public class EndTaskButton extends JButton {

	private static final long serialVersionUID = -7886632775613251506L;
	private WarningDialog warning;
	
	public EndTaskButton(){
		try {
		    Image img = ImageIO.read(getClass().getResource("stopTask.png"));
		    this.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		this.setToolTipText("End Task");
		
		
		this.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {
	            //Execute when button is pressed
	            warning = new WarningDialog();
	            warning.displayMessage("The current task will be terminated. Press OK to continue");
	            if(warning.displayConfirmDialog() == 1)
	            {		        
	            	 //removeSelectedRow(); (din clasa TaskListArea)??     	
	            }
	        }
	    }); 
	}
	
	
}
