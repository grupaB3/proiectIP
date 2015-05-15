package check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.DigitalSignature;

public class DigitalSignatureChecker
{
	public DigitalSignature check(int pID) throws IOException, InterruptedException
	{
		try {
			String exectPath = getExecutablePath(pID);
			String sigcheckPath = this.getClass().getResource("sigcheck.exe").getPath().substring(1);
			System.out.println(sigcheckPath);
			String command = "\""+ sigcheckPath + "\" " + exectPath + "\"";
			Process systemCommand = Runtime.getRuntime().exec(command);
			systemCommand.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(systemCommand.getInputStream()));
			
			
			String name = reader.readLine();
			String verified = reader.readLine();
			String signing = reader.readLine();
			String publisher = reader.readLine();
			String description = reader.readLine();
			String product = reader.readLine();
			String prodVersion = reader.readLine();
			String fileVersion = reader.readLine();
								
		
			return new DigitalSignature(name,verified,signing,publisher,description,product,prodVersion,fileVersion);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	
	public DigitalSignature check(String exectPath) throws IOException, InterruptedException
	{
		try {
			String sigcheckPath = this.getClass().getResource("sigcheck.exe").getPath().substring(1);
			String command = "\""+ sigcheckPath + "\" " + exectPath + "\"";
			Process systemCommand = Runtime.getRuntime().exec(command);
			systemCommand.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(systemCommand.getInputStream()));
			
			
			String name = reader.readLine();
			String verified = reader.readLine();
			String signing = reader.readLine();
			String publisher = reader.readLine();
			String description = reader.readLine();
			String product = reader.readLine();
			String prodVersion = reader.readLine();
			String fileVersion = reader.readLine();
					
			
			return new DigitalSignature(name,verified,signing,publisher,description,product,prodVersion,fileVersion);
		} catch (Exception e) {
			e.printStackTrace();
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

