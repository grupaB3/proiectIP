package check;


import java.io.*;
import java.util.ArrayList;
import java.util.List;

import model.Proces;

/**
 * Clasa DiskProcesses 
 * @author Razvan
 *
 */

public class DiskProcesses {
	/**
	 * Activitatea proceselor active cu disk-ul. Cati biti au fost scrisi sau cititi de la pornirea procesului.
	 * @return O lista de obiecte Proces.
	 * @throws Exception
	 */
	public List<Proces> showActivity() throws Exception {
		
		@SuppressWarnings("unused")
		String Node,Name=null,pID = null,ReadOpCount = null, ReadTransferCount = null, WriteOperationCount = null,
			WriteTransferCount = null;
		
        ProcessBuilder builder = new ProcessBuilder(
            "cmd.exe", "/c", "wmic process list io /format:csv");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));
        reader.readLine();reader.readLine();
        String line;
        String delimitator = ",";
        ArrayList<Proces> listaProcese = new ArrayList<Proces>();
        reader.readLine(); reader.readLine();
        
        while (true) {
            line = reader.readLine(); reader.readLine();
            if (line == null) { break; }
            String[] tokens = line.split(delimitator);
            int contor = 0, row = 0;
            for(String token : tokens){
       
            	row = contor%7;
            	
            	if (row == 0){
            		Node = token;
            		contor++;
            	}
            	if (row ==1){
            		Name = token;
            		contor++;
            	}
            	if (row == 2){
            		pID = token;
            		contor++;
            	}
            	if(row == 3){
            		ReadOpCount = token;
            		contor++;
            	}
            	if (row == 4){
            		ReadTransferCount = token;
            		contor++;
            	}
            	if (row == 5){
            		WriteOperationCount = token;
            		contor++;
            	}
            	if (row == 6){
            		WriteTransferCount = token;
            		contor++;
            	}
            	if(contor%7 ==0){
            		
            		Proces newProcess = new Proces();
            		newProcess.setActivity(Name, Integer.parseInt(pID), ReadTransferCount,ReadOpCount,WriteTransferCount,WriteOperationCount);
            		listaProcese.add(newProcess);
            		contor++;
            	}
            
        }
        }
        return listaProcese;
	}
}
