package list;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import check.DigitalSignatureChecker;
import model.DigitalSignature;

public class ProcessListSuspicious extends Observable {
	
	public ProcessListSuspicious(List<Process> allProcesses) {
		super(allProcesses);
	}
	
	public List<DigitalSignature> scan(int[] listPID) throws IOException, InterruptedException
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
	
	public List<DigitalSignature> scan(List<String> listPath) throws IOException, InterruptedException
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
	
	
}
