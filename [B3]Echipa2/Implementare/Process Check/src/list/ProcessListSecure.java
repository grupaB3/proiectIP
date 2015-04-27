package list;

import java.util.List;

public class ProcessListSecure extends Observable {
	private boolean monitoring;
	public ProcessListSecure(List<Process> allProcesses) {
		super(allProcesses);
		this.monitoring = false;
	}
	
	public boolean isMonitoring() {
		return monitoring;
	}
	
	public Process findProcess(Process proces){
		return proces;}
	public void showActivity(){}
	
	public void startMonitoring(){
		this.monitoring = true;
	}
	public void stopMonitoring(){
		this.monitoring = false;
	}
}
