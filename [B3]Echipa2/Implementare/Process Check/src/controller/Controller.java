package controller;

import java.io.IOException;
import java.util.List;

import list.ProcessListDangerous;
import list.ProcessListSecure;
import list.ProcessListSuspicious;
import model.Proces;
import model.SecureDelete;

public class Controller {
	private SecureDelete destroyer;
	private ProcessListSecure safeProcesses;
	private ProcessListSuspicious suspiciousProcesses;
	private ProcessListDangerous dangerousProcesses;
	
	
	public Controller (SecureDelete destroyer,ProcessListSecure safeProcesses,ProcessListSuspicious suspiciousProcesses,ProcessListDangerous dangerousProcesses){
		this.destroyer = destroyer;
		this.safeProcesses = safeProcesses;
		this.suspiciousProcesses = suspiciousProcesses;
		this.dangerousProcesses = dangerousProcesses;
	}
	
	public boolean deleteFile(String path) throws IOException{
		return destroyer.delete(path);
	}
	
	public void showProcessesSafe(){
		safeProcesses.showProcess();
	}
	
	
	public void showProcessesSuspicious(){
		suspiciousProcesses.showProcess();
	}
	
	public void showProcessesDangerous(){
		dangerousProcesses.showProcess();
	}
	
	public void scanProcess(int pid){
		
	}
	
	public List<Proces> safeProcessesActivity() throws Exception{
		return safeProcesses.showActivity();
	}
	
	public void dangerousProcessesActivity(){
		dangerousProcesses.showActivity();
	}
	
}

