package items;


import displayArea.ServicesDisplayer;

public class ServiceHandler {
	private ServicesDisplayer serviceDisplayer;
	private String selectedService = null;	


	public void startService(String service) {
		//start service - module 1
		this.setSelectedService(service);
		

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

	public void setSelectedService(String service){
		this.selectedService = service;
	}
	public String getSelectedService(){
		return selectedService;
	}
	

}
