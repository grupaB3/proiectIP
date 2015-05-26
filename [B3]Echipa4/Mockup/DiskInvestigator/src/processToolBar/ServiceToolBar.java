package processToolBar;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JToolBar;

import observers.ServiceObserver;

public class ServiceToolBar extends JToolBar {

	private static final long serialVersionUID = 3806074614969488448L;
	
	private StartServiceButton startServiceButton = new StartServiceButton();
	private StopServiceButton stopServiceButton = new StopServiceButton();
	private StartupTypeBox startupTypeBox = new StartupTypeBox();
	private ServiceObserver serviceObserver;
	
	public ServiceToolBar() {	
		setFloatable(false);
		setPreferredSize(new Dimension(100, 70));
		
		initializeButtons();
	}
	
	private void initializeButtons() {
		add(new JLabel("             "));
		add(startServiceButton);
		add(new JLabel("             "));
		add(stopServiceButton);
		add(new JLabel("             "));
		add(startupTypeBox);
	}
	
	public ServiceObserver getServiceObserver() {
		return serviceObserver;
	}

	public void setServiceObserver(ServiceObserver serviceObserver) {
		this.serviceObserver = serviceObserver;
		startServiceButton.setServiceObserver(serviceObserver);
		stopServiceButton.setServiceObserver(serviceObserver);
		startupTypeBox.setServiceObserver(serviceObserver);
	}

	public void setVisibility(boolean status) {
		setVisible(status);
	}
}