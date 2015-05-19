package items;

import displayArea.ServicesDisplayer;

public class ServiceHandler {
	private ServicesDisplayer serviceDisplayer;

	public void startService() {
		//start service - module 1
	}
	
	public void stopService() {
		//sstop service - module 1
	}
	
	public ServicesDisplayer getServiceDisplayer() {
		return serviceDisplayer;
	}

	public void setServiceDisplayer(ServicesDisplayer serviceDisplayer) {
		this.serviceDisplayer = serviceDisplayer;
	}
}
