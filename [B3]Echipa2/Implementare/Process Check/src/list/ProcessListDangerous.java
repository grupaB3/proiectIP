package list;

import java.util.ArrayList;
import java.util.List;
import check.ProcessAnalyzer;
import model.MaliciousProcess;

public class ProcessListDangerous extends Observable {

	
	public ProcessListDangerous(List<Process> allProcesses) {
		super(allProcesses);
	}

	public List<MaliciousProcess> scan(int[] listPID)
	{
		ProcessAnalyzer analyzer = new ProcessAnalyzer();
		MaliciousProcess process = new MaliciousProcess();
		List<MaliciousProcess> list = new ArrayList();
		for(int i=0;i<listPID.length;i++){
			process = analyzer.analyzeProcess(listPID[i]);
			if(process != null)
				list.add(process);
		}
		return list;
		
	}
	
	public List<MaliciousProcess> scan(List<String> listPath)
	{
		ProcessAnalyzer analyzer = new ProcessAnalyzer();
		MaliciousProcess process = new MaliciousProcess();
		List<MaliciousProcess> list = new ArrayList();
		for(String p : listPath){
			process = analyzer.analyzeFile(p);
			if(process != null)
				list.add(process);
		}
		return list;
		
	}
	public Process findProcess(Process proces){
		return proces;}
	
	public void showActivity(){}
	
}
