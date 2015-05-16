package processToolBar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import dialogs.WarningDialog;

public class EndTaskButton extends JButton {

	private static final long serialVersionUID = -7886632775613251506L;
	private WarningDialog warning;
	
	public EndTaskButton(){
		super("End Task");
		setPreferredSize(new Dimension(100,40));
		setMaximumSize(new Dimension(100,40));
		setMinimumSize(new Dimension(100,40));		
		
		
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
