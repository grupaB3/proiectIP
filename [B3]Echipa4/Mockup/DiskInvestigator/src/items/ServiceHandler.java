package items;

import controller.ServiceMonitor;
import dialogs.ErrorDialog;
import displayArea.ServicesDisplayer;

public class ServiceHandler {
	private ServicesDisplayer serviceDisplayer;

	public void startService(){
		serviceDisplayer.getServiceListArea().StartServiceButton();
	}
	
	public void stopService() {
		serviceDisplayer.getServiceListArea().StopServiceButton();
	}
	
	public ServicesDisplayer getServiceDisplayer() {
		return serviceDisplayer;
	}

	public void setServiceDisplayer(ServicesDisplayer serviceDisplayer) {
		this.serviceDisplayer = serviceDisplayer;
	}

	public void changeStartup(String startupType) {
		int selectedStatus = serviceDisplayer.getServiceListArea().getSelectedStatus();
		if(selectedStatus!=-1) {
			ServiceMonitor serviceMonitor = new ServiceMonitor();
			String result = null;
			String newStartupType = null;
			
			switch(startupType) {
				case "Automatic":
					result = serviceMonitor.changeStartup(serviceDisplayer.getServiceListArea()
											.getSelectedName(selectedStatus), "auto");
					newStartupType = " 2  AUTO_START";
					break;
				case "Manual":
					result = serviceMonitor.changeStartup(serviceDisplayer.getServiceListArea()
											.getSelectedName(selectedStatus), "demand");
					newStartupType = " 3  DEMAND_START";
					break;
				case "Disabled":
					result = serviceMonitor.changeStartup(serviceDisplayer.getServiceListArea()
											.getSelectedName(selectedStatus), "disabled");
					newStartupType = " 4  DISABLED";
					break;
				case "Delayed-auto":
					result = serviceMonitor.changeStartup(serviceDisplayer.getServiceListArea()
											.getSelectedName(selectedStatus), "delayed-auto");
					newStartupType = " 2  AUTO_START (DELAYED)";
					break;
			}
			
			if(result.equals("Failed @changeStartup")) {
				ErrorDialog error = new ErrorDialog();
				error.displayMessage("The service failed to change its mode");
			}
			else {
				serviceDisplayer.getServiceListArea().changeStartupStatus(newStartupType, selectedStatus);
			}
		}
	}
}
