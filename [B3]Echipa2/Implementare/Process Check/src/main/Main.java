package main;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import controller.ProcessCheck;
import model.DigitalSignature;
import model.MaliciousProcess;
import model.Proces;

public class Main 
{
	public static void main(String args[]) throws Exception
	{
		ProcessCheck lista = new ProcessCheck();
		List<Proces> processList = new ArrayList();
		int[] pidList = new int[5];
		pidList[0] = 4900;
		pidList[1] = 2036;
		pidList[2] = 1760;
		pidList[3] = 1844;
		pidList[4] = 4304;
		
		processList = lista.showActiviy();
		
		for(Proces p : processList)
			System.out.println(p.showActivity());
	}
}
