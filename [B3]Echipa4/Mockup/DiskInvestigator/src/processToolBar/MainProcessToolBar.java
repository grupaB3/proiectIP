package processToolBar;

import java.awt.Dimension;

import javax.swing.JToolBar;

public class MainProcessToolBar extends JToolBar {
	
	private static final long serialVersionUID = 7329710301817502536L;
	
	private ProcessToolBar processesBar = new ProcessToolBar();
	private ServiceToolBar servicesBar = new ServiceToolBar();
	private TaskToolBar tasksBar = new TaskToolBar();
	
	public MainProcessToolBar() {
		
		setFloatable(false);
		setPreferredSize(new Dimension(100, 70));
	}
	
	public void initializeBars() {
		
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

	public ServiceToolBar getServicesBar() {
		return servicesBar;
	}

	protected void setServicesBar(ServiceToolBar servicesBar) {
		this.servicesBar = servicesBar;
	}

}
