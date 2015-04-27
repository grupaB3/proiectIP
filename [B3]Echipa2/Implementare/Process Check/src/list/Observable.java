package list;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable {

	private List<Process> allProcesses = new ArrayList<Process>();
	
	public Observable (List<Process> allProcesses){
		this.allProcesses = allProcesses;
	}
	
	public void getAll(){}
	public void update(){}
	public void showActivity(){}
	public void showProcess(){}
}
