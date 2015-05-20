package processToolBar;

import java.awt.Dimension;

import javax.swing.JToolBar;

import observers.ProcessesObserver;

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
			servicesBar.setVisibility(false);
			tasksBar.setVisible(false);
			break;
		case "service":
			processesBar.setVisible(false);
			servicesBar.setVisibility(true);
			tasksBar.setVisible(false);
		    break;
		case "task":
			processesBar.setVisible(false);
			servicesBar.setVisibility(false);
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

	public void setProcessesObserver(ProcessesObserver processesObserver) {
		processesBar.setObserver(processesObserver);
		
	}

}
