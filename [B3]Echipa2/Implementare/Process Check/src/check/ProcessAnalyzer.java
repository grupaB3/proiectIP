package check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;

import model.MaliciousProcess;

public class ProcessAnalyzer {
	
	public MaliciousProcess analyzeProcess(int pID){
			try {
				String execPath = getExecutablePath(pID);
				return analyzeFile(execPath);
			} catch (IOException | InterruptedException e) {
				return null;
			}
	}
	
	public MaliciousProcess analyzeFile(String fileName){
		try {
			String sigcheckPath = this.getClass().getResource("sigcheck.exe").getPath().substring(1);
			String command = "\""+sigcheckPath+"\""+" /accepteula -c -vt \""+fileName+"\"";
			Process systemCommand = Runtime.getRuntime().exec(command);
			systemCommand.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(systemCommand.getInputStream()));
			reader.readLine();
			String verified;
			String publisher;
			String description;
			String product;
			int numberOfTests = 0;
			int testsFailed = 0;
			String resultLine = reader.readLine(), aux;
			Scanner parser = new Scanner(resultLine);
			parser.useDelimiter(",");
			parser.next();
			verified = parser.next().replace("\"",	"");
			parser.next();
			aux = parser.next().replace("\"",	"");
			publisher = aux.equals("n/a")?null:aux;
			aux = parser.next().replace("\"",	"");
			description = aux.equals("n/a")?null:aux;
			aux = parser.next().replace("\"",	"");
			product = aux.equals("n/a")?null:aux;
			parser.next();parser.next();parser.next();
			aux = parser.next().replace("\"",	"");
			if(!aux.equals("Unknown")){
				String[] detection = parser.next().replace("\"", "").split("\\|");
				testsFailed = Integer.parseInt(detection[0]);
				numberOfTests = Integer.parseInt(detection[1]);
			}
			parser.close();
			return new MaliciousProcess(fileName, verified, publisher, description, product, numberOfTests, testsFailed);
		} catch (Exception e) {
			return null;
		}
	}
	
	private String getExecutablePath(int pID) throws IOException, InterruptedException {
		String command = "wmic process where ProcessId="+pID+" get ExecutablePath";
		Process systemCommand = Runtime.getRuntime().exec(command);
		systemCommand.waitFor();
		BufferedReader reader = new BufferedReader(new InputStreamReader(systemCommand.getInputStream()));
		
		if(reader.readLine() == null)
			return null;
		if(reader.readLine() == null)
			return null;
		String path = reader.readLine();
		if(path == null || path.equals("") || path.startsWith(" "))
			return null;
		return path;
	}
}