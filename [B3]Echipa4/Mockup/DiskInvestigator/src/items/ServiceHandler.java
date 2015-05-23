package items;


import displayArea.ServicesDisplayer;

public class ServiceHandler {
	private ServicesDisplayer serviceDisplayer;
	//private String selectedService = null;	


	public void startService(){
		
		serviceDisplayer.getServiceListArea().StartServiceButton();
	}
	
	public void stopService(String service) {
		//stop service - module 1
		
	}
	
	public ServicesDisplayer getServiceDisplayer() {
		return serviceDisplayer;
	}

	public void setServiceDisplayer(ServicesDisplayer serviceDisplayer) {
		this.serviceDisplayer = serviceDisplayer;
	}



}
