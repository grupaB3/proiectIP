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
		

}
