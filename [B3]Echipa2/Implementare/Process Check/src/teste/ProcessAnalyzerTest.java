package teste;

import static org.junit.Assert.*;
import model.MaliciousProcess;

import org.junit.Test;

import check.ProcessAnalyzer;

public class ProcessAnalyzerTest {
	@Test
	public void testAnalyzeProcess() {
		ProcessAnalyzer pa = new ProcessAnalyzer();
		MaliciousProcess mp = new MaliciousProcess();
		int pId = 1007870998;
		mp = pa.analyzeProcess(pId);
		if(mp.getExecPath() == null || mp.getExecPath() == "")
			fail("Date introduse incorect!");
		else
			if(mp.getDescription() == null || mp.getDescription() == "")
				fail("Date introduse incorect!");
			else
				if(mp.getPublisher() == null || mp.getPublisher() == "")
					fail("Date introduse incorect!");
	}

	
	@Test
	public void testAnalyzeFile() {
		ProcessAnalyzer pa = new ProcessAnalyzer();
		String fileName = "asdfds";
		if(pa.analyzeFile(fileName) == null )
			fail("Date introduse incorect!");
	}
}
