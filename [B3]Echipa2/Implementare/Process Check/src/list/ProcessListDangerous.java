package list;

import java.util.List;

public class ProcessListDangerous extends Observable {

	private boolean monitoring;
	public ProcessListDangerous(List<Process> allProcesses) {
		super(allProcesses);
	}

	public boolean isMonitoring() {
		return monitoring;
	}
	
	public Process findProcess(Process proces){
		return proces;}
	public void showActivity(){}
	public boolean suspend(Process proces){
		return monitoring;}
	public void scan(Process proces){}
	
	public void startMonitoring(){
		this.monitoring = true;
	}
	public void stopMonitoring(){
		this.monitoring = false;
	}
}
