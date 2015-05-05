package controller;

import java.io.IOException;

import list.ProcessListDangerous;
import list.ProcessListSecure;
import list.ProcessListSuspicious;
import model.FileList;
import model.SecureDelete;

public class Controller {
	private SecureDelete destroyer;
	private ProcessListSecure safeProcesses;
	private ProcessListSuspicious suspiciousProcesses;
	private ProcessListDangerous dangerousProcesses;
	private FileList files;
	
	
	public Controller (SecureDelete destroyer,ProcessListSecure safeProcesses,ProcessListSuspicious suspiciousProcesses,ProcessListDangerous dangerousProcesses,FileList files){
		this.destroyer = destroyer;
		this.safeProcesses = safeProcesses;
		this.suspiciousProcesses = suspiciousProcesses;
		this.dangerousProcesses = dangerousProcesses;
		this.files = files;
	}
	
	public boolean deleteFile(String path) throws IOException{
		return destroyer.delete(path);
	}
	
	public void showProcessesSafe(){
		safeProcesses.showProcess();
	}
	
	public void showFiles(){
		files.showFiles();
	}
	
	public void showProcessesSuspicious(){
		suspiciousProcesses.showProcess();
	}
	
	public void showProcessesDangerous(){
		dangerousProcesses.showProcess();
	}
	
	public void scanProcess(int pid){}
	
	public void safeProcessesActivity(){
		safeProcesses.showActivity();
	}
	public void suspiciousProcessesActivity(){
		suspiciousProcesses.showActivity();
	}
	public void dangerousProcessesActivity(){
		dangerousProcesses.showActivity();
	}
	
	public void startMonitoringSafe(){
		safeProcesses.startMonitoring();
	}
	public void startMonitoringSuspicious(){
		suspiciousProcesses.startMonitoring();
	}
	public void startMonitoringDangerous(){
		dangerousProcesses.startMonitoring();
	}
	
	public void stopMonitoringSafe(){
		safeProcesses.stopMonitoring();
	}
	public void stopMonitoringSuspicious(){
		suspiciousProcesses.stopMonitoring();
	}
	public void stopMonitoringDangerous(){
		dangerousProcesses.stopMonitoring();
	}
}
