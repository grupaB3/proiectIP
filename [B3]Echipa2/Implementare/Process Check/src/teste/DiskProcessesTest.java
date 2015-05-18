package teste;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.List;
import model.Proces;
import org.junit.Test;
import check.DiskProcesses;

public class DiskProcessesTest {
	@Test
	public void testShowActivity() throws Exception {
		DiskProcesses dp = new DiskProcesses();
		List<Process> listaProcese = new ArrayList<Process>();
		List<Proces> rezultat = dp.showActivity();
		assertFalse(rezultat.isEmpty());
	}
}
