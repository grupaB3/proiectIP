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

/**
 * Clasa din care se vor apela functiile 
 * @author Razvan
 *
 */

public class ProcessCheck{

	public ProcessCheck() {}

	/**
	 * Scaneaza procesele primite prin PID.
	 * @param listPID Un vector de tip integer care contine PID proceselor active.
	 * @return O lista de obiecte MaliciousProcess care vor contine rezultatele scanarii pentru procese.
	 */
	public List<MaliciousProcess> scan(int[] listPID)
	{
		ProcessAnalyzer analyzer = new ProcessAnalyzer();
		MaliciousProcess process = new MaliciousProcess();
		List<MaliciousProcess> list = new ArrayList<MaliciousProcess>();
		for(int i=0;i<listPID.length;i++){
			process = analyzer.analyzeProcess(listPID[i]);
			if(process != null)
				list.add(process);
			
		}
		return list;
		
	}
	/**
	 * Scaneaza fisierele primite prin path-ul complet.
	 * @param listPath O lista de stringuri care contine path-ul complet al fisierelor care vor fi scanate.
	 * @return O lista de obiecte MaliciousProcess care vor contine rezultatele scanarii pentru fisiere.
	 */
	public List<MaliciousProcess> scan(List<String> listPath)
	{
		ProcessAnalyzer analyzer = new ProcessAnalyzer();
		MaliciousProcess process = new MaliciousProcess();
		List<MaliciousProcess> list = new ArrayList<MaliciousProcess>();
		for(String p : listPath){
			process = analyzer.analyzeFile(p);
			if(process != null)
				list.add(process);
		}
		return list;
		
	}
	
	/**
	 * Verifica daca procesele primite sunt semnate digital.
	 * Functia scan() face si verificarea semnaturii digitale dar aceasta functie ofera mai multe informatii.
	 * @param listPID listPID Un vector de tip integer care contine PID proceselor active.
	 * @return O lista de obiecte DigitalSignature care vor contine rezultatele verificarii pentru procese.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public List<DigitalSignature> verify(int[] listPID) throws IOException, InterruptedException
	{
		DigitalSignatureChecker analyzer = new DigitalSignatureChecker();
		DigitalSignature process = new DigitalSignature();
		List<DigitalSignature> list = new ArrayList<DigitalSignature>();
		for(int i=0;i<listPID.length;i++){
			process = analyzer.check(listPID[i]);
			if(process != null)
				list.add(process);
		}
		return list;
	}
	/**
	 * Verifica daca fisierele primite sunt semnate digital.
	 * Functia scan() face si verificarea semnaturii digitale dar aceasta functie ofera mai multe informatii.
	 * @param listPath listPath O lista de stringuri care contine path-ul complet al fisierelor care vor fi scanate.
	 * @return O lista de obiecte DigitalSignature care vor contine rezultatele verificarii pentru fisiere.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public List<DigitalSignature> verify(List<String> listPath) throws IOException, InterruptedException
	{
		DigitalSignatureChecker analyzer = new DigitalSignatureChecker();
		DigitalSignature process = new DigitalSignature();
		List<DigitalSignature> list = new ArrayList<DigitalSignature>();
		for(String s : listPath){
			process = analyzer.check(s);
			if(process != null)
				list.add(process);
		}
		return list;
	}
	/**
	 * Stergerea definitiva a unui fisier sau a unui director.
	 * @param path Un string catre fisierul respectiv(Path-ul complet).
	 * @return True daca sa sters. False daca nu s-a putut sterge sau fisierul nu exista
	 * @throws IOException
	 */
	public boolean delete(String path) throws IOException
	{
		SecureDelete destroyer = new SecureDelete();
		return destroyer.delete(path);
	}
	/**
	 * Activitatea proceselor active cu disk-ul. Cati biti au fost scrisi sau cititi de la pornirea procesului.
	 * @return O lista de obiecte Proces
	 * @throws Exception
	 */
	public List<Proces> showActiviy() throws Exception
	{
		DiskProcesses diskProcess = new DiskProcesses();
		return diskProcess.showActivity();
		
	}

}
