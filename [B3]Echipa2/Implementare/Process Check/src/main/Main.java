package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import check.DigitalSignatureChecker;
import controller.ProcessCheck;
import model.DigitalSignature;
import model.MaliciousProcess;
import model.Proces;

public class Main 
{
	public static void main(String args[]) throws Exception
	{
		ProcessCheck lista = new ProcessCheck();
		int[] pidList = new int[150];
		/*pidList[0] = 4040;
		pidList[1] = 6216;
		pidList[2] = 123;
		pidList[3] = 4088;
		pidList[4] = 6216;*/
		
		/*List<String> l = new ArrayList<String>();
		l.add("d:\\Jocuri\\Origin Games\\Battlefield 3\\bf3.exe");
		l.add("asdasdasasdasdasd");*/
		
		
		List<Proces> processList = new ArrayList();
		processList = lista.showActiviy();
		int i=0;
		for(Proces p : processList)
		{
			pidList[i]=p.getPID();
			i++;
		}
		
		/*List<DigitalSignature> listaDigital = new ArrayList<DigitalSignature>();
		listaDigital = lista.verify(l);
		
		for(DigitalSignature d : listaDigital)
		{
			System.out.println(d.getName());
			System.out.println(d.isSigned());
			System.out.println(d.getDescription());
			System.out.println(d.getFileVerison());
			System.out.println(d.getProduct());
			System.out.println(d.getPublisher());
			System.out.println(d.getSigningDate());
			System.out.println(d.getProductVersion());
		}*/
		
		List<MaliciousProcess> listaMalicious = new ArrayList<MaliciousProcess>();
		listaMalicious = lista.scan(pidList);
		int j=1;
		for(MaliciousProcess p : listaMalicious)
		{
			if(p!=null)
			{
				System.out.println(j++);
				System.out.println(p.getExecPath());
				System.out.println(p.getDetectionRatio());
				System.out.println(p.getVerified());
				System.out.println(p.getDescription());
				System.out.println(p.getProduct());
				System.out.println(p.getPublisher());
				System.out.println(p.getNumberOfTests());
				System.out.println(p.getTestsFailed());
			}
			//catch (NullPointerException e)
			//{
			//	continue;
			//}
		}
		
		//System.out.println(lista.delete("d:\\Patch_0.4.exe"));
		
		
	}
}
