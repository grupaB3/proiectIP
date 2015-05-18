package teste;

import static org.junit.Assert.*;
import model.MaliciousProcess;

import org.junit.Before;
import org.junit.Test;

public class MaliciousProcessTest {

	@Before
	public void testGetDetectionRatio(){
		
		MaliciousProcess mp = new MaliciousProcess();
		mp.setNumberOfTests(0);
		int nrTeste = mp.getNumberOfTests();
		if(nrTeste == 0 && mp.getDetectionRatio() != 0)
			fail("Calcul gresit! Pentru un numar de 0 teste efectuate gradul de infectare al procesului nu poate fi mai mare de 0!");
	}
	
	
	@Test
	public void testGetDetectionRatio1()  {
		
		MaliciousProcess mp1 =  new MaliciousProcess();
		mp1.setNumberOfTests(5);
		mp1.setTestsFailed(3);
		int testePicate = mp1.getTestsFailed();
		
		if(testePicate !=0 && mp1.getDetectionRatio() == 0 )
			fail("Metoda de calculare a gradului de infectare a procesului nu functioneaza!");
	}
	
	@Before
	public void testMaliciousProcess(){
		MaliciousProcess m = new MaliciousProcess();
		
		if( m.getExecPath() != null)
			fail("exec");
		
		if( m.getVerified() != null)
			fail("verified");
		
		if( m.getPublisher() != null)
			fail("publ");
		
		if( m.getDescription() != null)
			fail("desc");
		
		if( m.getProduct() != null)
			fail("prod");
		
		if( m.getNumberOfTests() != 0)
			fail("test");
		
		if( m.getTestsFailed() != 0)
			fail("failed");	
	}
	
	@Test
	public void testMaliciousProcesses() {
		MaliciousProcess mp = new MaliciousProcess("asdf","asdd","asda","asdfs","asaf",123,324);
		if( mp.getExecPath() != "asdf")
			fail("execPath");
		
		if(mp.getVerified() != "asdd")
			fail("verified");
		
		if(mp.getPublisher() != "asda")
			fail("publisher");
		
		if(mp.getDescription() != "asdfs")
			fail("description");
		
		if(mp.getProduct() !=  "asaf")
			fail("product");
		
		if( mp.getNumberOfTests() != 123)
			fail("numberTest");
		
		if( mp.getTestsFailed() != 324)
			fail("failedTest");
		
		if ( mp.getDetectionRatio() == 0)
			fail("detection");
	}

}
