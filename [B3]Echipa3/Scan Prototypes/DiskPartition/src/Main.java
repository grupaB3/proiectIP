import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;


public class Main {
	public static void main(String[] args) {
		ArrayList physDrives = new ArrayList();
		int physDriveIt = 0;
		while(true)
		{
			File tmp = new File("\\\\.\\PhysicalDrive"+physDriveIt+"");
			try
			{
				BufferedInputStream br = new BufferedInputStream(new FileInputStream(tmp));
				int iTmp = br.read();
				if(iTmp!=-1)
				{
					physDrives.add("PhysicalDrive" + physDriveIt+"");
					physDriveIt++;
				}
			}
			catch(Exception ex)
			{
				break;
			}
		}
		for (int i = 0; i < physDrives.size(); i++){
			String drive = "\\\\.\\" + physDrives.get(i);
			System.out.println(drive);
		}
	}
}
