package teste;

import static org.junit.Assert.*;
import java.io.IOException;
import model.SecureDelete;
import org.junit.Test;

public class SecureDeleteTest {
	@Test
	public void testDelete() throws IOException {
		SecureDelete p = new SecureDelete();
		String path = "asddfs";
		if(p.delete(path) == true)
			fail("Date introduse incorect");
	}

}
