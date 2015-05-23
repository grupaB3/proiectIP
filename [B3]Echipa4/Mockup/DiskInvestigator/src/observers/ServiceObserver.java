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

	
	public void startService(){
		//System.out.println("Observer");
		serviceHandler.startService();
	}

	public void stop(String service){
		serviceHandler.stopService(service);
	}

}
