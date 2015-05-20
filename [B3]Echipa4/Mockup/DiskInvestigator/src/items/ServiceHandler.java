package items;

import java.util.List;

import controller.ServiceMonitor;
import displayArea.ServicesDisplayer;

public class ServiceHandler {
	private ServicesDisplayer serviceDisplayer;
	private String selectedService = null;
	@SuppressWarnings("unused")
	private List<model.Service> services;
	@SuppressWarnings("unused")
	private ServiceMonitor sm = new ServiceMonitor();
	
	public void display(){
		
		//sm.initiliaze();
		//sm.connect();
		//sm.parse();
		//this.setServicesList(sm.getServicesList());		
		//serviceDisplayer.getServiceListArea().setData(services);
	}
	public void setServicesList(List<model.Service> list){
		services = list;
	}
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
