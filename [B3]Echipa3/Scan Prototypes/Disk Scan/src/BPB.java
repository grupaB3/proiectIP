import java.nio.ByteBuffer;
import java.util.Arrays;


public class BPB {
	
	private char bytesPerSector;
	private byte sectorPerCluster;
	private char reservedSectors;
	private byte mediaDescriptor;
	private char sectorsPerTrack;
	private char numberOfHeads;
	private int hiddenSectors;
	private long totalSectors;
	private long logicalMFT;
	private long logicalMFTMirr;
	private int clustersPerFileRS;
	private byte clustersPerIndex;
	private long volumeSerialNumber;
	private int checkSum;
	
	public BPB(byte[] b) {
		bytesPerSector = (char)(b[1] << 8 + b[0]);
		sectorPerCluster = b[2];
		reservedSectors = (char)(b[4] << 8 + b[3]);
		mediaDescriptor = b[10];
		sectorsPerTrack = (char)(b[14] << 8 + b[13]);
		numberOfHeads = (char)(b[16] << 8 + b[15]);
		hiddenSectors = (int)(b[20] << 24 + b[19] << 16 + b[18] << 8 + b[17]);
		totalSectors = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 29, 37))).getLong();
		logicalMFT = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 37, 45))).getLong();
		logicalMFTMirr = ByteBuffer.wrap(Utile.getReverseBytes(Arrays.copyOfRange(b, 45, 53))).getLong();
		clustersPerFileRS = (int)(b[56] << 24 + b[55] << 16 + b[54] << 8 + b[53]);
		clustersPerIndex = b[57];
		volumeSerialNumber = (long)(b[68] << 56 + b[67] << 48 +  b[66] << 40 + b[65] << 32 +  b[64] << 24 + b[63] << 16 + b[62] << 8 + b[61]);
		checkSum = (int)(b[72] << 24 + b[71] << 16 + b[70] << 8 + b[69]);
	}

	public char getBytesPerSector() {
		return bytesPerSector;
	}

	public byte getSectorPerCluster() {
		return sectorPerCluster;
	}

	public char getReservedSectors() {
		return reservedSectors;
	}

	public byte getMediaDescriptor() {
		return mediaDescriptor;
	}

	public char getSectorsPerTrack() {
		return sectorsPerTrack;
	}

	public char getNumberOfHeads() {
		return numberOfHeads;
	}

	public int getHiddenSectors() {
		return hiddenSectors;
	}

	public long getTotalSectors() {
		return totalSectors;
	}

	public long getLogicalMFT() {
		return logicalMFT;
	}

	public long getLogicalMFTMirr() {
		return logicalMFTMirr;
	}

	public int getClustersPerFileRS() {
		return clustersPerFileRS;
	}

	public byte getClustersPerIndex() {
		return clustersPerIndex;
	}

	public long getVolumeSerialNumber() {
		return volumeSerialNumber;
	}

	public int getCheckSum() {
		return checkSum;
	}
	
}
