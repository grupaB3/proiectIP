package items;

import java.util.List;

import model.MaliciousProcess;
import model.ProcessT;
import controller.ProcessCheck;
import controller.ProcessMonitor;
import dialogs.ErrorDialog;
import dialogs.InputDialog;
import dialogs.WarningDialog;
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
		
		int[] pidList = new int[processList.size()];
		for(int i=0; i<processList.size();i++){
			pidList[i]=Integer.parseInt(processList.get(i).getPID());
		}
		ProcessCheck processCheck = new ProcessCheck();
		List<MaliciousProcess> maliciousList;
		maliciousList = processCheck.scan(pidList);
		System.out.println(maliciousList.size());
		if(!maliciousList.isEmpty()){
			
		for(int i=0; i<maliciousList.size();i++){
			if(maliciousList.get(i)!=null){
				System.out.println(maliciousList.get(i).getExecPath());
				System.out.println(maliciousList.get(i).getDetectionRatio());
			}
		}
	}
	}

	public void startProcesses(){
		if(!processDisplayer.getProcessListArea().isScanned()){
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
		
		if(!processDisplayer.getProcessListArea().isScanned()){
			WarningDialog warning = new WarningDialog();
			warning.displayMessage("Processes must be scanned first.");
			if(warning.displayConfirmDialog()==1){
				scanProcesses();
			}
		}
		else{
			String p;
			p = processDisplayer.getProcessListArea().getSelectedProcess();
			
			if(p == null){
				ErrorDialog errDialog = new ErrorDialog();
				errDialog.displayMessage("You must select a process to stop it!");
			}else{
				processMonitor.delete(p);

				//processList = processMonitor.getProcessList();
				//processDisplayer.getProcessListArea().setData(processList);
				System.out.println("Finished: Ended process "+ p);
			}
		}
	}
	
	public void scanProcesses() {
		if(processDisplayer.getProcessListArea().isScanned()) {
			ErrorDialog error = new ErrorDialog();
			error.displayMessage("Processes have already been scanned.");
		}
		else {
			processMonitor = new ProcessMonitor();
			processMonitor.connect();
			processMonitor.parse();
		
			processList = processMonitor.getProcessList();
			
			processDisplayer.getProcessListArea().setData(processList);
			processDisplayer.getProcessListArea().setScanned(true);
			
			processDisplayer.getProcessListArea().startRefresh();
		}
	}
	
	public List<ProcessT> getProcessList(){
		return processList;
	}
	public void setProcessList(List<ProcessT> p){
		processList = p;
	}
}