package processToolBar;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.JToolBar;

public class ServiceToolBar extends JToolBar {

	private static final long serialVersionUID = 3806074614969488448L;
	
	private StartServiceButton startServiceButton = new StartServiceButton();
	private StopServiceButton stopServiceButton = new StopServiceButton();
	private StartupTypeBox startupTypeBox = new StartupTypeBox();
	
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
		
		startupTypeBox.setVisible(false);
	}
	
	public void setSelectedStatus(boolean newStatus) {
		if(newStatus) {
			startupTypeBox.setVisible(true);
		}
		else {
			startupTypeBox.setVisible(false);
		}
	}
}