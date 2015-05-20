package observers;


import items.ProcessHandler;

public class ProcessesObserver {
	private ProcessHandler processHandler;
	
	public ProcessesObserver(ProcessHandler processHandler) {
		setProcessHandler(processHandler);
	}
	
	public void processCheck(){
			
	}
	
	public void setProcessHandler(ProcessHandler processHandler) {
		this.processHandler = processHandler;
	}
	
	public ProcessHandler getProcessHandler(){
		return processHandler;
	}
}
