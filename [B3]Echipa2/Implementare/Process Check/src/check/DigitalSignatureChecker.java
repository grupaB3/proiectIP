package check;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import model.DigitalSignature;

/**
 * Clasa DigitalSignatureChecker ofera posibilitatea de a verifica daca un fisier sau un proces este semnat digital .
 * @author Razvan
 *
 */

public class DigitalSignatureChecker
{
	/**
	 * Verifica daca un proces este semnat digital dupa PID.
	 * @param pID PID unui proces activ.
	 * @return Un obiect DigitalSignature ce contine infomatii despre proces.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public DigitalSignature check(int pID) throws IOException, InterruptedException
	{
		try {
			String exectPath = getExecutablePath(pID);
			String sigcheckPath = Extractor.getFileLocation("sigcheck.exe").getPath().replace("%20", " ").replace("%5b", "[").replace("%5d", "]").substring(1);
			String command = sigcheckPath + " \"" + exectPath + "\"";
			Process systemCommand = Runtime.getRuntime().exec(command);
			systemCommand.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(systemCommand.getInputStream()));
			
			
			String name = reader.readLine();
			if(name.contains("No matching files were found."))
				return null;
			String verified = reader.readLine().substring(11);
			String signingDate = reader.readLine().substring(15);
			String publisher = reader.readLine().substring(12);
			String description = reader.readLine().substring(14);
			String product = reader.readLine().substring(10);
			String prodVersion = reader.readLine().substring(18);
			String fileVersion = reader.readLine().substring(15);
								
		
			return new DigitalSignature(name,verified,signingDate,publisher,description,product,prodVersion,fileVersion);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	
	/**
	 * Verifica daca un fisier sau proces este semnat digital dupa path-ul complet.
	 * @param exectPath Path-ul complet catre fisier.
	 * @return Un obiect DigitalSignature ce contine infomatii despre proces.
	 * @throws IOException
	 * @throws InterruptedException
	 */
	public DigitalSignature check(String exectPath) throws IOException, InterruptedException
	{
		try {
			String sigcheckPath = this.getClass().getResource("sigcheck.exe").getPath().replace("%20", " ").replace("%5b", "[").replace("%5d", "]").substring(1);
			String command = sigcheckPath + " \"" + exectPath + "\"";
			Process systemCommand = Runtime.getRuntime().exec(command);
			systemCommand.waitFor();
			BufferedReader reader = new BufferedReader(new InputStreamReader(systemCommand.getInputStream()));
			
			
			String name = reader.readLine();
			if(name.contains("No matching files were found."))
				return null;
			String verified = reader.readLine().substring(11);
			String signingDate = reader.readLine().substring(15);
			String publisher = reader.readLine().substring(12);
			String description = reader.readLine().substring(14);
			String product = reader.readLine().substring(10);
			String prodVersion = reader.readLine().substring(18);
			String fileVersion = reader.readLine().substring(15);
					
			
			return new DigitalSignature(name,verified,signingDate,publisher,description,product,prodVersion,fileVersion);
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

