package md5processcheck;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.URISyntaxException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.stream.Stream;

public class ProcessCheck {
	public boolean isDangerous(int pID){
		try {
			String executablePath;
			if((executablePath = getExecutablePath(pID)) == null)
				return false;
			String checksum = getMD5sum(executablePath);
			return findMD5(checksum);
		} catch (IOException | InterruptedException | NoSuchAlgorithmException | URISyntaxException e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private boolean findMD5(String checksum) throws IOException, URISyntaxException {
		File resourceFilesDir = new File(this.getClass().getResource("../resources/md5files").toURI());
		Stream<String> lines;
		boolean[] found = new boolean[]{false};
		if(resourceFilesDir.isDirectory())
			for(File resource:resourceFilesDir.listFiles()){
				lines = Files.lines(resource.toPath(), Charset.defaultCharset());
				lines.forEach(line -> {
					if(checksum.equals(line))
						found[0] = true;
				});
				lines.close();
				if(found[0])
					return true;
			}
		return false;
	}

	private static String getMD5sum(String filename) throws NoSuchAlgorithmException, IOException {
		byte[] buffer = new byte[1024];
		InputStream is = new FileInputStream(filename);
		MessageDigest md = MessageDigest.getInstance("MD5");
		
		int buffsize;
		do{
			buffsize = is.read(buffer);
			if(buffsize > 0)
				md.update(buffer, 0, buffsize);
		}while(buffsize != -1);
		is.close();
		
		byte[] checksum = md.digest();
		String result = String.format("%032x", new BigInteger(1, checksum));
		return result;
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
