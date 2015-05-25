package items;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

import javax.swing.SwingWorker;

import model.MaliciousProcess;
import model.ProcessT;
import controller.ProcessCheck;
import controller.ProcessMonitor;
import dialogs.ErrorDialog;
import dialogs.InputDialog;
import dialogs.ProcessesLoadingDialog;
import dialogs.WarningDialog;
import displayArea.ProcessesDisplayer;

public class ProcessHandler {

	private ProcessesDisplayer processDisplayer;
	private ProcessMonitor processMonitor;
	private List<ProcessT> processList;
	private ProcessesLoadingDialog processLoading;
	@SuppressWarnings("unused")
	private double maliciousRatio[];
	private int[] pidList;
	private List<MaliciousProcess> maliciousList;
	
	
	public ProcessesDisplayer getProcessDisplayer() {
		return processDisplayer;
	}

	public void setProcessDisplayer(ProcessesDisplayer processDisplayer) {
		this.processDisplayer = processDisplayer;
	}
	
	public void checkProcesses(){
		
		processLoading = new ProcessesLoadingDialog(this);
		processLoading.setVisibility(true);
		
		
		SwingWorker<Void, Void> mySwingWorker = new SwingWorker<Void, Void>(){
			@Override
			protected Void doInBackground() throws Exception {
		pidList = new int[processList.size()];
		for(int i=0; i<processList.size();i++){
			pidList[i]=Integer.parseInt(processList.get(i).getPID());
		}
		ProcessCheck processCheck = new ProcessCheck();
		
		maliciousList = processCheck.scan(pidList);
		if(!maliciousList.isEmpty()){
			
		for(int i=0; i<maliciousList.size();i++){
			if(maliciousList.get(i)!=null){
				
				processDisplayer.getProcessListArea().checkAndModify2(pidList[i],maliciousList.get(i).getDetectionRatio());
				
			}else processDisplayer.getProcessListArea().checkAndModify2(pidList[i],-1);
		}
		
		processDisplayer.getProcessListArea().setColorTable();
		
	}
		return null;
			}
		};
		
		
		mySwingWorker.addPropertyChangeListener(new PropertyChangeListener() {

			@Override
			public void propertyChange(PropertyChangeEvent evt) {
				if (evt.getPropertyName().equals("state")) {
					if (evt.getNewValue() == SwingWorker.StateValue.DONE) {
						processLoading.dispose();
					}
				}
			}
		});
		mySwingWorker.execute();

		processLoading.displayMessage("Checking...");
		
		
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
			InputDialog dialog = new InputDialog(this);
			dialog.displayMessage(null);
			
			if(processMonitor.create(dialog.getText()).contains("Succes"))
				{;}
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