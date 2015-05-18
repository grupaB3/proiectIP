package diskscan;
import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.RandomAccessFile;
import java.text.Normalizer;
import java.util.Arrays;


public class Recover {
	public static void revive(int recNumber, File file) {
		try{
			MasterFileTable mft = MasterFileTable.getInstance();
			MFTEntry desiredFile = mft.getEntry(recNumber);
			long partitionOffset = desiredFile.getPartitionStart();
			RandomAccessFile raf = new RandomAccessFile(file, "r");
			for(NTFSAttribute attr : desiredFile.getAttributes()) {
				if(attr.getType() == 0x80) {
					if(attr.getNonResFlag() == 0) {
						raf.seek(desiredFile.getOffset());
						byte[] buffer = new byte[1024];
						raf.readFully(buffer);
						FileOutputStream out = new FileOutputStream(desiredFile.getFileName().getName());
						int first = attr.getStart() + attr.getrAttr().getAttrOffset();
						int last = attr.getStart() + attr.getrAttr().getAttrOffset() + attr.getrAttr().getLength();
						out.write(Arrays.copyOfRange(buffer, first, last));
						out.close();
						raf.close();
					} 
					else {
						int clusterOffset = 0;
						for(DataRun dr : attr.getNrAttr().getDataRuns()) {
							clusterOffset += dr.getClusterOffset();
							System.out.println(dr.getLength() + " " + dr.getClusterOffset());
							raf.seek(partitionOffset + (long)clusterOffset * 512 * 8);
							byte[] buffer = new byte[512];
							FileOutputStream out = new FileOutputStream(desiredFile.getFileName().getName());
							//FileOutputStream out = new FileOutputStream("img.txt");
							for(int i = 0; i < dr.getLength() * 8; i++) {
								raf.readFully(buffer);
								out.write(buffer);
							}
						}
						System.out.println("Done!");
					}
				}
			}
		}catch(Exception e) {
			System.out.println(e.toString());
		}
	}
}
