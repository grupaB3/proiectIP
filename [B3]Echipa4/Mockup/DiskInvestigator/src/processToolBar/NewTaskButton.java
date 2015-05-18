package processToolBar;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class NewTaskButton extends JButton {

	private static final long serialVersionUID = 8036356612846484755L;
	//private TaskListArea task = new TaskListArea();
	//private DialogWindow dialogWindow;
	
	protected NewTaskButton(){
		try {
		    Image img = ImageIO.read(getClass().getResource("startTask.png"));
		    this.setIcon(new ImageIcon(img));
		  } catch (IOException ex) {
		  }
		this.setToolTipText("New Task");
		
		this.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {
	        	//String taskName;
	            //Execute when button is pressed
	        	//dialogWindow = new DialogWindow(); ??	        	
//	        	taskName = JOptionPane.showInputDialog(null, "Enter task name:");
//	    		task.insertRow(taskName);	        	
	        }
	    }); 
	}
}
