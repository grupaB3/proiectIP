package diskscan;
public class Partition {
	private Byte chBootInd;
	private Byte chHead;
	private Byte chSector;
	private Byte chCylinder;
	private Byte chType;
	private Byte chLastHead;
	private Byte chLastSector;
	private Byte chLastCylinder;
	private int dwRelativeSector;
	private int dwNumberSectors;
	
	public Partition(byte[] b) {
		chBootInd = b[0];
		chHead = b[1];
		chSector = b[2];
		chCylinder = b[3];
		chType = b[4];
		chLastHead = b[5];
		chLastSector = b[6];
		chLastCylinder = b[7];
		dwRelativeSector = (b[11] << 24) + (b[10] << 16) + (b[9] << 8) + (b[8]);
		dwNumberSectors = (b[15] << 24) + (b[14] << 16) + (b[13] << 8) + (b[12]);
	}
	public String getchType() {
		if(chType == 0x07)
			return "NTFS";
		return ""+chType;
	}
	public Byte getChBootInd() {
		return chBootInd;
	}
	public Byte getChHead() {
		return chHead;
	}
	public Byte getChSector() {
		return chSector;
	}
	public Byte getChCylinder() {
		return chCylinder;
	}
	public Byte getChLastHead() {
		return chLastHead;
	}
	public Byte getChLastSector() {
		return chLastSector;
	}
	public Byte getChLastCylinder() {
		return chLastCylinder;
	}
	public int getDwRelativeSector() {
		return dwRelativeSector;
	}
	public int getDwNumberSectors() {
		return dwNumberSectors;
	}
}
