package items;

import java.util.List;

import model.ProcessT;
import controller.ProcessMonitor;
import dialogs.ErrorDialog;
import dialogs.InputDialog;
import dialogs.WarningDialog;
import displayArea.ProcessesDisplayer;

public class ProcessHandler {

	private ProcessesDisplayer processDisplayer;
	private ProcessMonitor processMonitor;
	private List<ProcessT> processList;
	private boolean scanned = false;
	
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
		if(!scanned){
			WarningDialog warning = new WarningDialog();
			warning.displayMessage("Processes must be scanned");
			if(warning.displayConfirmDialog()==1){
				scanProcesses();
				startProcesses();
			}
			
		}else{
			System.out.println("Started process");
			InputDialog dialog = new InputDialog(this);
			dialog.displayMessage(null);
			
			if(processMonitor.create(dialog.getText()).contains("Succes"))
				System.out.println("Success:  Started "+dialog.getText());
			else{		
				ErrorDialog errDialog = new ErrorDialog();
				errDialog.displayMessage("Incorrect process name! (you have to include extension)"); //schimba??
			}
			
			//processList = processMonitor.getProcessList();
			//processDisplayer.getProcessListArea().setData(processList);
			
		}
	}
	
	public void endProcesses(){
		
		if(!scanned){
			WarningDialog warning = new WarningDialog();
			warning.displayMessage("Processes must be scanned first.");
			if(warning.displayConfirmDialog()==1){
				scanProcesses();
			}
		}
		else{
			ProcessT p;
			p = processDisplayer.getProcessListArea().getSelectedProcess();
			
			if(p == null){
				ErrorDialog errDialog = new ErrorDialog();
				errDialog.displayMessage("You must select a process to stop it!");
			}else{
				processMonitor.delete(p.getPID());
				
				//TODO 
				//processList = processMonitor.getProcessList();
				//processDisplayer.getProcessListArea().setData(processList);
				
				processDisplayer.getProcessListArea().deleteProcess(p);
				System.out.println("Finished: Ended process "+ p.getName());
			}
		}
	}
	
	
	public void scanProcesses(){
		processMonitor = new ProcessMonitor();
		processMonitor.connect();
		processMonitor.parse();
		
		processList = processMonitor.getProcessList();
		
		processDisplayer.getProcessListArea().setData(processList);
		scanned = true;
	}
	
	public List<ProcessT> getProcessList(){
		return processList;
	}
	public void setProcessList(List<ProcessT> p){
		processList = p;
	}
}

