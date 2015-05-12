import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;


public class Main {

	public static void main(String[] args) {
		try {
			MasterFileTable mft = MasterFileTable.getInstance();
			File file = new File("\\\\.\\PhysicalDrive0");
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			for(int rangeStart = 446; rangeStart <= 494; rangeStart = rangeStart + 16){	
				raf = new RandomAccessFile(file, "r");
				byte[] buff = new byte[512];
				raf.readFully(buff);
				//Partition P = new Partition(Arrays.copyOfRange(buff, 446 + 16, 446 + 32));
				Partition P = new Partition(Arrays.copyOfRange(buff, rangeStart, rangeStart + 16));
				//System.out.println(rangeStart +" "+ P.getchType());
				if(P.getchType().equals("NTFS")){
					raf.seek(P.getDwRelativeSector()*512);
					raf.readFully(buff);
					BootSector BS = new BootSector(buff);
					long MFTStart = P.getDwRelativeSector() * 512 + BS.getBpb().getBytesPerSector() * BS.getBpb().getSectorPerCluster() * BS.getBpb().getLogicalMFT();
					byte[] buffer = new byte[1024];
					System.out.println(BS.getChOEM());
					do {
						raf.seek(MFTStart);
						raf.readFully(buffer);
						if(buffer.length == 0)
							break;
						MFTEntry mftEntry = new MFTEntry(MFTStart);
						mftEntry.scan(buffer);
						if(mftEntry.getMftHeader().getFileSignature().toString().equals("FILE") == false)
							break;
						if(mftEntry.isInvalid() == false)
							mft.addEntry(mftEntry.getMftHeader().getMftRecNumber(), mftEntry);
						MFTStart = MFTStart + 1024;
					} while(MFTStart > 1024);
				}
			}
			raf.close();
			mft.afiseazaCaile();
		} catch(IOException e) {
			System.out.println(e.toString());
		}
	}

}
