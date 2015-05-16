package processToolBar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;

import dialogs.DialogWindow;
import displayArea.TaskListArea;


public class NewTaskButton extends JButton {

	private static final long serialVersionUID = 8036356612846484755L;
	private TaskListArea task = new TaskListArea();
	//private DialogWindow dialogWindow;
	
	protected NewTaskButton(){
		super("New Task");
		setPreferredSize(new Dimension(100,40));
		setMaximumSize(new Dimension(100,40));
		setMinimumSize(new Dimension(100,40));
		
		this.addActionListener(new ActionListener() {
			 
	        public void actionPerformed(ActionEvent e)
	        {
	        	String taskName;
	            //Execute when button is pressed
	        	//dialogWindow = new DialogWindow(); ??	        	
	        	taskName = JOptionPane.showInputDialog(null, "Enter task name:");
	    		task.insertRow(taskName);	        	
	        }
	    }); 
	}
}
