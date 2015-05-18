package diskscan;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;


public class DiskPartition {
	private ArrayList physDrives;
	
	public DiskPartition(){
		physDrives = new ArrayList();
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
//		for (int i = 0; i < physDrives.size(); i++){
//			System.out.println(physDrives.get(i));
//		}
	}
	
	public ArrayList getPhysDrives(){
		return physDrives;
	}
}
