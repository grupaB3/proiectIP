package observers;


import javax.swing.SwingWorker;

import items.ProcessHandler;

public class ProcessesObserver {
	private ProcessHandler processHandler;
	
	public ProcessesObserver(ProcessHandler processHandler) {
		setProcessHandler(processHandler);
	}
	
	public void startScan() {
	
	//	SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>(){
	//			@Override
	//			protected Void doInBackground() throws Exception {
	//				boolean intermediary = processHandler.getProcessDisplayer().getProcessListArea().isFocus();
	//				while(intermediary) {
	//					processHandler.scanProcesses();
	//					Thread.sleep(5000);
	//					intermediary = processHandler.getProcessDisplayer().getProcessListArea().isFocus();
	//				}
	//				return null;
	//			}
	//		};
	//	mySwingWorker.execute();
		processHandler.scanProcesses();
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
