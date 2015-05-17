package model;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.security.SecureRandom;

/**
 * Shred File 
 * @author Razvan
 *
 */



public class SecureDelete
{
	/**
	 * Sterge un fisier sau un folder definitiv
	 * @param path Path-ul complet al fisierului
	 * @return True daca sa sters fisieru sau false daca nu s-a putut sterge
	 * @throws IOException
	 */
	public boolean delete(String path) throws IOException{
		File file = new File(path);
		if(file.isFile() && file.exists() ){
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
			if(file.isDirectory() && file.exists()){
				File[] list = file.listFiles();
				for(File f:list)
					delete(f.getAbsolutePath());
			}
			if(file.exists())
				file.delete();
		}
		return false;
	}
}
