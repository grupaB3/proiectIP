package processToolBar;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;

import dialogs.ErrorDialog;
import observers.ServiceObserver;

@SuppressWarnings("serial")
public class StartupTypeBox extends JComboBox<String> {
	private ServiceObserver serviceObserver;
	
	protected StartupTypeBox() {
		String[] choices = {"Automatic", "Manual", "Disabled", "Delayed-auto"};

		insertItemAt("", 0);
		initBox(choices);
		setMinimumSize(new Dimension(100, 30));
		setMaximumSize(new Dimension(100, 30));
	}
	
	private void initBox(String[] choices) {
		for(int index = 0; index < choices.length; index ++) {
			addItem(choices[index]);
		}
		
		addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				if(serviceObserver.getServiceHandler().getServiceDisplayer().getServiceListArea().getSelectedStatus() == -1) {
					ErrorDialog error = new ErrorDialog();
					error.displayMessage("You have to select a service first.");
					setSelectedItem("");
				}
				else 
					if(!getSelectedItem().toString().equals("")) {
						serviceObserver.getServiceHandler().changeStartup(getSelectedItem().toString());
					}
			}
		});
	}

	public void setServiceObserver(ServiceObserver serviceObserver) {
		this.serviceObserver = serviceObserver;
	}
	
	public ServiceObserver getServiceObserver() {
		return serviceObserver;
	}
}