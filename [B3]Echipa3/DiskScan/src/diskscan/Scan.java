package diskscan;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.Arrays;
import java.util.Map;

public class Scan {
	private boolean isStopped = false;
	MasterFileTable mft;
	String physDrive;
	
	public Scan(String physDrive){
		this.physDrive = physDrive;
	}
	
	public void startScan(){
		try {
			mft = MasterFileTable.getInstance();
			File file = new File("\\\\.\\"+physDrive);
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			byte[] partitionBuff = new byte[512];
			raf.readFully(partitionBuff);
			for(int rangeStart = 446; rangeStart <= 494; rangeStart = rangeStart + 16) {	
				Partition P = new Partition(Arrays.copyOfRange(partitionBuff, rangeStart, rangeStart + 16));
				byte[] buff = new byte[512];
				if(P.getchType().equals("NTFS")){
					raf.seek((long)P.getDwRelativeSector()*512);
					raf.readFully(buff);
					BootSector BS = new BootSector(buff);
					long MFTStart = (long)P.getDwRelativeSector() * 512 + BS.getBpb().getBytesPerSector() * BS.getBpb().getSectorPerCluster() * BS.getBpb().getLogicalMFT();
					byte[] buffer = new byte[1024];
					do {
						raf.seek(MFTStart);
						raf.readFully(buffer);
						if(buffer.length == 0)
							break;
						MFTEntry mftEntry = new MFTEntry(MFTStart, (long)P.getDwRelativeSector() * 512);
						mftEntry.scan(buffer);
						if(mftEntry.getMftHeader().getFileSignature().toString().equals("FILE") == false)
							break;
						if(mftEntry.isInvalid() == false)
							mft.addEntry(mftEntry.getMftHeader().getMftRecNumber(), mftEntry);
						MFTStart = MFTStart + 1024;
					} while(isStopped != true && MFTStart > 1024);
				}
			}
			raf.close();
			//mft.afiseazaCaile();
			//Recover.revive(40, file);
			Serialize serializare = new Serialize(mft, physDrive);
			//Example example = serializer.read(Example.class, source);
		} catch(IOException e) {
			System.out.println(e.toString());
		}
	}
	
	public void setStopped(){
		if(isStopped == false)
			isStopped = true;
	}
	
	public Map<Integer,MFTEntry> getMapMFT(){
		return mft.getMap();
	}
}
