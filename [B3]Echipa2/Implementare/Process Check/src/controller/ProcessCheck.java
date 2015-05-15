package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import check.DigitalSignatureChecker;
import check.DiskProcesses;
import check.ProcessAnalyzer;
import model.DigitalSignature;
import model.MaliciousProcess;
import model.Proces;
import model.SecureDelete;

public class ProcessCheck{

	public ProcessCheck() {}

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
	
	public List<DigitalSignature> verify(int[] listPID) throws IOException, InterruptedException
	{
		DigitalSignatureChecker analyzer = new DigitalSignatureChecker();
		DigitalSignature process = new DigitalSignature();
		List<DigitalSignature> list = new ArrayList();
		for(int i=0;i<listPID.length;i++){
			process = analyzer.check(listPID[i]);
			if(process != null)
				list.add(process);
		}
		return list;
	}
	
	public List<DigitalSignature> verify(List<String> listPath) throws IOException, InterruptedException
	{
		DigitalSignatureChecker analyzer = new DigitalSignatureChecker();
		DigitalSignature process = new DigitalSignature();
		List<DigitalSignature> list = new ArrayList();
		for(String s : listPath){
			process = analyzer.check(s);
			if(process != null)
				list.add(process);
		}
		return list;
	}
	
	public boolean delete(String path) throws IOException
	{
		SecureDelete destroyer = new SecureDelete();
		return destroyer.delete(path);
	}
	
	public List<Proces> showActiviy() throws Exception
	{
		DiskProcesses diskProcess = new DiskProcesses();
		return diskProcess.showActivity();
		
	}

}
