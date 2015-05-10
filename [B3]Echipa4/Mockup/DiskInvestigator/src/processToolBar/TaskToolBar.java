package processToolBar;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JToolBar;

public class TaskToolBar extends JToolBar {

	private static final long serialVersionUID = 320025258233085654L;
	
	private NewTaskButton newTaskButton = new NewTaskButton();
	private EndTaskButton endTaskButton = new EndTaskButton();
	public TaskToolBar() {	
		setFloatable(false);
		setPreferredSize(new Dimension(100, 70));
		
		initializeButtons();
	}
	
	private void initializeButtons() {
		add(new JLabel("                 "));
		add(newTaskButton);
		add(new JLabel("                 "));
		add(endTaskButton);
	}
}