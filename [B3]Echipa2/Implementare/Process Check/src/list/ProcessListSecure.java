package list;

import java.util.List;

import model.Proces;
import check.DiskProcesses;

public class ProcessListSecure extends Observable {
	private DiskProcesses diskProcesses = new DiskProcesses();
	public ProcessListSecure(List<Process> allProcesses) {
		super(allProcesses);
	}
	
	
	public Process findProcess(Process proces){
		return proces;}
	public List<Proces> showActivity() throws Exception{
		
		return diskProcesses.showActivity();
	}
	
	
}
