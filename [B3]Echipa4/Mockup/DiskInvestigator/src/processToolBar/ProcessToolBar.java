package processToolBar;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JToolBar;

public class ProcessToolBar extends JToolBar {
	private ProcessScan processScan = new ProcessScan();
	private ProcessCheck processCheck = new ProcessCheck();
	private JToolBar processesBar = new JToolBar();
	private JToolBar servicesBar = new JToolBar();
	private JToolBar tasksBar = new JToolBar();
	
	public ProcessToolBar(){
		
		setFloatable(false);
		setPreferredSize(new Dimension(100, 70));
	}
	
	public void initializeButtons() {
		processesBar.add(new JLabel("                 "));
		processesBar.add(processCheck.getCheckButton());
		processesBar.add(new JLabel("                 "));
		processesBar.add(processScan.getEndButton());
		processesBar.setVisible(false);
		
		tasksBar.add(new JLabel("                 "));
		tasksBar.add(processScan.getNewTaskButton());
		tasksBar.setVisible(false);
		
		servicesBar.add(new JLabel("                 "));
		servicesBar.add(processScan.getNewTaskButton());
		servicesBar.setVisible(false);
		
		add(processesBar);
		add(servicesBar);
		add(tasksBar);
	}
	
	public void setToolBar(String option) {
		switch(option) {
		case "process":
			processesBar.setVisible(true);
			servicesBar.setVisible(false);
			tasksBar.setVisible(false);
			break;
		case "service":
			processesBar.setVisible(false);
			servicesBar.setVisible(true);
			tasksBar.setVisible(false);
		    break;
		case "task":
			processesBar.setVisible(false);
			servicesBar.setVisible(false);
			tasksBar.setVisible(true);

			break;
	}
	}
}
