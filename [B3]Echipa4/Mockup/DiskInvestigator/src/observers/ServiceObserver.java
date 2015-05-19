package observers;


import items.ServiceHandler;

public class ServiceObserver {
	private ServiceHandler serviceHandler;

	public ServiceObserver(ServiceHandler serviceHandler) {
		setServiceHandler(serviceHandler);
	}

	public ServiceHandler getServiceHandler() {
		return serviceHandler;
	}

	public void setServiceHandler(ServiceHandler serviceHandler) {
		this.serviceHandler = serviceHandler;
	}
	
	public void start(String service){
		serviceHandler.startService(service);
	}
	public void stop(String service){
		serviceHandler.stopService(service);
	}
	public void displayServices(){
		serviceHandler.display();
	}

}
