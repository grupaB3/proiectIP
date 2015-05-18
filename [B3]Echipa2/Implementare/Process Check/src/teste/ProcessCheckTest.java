package teste;

import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.DigitalSignature;
import model.MaliciousProcess;
import model.Proces;

import org.junit.Test;

import controller.ProcessCheck;
import check.DigitalSignatureChecker;


public class ProcessCheckTest {

	
	@Test
	public void testVerifyInt() throws IOException, InterruptedException {
		List<Process> listaProcese = new ArrayList<Process>();
		ProcessCheck pc = new ProcessCheck();
		int[] listaPIDuri = {};
		List<DigitalSignature> lista = pc.verify(listaPIDuri);
		assertTrue(lista.isEmpty());
	}
	
	@Test
	public void testScanIntArray() {
		
		ProcessCheck pld = new ProcessCheck();
		int[] listaPId = {123,124,125};
		
		List<MaliciousProcess> rezultat = pld.scan(listaPId);
		assertTrue(rezultat.isEmpty());		
	}

	@Test
	public void testScanListOfString() {	
		ProcessCheck pld = new ProcessCheck();
		List<String> listaPath = Arrays.asList("asdf","123","asdh764");
		List<MaliciousProcess> rezultat = pld.scan(listaPath);
		assertTrue(rezultat.isEmpty());

	}

	@Test
	public void testVerifyIntArray() throws IOException, InterruptedException {	
		ProcessCheck pld = new ProcessCheck();
		int[] listaPId = {-1,124123123,0};
		List<DigitalSignature> rezultat = pld.verify(listaPId);
		assertTrue(rezultat.isEmpty());
	}

	@Test
	public void testVerifyListOfString() throws IOException, InterruptedException {
		ProcessCheck pld = new ProcessCheck();
		List<String> listaPath = Arrays.asList("asdf","123","asdh764");
		List<DigitalSignature> rezultat = pld.verify(listaPath);
		assertTrue(rezultat.isEmpty());
		
	}
	@Test
	public void testshowActivity() throws Exception {
		ProcessCheck pc = new ProcessCheck();
		List<Proces> ProcessList = new ArrayList<Proces>();
		List<Proces> list = pc.showActiviy();
		assertFalse(list.isEmpty());
	}

}

