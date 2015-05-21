package items;

import dialogs.InputDialog;
import displayArea.ProcessesDisplayer;

public class ProcessHandler {

	private ProcessesDisplayer processDisplayer;

	public ProcessesDisplayer getProcessDisplayer() {
		return processDisplayer;
	}

	public void setProcessDisplayer(ProcessesDisplayer processDisplayer) {
		this.processDisplayer = processDisplayer;
	}
	
	public void checkProcesses(){
		System.out.println("Am ajuns aici");
	}

	public void startProcesses(){
		System.out.println("Started process");
		InputDialog dialog = new InputDialog(this);
		dialog.displayMessage(null);
	}
	
	public void endProcesses(){
		System.out.println("Ended process");
	}
	
	public void scanProcesses(){
		System.out.println("Scanned process");
	}
}

