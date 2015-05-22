package items;

import java.util.List;

import model.ProcessT;
import controller.ProcessMonitor;
import dialogs.InputDialog;
import displayArea.ProcessesDisplayer;

public class ProcessHandler {

	private ProcessesDisplayer processDisplayer;
	private ProcessMonitor processMonitor;
	private List<ProcessT> processList;
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
		processMonitor = new ProcessMonitor();
		processMonitor.connect();
		processMonitor.parse();
		
		processList = processMonitor.getProcessList();
		
		processDisplayer.getProcessListArea().setData(processList);
		
	}
	
	public List<ProcessT> getProcessList(){
		return processList;
	}
}

