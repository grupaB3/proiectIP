package model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.SecureRandom;

public class SecureDelete
{
	public boolean delete(String path) throws IOException{
		File file = new File(path);
		if(file.isFile()){
			long length = file.length();
			SecureRandom random = new SecureRandom();
			RandomAccessFile raf = new RandomAccessFile(file,"rws");
			raf.seek(0);
			raf.getFilePointer();
			byte[] data = new byte[64];
			int position = 0;
			while(position < length){
				random.nextBytes(data);
				raf.write(data);
				position += data.length;
			}
			raf.close();
			file.delete();
			return true;
		}
		else
		{
			if(file.isDirectory()){
				File[] list = file.listFiles();
				for(File f:list)
					delete(f.getAbsolutePath());
			}
			file.delete();
		}
		return false;
	}
}
