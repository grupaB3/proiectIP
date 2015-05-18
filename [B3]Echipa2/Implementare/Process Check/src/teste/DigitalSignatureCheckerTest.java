package teste;

import static org.junit.Assert.*;
import java.io.IOException;
import model.DigitalSignature;
import org.junit.Test;
import check.DigitalSignatureChecker;

public class DigitalSignatureCheckerTest {

	@Test
	public void testCheckInt() throws IOException, InterruptedException {
		DigitalSignatureChecker dsc = new DigitalSignatureChecker();
		DigitalSignature ds = new DigitalSignature();
		int pId = 12123132;
		DigitalSignature rezultat = new DigitalSignature();
		rezultat = dsc.check(pId);
		if(rezultat != null)
			fail("");
		
	}

	@Test
	public void testCheckString() throws IOException, InterruptedException {
		DigitalSignatureChecker dsc = new DigitalSignatureChecker();
		String execPath = "asdkjfd";
		DigitalSignature rezultat = new DigitalSignature();
		rezultat = dsc.check(execPath);
		if(rezultat != null)
			fail("");
	}

}
